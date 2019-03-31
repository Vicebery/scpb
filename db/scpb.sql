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

 Date: 31/03/2019 18:44:28
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
  CONSTRAINT `chainticket_ibfk_1` FOREIGN KEY (`ownerId`) REFERENCES `enterprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chainticket
-- ----------------------------
INSERT INTO `chainticket` VALUES ('2019033019323423', '100', '2019-03-30', 6, '2019004', '2019-10-01', '2019001');
INSERT INTO `chainticket` VALUES ('201903301939233', '120', '2019-03-30', 2, '2019002', '2019-10-01', '2019002');
INSERT INTO `chainticket` VALUES ('2019033020073454', '500', '2019-03-30', 6, '2019003', '2019-10-01', '2019001');
INSERT INTO `chainticket` VALUES ('2019033020114347', '77', '2019-03-30', 6, '2019003', '2019-10-01', '2019001');
INSERT INTO `chainticket` VALUES ('2019033020122640', '300', '2019-03-30', 1, '2019003', '2019-10-01', '2019001');
INSERT INTO `chainticket` VALUES ('2019033020122660', '200.0', '2019-03-30', 6, '2019003', '2019-10-01', '2019001');
INSERT INTO `chainticket` VALUES ('2019033020175356', '50', '2019-03-30', 1, '2019003', '2019-10-01', '2019001');
INSERT INTO `chainticket` VALUES ('2019033020175365', '150.0', '2019-03-30', 6, '2019003', '2019-10-01', '2019001');
INSERT INTO `chainticket` VALUES ('2019033020192931', '12.0', '2019-03-30', 3, '2019004', '2019-10-01', '2019001');
INSERT INTO `chainticket` VALUES ('2019033020192947', '88', '2019-03-30', 3, '2019005', '2019-10-01', '2019001');
INSERT INTO `chainticket` VALUES ('2019033020205711', '400', '2019-03-30', 2, '2019002', '2019-10-01', '2019002');
INSERT INTO `chainticket` VALUES ('2019033020470526', '77', '2019-03-30', 1, '2019003', '2019-10-01', '2019001');
INSERT INTO `chainticket` VALUES ('2019033020470598', '0.0', '2019-03-30', 3, '2019003', '2019-10-01', '2019001');
INSERT INTO `chainticket` VALUES ('2019033110483116', '50', '2019-03-31', 2, '2019002', '2019-10-01', '2019002');
INSERT INTO `chainticket` VALUES ('2019033114571953', '100.0', '2019-03-31', 3, '2019003', '2019-10-01', '2019001');
INSERT INTO `chainticket` VALUES ('2019033114571963', '50', '2019-03-31', 3, '2019005', '2019-10-01', '2019001');

-- ----------------------------
-- Table structure for coreenterprise
-- ----------------------------
DROP TABLE IF EXISTS `coreenterprise`;
CREATE TABLE `coreenterprise`  (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `limit` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `coreenterprise_ibfk_1` FOREIGN KEY (`id`) REFERENCES `enterprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coreenterprise
-- ----------------------------
INSERT INTO `coreenterprise` VALUES ('2019001', '500000');

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
INSERT INTO `enterprise` VALUES ('2019001', '15071429552', '123456', '1', '核心企业', '1', '1', 1);
INSERT INTO `enterprise` VALUES ('2019002', '15203881534', '123456', '11', '成员企业1', '11', '11', 2);
INSERT INTO `enterprise` VALUES ('2019003', '13123886950', '123456', '111', '供应商1', '111', '111', 3);
INSERT INTO `enterprise` VALUES ('2019004', '18222990843', '123456', '1111', '供应商2', '1111', '1111', 3);
INSERT INTO `enterprise` VALUES ('2019005', '15938870043', '123456', '11111', '保理商', '11111', '11111', 4);
INSERT INTO `enterprise` VALUES ('2019006', '13988888811', '123456', '111111', '供应商3', '111111', '111111', 3);

