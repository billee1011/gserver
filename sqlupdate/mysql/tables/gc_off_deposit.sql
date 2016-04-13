/*
Navicat MySQL Data Transfer

Source Server         : 192.168.6.164
Source Server Version : 50626
Source Host           : 192.168.6.164:3306
Source Database       : game

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-04-13 13:19:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gc_off_deposit
-- ----------------------------
DROP TABLE IF EXISTS `gc_off_deposit`;
CREATE TABLE `gc_off_deposit` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `amount` decimal(10,2) DEFAULT NULL COMMENT '充值金额',
  `off` int(11) DEFAULT NULL COMMENT '折扣值(按照整数来设置,比如九五折,设置为95)',
  `status` int(11) DEFAULT NULL COMMENT '是否有效(0:无效,1:有效)',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
