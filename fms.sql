/*
Navicat MySQL Data Transfer

Source Server         : com.car
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : fms

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-06-24 20:55:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) DEFAULT NULL,
  `admin_password` varchar(255) DEFAULT NULL,
  `admin_role` int(11) DEFAULT '0' COMMENT '管理员角色',
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'system', '4QrcOUm6Wau+VuBX8g+IPg==', '1', null);

-- ----------------------------
-- Table structure for t_car
-- ----------------------------
DROP TABLE IF EXISTS `t_car`;
CREATE TABLE `t_car` (
  `car_id` int(11) NOT NULL AUTO_INCREMENT,
  `car_name` varchar(255) DEFAULT NULL,
  `car_number` varchar(255) DEFAULT NULL,
  `car_brand` varchar(255) DEFAULT NULL,
  `car_size` int(11) DEFAULT NULL,
  `car_register_date` varchar(255) DEFAULT NULL,
  `car_insurance_date` varchar(255) DEFAULT NULL,
  `car_registration` varchar(255) DEFAULT NULL,
  `driver_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`car_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_car
-- ----------------------------
INSERT INTO `t_car` VALUES ('1', '凯美瑞', '粤E4321K', '广汽丰田', '5', '2019-06-19', '2019-06-19', '1231231231231231', '1');
INSERT INTO `t_car` VALUES ('2', 'C-HR', '粤A1MCR7', '广汽丰田', '5', '2019-06-27', '2019-06-27', '4564564564564564', '2');
INSERT INTO `t_car` VALUES ('3', '雅阁', '粤A666JH', '广汽本田', '5', '2019-06-21', '2019-06-21', '7897897897897897', '3');

-- ----------------------------
-- Table structure for t_department
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department` (
  `department_id` int(11) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_department
-- ----------------------------
INSERT INTO `t_department` VALUES ('1', '外包161', '计算机科学与技术（外包特色班）');
INSERT INTO `t_department` VALUES ('2', '外包162', '班级名称');
INSERT INTO `t_department` VALUES ('3', '生医161', '生物医学工程');
INSERT INTO `t_department` VALUES ('4', '生医162', '生物医学工程');

-- ----------------------------
-- Table structure for t_driver
-- ----------------------------
DROP TABLE IF EXISTS `t_driver`;
CREATE TABLE `t_driver` (
  `driver_id` int(11) NOT NULL AUTO_INCREMENT,
  `driver_name` varchar(255) DEFAULT NULL,
  `driver_license` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`driver_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_driver
-- ----------------------------
INSERT INTO `t_driver` VALUES ('1', '樱杰', '441827xxxxxxxxxxxx');
INSERT INTO `t_driver` VALUES ('2', '克总', '441283xxxxxxxxxxxx');
INSERT INTO `t_driver` VALUES ('3', '老胡', '440103xxxxxxxxxxxx');
INSERT INTO `t_driver` VALUES ('4', '熊经理', '440782xxxxxxxxxxxx');
INSERT INTO `t_driver` VALUES ('5', '小桃', '440782xxxxxxxxxxxx');
INSERT INTO `t_driver` VALUES ('6', '小朋友', '440103xxxxxxxxxxxx');
INSERT INTO `t_driver` VALUES ('7', '味甜', '441827xxxxxxxxxxxx');

-- ----------------------------
-- Table structure for t_employee
-- ----------------------------
DROP TABLE IF EXISTS `t_employee`;
CREATE TABLE `t_employee` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(255) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1600502115 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_employee
-- ----------------------------
INSERT INTO `t_employee` VALUES ('1600502101', '小克', '1', '1');
INSERT INTO `t_employee` VALUES ('1600502102', '吉普森', '1', '1');
INSERT INTO `t_employee` VALUES ('1600502103', '锦江', '1', '1');
INSERT INTO `t_employee` VALUES ('1600502104', '小钢炮', '1', '1');
INSERT INTO `t_employee` VALUES ('1600502105', '王子', '1', '1');
INSERT INTO `t_employee` VALUES ('1600502106', '欢喜哥', '2', '2');
INSERT INTO `t_employee` VALUES ('1600502107', 'B超', '1', '1');
INSERT INTO `t_employee` VALUES ('1600502108', 'Xender', '1', '1');
INSERT INTO `t_employee` VALUES ('1600502109', '老胡', '1', '2');
INSERT INTO `t_employee` VALUES ('1600502110', '墨子', '1', '2');
INSERT INTO `t_employee` VALUES ('1600502111', '夜夜夜夜', '1', '1');
INSERT INTO `t_employee` VALUES ('1600502112', '宇文化及', '1', '1');
INSERT INTO `t_employee` VALUES ('1600502113', '慧仪', '1', '1');
INSERT INTO `t_employee` VALUES ('1600502114', '折翼', '1', '1');

-- ----------------------------
-- Table structure for t_employee_record
-- ----------------------------
DROP TABLE IF EXISTS `t_employee_record`;
CREATE TABLE `t_employee_record` (
  `er_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `schedule_id` int(11) DEFAULT NULL,
  `station_id` int(11) DEFAULT NULL,
  `boarding_time` varchar(255) DEFAULT NULL COMMENT '上车时间',
  `status` varchar(255) DEFAULT NULL COMMENT '乘车状态',
  PRIMARY KEY (`er_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_employee_record
-- ----------------------------

-- ----------------------------
-- Table structure for t_group
-- ----------------------------
DROP TABLE IF EXISTS `t_group`;
CREATE TABLE `t_group` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_group
-- ----------------------------
INSERT INTO `t_group` VALUES ('1', '洗洗睡吧梦之队', '王者战队');
INSERT INTO `t_group` VALUES ('2', '外包制药厂', '足球队');
INSERT INTO `t_group` VALUES ('3', '信工团学', '团委学生会');

-- ----------------------------
-- Table structure for t_line
-- ----------------------------
DROP TABLE IF EXISTS `t_line`;
CREATE TABLE `t_line` (
  `line_id` int(11) NOT NULL AUTO_INCREMENT,
  `line_name` varchar(255) DEFAULT NULL,
  `departure_id` int(11) DEFAULT NULL COMMENT '始发站编号',
  `destination_id` int(11) DEFAULT NULL COMMENT '终点站编号',
  PRIMARY KEY (`line_id`),
  KEY `departure` (`departure_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_line
-- ----------------------------
INSERT INTO `t_line` VALUES ('1', '广药环线', '1', '1');
INSERT INTO `t_line` VALUES ('2', '广外环线', '2', '2');

-- ----------------------------
-- Table structure for t_line_station
-- ----------------------------
DROP TABLE IF EXISTS `t_line_station`;
CREATE TABLE `t_line_station` (
  `ls_id` int(11) NOT NULL AUTO_INCREMENT,
  `sequence` int(11) DEFAULT NULL COMMENT '站线顺序',
  `line_id` int(11) DEFAULT NULL,
  `station_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ls_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_line_station
-- ----------------------------
INSERT INTO `t_line_station` VALUES ('1', '1', '1', '1');
INSERT INTO `t_line_station` VALUES ('2', '0', '1', '1');
INSERT INTO `t_line_station` VALUES ('3', '1', '2', '2');
INSERT INTO `t_line_station` VALUES ('4', '0', '2', '2');
INSERT INTO `t_line_station` VALUES ('5', '2', '1', '3');
INSERT INTO `t_line_station` VALUES ('6', '2', '2', '3');

-- ----------------------------
-- Table structure for t_schedule
-- ----------------------------
DROP TABLE IF EXISTS `t_schedule`;
CREATE TABLE `t_schedule` (
  `schedule_id` int(11) NOT NULL AUTO_INCREMENT,
  `line_id` int(11) DEFAULT NULL,
  `car_id` int(11) DEFAULT NULL,
  `departure_time` varchar(255) DEFAULT NULL COMMENT '发车时间',
  PRIMARY KEY (`schedule_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_schedule
-- ----------------------------
INSERT INTO `t_schedule` VALUES ('1', '1', '1', '2019-06-12T12:36');
INSERT INTO `t_schedule` VALUES ('2', '1', '2', '2019-06-25T12:00');
INSERT INTO `t_schedule` VALUES ('3', '1', '3', '2019-06-26T11:26');

-- ----------------------------
-- Table structure for t_schedule_record
-- ----------------------------
DROP TABLE IF EXISTS `t_schedule_record`;
CREATE TABLE `t_schedule_record` (
  `sr_id` int(11) NOT NULL AUTO_INCREMENT,
  `schedule_id` int(11) DEFAULT NULL,
  `passenger_number` int(11) DEFAULT NULL COMMENT '乘坐人数',
  `ride_ratio` double DEFAULT NULL COMMENT '乘载比率',
  PRIMARY KEY (`sr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_schedule_record
-- ----------------------------

-- ----------------------------
-- Table structure for t_station
-- ----------------------------
DROP TABLE IF EXISTS `t_station`;
CREATE TABLE `t_station` (
  `station_id` int(11) NOT NULL AUTO_INCREMENT,
  `station_name` varchar(255) DEFAULT NULL,
  `station_location` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`station_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_station
-- ----------------------------
INSERT INTO `t_station` VALUES ('1', '广药站', '大学城广药生活区');
INSERT INTO `t_station` VALUES ('2', '广外站', '大学城广外生活区');
INSERT INTO `t_station` VALUES ('3', '官洲隧道站', '广东省广州市海珠区官洲隧道');
