/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : scpb

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2019-04-02 12:54:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for chainTicket
-- ----------------------------
DROP TABLE IF EXISTS `chainTicket`;
CREATE TABLE `chainTicket` (
  `id` varchar(80) NOT NULL,
  `amount` varchar(40) DEFAULT NULL,
  `drawTime` varchar(40) DEFAULT NULL,
  `state` int(2) DEFAULT NULL,
  `ownerId` varchar(40) DEFAULT NULL,
  `deadline` varchar(40) DEFAULT NULL,
  `drawEnterprise` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `ownerId` (`ownerId`) USING BTREE,
  CONSTRAINT `chainTicket_ibfk_1` FOREIGN KEY (`ownerId`) REFERENCES `enterprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;


-- ----------------------------
-- Table structure for coreEnterprise
-- ----------------------------
DROP TABLE IF EXISTS `coreEnterprise`;
CREATE TABLE `coreEnterprise` (
  `id` varchar(40) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `limit` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `coreEnterprise_ibfk_1` FOREIGN KEY (`id`) REFERENCES `enterprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of coreEnterprise
-- ----------------------------
INSERT INTO `coreEnterprise` VALUES ('15002019001', '核心企业', '16500.0');

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
INSERT INTO `enterprise` VALUES ('15002019001', '15002019001', '123456', '290-000-0887', '核心企业', '190000', '123432666', '1');
INSERT INTO `enterprise` VALUES ('15002019002', '15002019002', '123456', '11', '成员企业1', '11', '11', '2');
INSERT INTO `enterprise` VALUES ('15002019004', '15002019004', '123456', '111', '供应商1', '111', '111', '3');
INSERT INTO `enterprise` VALUES ('15002019005', '15002019005', '123456', '1111', '供应商2', '1111', '1111', '3');
INSERT INTO `enterprise` VALUES ('15002019007', '15002019007', '123456', '11111', '保理商', '4444444', '1111144', '4');
INSERT INTO `enterprise` VALUES ('15002019006', '15002019006', '123456', '111111', '供应商3', '111111', '111111', '3');
INSERT INTO `enterprise` VALUES ('15002019008', '15002019008', '123456', '1111111', '保理商2', '2121212', '21212121', '4');
INSERT INTO `enterprise` VALUES ('15002019003', '15002019003', '123456', '66666666', '成员企业2', '33333', '2222222', '2');

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
INSERT INTO `factor` VALUES ('15002019007', '保理商1');
INSERT INTO `factor` VALUES ('15002019008', '保理商2');

-- ----------------------------
-- Table structure for memberEnterprise
-- ----------------------------
DROP TABLE IF EXISTS `memberEnterprise`;
CREATE TABLE `memberEnterprise` (
  `id` varchar(40) NOT NULL,
  `limit` varchar(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `memberEnterprise_ibfk_1` FOREIGN KEY (`id`) REFERENCES `enterprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of memberEnterprise
-- ----------------------------
INSERT INTO `memberEnterprise` VALUES ('15002019002', '2400.0', '成员企业1');
INSERT INTO `memberEnterprise` VALUES ('15002019003', '2120.0', '成员企业2');

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
INSERT INTO `supplier` VALUES ('15002019004', '供应商1');
INSERT INTO `supplier` VALUES ('15002019005', '供应商2');
INSERT INTO `supplier` VALUES ('15002019006', '供应商3');

-- ----------------------------
-- Table structure for supplyRelation
-- ----------------------------
DROP TABLE IF EXISTS `supplyRelation`;
CREATE TABLE `supplyRelation` (
  `id` varchar(200) NOT NULL,
  `mySupplier` varchar(200) NOT NULL,
  PRIMARY KEY (`id`,`mySupplier`) USING BTREE,
  KEY `mySupplier` (`mySupplier`) USING BTREE,
  CONSTRAINT `supplyRelation_ibfk_1` FOREIGN KEY (`id`) REFERENCES `enterprise` (`id`),
  CONSTRAINT `supplyRelation_ibfk_2` FOREIGN KEY (`mySupplier`) REFERENCES `enterprise` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of supplyRelation
-- ----------------------------
INSERT INTO `supplyRelation` VALUES ('15002019001', '15002019004');
INSERT INTO `supplyRelation` VALUES ('15002019001', '15002019005');
INSERT INTO `supplyRelation` VALUES ('15002019001', '15002019006');
INSERT INTO `supplyRelation` VALUES ('15002019002', '15002019004');
INSERT INTO `supplyRelation` VALUES ('15002019003', '15002019005');
INSERT INTO `supplyRelation` VALUES ('15002019003', '15002019006');
INSERT INTO `supplyRelation` VALUES ('15002019004', '15002019005');
INSERT INTO `supplyRelation` VALUES ('15002019005', '15002019006');
INSERT INTO `supplyRelation` VALUES ('15002019004', '15002019006');

-- ----------------------------
-- Table structure for tradeInformation
-- ----------------------------
DROP TABLE IF EXISTS `tradeInformation`;
CREATE TABLE `tradeInformation` (
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
  CONSTRAINT `tradeInformation_ibfk_1` FOREIGN KEY (`firstParty`) REFERENCES `enterprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tradeInformation_ibfk_2` FOREIGN KEY (`secondParty`) REFERENCES `enterprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

SET FOREIGN_KEY_CHECKS=1;
