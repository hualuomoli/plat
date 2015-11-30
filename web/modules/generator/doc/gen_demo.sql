/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.182
Source Server Version : 50613
Source Host           : 192.168.1.182:3306
Source Database       : financial

Target Server Type    : MYSQL
Target Server Version : 50613
File Encoding         : 65001

Date: 2015-11-30 15:03:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gen_demo
-- ----------------------------
DROP TABLE IF EXISTS `gen_demo`;
CREATE TABLE `gen_demo` (
  `id` int(11) NOT NULL COMMENT '代码生成器测试表',
  `gen_code` varchar(32) NOT NULL COMMENT '编码',
  `gen_name` varchar(255) DEFAULT NULL COMMENT '名称',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `salary` double(10,2) DEFAULT NULL COMMENT '工资',
  `create_by` varchar(32) NOT NULL COMMENT '创建人',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(32) NOT NULL COMMENT '修改人',
  `update_date` datetime NOT NULL COMMENT '修改时间',
  `status` char(1) NOT NULL DEFAULT '1' COMMENT '状态，1正常',
  `remark` longtext COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
