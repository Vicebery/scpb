/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : scpb

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2019-04-02 11:41:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for chainticket
-- ----------------------------
DROP TABLE IF EXISTS `chainticket`;
CREATE TABLE `chainticket` (
  `id` varchar(80) NOT NULL,
  `amount` varchar(40) DEFAULT NULL,
  `drawTime` varchar(40) DEFAULT NULL,
  `state` int(2) DEFAULT NULL,
  `ownerId` varchar(40) DEFAULT NULL,
  `deadline` varchar(40) DEFAULT NULL,
  `drawEnterprise` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `ownerId` (`ownerId`) USING BTREE,
  CONSTRAINT `chainticket_ibfk_1` FOREIGN KEY (`ownerId`) REFERENCES `enterprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of chainticket
-- ----------------------------
INSERT INTO `chainticket` VALUES ('2019040122540085', '400', '2019-04-01', '6', '2019003', '2121-09-09', '2019001');
INSERT INTO `chainticket` VALUES ('2019040122560283', '100', '2019-04-01', '6', '2019004', '2121-09-09', '2019001');
INSERT INTO `chainticket` VALUES ('2019040122580783', '400', '2019-04-01', '6', '2019002', '2121-09-09', '2019002');
INSERT INTO `chainticket` VALUES ('2019040122590234', '100', '2019-04-01', '1', '2019002', '2011-09-09', '2019002');
INSERT INTO `chainticket` VALUES ('2019040123095926', '100', '2019-04-01', '3', '2019003', '2121-09-09', '2019001');
INSERT INTO `chainticket` VALUES ('2019040123095956', '300.0', '2019-04-01', '6', '2019003', '2121-09-09', '2019001');
INSERT INTO `chainticket` VALUES ('2019040123125158', '100', '2019-04-01', '3', '2019005', '2121-09-09', '2019001');
INSERT INTO `chainticket` VALUES ('2019040123125159', '200.0', '2019-04-01', '3', '2019003', '2121-09-09', '2019001');
INSERT INTO `chainticket` VALUES ('2019040123150153', '20', '2019-04-01', '3', '2019004', '2121-09-09', '2019001');
INSERT INTO `chainticket` VALUES ('2019040123150167', '80.0', '2019-04-01', '3', '2019004', '2121-09-09', '2019001');

-- ----------------------------
-- Table structure for coreenterprise
-- ----------------------------
DROP TABLE IF EXISTS `coreenterprise`;
CREATE TABLE `coreenterprise` (
  `id` varchar(40) NOT NULL,
  `limit` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `coreenterprise_ibfk_1` FOREIGN KEY (`id`) REFERENCES `enterprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of coreenterprise
-- ----------------------------
INSERT INTO `coreenterprise` VALUES ('2019001', '16500.0');

-- ----------------------------
-- Table structure for enterprise
-- ----------------------------
DROP TABLE IF EXISTS `enterprise`;
CREATE TABLE `enterprise` (
  `id` varchar(40) NOT NULL,
  `account` varchar(20) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  `bank` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `UCC` varchar(20) DEFAULT NULL,
  `LPC` varchar(20) DEFAULT NULL,
  `type` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of enterprise
-- ----------------------------
INSERT INTO `enterprise` VALUES ('2019001', '15071429552', '123456', '290-000-0887', '核心企业', '190000', '123432666', '1');
INSERT INTO `enterprise` VALUES ('2019002', '15203881534', '123456', '11', '成员企业1', '11', '11', '2');
INSERT INTO `enterprise` VALUES ('2019003', '13123886950', '123456', '111', '供应商1', '111', '111', '3');
INSERT INTO `enterprise` VALUES ('2019004', '18222990843', '123456', '1111', '供应商2', '1111', '1111', '3');
INSERT INTO `enterprise` VALUES ('2019005', '15938870043', '123456', '11111', '保理商', '4444444', '1111144', '4');
INSERT INTO `enterprise` VALUES ('2019006', '13988888811', '123456', '111111', '供应商3', '111111', '111111', '3');
INSERT INTO `enterprise` VALUES ('413532323232', '13532323232', '123456', '1111111', '保理商2', '2121212', '21212121', '4');
INSERT INTO `enterprise` VALUES ('413545264414', '13545264414', '123456', '66666666', '成员企业2', '33333', '2222222', '2');

-- ----------------------------
-- Table structure for factor
-- ----------------------------
DROP TABLE IF EXISTS `factor`;
CREATE TABLE `factor` (
  `id` varchar(40) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `factor_ibfk_1` FOREIGN KEY (`id`) REFERENCES `enterprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of factor
-- ----------------------------
INSERT INTO `factor` VALUES ('2019005', '保理商1');
INSERT INTO `factor` VALUES ('413532323232', null);

-- ----------------------------
-- Table structure for memberenterprise
-- ----------------------------
DROP TABLE IF EXISTS `memberenterprise`;
CREATE TABLE `memberenterprise` (
  `id` varchar(40) NOT NULL,
  `limit` varchar(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `memberenterprise_ibfk_1` FOREIGN KEY (`id`) REFERENCES `enterprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of memberenterprise
-- ----------------------------
INSERT INTO `memberenterprise` VALUES ('2019002', '2400.0', '成员企业1');
INSERT INTO `memberenterprise` VALUES ('413545264414', '2120.0', '成员企业2');

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `id` varchar(40) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `supplier_ibfk_1` FOREIGN KEY (`id`) REFERENCES `enterprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES ('2019003', '供应商1');
INSERT INTO `supplier` VALUES ('2019004', '供应商2');
INSERT INTO `supplier` VALUES ('2019006', '供应商3');

-- ----------------------------
-- Table structure for supplyrelation
-- ----------------------------
DROP TABLE IF EXISTS `supplyrelation`;
CREATE TABLE `supplyrelation` (
  `id` varchar(200) NOT NULL,
  `mySupplier` varchar(200) NOT NULL,
  PRIMARY KEY (`id`,`mySupplier`) USING BTREE,
  KEY `mySupplier` (`mySupplier`) USING BTREE,
  CONSTRAINT `supplyrelation_ibfk_1` FOREIGN KEY (`id`) REFERENCES `enterprise` (`id`),
  CONSTRAINT `supplyrelation_ibfk_2` FOREIGN KEY (`mySupplier`) REFERENCES `enterprise` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of supplyrelation
-- ----------------------------
INSERT INTO `supplyrelation` VALUES ('2019001', '2019003');
INSERT INTO `supplyrelation` VALUES ('2019002', '2019003');
INSERT INTO `supplyrelation` VALUES ('2019001', '2019004');
INSERT INTO `supplyrelation` VALUES ('2019002', '2019004');
INSERT INTO `supplyrelation` VALUES ('2019003', '2019004');
INSERT INTO `supplyrelation` VALUES ('2019001', '2019006');
INSERT INTO `supplyrelation` VALUES ('2019003', '2019006');
INSERT INTO `supplyrelation` VALUES ('2019004', '2019006');

-- ----------------------------
-- Table structure for tradeinformation
-- ----------------------------
DROP TABLE IF EXISTS `tradeinformation`;
CREATE TABLE `tradeinformation` (
  `id` varchar(80) NOT NULL,
  `tradeTime` varchar(40) DEFAULT NULL,
  `firstParty` varchar(40) DEFAULT NULL,
  `secondParty` varchar(40) DEFAULT NULL,
  `sum` varchar(20) DEFAULT NULL,
  `tradeRemark` varchar(255) DEFAULT NULL,
  `payCT` varchar(80) DEFAULT NULL,
  `receiveCT` varchar(80) DEFAULT NULL,
  `remainCT` varchar(80) DEFAULT NULL,
  `verifyInf` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `firstParty` (`firstParty`) USING BTREE,
  KEY `secondParty` (`secondParty`) USING BTREE,
  CONSTRAINT `tradeinformation_ibfk_1` FOREIGN KEY (`firstParty`) REFERENCES `enterprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tradeinformation_ibfk_2` FOREIGN KEY (`secondParty`) REFERENCES `enterprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tradeinformation
-- ----------------------------
INSERT INTO `tradeinformation` VALUES ('20190401225400', '2019-04-01', '2019001', '2019003', '400', '测试开具', '2019040122540085', '2019040122540085', '2019040122540091', '3');
INSERT INTO `tradeinformation` VALUES ('20190401225602', '2019-04-01', '2019001', '2019004', '100', '测试开具2', '2019040122560283', '2019040122560283', '2019040122560242', '3');
INSERT INTO `tradeinformation` VALUES ('20190401225807', '2019-04-01', '2019002', '2019003', '400', '成员测试开具', '2019040122580783', '2019040122580783', '2019040122580746', '4');
INSERT INTO `tradeinformation` VALUES ('20190401225902', '2019-04-01', '2019002', '2019003', '100', '成员测试开具2', '2019040122590234', '2019040122590234', '2019040122590299', '1');
INSERT INTO `tradeinformation` VALUES ('20190401230959', '2019-04-01', '2019003', '2019004', '100', '转让测试', '2019040122540085', '2019040123095926', '2019040123095956', '4');
INSERT INTO `tradeinformation` VALUES ('20190401231251', '2019-04-01', '2019003', '2019005', '100', '融资测试', '2019040123095956', '2019040123125158', '2019040123125159', '3');
INSERT INTO `tradeinformation` VALUES ('20190401231501', '2019-04-01', '2019004', '2019006', '20', '转让测试', '2019040122560283', '2019040123150153', '2019040123150167', '4');
SET FOREIGN_KEY_CHECKS=1;
