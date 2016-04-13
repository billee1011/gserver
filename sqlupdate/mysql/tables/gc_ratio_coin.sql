/*
Navicat MySQL Data Transfer

Source Server         : 192.168.6.164
Source Server Version : 50626
Source Host           : 192.168.6.164:3306
Source Database       : game

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-04-13 13:19:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gc_ratio_coin
-- ----------------------------
DROP TABLE IF EXISTS `gc_ratio_coin`;
CREATE TABLE `gc_ratio_coin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ratio` int(11) DEFAULT '100000' COMMENT '比例值',
  `status` int(11) DEFAULT NULL COMMENT '是否有效(0:无效,1:有效)',
  `lastdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
