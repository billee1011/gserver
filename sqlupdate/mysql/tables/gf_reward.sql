/*
Navicat MySQL Data Transfer

Source Server         : 192.168.6.164
Source Server Version : 50626
Source Host           : 192.168.6.164:3306
Source Database       : game

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-04-13 13:20:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gf_reward
-- ----------------------------
DROP TABLE IF EXISTS `gf_reward`;
CREATE TABLE `gf_reward` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `type` int(11) DEFAULT NULL COMMENT '奖励发放方式(0:游戏币方式,1:微信红包,2:支付宝红包,...)',
  `rewardmoney` decimal(10,2) DEFAULT NULL COMMENT '奖励红包金额',
  `rewardmoneytax` decimal(10,2) DEFAULT NULL COMMENT '奖励红包抽水',
  `rewardcoin` int(11) DEFAULT NULL COMMENT '奖励游戏币金额',
  `rewardcointax` int(11) DEFAULT NULL COMMENT '奖励金币抽水',
  `status` int(11) DEFAULT NULL COMMENT '发放状态(0:未发放,1:正在发放中,2:发放成功,3:发放失败)',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
