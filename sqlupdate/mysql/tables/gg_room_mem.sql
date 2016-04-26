/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : game

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2016-04-26 23:46:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gg_room_mem
-- ----------------------------
DROP TABLE IF EXISTS `gg_room_mem`;
CREATE TABLE `gg_room_mem` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `k` varchar(10) DEFAULT NULL COMMENT '缓存key值(R_RoomNo,如:R_98712)',
  `v` varchar(20) DEFAULT NULL COMMENT '缓存的value值(游戏处理的服务ip:port)',
  `status` int(11) DEFAULT '1' COMMENT '是否有效(0:无效,1:有效)',
  `createdate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifydate` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
