/*
Navicat MySQL Data Transfer

Source Server         : dcc
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : studentsystem

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2020-06-10 10:19:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` varchar(30) NOT NULL,
  `admin_name` varchar(30) DEFAULT NULL,
  `admin_ps` varchar(30) DEFAULT NULL,
  `title` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', '老张', '123456', '管理员1号');

-- ----------------------------
-- Table structure for dormitory
-- ----------------------------
DROP TABLE IF EXISTS `dormitory`;
CREATE TABLE `dormitory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `building_no` varchar(30) DEFAULT NULL,
  `dormitory_no` varchar(30) DEFAULT NULL,
  `cost` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dormitory
-- ----------------------------

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `building_no` varchar(30) DEFAULT NULL,
  `employee_no` varchar(30) DEFAULT NULL,
  `employee_name` varchar(30) DEFAULT NULL,
  `employee_ps` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', 'A1', 'sg1', '老李', '123456');

-- ----------------------------
-- Table structure for laterecord
-- ----------------------------
DROP TABLE IF EXISTS `laterecord`;
CREATE TABLE `laterecord` (
  `student_no` varchar(30) NOT NULL,
  `student_name` varchar(30) DEFAULT NULL,
  `building_no` varchar(30) DEFAULT NULL,
  `dormitory_no` varchar(30) DEFAULT NULL,
  `date` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`student_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of laterecord
-- ----------------------------
INSERT INTO `laterecord` VALUES ('s9527', '张三', 'A11', 's13', '2016-06-05');
INSERT INTO `laterecord` VALUES ('s9528', '李四', 'A2', 'ss', '2016-05=06				');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_no` varchar(30) DEFAULT NULL,
  `student_name` varchar(30) DEFAULT NULL,
  `student_sex` varchar(2) DEFAULT NULL,
  `department` varchar(30) DEFAULT NULL,
  `grade` varchar(30) DEFAULT NULL,
  `professional` varchar(30) DEFAULT NULL,
  `phonenumber` varchar(30) DEFAULT NULL,
  `int_time` varchar(30) DEFAULT NULL,
  `out_time` varchar(30) DEFAULT NULL,
  `building_no` varchar(30) DEFAULT NULL,
  `dormitory_no` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 's9527', '张三', '男', '经济管理学院', '2015', '经济学', '13112541214', '2015-09-01', '2018-06-07', 'A11', 's13');
INSERT INTO `student` VALUES ('2', 's9528', '李四', '男', '信电学院', '2015', '计算机', '15664656565', '2016-05-06', '2020-06-08', 'A2', 'ss');
