/*
Navicat MySQL Data Transfer

Source Server         : 192.168.6.164
Source Server Version : 50626
Source Host           : 192.168.6.164:3306
Source Database       : game

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-04-13 13:20:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gf_score
-- ----------------------------
DROP TABLE IF EXISTS `gf_score`;
CREATE TABLE `gf_score` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `roomid` bigint(20) NOT NULL COMMENT '房间id',
  `round` int(11) DEFAULT NULL COMMENT '第几局',
  `uid` int(11) DEFAULT NULL COMMENT '用户id',
  `score` int(11) DEFAULT NULL COMMENT '用户本局分数',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
