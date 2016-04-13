/*
Navicat MySQL Data Transfer

Source Server         : 192.168.6.164
Source Server Version : 50626
Source Host           : 192.168.6.164:3306
Source Database       : game

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-04-13 13:20:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gg_room_player
-- ----------------------------
DROP TABLE IF EXISTS `gg_room_player`;
CREATE TABLE `gg_room_player` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` int(11) DEFAULT NULL COMMENT '东方玩家id',
  `roomid` bigint(20) DEFAULT NULL COMMENT '房间id',
  `position` int(11) NOT NULL COMMENT '位置序号',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `lastdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
