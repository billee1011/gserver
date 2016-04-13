/*
Navicat MySQL Data Transfer

Source Server         : 192.168.6.164
Source Server Version : 50626
Source Host           : 192.168.6.164:3306
Source Database       : game

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-04-13 13:20:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gc_ratio_tax
-- ----------------------------
DROP TABLE IF EXISTS `gc_ratio_tax`;
CREATE TABLE `gc_ratio_tax` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL COMMENT '抽税类型(0:红包抽税,1:金币抽税)',
  `taxratio` decimal(10,2) DEFAULT NULL COMMENT '抽税比例(例如:0.1即10%)',
  `status` int(11) DEFAULT NULL COMMENT '是否有效(0:无效,1:有效)',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
