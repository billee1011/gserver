/*
Navicat MySQL Data Transfer

Source Server         : 192.168.6.164
Source Server Version : 50626
Source Host           : 192.168.6.164:3306
Source Database       : game

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-04-13 13:20:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gu_deposit
-- ----------------------------
DROP TABLE IF EXISTS `gu_deposit`;
CREATE TABLE `gu_deposit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL COMMENT '用户id',
  `type` int(11) DEFAULT NULL COMMENT '类型(0:现金充值,1:微信充值,2:支付宝充值,9:转账)',
  `amount` decimal(10,2) DEFAULT NULL COMMENT '充值金额',
  `offamount` decimal(10,2) DEFAULT NULL COMMENT '充值折扣金额',
  `ratio` int(11) DEFAULT NULL COMMENT '比例倍数(游戏币的倍数)',
  `coins` bigint(20) DEFAULT NULL COMMENT '充值金币数量',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '充值时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
