/*
Navicat MySQL Data Transfer

Source Server         : xw
Source Server Version : 60011
Source Host           : localhost:3306
Source Database       : xw_taes

Target Server Type    : MYSQL
Target Server Version : 60011
File Encoding         : 65001

Date: 2019-05-14 07:40:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_xw_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_xw_order`;
CREATE TABLE `t_xw_order` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ORDER_NUM` varchar(50) NOT NULL COMMENT '订单编号',
  `ORDER_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '下单时间',
  `PEOPLE_COUNT` int(11) DEFAULT NULL COMMENT '出行人数',
  `ORDER_DESC` varchar(500) DEFAULT NULL COMMENT '订单描述',
  `PAY_TYPE` int(11) DEFAULT NULL COMMENT '支付方式（0 支付宝 1 微信 2 其他）',
  `ORDER_STATUS` int(11) DEFAULT NULL COMMENT '订单状态（0 未支付 1 已支付）',
  `PRODUCT_ID` int(11) DEFAULT NULL COMMENT '产品Id 外键',
  `MEMBER_ID` int(11) DEFAULT NULL COMMENT '会员id',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_xw_order
-- ----------------------------

-- ----------------------------
-- Table structure for `t_xw_order_passenger`
-- ----------------------------
DROP TABLE IF EXISTS `t_xw_order_passenger`;
CREATE TABLE `t_xw_order_passenger` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ORDER_ID` int(11) DEFAULT NULL COMMENT '订单id',
  `PASSENGER_ID` int(11) DEFAULT NULL COMMENT '旅客id',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_xw_order_passenger
-- ----------------------------

-- ----------------------------
-- Table structure for `t_xw_passenger`
-- ----------------------------
DROP TABLE IF EXISTS `t_xw_passenger`;
CREATE TABLE `t_xw_passenger` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(20) DEFAULT NULL COMMENT '姓名',
  `SEX` varchar(20) DEFAULT NULL COMMENT '性别',
  `PHONE_NUM` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `CREDENTIALS_TYPE` int(11) DEFAULT NULL COMMENT '证件类型 0 身份证 1 护照 2 军官证',
  `CREDENTIALS_NUM` varchar(50) DEFAULT NULL COMMENT '证件号码',
  `TRAVELLER_TYPE` int(11) DEFAULT NULL COMMENT '旅客类型0 成人 1 儿童',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_xw_passenger
-- ----------------------------

-- ----------------------------
-- Table structure for `t_xw_product`
-- ----------------------------
DROP TABLE IF EXISTS `t_xw_product`;
CREATE TABLE `t_xw_product` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键标志',
  `PRODUCT_NUM` varchar(50) NOT NULL COMMENT '产品编号，唯一，不为空',
  `PRODUCT_NAME` varchar(50) DEFAULT NULL COMMENT '产品名称',
  `CITY_NAME` varchar(50) DEFAULT NULL COMMENT '出发城市',
  `DEPARTURE_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '出发时间',
  `PRODUCT_PRICE` double(11,2) DEFAULT NULL COMMENT '产品价格',
  `PRODUCT_DESC` text COMMENT '产品描述',
  `PRODUCT_STATUS` int(11) DEFAULT NULL COMMENT '状态（0 关闭 1 开启）',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_xw_product
-- ----------------------------

-- ----------------------------
-- Table structure for `t_xw_s_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_xw_s_log`;
CREATE TABLE `t_xw_s_log` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `VISIT_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '访问时间',
  `USER_NAME` varchar(20) DEFAULT NULL COMMENT '操作者用户名',
  `IP` varchar(30) DEFAULT NULL COMMENT '访问ip',
  `URL` varchar(100) DEFAULT NULL COMMENT '访问资源URL',
  `EXECUTION_TIME` int(11) DEFAULT NULL COMMENT '执行时长',
  `METHOD` varchar(200) DEFAULT NULL COMMENT '访问方法',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_xw_s_log
-- ----------------------------

-- ----------------------------
-- Table structure for `t_xw_s_permission`
-- ----------------------------
DROP TABLE IF EXISTS `t_xw_s_permission`;
CREATE TABLE `t_xw_s_permission` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `PERMISSION_NAME` varchar(20) DEFAULT NULL COMMENT '权限名',
  `URL` varchar(100) DEFAULT NULL COMMENT '资源路径',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_xw_s_permission
-- ----------------------------

-- ----------------------------
-- Table structure for `t_xw_s_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_xw_s_role`;
CREATE TABLE `t_xw_s_role` (
  `ID` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ROLE_NAME` varchar(20) DEFAULT NULL COMMENT '角色名',
  `ROLE_DESC` varchar(200) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_xw_s_role
-- ----------------------------

-- ----------------------------
-- Table structure for `t_xw_s_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `t_xw_s_role_permission`;
CREATE TABLE `t_xw_s_role_permission` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ROLE_ID` int(11) DEFAULT NULL COMMENT '角色id',
  `PERMISSION_ID` int(11) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_xw_s_role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for `t_xw_s_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_xw_s_user`;
CREATE TABLE `t_xw_s_user` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `EMAIL` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `USER_NAME` varchar(20) DEFAULT NULL COMMENT '用户名',
  `PASSWORD` varchar(100) DEFAULT NULL COMMENT '密码',
  `PHONE_NUM` varchar(30) DEFAULT NULL COMMENT '电话',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态0 未开启 1 开启',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_xw_s_user
-- ----------------------------

-- ----------------------------
-- Table structure for `t_xw_s_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_xw_s_user_role`;
CREATE TABLE `t_xw_s_user_role` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `USER_ID` int(11) DEFAULT NULL COMMENT '用户id',
  `ROLE_ID` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_xw_s_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for `t_xw_vip_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_xw_vip_user`;
CREATE TABLE `t_xw_vip_user` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(20) DEFAULT NULL COMMENT '姓名',
  `NICK_NAME` varchar(20) DEFAULT NULL COMMENT '昵称',
  `PHONE_NUM` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `EMAIL` varchar(50) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_xw_vip_user
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'xw', '123', '熊伟');
INSERT INTO `user` VALUES ('2', 'xm', '234', '熊密');
