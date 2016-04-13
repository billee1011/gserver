/*
Navicat MySQL Data Transfer

Source Server         : 192.168.6.164
Source Server Version : 50626
Source Host           : 192.168.6.164:3306
Source Database       : game

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-04-13 13:20:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gu_login
-- ----------------------------
DROP TABLE IF EXISTS `gu_login`;
CREATE TABLE `gu_login` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL COMMENT '玩家id',
  `ip` varchar(50) DEFAULT NULL COMMENT '玩家ip',
  `createtime` datetime DEFAULT NULL COMMENT '玩家登录时间',
  `lastdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `status` int(11) DEFAULT '0' COMMENT '玩家状态(0:已登录,-1:已退出)',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