-- ----------------------------
-- Table structure for factor
-- ----------------------------
DROP TABLE IF EXISTS `factor`;
CREATE TABLE `factor`  (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `factor_ibfk_1` FOREIGN KEY (`id`) REFERENCES `enterprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of factor
-- ----------------------------
INSERT INTO `factor` VALUES ('2019005');

-- ----------------------------
-- Table structure for memberenterprise
-- ----------------------------
DROP TABLE IF EXISTS `memberenterprise`;
CREATE TABLE `memberenterprise`  (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `limit` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `memberenterprise_ibfk_1` FOREIGN KEY (`id`) REFERENCES `enterprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier`  (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `supplier_ibfk_1` FOREIGN KEY (`id`) REFERENCES `enterprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES ('2019006');

-- ----------------------------
-- Table structure for supplyrelation
-- ----------------------------
DROP TABLE IF EXISTS `supplyrelation`;
CREATE TABLE `supplyrelation`  (
  `id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mySupplier` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`, `mySupplier`) USING BTREE,
  INDEX `mySupplier`(`mySupplier`) USING BTREE,
  CONSTRAINT `supplyrelation_ibfk_1` FOREIGN KEY (`id`) REFERENCES `enterprise` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `supplyrelation_ibfk_2` FOREIGN KEY (`mySupplier`) REFERENCES `enterprise` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of supplyrelation
-- ----------------------------
INSERT INTO `supplyrelation` VALUES ('2019001', '2019003');
INSERT INTO `supplyrelation` VALUES ('2019003', '2019004');
INSERT INTO `supplyrelation` VALUES ('2019006', '2019004');

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
  `verifyInf` int(3) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `firstParty`(`firstParty`) USING BTREE,
  INDEX `secondParty`(`secondParty`) USING BTREE,
  CONSTRAINT `tradeinformation_ibfk_1` FOREIGN KEY (`firstParty`) REFERENCES `enterprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tradeinformation_ibfk_2` FOREIGN KEY (`secondParty`) REFERENCES `enterprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tradeinformation
-- ----------------------------
INSERT INTO `tradeinformation` VALUES ('20190330193235', '2019-03-30', '2019001', '2019004', '100', '测试开具功能', '2019033019323423', '2019033019323423', '2019033019323586', 3);
INSERT INTO `tradeinformation` VALUES ('20190330200734', '2019-03-30', '2019001', '2019003', '500', '测试开具功能', '2019033020073454', '2019033020073454', '2019033020073423', 3);
INSERT INTO `tradeinformation` VALUES ('20190330201143', '2019-03-30', '2019001', '2019003', '77', '测试开具功能', '2019033020114347', '2019033020114347', '2019033020114356', 3);
INSERT INTO `tradeinformation` VALUES ('20190330201753', '2019-03-30', '2019003', '2019004', '50', '测试转让功能', '2019033020122660', '2019033020175356', '2019033020175365', 2);
INSERT INTO `tradeinformation` VALUES ('20190330201929', '2019-03-30', '2019004', '2019005', '88', '测试融资功能', '2019033019323423', '2019033020192947', '2019033020192931', 3);
INSERT INTO `tradeinformation` VALUES ('20190330204705', '2019-03-30', '2019003', '2019004', '77', '测试转让功能', '2019033020114347', '2019033020470526', '2019033020470598', 2);
INSERT INTO `tradeinformation` VALUES ('20190331104831', '2019-03-31', '2019002', '2019004', '50', '测试开具功能', '2019033110483116', '2019033110483116', '2019033110483135', 2);
INSERT INTO `tradeinformation` VALUES ('20190331145720', '2019-03-31', '2019003', '2019005', '50', '测试融资功能', '2019033020175365', '2019033114571963', '2019033114571953', 1);

SET FOREIGN_KEY_CHECKS = 1;
