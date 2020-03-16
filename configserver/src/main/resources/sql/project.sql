/*
 Navicat Premium Data Transfer

 Source Server         : 172.16.200.12_30686
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : 172.16.200.12:30686
 Source Schema         : project

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 16/03/2020 10:47:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for test_domain
-- ----------------------------
DROP TABLE IF EXISTS `test_domain`;
CREATE TABLE `test_domain`  (
  `id` bigint(20) NOT NULL,
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `create_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `modified_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '最后修改人',
  `customer_id` bigint(20) NULL DEFAULT NULL COMMENT '客户ID',
  `lre_domain_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '关联LREdomainID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '域名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_domain
-- ----------------------------

-- ----------------------------
-- Table structure for test_pool
-- ----------------------------
DROP TABLE IF EXISTS `test_pool`;
CREATE TABLE `test_pool`  (
  `id` bigint(20) NOT NULL,
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `create_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `modified_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '最后修改人',
  `customer_id` bigint(20) NULL DEFAULT NULL COMMENT '客户ID',
  `lre_pool_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '关联LRE pool ID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'pool名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_pool
-- ----------------------------

-- ----------------------------
-- Table structure for test_pool_server
-- ----------------------------
DROP TABLE IF EXISTS `test_pool_server`;
CREATE TABLE `test_pool_server`  (
  `id` bigint(20) NOT NULL,
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `create_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `modified_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '最后修改人',
  `customer_id` bigint(20) NULL DEFAULT NULL COMMENT '客户ID',
  `pool_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'pool id',
  `server_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'server id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_pool_server
-- ----------------------------

-- ----------------------------
-- Table structure for test_project
-- ----------------------------
DROP TABLE IF EXISTS `test_project`;
CREATE TABLE `test_project`  (
  `id` bigint(20) NOT NULL,
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `create_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `modified_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '最后修改人',
  `customer_id` bigint(20) NULL DEFAULT NULL COMMENT '客户ID',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '项目名称',
  `state` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '项目状态 1 正常 2停用 3删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_project
-- ----------------------------

-- ----------------------------
-- Table structure for test_project_lre
-- ----------------------------
DROP TABLE IF EXISTS `test_project_lre`;
CREATE TABLE `test_project_lre`  (
  `id` bigint(20) NOT NULL,
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `create_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `modified_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '最后修改人',
  `customer_id` bigint(20) NULL DEFAULT NULL COMMENT '客户ID',
  `domain_id` bigint(20) NULL DEFAULT NULL COMMENT 'domain id',
  `lre_domain_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'lre domain id （冗余）',
  `pool_id` bigint(20) NULL DEFAULT NULL COMMENT 'pool_id',
  `host_limit` int(10) NULL DEFAULT NULL COMMENT '主机限制',
  `vuser_limit` int(10) NULL DEFAULT NULL COMMENT '虚拟用户限制',
  `concurrent_run_limit` int(10) NULL DEFAULT NULL,
  `db_connect` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '数据库连接字段',
  `db_user` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '数据库用户名',
  `db_pwd` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '数据库密码',
  `db_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '数据库类型 0 sqlserver 1 oracle',
  `lre_project_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '关联LRE项目ID',
  `project_id` bigint(20) NULL DEFAULT NULL COMMENT '项目ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_project_lre
-- ----------------------------

-- ----------------------------
-- Table structure for test_project_user
-- ----------------------------
DROP TABLE IF EXISTS `test_project_user`;
CREATE TABLE `test_project_user`  (
  `id` bigint(20) NOT NULL,
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `create_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `modified_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '最后修改人',
  `customer_id` bigint(20) NULL DEFAULT NULL COMMENT '客户ID',
  `project_id` bigint(20) NULL DEFAULT NULL COMMENT '项目ID',
  `project_lre_id` bigint(20) NULL DEFAULT NULL COMMENT 'LRE项目ID',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT 'userID',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '人员在该项目下的角色',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_project_user
-- ----------------------------

-- ----------------------------
-- Table structure for test_result
-- ----------------------------
DROP TABLE IF EXISTS `test_result`;
CREATE TABLE `test_result`  (
  `id` bigint(20) NOT NULL,
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `create_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `modified_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '最后修改人',
  `customer_id` bigint(20) NULL DEFAULT NULL COMMENT '客户ID',
  `domain_id` bigint(20) NULL DEFAULT NULL COMMENT '域ID （冗余）',
  `lre_domain_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'LRE中 域 id （冗余）',
  `project_id` bigint(20) NULL DEFAULT NULL COMMENT '项目ID （冗余）',
  `project_lre_id` bigint(20) NULL DEFAULT NULL COMMENT 'LRE 项目ID',
  `lre_project_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'LRE中 项目ID （冗余）',
  `test_id` bigint(20) NULL DEFAULT NULL COMMENT '测试ID （冗余）',
  `lre_test_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'LRE中测试ID （冗余）',
  `run_id` bigint(20) NULL DEFAULT NULL COMMENT 'runID',
  `lre_run_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'LRE中测试ID （冗余）',
  `lre_result_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'LRE中结果ID',
  `result_type` char(0) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '结果类型',
  `result_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '结果名称',
  `result_file_id` bigint(20) NULL DEFAULT NULL COMMENT '结果文件路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_result
-- ----------------------------

-- ----------------------------
-- Table structure for test_run
-- ----------------------------
DROP TABLE IF EXISTS `test_run`;
CREATE TABLE `test_run`  (
  `id` bigint(20) NOT NULL,
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `create_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `modified_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '最后修改人',
  `customer_id` bigint(20) NULL DEFAULT NULL COMMENT '客户ID',
  `domain_id` bigint(20) NULL DEFAULT NULL COMMENT '域ID （冗余）',
  `lre_domain_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'LRE中域 id （冗余）',
  `project_id` bigint(20) NULL DEFAULT NULL COMMENT '项目ID （冗余）',
  `lre_project_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'LRE中项目ID （冗余）',
  `project_lre_id` int(11) NULL DEFAULT NULL COMMENT 'LRE项目ID （冗余）',
  `lre_test_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'LRE测试ID （冗余）',
  `test_id` bigint(20) NULL DEFAULT NULL COMMENT '项目ID',
  `lre_run_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'LRE测试ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_run
-- ----------------------------

-- ----------------------------
-- Table structure for test_test
-- ----------------------------
DROP TABLE IF EXISTS `test_test`;
CREATE TABLE `test_test`  (
  `id` bigint(20) NOT NULL,
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `create_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `modified_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '最后修改人',
  `customer_id` bigint(20) NULL DEFAULT NULL COMMENT '客户ID',
  `domain_id` bigint(20) NULL DEFAULT NULL COMMENT '域ID （冗余）',
  `lre_domain_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'LRE 域 id （冗余）',
  `project_id` bigint(20) NULL DEFAULT NULL COMMENT '项目ID （冗余）',
  `lre_project_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'LRE 中 项目ID （冗余）',
  `project_lre_id` bigint(20) NULL DEFAULT NULL COMMENT 'LRE项目ID',
  `lre_test_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'LRE中 测试ID',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '测试名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_test
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
