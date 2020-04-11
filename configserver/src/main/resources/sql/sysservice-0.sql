/*
 Navicat Premium Data Transfer

 Source Server         : 172.16.200.12_3306
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : 172.16.200.12:3306
 Source Schema         : sysservice-0

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 12/04/2020 00:18:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dict
-- ----------------------------
DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict`  (
  `id` bigint(20) NOT NULL,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '字典名称',
  `code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '字典code',
  `p_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '父级code',
  `path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '路径  \"code1/code2/code3\" 可用于验证重复',
  `order_no` int(3) NULL DEFAULT NULL COMMENT '排序序号,同级排序',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `create_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `modified_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '最后修改人',
  `is_delete` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '删除状态 0 正常 1删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id`(`id`) USING BTREE,
  INDEX `path`(`path`) USING BTREE,
  INDEX `p_code`(`p_code`, `code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dict
-- ----------------------------
INSERT INTO `dict` VALUES (688060335726264320, '人物', 'person', '', NULL, NULL, '2020-03-13 16:26:08', NULL, 'admin', NULL, NULL);
INSERT INTO `dict` VALUES (688061066302717952, '性别', 'sex', 'person', '/person/sex', NULL, '2020-03-13 16:29:02', NULL, 'admin', NULL, NULL);
INSERT INTO `dict` VALUES (688061299954810880, '民族', 'minzu', 'person', '/person/minzu', NULL, '2020-03-13 16:29:57', NULL, 'admin', NULL, NULL);
INSERT INTO `dict` VALUES (688061533170696192, '汉族', '0', 'minzu', '/person/minzu/0', NULL, '2020-03-13 16:30:53', NULL, 'admin', NULL, NULL);
INSERT INTO `dict` VALUES (688061672757133312, '回族', '1', 'minzu', '/person/minzu/1', NULL, '2020-03-13 16:31:26', NULL, 'admin', NULL, NULL);

-- ----------------------------
-- Table structure for file_0
-- ----------------------------
DROP TABLE IF EXISTS `file_0`;
CREATE TABLE `file_0`  (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文件名',
  `size` decimal(5, 0) NULL DEFAULT NULL COMMENT '文件大小',
  `path` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文件所在路径',
  `type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文件类型',
  `image_high` decimal(10, 2) NULL DEFAULT NULL COMMENT '图片高度',
  `bucket` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'OSS专用  ',
  `image_width` decimal(10, 2) NULL DEFAULT NULL COMMENT '图片宽度',
  `tenant_id` bigint(20) NULL DEFAULT NULL COMMENT '客户ID',
  `module` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '模块 0 system 1product 2order',
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `create_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `modified_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '最后修改人',
  `is_delete` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '删除状态 0 正常 1删除',
  `store_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '存储类型 0 oss 1本地',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `customer_id`(`module`, `tenant_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of file_0
-- ----------------------------

-- ----------------------------
-- Table structure for file_relation_0
-- ----------------------------
DROP TABLE IF EXISTS `file_relation_0`;
CREATE TABLE `file_relation_0`  (
  `id` bigint(20) NOT NULL,
  `type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '关联类型',
  `file_id` bigint(20) NOT NULL COMMENT '文件ID',
  `ref_id` bigint(20) NOT NULL COMMENT '关联对象ID',
  `tenant_id` bigint(20) NOT NULL,
  `module` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '模块',
  `gmt_create` datetime(0) NOT NULL,
  `gmt_modified` datetime(0) NOT NULL,
  `create_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `modified_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '最后修改人',
  `is_delete` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '删除状态 0 正常 1删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `module`(`module`, `tenant_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of file_relation_0
-- ----------------------------

-- ----------------------------
-- Table structure for log_0
-- ----------------------------
DROP TABLE IF EXISTS `log_0`;
CREATE TABLE `log_0`  (
  `id` bigint(20) NOT NULL,
  `tenant_id` bigint(20) NULL DEFAULT NULL COMMENT '客户ID',
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `create_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `modified_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '最后修改人',
  `is_delete` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '删除状态 0 正常 1删除',
  `type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '日志类型',
  `level` int(1) NULL DEFAULT NULL COMMENT '日志级别',
  `info` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '日志内容',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '日志状态(0 未处理 1 已处理 2无法处理)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log_0
-- ----------------------------

-- ----------------------------
-- Table structure for message_0
-- ----------------------------
DROP TABLE IF EXISTS `message_0`;
CREATE TABLE `message_0`  (
  `id` bigint(20) NOT NULL,
  `tenant_id` bigint(20) NULL DEFAULT NULL COMMENT '客户ID',
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `create_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `modified_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '最后修改人',
  `is_delete` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '删除状态 0 正常 1删除',
  `type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '消息类型',
  `send_type` char(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '000  第一位代表 站内 第二位代表 邮件 第三位代表 短信',
  `level` int(1) NULL DEFAULT NULL COMMENT '消息级别',
  `info` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '消息内容',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '消息状态(0 未读 1 已读)',
  `owner` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '消息接收人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message_0
-- ----------------------------

-- ----------------------------
-- Table structure for tenant
-- ----------------------------
DROP TABLE IF EXISTS `tenant`;
CREATE TABLE `tenant`  (
  `id` bigint(20) NOT NULL,
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `create_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `modified_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '最后修改人',
  `is_delete` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '删除状态 0 正常 1删除',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '单位名称',
  `no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '组织机构代码',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系人手机号码',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系人邮箱',
  `card_image_id` bigint(20) NULL DEFAULT NULL COMMENT '营业执照文件ID',
  `address` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '单位所在地址',
  `register_date` date NULL DEFAULT NULL COMMENT '注册日期',
  `state` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '认证状态 0 未认证 1已认证',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tenant
-- ----------------------------
INSERT INTO `tenant` VALUES (1, '2020-03-01 00:13:47', '2020-03-01 00:13:49', 'admin', 'admin', NULL, '运营方', NULL, NULL, NULL, NULL, NULL, NULL, '0');
INSERT INTO `tenant` VALUES (2, '2020-03-03 10:32:28', NULL, 'admin', NULL, NULL, '山东道普', NULL, NULL, NULL, NULL, NULL, '2020-03-03', '1');
INSERT INTO `tenant` VALUES (698237178668384256, '2020-04-10 18:25:13', NULL, 'system', NULL, '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tenant` VALUES (698240987096416256, '2020-04-10 18:40:24', NULL, 'system', NULL, '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tenant` VALUES (698246281528606720, '2020-04-10 19:01:16', NULL, 'system', NULL, '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tenant` VALUES (698248594586599424, '2020-04-10 19:10:35', NULL, 'system', NULL, '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL,
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `create_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `modified_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '最后修改人',
  `is_delete` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '删除状态 0 正常 1删除',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
  `account` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '账号',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `pwd` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `state` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '0 注销 1正常',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `account`(`account`) USING BTREE,
  INDEX `phone`(`phone`) USING BTREE,
  INDEX `email`(`email`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '2020-03-01 00:06:11', '2020-03-01 00:06:13', 'admin', 'admin', '0', 'admin', 'admin', 'admin', 'admin', '$2a$14$QFFQecziwCDo5DKsMLDrfetZjigXyRJMPtBhJTX/90xP3oAvLponO', '1');
INSERT INTO `user` VALUES (2, '2020-03-01 00:06:53', '2020-03-01 00:06:55', 'admin', 'admin', '0', 'cheng', 'cheng', 'cheng', 'cheng', '$2a$14$QFFQecziwCDo5DKsMLDrfetZjigXyRJMPtBhJTX/90xP3oAvLponO', '1');
INSERT INTO `user` VALUES (11, NULL, NULL, NULL, NULL, '0', NULL, 'gang', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (698237179846983680, '2020-04-10 18:25:16', NULL, 'system', NULL, '0', NULL, 'qqq', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (698241007602368512, '2020-04-10 18:40:29', NULL, 'system', NULL, '0', '张三', 'test01', '11', NULL, '1', NULL);
INSERT INTO `user` VALUES (698246289271291904, '2020-04-10 19:01:28', NULL, 'system', NULL, '0', '李四', 'test02', '1111', NULL, '1', NULL);
INSERT INTO `user` VALUES (698248595320602624, '2020-04-10 19:10:38', NULL, 'system', NULL, '0', '王五', 'test03', '112212', NULL, '1', NULL);

SET FOREIGN_KEY_CHECKS = 1;
