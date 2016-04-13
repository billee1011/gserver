/*
Navicat MySQL Data Transfer

Source Server         : 192.168.6.164
Source Server Version : 50626
Source Host           : 192.168.6.164:3306
Source Database       : game

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-04-13 13:20:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gg_room
-- ----------------------------
DROP TABLE IF EXISTS `gg_room`;
CREATE TABLE `gg_room` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `roomno` int(11) NOT NULL COMMENT '房间号',
  `status` int(11) DEFAULT '1' COMMENT '房间状态(0:已经解散,1:正在进行中)',
  `gameid` int(11) DEFAULT NULL COMMENT '游戏id',
  `gametype` int(11) DEFAULT NULL COMMENT '游戏类型(0:免费房间,1:比赛房间)',
  `gameprice` bigint(20) DEFAULT '100000' COMMENT '游戏比赛价格(游戏币)',
  `round` int(11) NOT NULL DEFAULT '1' COMMENT '局数',
  `players` int(11) DEFAULT '1' COMMENT '房间人数',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  INDEX `idx_gr_rsg` (`roomno`, `status`, `gameid`) USING BTREE,
  UNIQUE INDEX `idx_gr_rr` (`roomno`, `remark`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
