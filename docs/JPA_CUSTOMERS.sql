/*
Navicat MySQL Data Transfer

Source Server         : 192.168.3.10_3306
Source Server Version : 50561
Source Host           : 192.168.3.10:3306
Source Database       : jpa

Target Server Type    : MYSQL
Target Server Version : 50561
File Encoding         : 65001

Date: 2019-02-07 14:36:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for JPA_CUSTOMERS
-- ----------------------------
DROP TABLE IF EXISTS `JPA_CUSTOMERS`;
CREATE TABLE `JPA_CUSTOMERS` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `birth` date DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `LAST_NAME` varchar(50) NOT NULL,
  `ADDR_ID` int(10) DEFAULT NULL COMMENT 'JPA_ADDRESSES 主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1360 DEFAULT CHARSET=utf8;
