/*
Navicat MySQL Data Transfer

Source Server         : db2020
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : sfdb02

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2020-01-08 23:05:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `alarminfo`
-- ----------------------------
DROP TABLE IF EXISTS `alarminfo`;
CREATE TABLE `alarminfo` (
  `aid` int(10) NOT NULL DEFAULT '0',
  `adate` datetime DEFAULT NULL,
  `ax` decimal(5,2) DEFAULT NULL,
  `ay` decimal(5,2) DEFAULT NULL,
  `astatus` varchar(10) CHARACTER SET utf8 DEFAULT '空',
  `apoid` int(10) DEFAULT NULL,
  `aangle` decimal(2,2) DEFAULT NULL,
  `auid` int(10) DEFAULT NULL,
  `aeid` int(10) DEFAULT NULL,
  `aemessage` tinytext CHARACTER SET utf8,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of alarminfo
-- ----------------------------
INSERT INTO `alarminfo` VALUES ('1101', '2019-12-10 00:00:00', '6.00', '7.00', '空', '1', '0.22', '13001', null, '');
INSERT INTO `alarminfo` VALUES ('1102', '2019-12-11 00:00:00', '8.00', '9.00', '空', '2', '0.33', '13002', null, '');
INSERT INTO `alarminfo` VALUES ('1103', '2019-12-12 00:00:00', '7.00', '7.00', '误', '3', '0.23', '13005', '1001', '不是火灾');
INSERT INTO `alarminfo` VALUES ('1104', '2018-06-02 00:00:00', '5.00', '20.00', '正', '4', '0.35', '13005', '1001', '是火灾');

-- ----------------------------
-- Table structure for `alarm_movie`
-- ----------------------------
DROP TABLE IF EXISTS `alarm_movie`;
CREATE TABLE `alarm_movie` (
  `aid` int(11) DEFAULT NULL,
  `mid` int(11) NOT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of alarm_movie
-- ----------------------------
INSERT INTO `alarm_movie` VALUES ('1101', '1001');
INSERT INTO `alarm_movie` VALUES ('1102', '1002');
INSERT INTO `alarm_movie` VALUES ('1103', '1003');
INSERT INTO `alarm_movie` VALUES ('1104', '1004');

-- ----------------------------
-- Table structure for `c3p0testtable`
-- ----------------------------
DROP TABLE IF EXISTS `c3p0testtable`;
CREATE TABLE `c3p0testtable` (
  `a` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of c3p0testtable
-- ----------------------------

-- ----------------------------
-- Table structure for `loginfo`
-- ----------------------------
DROP TABLE IF EXISTS `loginfo`;
CREATE TABLE `loginfo` (
  `lid` int(10) NOT NULL AUTO_INCREMENT,
  `llevel` tinyint(5) DEFAULT NULL,
  `ldate` datetime DEFAULT NULL,
  `lcontent` tinytext CHARACTER SET utf8,
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of loginfo
-- ----------------------------
INSERT INTO `loginfo` VALUES ('23', '1', '2020-01-08 11:29:53', '查询已处理报警记录');
INSERT INTO `loginfo` VALUES ('24', '1', '2020-01-08 11:29:56', '增加报警记录列表页');
INSERT INTO `loginfo` VALUES ('25', '1', '2020-01-08 11:30:00', '进入次数统计页');
INSERT INTO `loginfo` VALUES ('26', '1', '2020-01-08 11:30:03', '进入状态页');
INSERT INTO `loginfo` VALUES ('27', '1', '2020-01-08 11:30:05', '进入时间统计页');
INSERT INTO `loginfo` VALUES ('28', '1', '2020-01-08 11:30:08', '进入视频搜索页');
INSERT INTO `loginfo` VALUES ('29', '1', '2020-01-08 11:30:10', '进入视频在线播放页');
INSERT INTO `loginfo` VALUES ('30', '3', '2020-01-08 11:56:54', '日志查询');
INSERT INTO `loginfo` VALUES ('31', '3', '2020-01-08 11:57:02', '日志查询');
INSERT INTO `loginfo` VALUES ('32', '3', '2020-01-08 12:33:20', '进入审核注册页');
INSERT INTO `loginfo` VALUES ('33', '3', '2020-01-08 12:53:45', '进入审核注册页');
INSERT INTO `loginfo` VALUES ('34', '3', '2020-01-08 12:54:40', '进入审核注册页');
INSERT INTO `loginfo` VALUES ('35', '3', '2020-01-08 13:05:52', '进入用户管理页');
INSERT INTO `loginfo` VALUES ('36', '3', '2020-01-08 13:06:22', '进入用户管理页');
INSERT INTO `loginfo` VALUES ('37', '3', '2020-01-08 13:06:27', '进入审核注册页');
INSERT INTO `loginfo` VALUES ('38', '3', '2020-01-08 13:06:30', '进入用户管理页');
INSERT INTO `loginfo` VALUES ('39', '3', '2020-01-08 13:15:34', '日志查询');
INSERT INTO `loginfo` VALUES ('40', '3', '2020-01-08 13:15:48', '进入用户管理页');
INSERT INTO `loginfo` VALUES ('41', '3', '2020-01-08 13:16:16', '进入用户管理页');
INSERT INTO `loginfo` VALUES ('42', '3', '2020-01-08 13:16:55', '进入用户管理页');
INSERT INTO `loginfo` VALUES ('43', '3', '2020-01-08 13:38:21', '进入查找用户页');
INSERT INTO `loginfo` VALUES ('44', '3', '2020-01-08 13:38:41', '进入用户管理页');
INSERT INTO `loginfo` VALUES ('45', '3', '2020-01-08 13:38:43', '进入查找用户页');
INSERT INTO `loginfo` VALUES ('46', '3', '2020-01-08 13:38:45', '进入审核注册页');
INSERT INTO `loginfo` VALUES ('47', '3', '2020-01-08 13:38:49', '进入用户管理页');
INSERT INTO `loginfo` VALUES ('48', '3', '2020-01-08 13:52:12', '进入用户管理页');
INSERT INTO `loginfo` VALUES ('49', '3', '2020-01-08 13:56:25', '进入用户管理页');
INSERT INTO `loginfo` VALUES ('50', '3', '2020-01-08 13:57:14', '日志查询');
INSERT INTO `loginfo` VALUES ('51', '1', '2020-01-08 14:08:10', '进入扑火人员定位');
INSERT INTO `loginfo` VALUES ('52', '1', '2020-01-08 14:08:17', '进入次数统计页');
INSERT INTO `loginfo` VALUES ('53', '1', '2020-01-08 14:08:21', '进入图片搜索页');
INSERT INTO `loginfo` VALUES ('54', '1', '2020-01-08 14:13:43', '进入视频搜索页');
INSERT INTO `loginfo` VALUES ('55', '1', '2020-01-08 14:14:15', '进入图片搜索页');
INSERT INTO `loginfo` VALUES ('56', '2', '2020-01-08 14:27:22', '进入视频搜索页');
INSERT INTO `loginfo` VALUES ('57', '2', '2020-01-08 14:27:24', '进入视频在线播放页');
INSERT INTO `loginfo` VALUES ('58', '2', '2020-01-08 14:27:28', '进入视频在线播放页');
INSERT INTO `loginfo` VALUES ('59', '2', '2020-01-08 14:27:28', '进入视频下载页');
INSERT INTO `loginfo` VALUES ('60', '2', '2020-01-08 14:27:31', '进入批量删除视频页');
INSERT INTO `loginfo` VALUES ('61', '2', '2020-01-08 14:27:49', '进入图片下载页');
INSERT INTO `loginfo` VALUES ('62', '2', '2020-01-08 14:27:52', '进入视频下载页');
INSERT INTO `loginfo` VALUES ('63', '3', '2020-01-08 14:28:22', '日志查询');
INSERT INTO `loginfo` VALUES ('64', '3', '2020-01-08 14:28:51', '进入审核注册页');
INSERT INTO `loginfo` VALUES ('65', '3', '2020-01-08 14:28:57', '进入查找用户页');
INSERT INTO `loginfo` VALUES ('66', '3', '2020-01-08 14:28:59', '进入用户管理页');
INSERT INTO `loginfo` VALUES ('67', '3', '2020-01-08 15:02:21', '进入审核注册页');
INSERT INTO `loginfo` VALUES ('68', '3', '2020-01-08 15:02:30', '进入用户管理页');
INSERT INTO `loginfo` VALUES ('69', '3', '2020-01-08 15:02:46', '进入查找用户页');
INSERT INTO `loginfo` VALUES ('70', '3', '2020-01-08 15:03:05', '进入用户管理页');
INSERT INTO `loginfo` VALUES ('71', '3', '2020-01-08 15:03:13', '进入审核注册页');
INSERT INTO `loginfo` VALUES ('72', '1', '2020-01-08 15:06:54', '进入视频搜索页');
INSERT INTO `loginfo` VALUES ('73', '1', '2020-01-08 15:07:36', '进入视频下载页');
INSERT INTO `loginfo` VALUES ('74', '1', '2020-01-08 15:07:54', '进入批量删除视频页');
INSERT INTO `loginfo` VALUES ('75', '1', '2020-01-08 15:07:57', '进入视频下载页');
INSERT INTO `loginfo` VALUES ('76', '1', '2020-01-08 15:08:00', '进入图片搜索页');
INSERT INTO `loginfo` VALUES ('77', '1', '2020-01-08 15:08:36', '进入图片下载页');
INSERT INTO `loginfo` VALUES ('78', '1', '2020-01-08 15:08:52', '进入图片删除页');
INSERT INTO `loginfo` VALUES ('79', '1', '2020-01-08 15:08:57', '进入图片删除页');
INSERT INTO `loginfo` VALUES ('80', '1', '2020-01-08 15:09:15', '确认报警事件');
INSERT INTO `loginfo` VALUES ('81', '1', '2020-01-08 15:09:19', '查询未处理报警记录');
INSERT INTO `loginfo` VALUES ('82', '1', '2020-01-08 15:09:28', '查询未处理报警记录');
INSERT INTO `loginfo` VALUES ('83', '1', '2020-01-08 15:09:33', '确认报警事件');
INSERT INTO `loginfo` VALUES ('84', '1', '2020-01-08 15:09:56', '查询已处理报警记录');
INSERT INTO `loginfo` VALUES ('85', '1', '2020-01-08 15:09:59', '查询未处理报警记录');
INSERT INTO `loginfo` VALUES ('86', '1', '2020-01-08 15:10:37', '确认报警事件');
INSERT INTO `loginfo` VALUES ('87', '1', '2020-01-08 15:10:40', '增加报警记录列表页');
INSERT INTO `loginfo` VALUES ('88', '1', '2020-01-08 15:10:42', '查询已处理报警记录');
INSERT INTO `loginfo` VALUES ('89', '1', '2020-01-08 15:10:44', '查询未处理报警记录');
INSERT INTO `loginfo` VALUES ('90', '1', '2020-01-08 15:10:49', '确认报警事件');
INSERT INTO `loginfo` VALUES ('91', '1', '2020-01-08 15:11:23', '进入次数统计页');
INSERT INTO `loginfo` VALUES ('92', '1', '2020-01-08 15:11:26', '进入状态页');
INSERT INTO `loginfo` VALUES ('93', '1', '2020-01-08 15:11:30', '进入时间统计页');
INSERT INTO `loginfo` VALUES ('94', '1', '2020-01-08 15:11:49', '进入扑火人员定位');
INSERT INTO `loginfo` VALUES ('95', '2', '2020-01-08 15:12:39', '进入图片搜索页');
INSERT INTO `loginfo` VALUES ('96', '2', '2020-01-08 15:12:44', '查询未处理报警记录');
INSERT INTO `loginfo` VALUES ('97', '2', '2020-01-08 15:12:49', '查询已处理报警记录');
INSERT INTO `loginfo` VALUES ('98', '2', '2020-01-08 15:12:56', '增加报警记录列表页');
INSERT INTO `loginfo` VALUES ('99', '3', '2020-01-08 15:13:30', '进入审核注册页');
INSERT INTO `loginfo` VALUES ('100', '3', '2020-01-08 15:13:34', '进入查找用户页');
INSERT INTO `loginfo` VALUES ('101', '3', '2020-01-08 15:13:36', '进入用户管理页');
INSERT INTO `loginfo` VALUES ('102', '3', '2020-01-08 15:13:49', '日志查询');
INSERT INTO `loginfo` VALUES ('103', '3', '2020-01-08 15:14:44', '进入查找用户页');
INSERT INTO `loginfo` VALUES ('104', '3', '2020-01-08 15:14:54', '日志查询');
INSERT INTO `loginfo` VALUES ('105', '1', '2020-01-08 15:38:28', '进入批量删除视频页');
INSERT INTO `loginfo` VALUES ('106', '1', '2020-01-08 15:42:03', '进入批量删除视频页');
INSERT INTO `loginfo` VALUES ('107', '1', '2020-01-08 15:42:20', '进入扑火人员定位');
INSERT INTO `loginfo` VALUES ('108', '3', '2020-01-08 21:16:08', '日志查询');

-- ----------------------------
-- Table structure for `manageuser`
-- ----------------------------
DROP TABLE IF EXISTS `manageuser`;
CREATE TABLE `manageuser` (
  `muid` int(10) NOT NULL DEFAULT '0',
  `muname` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `mupwd` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`muid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of manageuser
-- ----------------------------

-- ----------------------------
-- Table structure for `movieinfo`
-- ----------------------------
DROP TABLE IF EXISTS `movieinfo`;
CREATE TABLE `movieinfo` (
  `mid` int(10) NOT NULL AUTO_INCREMENT,
  `mname` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `mdate` datetime DEFAULT NULL,
  `mpaddress` varchar(20) DEFAULT NULL,
  `mdaddress` varchar(20) DEFAULT NULL,
  `mtype` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `mlocation` int(10) DEFAULT NULL,
  `muid` int(10) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=1007 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of movieinfo
-- ----------------------------
INSERT INTO `movieinfo` VALUES ('1001', 'm101', '2017-09-28 16:18:21', 'm101.mp4', 'pic10101.jpg', 'mp4', '1', '1001');
INSERT INTO `movieinfo` VALUES ('1002', 'm102', '2017-09-28 12:35:55', 'm102.mp4', 'pic10201.jpg', 'mp4', '2', '1002');
INSERT INTO `movieinfo` VALUES ('1003', 'm103', '2017-09-29 06:08:00', 'm103.mp4', 'pic10301.jpg', 'mp4', '3', '1002');
INSERT INTO `movieinfo` VALUES ('1004', 'm104', '2017-09-28 16:17:43', 'm104.mp4', 'pic10401.jpg', 'mp4', '4', '1001');
INSERT INTO `movieinfo` VALUES ('1005', '删除测试1', '2020-01-08 00:00:00', 'm102.mp4', 'pic10101.jpg', 'mp4', '1', '1001');
INSERT INTO `movieinfo` VALUES ('1006', '删除测试2', '2020-01-09 00:00:00', 'm101.mp4', 'pic10201.jpg', 'mp4', '2', '1002');

-- ----------------------------
-- Table structure for `movie_picture`
-- ----------------------------
DROP TABLE IF EXISTS `movie_picture`;
CREATE TABLE `movie_picture` (
  `pid` int(20) NOT NULL DEFAULT '0',
  `mid` int(20) NOT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of movie_picture
-- ----------------------------
INSERT INTO `movie_picture` VALUES ('1', '1001');
INSERT INTO `movie_picture` VALUES ('2', '1001');
INSERT INTO `movie_picture` VALUES ('3', '1001');
INSERT INTO `movie_picture` VALUES ('4', '1001');
INSERT INTO `movie_picture` VALUES ('5', '1002');
INSERT INTO `movie_picture` VALUES ('6', '1002');
INSERT INTO `movie_picture` VALUES ('7', '1002');
INSERT INTO `movie_picture` VALUES ('8', '1002');
INSERT INTO `movie_picture` VALUES ('9', '1003');
INSERT INTO `movie_picture` VALUES ('10', '1003');
INSERT INTO `movie_picture` VALUES ('11', '1003');
INSERT INTO `movie_picture` VALUES ('12', '1003');
INSERT INTO `movie_picture` VALUES ('13', '1004');
INSERT INTO `movie_picture` VALUES ('14', '1004');
INSERT INTO `movie_picture` VALUES ('15', '1004');
INSERT INTO `movie_picture` VALUES ('16', '1004');

-- ----------------------------
-- Table structure for `pictureinfo`
-- ----------------------------
DROP TABLE IF EXISTS `pictureinfo`;
CREATE TABLE `pictureinfo` (
  `pid` int(10) NOT NULL DEFAULT '0',
  `pname` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `presolution` varchar(20) DEFAULT NULL,
  `pdaddress` varchar(40) DEFAULT NULL,
  `paddress` varchar(40) DEFAULT NULL,
  `ptype` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `pdate` datetime DEFAULT NULL,
  `poid` int(20) DEFAULT NULL,
  `puid` int(10) DEFAULT NULL,
  `pcmethod` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of pictureinfo
-- ----------------------------
INSERT INTO `pictureinfo` VALUES ('1', 'pic10101', '640*480', 'xxx', 'pic10101.jpg', 'jpg', '2017-09-28 16:17:28', '1', '1001', '分片随机截取');
INSERT INTO `pictureinfo` VALUES ('2', 'pic10102', '640*480', 'xxx', 'pic10102.jpg', 'jpg', '2017-09-28 16:18:01', '1', '1001', '分片随机截取');
INSERT INTO `pictureinfo` VALUES ('3', 'pic10103', '640*480', 'xxx', 'pic10103.jpg', 'jpg', '2017-09-28 16:18:42', '1', '1001', '分片随机截取');
INSERT INTO `pictureinfo` VALUES ('4', 'pic10104', '640*480', 'xxx', 'pic10104.jpg', 'jpg', '2017-09-28 16:19:11', '1', '1001', '分片随机截取');
INSERT INTO `pictureinfo` VALUES ('5', 'pic10201', '640*480', 'xxx', 'pic10201.jpg', 'jpg', '2017-09-28 12:35:56', '2', '1002', '分片随机截取');
INSERT INTO `pictureinfo` VALUES ('6', 'pic10202', '640*480', 'xxx', 'pic10202.jpg', 'jpg', '2017-09-28 12:36:23', '2', '1002', '分片随机截取');
INSERT INTO `pictureinfo` VALUES ('7', 'pic10203', '640*480', 'xxx', 'pic10203.jpg', 'jpg', '2017-09-28 12:37:03', '2', '1002', '分片随机截取');
INSERT INTO `pictureinfo` VALUES ('8', 'pic10204', '640*480', 'xxx', 'pic10204.jpg', 'jpg', '2017-09-28 12:37:33', '2', '1002', '分片随机截取');
INSERT INTO `pictureinfo` VALUES ('9', 'pic10301', '640*480', 'xxx', 'pic10301.jpg', 'jpg', '2017-09-29 06:08:01', '3', '1002', '分片随机截取');
INSERT INTO `pictureinfo` VALUES ('10', 'pic10302', '640*480', 'xxx', 'pic10302.jpg', 'jpg', '2017-09-29 06:08:32', '3', '1002', '分片随机截取');
INSERT INTO `pictureinfo` VALUES ('11', 'pic10303', '640*480', 'xxx', 'pic10303.jpg', 'jpg', '2017-09-29 06:09:21', '3', '1002', '分片随机截取');
INSERT INTO `pictureinfo` VALUES ('12', 'pic10304', '640*480', 'xxx', 'pic10304.jpg', 'jpg', '2017-09-29 06:09:48', '3', '1002', '分片随机截取');
INSERT INTO `pictureinfo` VALUES ('13', 'pic10401', '640*480', 'xxx', 'pic10401.jpg', 'jpg', '2017-09-28 16:17:35', '4', '1002', '分片随机截取');
INSERT INTO `pictureinfo` VALUES ('14', 'pic10402', '640*480', 'xxx', 'pic10402.jpg', 'jpg', '2017-09-28 16:18:01', '4', '1002', '分片随机截取');
INSERT INTO `pictureinfo` VALUES ('15', 'pic10403', '640*480', 'xxx', 'pic10403.jpg', 'jpg', '2017-09-28 16:18:31', '4', '1002', '分片随机截取');
INSERT INTO `pictureinfo` VALUES ('16', 'pic10404', '640*480', 'xxx', 'pic10404.jpg', 'jpg', '2017-09-28 16:19:11', '4', '1002', '分片随机截取');

-- ----------------------------
-- Table structure for `positioninfo`
-- ----------------------------
DROP TABLE IF EXISTS `positioninfo`;
CREATE TABLE `positioninfo` (
  `poid` int(10) NOT NULL DEFAULT '0',
  `poname` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `poip` char(15) DEFAULT NULL,
  `poaltitude` decimal(5,2) DEFAULT NULL,
  `poPOI` char(20) DEFAULT NULL,
  PRIMARY KEY (`poid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of positioninfo
-- ----------------------------
INSERT INTO `positioninfo` VALUES ('1', '大门坨瞭望塔A点', 'A', '380.30', 'xxxx');
INSERT INTO `positioninfo` VALUES ('2', '大门坨瞭望塔B点', 'B', '450.30', 'xxxx');
INSERT INTO `positioninfo` VALUES ('3', '萝芭地瞭望塔C点', 'C', '398.60', 'xxxx');
INSERT INTO `positioninfo` VALUES ('4', '萝芭地瞭望塔D点', 'D', '420.70', 'xxxx');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(10) NOT NULL,
  `pwd` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1001', '123');
INSERT INTO `user` VALUES ('1002', '123');
INSERT INTO `user` VALUES ('1003', '123');
INSERT INTO `user` VALUES ('2004', '123');

-- ----------------------------
-- Table structure for `userdetail`
-- ----------------------------
DROP TABLE IF EXISTS `userdetail`;
CREATE TABLE `userdetail` (
  `uid` int(10) NOT NULL,
  `uname` varchar(15) CHARACTER SET utf8 DEFAULT NULL,
  `uemail` varchar(20) DEFAULT NULL,
  `uphone` varchar(15) DEFAULT NULL,
  `udept` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `udate` date DEFAULT NULL,
  `utype` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of userdetail
-- ----------------------------
INSERT INTO `userdetail` VALUES ('1001', '陈功', '777888@126.com', '1366666', '森林防火中心', '2016-02-06', '专家');
INSERT INTO `userdetail` VALUES ('1002', '张三', '33333@125.com', '1236549', '森林防火中心', '2016-03-01', '工作人员');
INSERT INTO `userdetail` VALUES ('1003', '李四', '66666@126.com', '1377777', '森林防火中心', '2015-10-03', '管理员');
INSERT INTO `userdetail` VALUES ('2004', '李一', '66666@126.com', '55456456', '深圳森林防火中心', '2015-03-02', '工作人员');

-- ----------------------------
-- Table structure for `waituser`
-- ----------------------------
DROP TABLE IF EXISTS `waituser`;
CREATE TABLE `waituser` (
  `uid` int(10) NOT NULL AUTO_INCREMENT,
  `uname` varchar(15) CHARACTER SET utf8 DEFAULT NULL,
  `upwd` varchar(15) DEFAULT NULL,
  `uemail` varchar(20) DEFAULT NULL,
  `uphone` varchar(15) NOT NULL DEFAULT '',
  `udept` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `udate` date DEFAULT NULL,
  `utype` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`uid`,`uphone`)
) ENGINE=InnoDB AUTO_INCREMENT=2005 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of waituser
-- ----------------------------
INSERT INTO `waituser` VALUES ('2002', '张二', '123', '222@126.com', '1235555', '北京森林防火中心', '2017-06-02', '工作人员');
INSERT INTO `waituser` VALUES ('2003', '张三', '123', '333@126.com', '123123', '杭州森林防火中心', '2015-03-05', '专家');
