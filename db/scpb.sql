/*
 Navicat Premium Data Transfer

 Source Server         : scpb
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : scpb

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 09/03/2019 12:13:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for chainticket
-- ----------------------------
DROP TABLE IF EXISTS `chainticket`;
CREATE TABLE `chainticket`  (
  `id` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `amount` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `drawTime` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(2) NULL DEFAULT NULL,
  `ownerId` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `deadline` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `drawEnterprise` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ownerId`(`ownerId`) USING BTREE,
  CONSTRAINT `ownerId` FOREIGN KEY (`ownerId`) REFERENCES `enterprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chainticket
-- ----------------------------
INSERT INTO `chainticket` VALUES ('20190308163928', '500', '2019-03-08', 1, '2019001', '20191111', '2019001');
INSERT INTO `chainticket` VALUES ('20190308215931', '300', '2019-03-08', 0, '2019002', '20200101', '2019002');
INSERT INTO `chainticket` VALUES ('2019030912123666', '400.0', '2019-03-09', 0, '2019001', '20191111', '2019001');
INSERT INTO `chainticket` VALUES ('2019030912123685', '100', '2019-03-09', 0, '2019002', '20191111', '2019001');

-- ----------------------------
-- Table structure for coreenterprise
-- ----------------------------
DROP TABLE IF EXISTS `coreenterprise`;
CREATE TABLE `coreenterprise`  (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `limit` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coreenterprise
-- ----------------------------
INSERT INTO `coreenterprise` VALUES ('2019001', '50000');

-- ----------------------------
-- Table structure for enterprise
-- ----------------------------
DROP TABLE IF EXISTS `enterprise`;
CREATE TABLE `enterprise`  (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `account` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pwd` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `bank` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `UCC` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LPC` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` int(3) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of enterprise
-- ----------------------------
INSERT INTO `enterprise` VALUES ('2019001', '13612345678', '123456', '62080000', 'baidu', '10000001', '123456789012345678', 1);
INSERT INTO `enterprise` VALUES ('2019002', '13123886950', '123456', '111', '趣链', 'qulain', '11', 1);
INSERT INTO `enterprise` VALUES ('2019003', '13045009900', '123456', '1111', 'xiaomi', '1111', '1111', 2);

-- ----------------------------
-- Table structure for factor
-- ----------------------------
DROP TABLE IF EXISTS `factor`;
CREATE TABLE `factor`  (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for memberenterprise
-- ----------------------------
DROP TABLE IF EXISTS `memberenterprise`;
CREATE TABLE `memberenterprise`  (
  `id` varchar(40) CHARACTER SET ascii COLLATE ascii_general_ci NOT NULL,
  `limit` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `coreEnterprise` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ceId`(`coreEnterprise`) USING BTREE,
  CONSTRAINT `ceId` FOREIGN KEY (`coreEnterprise`) REFERENCES `coreenterprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier`  (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tradeinformation
-- ----------------------------
DROP TABLE IF EXISTS `tradeinformation`;
CREATE TABLE `tradeinformation`  (
  `id` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tradeTime` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `firstParty` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `secondParty` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sum` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tradeRemark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `payCT` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receiveCT` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remainCT` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `firstParty`(`firstParty`) USING BTREE,
  INDEX `secondParty`(`secondParty`) USING BTREE,
  CONSTRAINT `firstParty` FOREIGN KEY (`firstParty`) REFERENCES `enterprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `secondParty` FOREIGN KEY (`secondParty`) REFERENCES `enterprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tradeinformation
-- ----------------------------
INSERT INTO `tradeinformation` VALUES ('20190309121237', '2019-03-09', '2019001', '2019002', '100', '测试', '20190308163928', '2019030912123685', '2019030912123666');

SET FOREIGN_KEY_CHECKS = 1;
