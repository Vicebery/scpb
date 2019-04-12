/*
SPDX-License-Identifier: Apache-2.0
*/

/*
 * This application has 6 basic steps:
 * 1. Select an identity from a wallet
 * 2. Connect to network gateway
 * 3. Access PaperNet network
 * 4. Construct request to issue commercial paper
 * 5. Submit transaction
 * 6. Process response
 */

'use strict';

// Bring key classes into scope, most importantly Fabric SDK network class
const fs = require('fs');
const yaml = require('js-yaml');
const { FileSystemWallet, Gateway } = require('fabric-network');
const CommercialPaper = require('../contract/lib/paper.js');

// A wallet stores a collection of identities for use
const wallet = new FileSystemWallet('../identity/user/balaji/wallet');

// Main program function
async function main() {

  // A gateway defines the peers used to access Fabric networks
  const gateway = new Gateway();

  // Main try/catch block
  try {

    // Specify userName for network access
    // const userName = 'isabella.issuer@magnetocorp.com';
    const userName = 'Admin@org1.example.com';

    // Load connection profile; will be used to locate a gateway
    let connectionProfile = yaml.safeLoad(fs.readFileSync('../gateway/networkConnection.yaml', 'utf8'));

    // Set connection options; identity and wallet
    let connectionOptions = {
      identity: userName,
      wallet: wallet,
      discovery: { enabled:false, asLocalhost: true }

    };

    // Connect to gateway using application specified parameters
    console.log('Connect to Fabric gateway.');

    await gateway.connect(connectionProfile, connectionOptions);

    // Access PaperNet network
    console.log('Use network channel: mychannel.');

    const network = await gateway.getNetwork('mychannel');

    // Get addressability to commercial paper contract
    console.log('Use org.papernet.commercialpaper smart contract.');

    const contract = await network.getContract('papercontract', 'org.papernet.commercialpaper');

    // buy commercial paper
    console.log('Submit commercial paper buy transaction.');

    var data = fs.readFileSync('./buy.txt', 'utf8');

    console.log('buy:'+data);

    var strAry = data.split(',');

    const queryResponse = await contract.submitTransaction('query', strAry[0], strAry[3]);

    let paper = CommercialPaper.fromBuffer(queryResponse);

    console.log(`${paper.issuer} commercial paper : ${paper.paperNumber} successfully queryed for value ${paper.faceValue}`);

    const buyResponse1 = await contract.submitTransaction('buy', strAry[0], strAry[1], strAry[6], strAry[4], paper.getMaturityDateTime(), (paper.getFaceValue()*1-strAry[5]*1).toString());

    const buyResponse2 = await contract.submitTransaction('buy', strAry[0], strAry[2], strAry[7].split('\n')[0], strAry[4], paper.getMaturityDateTime(), strAry[5]);

    const cancelResponse = await contract.submitTransaction('cancel', strAry[0], strAry[3], strAry[1], strAry[4]);

    // process response
    console.log('Process buy transaction response.');

    let newPaper1 = CommercialPaper.fromBuffer(buyResponse1);
    let newPaper2 = CommercialPaper.fromBuffer(buyResponse2);
    var buyResult = newPaper1.issuer+','+newPaper1.paperNumber+'\n'+newPaper2.issuer+','+newPaper2.paperNumber;
    console.log(`buyResult:${newPaper2.issuer} commercial paper : ${newPaper2.paperNumber} successfully purchased by ${newPaper2.owner},value:${newPaper2.faceValue}`);
    console.log('Transaction complete.');

    fs.writeFileSync('./buyResult.txt',buyResult);
  } catch (error) {

    console.log(`Error processing transaction. ${error}`);
    console.log(error.stack);

  } finally {

    // Disconnect from the gateway
    console.log('Disconnect from Fabric gateway.')
    gateway.disconnect();

  }
}
main().then(() => {

  console.log('Buy program complete.');

}).catch((e) => {

  console.log('Buy program exception.');
  console.log(e);
  console.log(e.stack);
  process.exit(-1);

});