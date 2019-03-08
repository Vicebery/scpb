/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : scpb

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2019-03-08 16:43:40
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
  `ownerType` int(3) DEFAULT NULL,
  `ownerId` varchar(40) DEFAULT NULL,
  `deadline` varchar(40) DEFAULT NULL,
  `drawEnterprise` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `ownerId` (`ownerId`) USING BTREE,
  CONSTRAINT `ownerId` FOREIGN KEY (`ownerId`) REFERENCES `enterprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of chainticket
-- ----------------------------
INSERT INTO `chainticket` VALUES ('20190308163928', '500', '2019-03-08', '0', '1', '2019001', '20191111', '2019001');

-- ----------------------------
-- Table structure for coreenterprise
-- ----------------------------
DROP TABLE IF EXISTS `coreenterprise`;
CREATE TABLE `coreenterprise` (
  `id` varchar(40) NOT NULL,
  `limit` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of coreenterprise
-- ----------------------------
INSERT INTO `coreenterprise` VALUES ('2019001', '50000');

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
INSERT INTO `enterprise` VALUES ('2019001', '13612345678', '123456', '62080000', 'baidu', '10000001', '123456789012345678', '1');
INSERT INTO `enterprise` VALUES ('2019002', '13123886950', '123456', '111', '趣链', 'qulain', '11', '1');
INSERT INTO `enterprise` VALUES ('2019003', '13045009900', '123456', '1111', 'xiaomi', '1111', '1111', '2');

-- ----------------------------
-- Table structure for factor
-- ----------------------------
DROP TABLE IF EXISTS `factor`;
CREATE TABLE `factor` (
  `id` varchar(40) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of factor
-- ----------------------------

-- ----------------------------
-- Table structure for memberenterprise
-- ----------------------------
DROP TABLE IF EXISTS `memberenterprise`;
CREATE TABLE `memberenterprise` (
  `id` varchar(40) CHARACTER SET ascii NOT NULL,
  `limit` varchar(20) DEFAULT NULL,
  `coreEnterprise` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `ceId` (`coreEnterprise`) USING BTREE,
  CONSTRAINT `ceId` FOREIGN KEY (`coreEnterprise`) REFERENCES `coreenterprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of memberenterprise
-- ----------------------------

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `id` varchar(40) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of supplier
-- ----------------------------

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
  PRIMARY KEY (`id`) USING BTREE,
  KEY `firstParty` (`firstParty`) USING BTREE,
  KEY `secondParty` (`secondParty`) USING BTREE,
  CONSTRAINT `firstParty` FOREIGN KEY (`firstParty`) REFERENCES `enterprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `secondParty` FOREIGN KEY (`secondParty`) REFERENCES `enterprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tradeinformation
-- ----------------------------
SET FOREIGN_KEY_CHECKS=1;
