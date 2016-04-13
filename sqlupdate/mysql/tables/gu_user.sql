/*
Navicat MySQL Data Transfer

Source Server         : 192.168.6.164
Source Server Version : 50626
Source Host           : 192.168.6.164:3306
Source Database       : game

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-04-13 13:21:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gu_user
-- ----------------------------
DROP TABLE IF EXISTS `gu_user`;
CREATE TABLE `gu_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(50) DEFAULT NULL COMMENT '用户昵称',
  `icon` blob COMMENT '头像数据',
  `iconurl` varchar(255) DEFAULT NULL COMMENT '头像的url地址',
  `coin` bigint(20) DEFAULT '100000' COMMENT '账户所剩金币数',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_guser_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
