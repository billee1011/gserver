/*
Navicat MySQL Data Transfer

Source Server         : 192.168.6.164
Source Server Version : 50626
Source Host           : 192.168.6.164:3306
Source Database       : game

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-04-13 13:20:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gf_rank
-- ----------------------------
DROP TABLE IF EXISTS `gf_rank`;
CREATE TABLE `gf_rank` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `roomid` bigint(20) NOT NULL COMMENT '房间id',
  `uid` int(11) DEFAULT NULL COMMENT '玩家id',
  `rank` int(11) DEFAULT NULL COMMENT '房间结束玩局排名',
  `createtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
