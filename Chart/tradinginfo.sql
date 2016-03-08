/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : chart

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2015-12-30 14:55:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tradinginfo`
-- ----------------------------
DROP TABLE IF EXISTS `tradinginfo`;
CREATE TABLE `tradinginfo` (
  `trading_id` varchar(255) NOT NULL,
  `trading_goods_id` varchar(255) DEFAULT NULL,
  `trading_user_id` varchar(255) DEFAULT NULL,
  `trading_number` double DEFAULT NULL,
  PRIMARY KEY (`trading_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tradinginfo
-- ----------------------------
INSERT INTO `tradinginfo` VALUES ('1', '1', '1', '1');
