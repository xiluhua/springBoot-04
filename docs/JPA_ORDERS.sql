/*
Navicat MySQL Data Transfer

Source Server         : 192.168.3.10_3306
Source Server Version : 50561
Source Host           : 192.168.3.10:3306
Source Database       : jpa

Target Server Type    : MYSQL
Target Server Version : 50561
File Encoding         : 65001

Date: 2019-02-07 23:43:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for JPA_ORDERS
-- ----------------------------
DROP TABLE IF EXISTS `JPA_ORDERS`;
CREATE TABLE `JPA_ORDERS` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderName` varchar(255) DEFAULT NULL,
  `CUSTOMER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_85wpb7frm8305lho66wj458mk` (`CUSTOMER_ID`),
  CONSTRAINT `FK_85wpb7frm8305lho66wj458mk` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `JPA_CUSTOMERS` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
