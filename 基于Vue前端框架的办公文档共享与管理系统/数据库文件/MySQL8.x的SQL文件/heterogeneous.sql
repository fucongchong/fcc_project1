/*
 Navicat Premium Data Transfer

 Source Server         : db2021
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : heterogeneous

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 25/06/2021 15:24:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for db_node
-- ----------------------------
DROP TABLE IF EXISTS `db_node`;
CREATE TABLE `db_node`  (
  `link` int(0) NOT NULL,
  `dbtype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `dbname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `port` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `statement` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`link`) USING BTREE,
  CONSTRAINT `db_node_ibfk_1` FOREIGN KEY (`link`) REFERENCES `node` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_node
-- ----------------------------
INSERT INTO `db_node` VALUES (830, 'mysql', 'localhost', 'root', '123456', 'heterogeneous', '3306', 'select * from user');
INSERT INTO `db_node` VALUES (831, 'mysql', 'localhost', 'root', '123456', 'heterogeneous', '3306', 'select * from test');
INSERT INTO `db_node` VALUES (832, 'oracle', 'localhost', 'C##TEST', '123456', 'orcl', '1521', 'select * from \"test\"');
INSERT INTO `db_node` VALUES (833, 'mysql', 'localhost', 'root', '123456', 'heterogeneous', '3306', 'select * from test2');
INSERT INTO `db_node` VALUES (834, 'oracle', 'localhost', 'C##TEST', '123456', 'orcl', '1521', 'select * from \"CALTEST1\"');
INSERT INTO `db_node` VALUES (872, 'mysql', 'localhost', 'root', '123456', 'heterogeneous', '3306', 'select * from test2');

-- ----------------------------
-- Table structure for excel_txt
-- ----------------------------
DROP TABLE IF EXISTS `excel_txt`;
CREATE TABLE `excel_txt`  (
  `id` int(0) NOT NULL,
  `txtid` int(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of excel_txt
-- ----------------------------
INSERT INTO `excel_txt` VALUES (601, 607);
INSERT INTO `excel_txt` VALUES (669, 670);
INSERT INTO `excel_txt` VALUES (697, 698);
INSERT INTO `excel_txt` VALUES (701, 736);
INSERT INTO `excel_txt` VALUES (702, 731);
INSERT INTO `excel_txt` VALUES (722, 723);
INSERT INTO `excel_txt` VALUES (724, 725);
INSERT INTO `excel_txt` VALUES (730, 735);
INSERT INTO `excel_txt` VALUES (737, 738);
INSERT INTO `excel_txt` VALUES (739, 740);
INSERT INTO `excel_txt` VALUES (827, 871);
INSERT INTO `excel_txt` VALUES (830, 836);
INSERT INTO `excel_txt` VALUES (831, 837);
INSERT INTO `excel_txt` VALUES (832, 839);
INSERT INTO `excel_txt` VALUES (833, 838);
INSERT INTO `excel_txt` VALUES (834, 840);
INSERT INTO `excel_txt` VALUES (872, 873);
INSERT INTO `excel_txt` VALUES (874, 875);

-- ----------------------------
-- Table structure for file_node
-- ----------------------------
DROP TABLE IF EXISTS `file_node`;
CREATE TABLE `file_node`  (
  `link` int(0) NOT NULL,
  `filepath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`link`) USING BTREE,
  CONSTRAINT `file_node_ibfk_1` FOREIGN KEY (`link`) REFERENCES `node` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of file_node
-- ----------------------------
INSERT INTO `file_node` VALUES (463, 'D:\\study\\testPic\\tomato.PNG');
INSERT INTO `file_node` VALUES (465, 'D:\\study\\testPic\\tiger.PNG');
INSERT INTO `file_node` VALUES (507, 'D:\\study\\testPic\\cat1.PNG');
INSERT INTO `file_node` VALUES (607, 'D:\\study\\testFile\\num.txt');
INSERT INTO `file_node` VALUES (670, 'D:\\study\\testFile\\t1.txt');
INSERT INTO `file_node` VALUES (698, 'D:\\study\\testFile\\num.txt');
INSERT INTO `file_node` VALUES (723, 'server:fadee12a7bc847adb6d1fb1e8bb9146a_数学成绩.txt');
INSERT INTO `file_node` VALUES (725, 'D:\\study\\testFile\\数学成绩.txt');
INSERT INTO `file_node` VALUES (731, 'D:\\study\\testFile\\dbtable5429.txt');
INSERT INTO `file_node` VALUES (735, 'D:\\study\\testFile\\dbtable1405.txt');
INSERT INTO `file_node` VALUES (736, 'D:\\study\\testFile\\dbtable5083.txt');
INSERT INTO `file_node` VALUES (738, 'D:\\study\\testFile\\dbtable8432.txt');
INSERT INTO `file_node` VALUES (740, 'D:\\study\\testFile\\dbtable5813.txt');
INSERT INTO `file_node` VALUES (800, 'D:\\study\\testPic\\cat1.PNG');
INSERT INTO `file_node` VALUES (801, 'D:\\study\\testPic\\dog.PNG');
INSERT INTO `file_node` VALUES (802, 'D:\\study\\testPic\\eagle.PNG');
INSERT INTO `file_node` VALUES (803, 'D:\\study\\testPic\\tiger.PNG');
INSERT INTO `file_node` VALUES (806, 'D:\\study\\testPic\\apple.jpg');
INSERT INTO `file_node` VALUES (807, 'D:\\study\\testVideo\\waterMelonVideo.mp4');
INSERT INTO `file_node` VALUES (808, 'D:\\study\\testPic\\cherry.PNG');
INSERT INTO `file_node` VALUES (809, 'D:\\study\\testPic\\coco.PNG');
INSERT INTO `file_node` VALUES (810, 'D:\\study\\testPic\\strawberry.PNG');
INSERT INTO `file_node` VALUES (811, 'D:\\study\\testPic\\blueberry.PNG');
INSERT INTO `file_node` VALUES (812, 'D:\\study\\testPic\\banana.PNG');
INSERT INTO `file_node` VALUES (813, 'D:\\study\\testPic\\tangerine.PNG');
INSERT INTO `file_node` VALUES (814, 'D:\\study\\testPic\\mango.PNG');
INSERT INTO `file_node` VALUES (815, 'D:\\study\\testPic\\pomegranate.PNG');
INSERT INTO `file_node` VALUES (817, 'D:\\study\\testPic\\cabbage.PNG');
INSERT INTO `file_node` VALUES (818, 'D:\\study\\testPic\\corn.PNG');
INSERT INTO `file_node` VALUES (819, 'D:\\study\\testPic\\potato.PNG');
INSERT INTO `file_node` VALUES (820, 'D:\\study\\testPic\\garlic.PNG');
INSERT INTO `file_node` VALUES (821, 'D:\\study\\testPic\\tomato.PNG');
INSERT INTO `file_node` VALUES (826, 'server:3c0c91a112d3426abb3fd51137ed8ac3_语文成绩.txt');
INSERT INTO `file_node` VALUES (827, 'D:\\study\\testFile\\数学成绩.xlsx');
INSERT INTO `file_node` VALUES (828, 'D:\\study\\testFile\\计算机成绩.txt');
INSERT INTO `file_node` VALUES (835, 'D:\\study\\testFile\\语文成绩.txt');
INSERT INTO `file_node` VALUES (836, 'D:\\study\\testFile\\dbtable5479.txt');
INSERT INTO `file_node` VALUES (837, 'D:\\study\\testFile\\dbtable5895.txt');
INSERT INTO `file_node` VALUES (838, 'D:\\study\\testFile\\dbtable3695.txt');
INSERT INTO `file_node` VALUES (839, 'D:\\study\\testFile\\dbtable5348.txt');
INSERT INTO `file_node` VALUES (840, 'D:\\study\\testFile\\dbtable916.txt');
INSERT INTO `file_node` VALUES (844, 'D:\\study\\testFile\\语文成绩.txt');
INSERT INTO `file_node` VALUES (845, 'D:\\study\\testFile\\语文成绩.txt');
INSERT INTO `file_node` VALUES (846, 'D:\\study\\testFile\\语文成绩.txt');
INSERT INTO `file_node` VALUES (847, 'D:\\study\\testFile\\语文成绩.txt');
INSERT INTO `file_node` VALUES (849, 'D:\\study\\testPic\\cabbage.PNG');
INSERT INTO `file_node` VALUES (850, 'D:\\study\\testPic\\corn.PNG');
INSERT INTO `file_node` VALUES (851, 'D:\\study\\testPic\\potato.PNG');
INSERT INTO `file_node` VALUES (852, 'D:\\study\\testPic\\garlic.PNG');
INSERT INTO `file_node` VALUES (853, 'D:\\study\\testPic\\tomato.PNG');
INSERT INTO `file_node` VALUES (855, 'D:\\study\\testPic\\cabbage.PNG');
INSERT INTO `file_node` VALUES (856, 'D:\\study\\testPic\\corn.PNG');
INSERT INTO `file_node` VALUES (857, 'D:\\study\\testPic\\potato.PNG');
INSERT INTO `file_node` VALUES (858, 'D:\\study\\testPic\\garlic.PNG');
INSERT INTO `file_node` VALUES (859, 'D:\\study\\testPic\\tomato.PNG');
INSERT INTO `file_node` VALUES (861, 'D:\\study\\testPic\\cabbage.PNG');
INSERT INTO `file_node` VALUES (862, 'D:\\study\\testPic\\corn.PNG');
INSERT INTO `file_node` VALUES (863, 'D:\\study\\testPic\\potato.PNG');
INSERT INTO `file_node` VALUES (864, 'D:\\study\\testPic\\garlic.PNG');
INSERT INTO `file_node` VALUES (865, 'D:\\study\\testPic\\tomato.PNG');
INSERT INTO `file_node` VALUES (866, 'D:\\study\\testVideo\\waterMelonVideo.mp4');
INSERT INTO `file_node` VALUES (867, 'D:\\study\\testVideo\\waterMelonVideo.mp4');
INSERT INTO `file_node` VALUES (868, 'D:\\study\\testPic\\tangerine.PNG');
INSERT INTO `file_node` VALUES (869, 'D:\\study\\testFile\\语文成绩.txt');
INSERT INTO `file_node` VALUES (870, 'D:\\study\\testPic\\eagle.PNG');
INSERT INTO `file_node` VALUES (871, 'D:\\study\\testFile\\数学成绩.txt');
INSERT INTO `file_node` VALUES (873, 'D:\\study\\testFile\\dbtable7663.txt');
INSERT INTO `file_node` VALUES (875, 'D:\\study\\testFile\\dbtable7123.txt');

-- ----------------------------
-- Table structure for intermediate_result
-- ----------------------------
DROP TABLE IF EXISTS `intermediate_result`;
CREATE TABLE `intermediate_result`  (
  `mid` int(0) NOT NULL AUTO_INCREMENT,
  `interm_res` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `interm_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`mid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of intermediate_result
-- ----------------------------
INSERT INTO `intermediate_result` VALUES (1, '59.0,82.0,23.0,2.0,4.0,3.0,3.0,4.0,13.0,5.0,8.0,14.0', '2021-06-18 16:36:36');

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `log_id` int(0) NOT NULL AUTO_INCREMENT,
  `log_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `creator` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `operation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `log_type` int(0) DEFAULT NULL,
  PRIMARY KEY (`log_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7133 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES (7199, '2021-06-24 20:05:20', 'tom', 'tom用户登录成功', 0);
INSERT INTO `log` VALUES (7200, '2021-06-24 20:05:29', 'tom', 'tom展开结点:ROOT', 1);
INSERT INTO `log` VALUES (7201, '2021-06-24 20:05:30', 'tom', 'tom展开结点:ROOT/系统公有数据', 1);
INSERT INTO `log` VALUES (7202, '2021-06-24 20:05:32', 'tom', 'tom展开结点:ROOT/系统公有数据/动物', 1);
INSERT INTO `log` VALUES (7203, '2021-06-24 20:05:33', 'tom', '获取文件:ROOT/系统公有数据/动物/狗的内容', 1);
INSERT INTO `log` VALUES (7204, '2021-06-24 20:05:35', 'tom', 'tom展开结点:ROOT/系统公有数据/植物', 1);
INSERT INTO `log` VALUES (7205, '2021-06-24 20:05:36', 'tom', 'tom展开结点:ROOT/系统公有数据/植物/水果文件', 1);
INSERT INTO `log` VALUES (7206, '2021-06-24 20:05:37', 'tom', '获取文件:ROOT/系统公有数据/动物/狗的内容', 1);
INSERT INTO `log` VALUES (7207, '2021-06-24 20:05:37', 'tom', '获取文件:ROOT/系统公有数据/植物/水果文件/椰子的内容', 1);
INSERT INTO `log` VALUES (7208, '2021-06-24 20:05:37', 'tom', '获取文件:ROOT/系统公有数据/植物/水果文件/蓝莓的内容', 1);
INSERT INTO `log` VALUES (7209, '2021-06-24 20:05:38', 'tom', 'tom展开结点:ROOT/被授权数据(私有)', 1);
INSERT INTO `log` VALUES (7210, '2021-06-24 20:05:39', 'tom', '获取文件:ROOT/系统公有数据/植物/水果文件/蓝莓的内容', 1);
INSERT INTO `log` VALUES (7211, '2021-06-24 20:05:39', 'tom', '获取文件:ROOT/被授权数据(私有)/西瓜的视频的内容', 1);
INSERT INTO `log` VALUES (7212, '2021-06-24 20:06:00', 'super', 'super用户登录成功', 0);
INSERT INTO `log` VALUES (7213, '2021-06-24 20:06:02', 'super', 'super展开结点:ROOT', 1);
INSERT INTO `log` VALUES (7214, '2021-06-24 20:06:04', 'super', '接受授权数据ROOT/被授权数据(私有)/语文成绩1', 0);
INSERT INTO `log` VALUES (7215, '2021-06-24 20:06:05', 'super', 'super展开结点:ROOT', 1);
INSERT INTO `log` VALUES (7216, '2021-06-24 20:06:06', 'super', 'super展开结点:ROOT/被授权数据(私有)', 1);
INSERT INTO `log` VALUES (7217, '2021-06-24 20:06:07', 'super', '获取文件:ROOT/被授权数据(私有)/语文成绩1的内容', 1);
INSERT INTO `log` VALUES (7218, '2021-06-24 20:06:18', 'super', 'super展开结点:ROOT/被授权数据(私有)/蔬菜文件', 1);
INSERT INTO `log` VALUES (7219, '2021-06-24 20:06:18', 'super', '获取文件:ROOT/被授权数据(私有)/语文成绩1的内容', 1);
INSERT INTO `log` VALUES (7220, '2021-06-24 20:06:18', 'super', '获取文件:ROOT/被授权数据(私有)/蔬菜文件/白菜的内容', 1);
INSERT INTO `log` VALUES (7221, '2021-06-24 20:06:19', 'super', '获取文件:ROOT/被授权数据(私有)/蔬菜文件/玉米的内容', 1);
INSERT INTO `log` VALUES (7222, '2021-06-24 20:06:19', 'super', '获取文件:ROOT/被授权数据(私有)/蔬菜文件/土豆的内容', 1);
INSERT INTO `log` VALUES (7223, '2021-06-24 20:06:20', 'super', '获取文件:ROOT/被授权数据(私有)/蔬菜文件/大蒜的内容', 1);
INSERT INTO `log` VALUES (7224, '2021-06-24 20:06:20', 'super', '获取文件:ROOT/被授权数据(私有)/蔬菜文件/西红柿的内容', 1);
INSERT INTO `log` VALUES (7225, '2021-06-24 20:06:21', 'super', '获取文件:ROOT/被授权数据(私有)/橘子的内容', 1);
INSERT INTO `log` VALUES (7226, '2021-06-24 20:07:18', 'Bob1', 'Bob1用户登录成功', 0);
INSERT INTO `log` VALUES (7227, '2021-06-24 20:07:20', 'Bob1', 'Bob1展开结点:ROOT', 1);
INSERT INTO `log` VALUES (7228, '2021-06-24 20:07:22', 'Bob1', 'Bob1展开结点:ROOT/系统公有数据', 1);
INSERT INTO `log` VALUES (7229, '2021-06-24 20:07:23', 'Bob1', 'Bob1展开结点:ROOT/系统公有数据/动物', 1);
INSERT INTO `log` VALUES (7230, '2021-06-24 20:07:26', 'Bob1', 'Bob1展开结点:ROOT/系统公有数据/教师文件', 1);
INSERT INTO `log` VALUES (7231, '2021-06-24 20:07:30', 'Bob1', 'Bob1展开结点:ROOT/被授权数据(私有)', 1);
INSERT INTO `log` VALUES (7232, '2021-06-24 20:07:34', 'Bob1', 'Bob1展开结点:ROOT/系统公有数据/植物', 1);
INSERT INTO `log` VALUES (7233, '2021-06-24 20:07:41', 'Bob1', '获取数据库:ROOT/系统公有数据/教师文件/test2DB的内容', 1);
INSERT INTO `log` VALUES (7234, '2021-06-24 20:07:42', 'Bob1', '获取数据库:ROOT/系统公有数据/教师文件/test2DB的内容', 1);
INSERT INTO `log` VALUES (7235, '2021-06-24 20:07:42', 'Bob1', '获取文件:ROOT/系统公有数据/教师文件/语文成绩1的内容', 1);
INSERT INTO `log` VALUES (7236, '2021-06-24 20:07:43', 'Bob1', '获取数据库:ROOT/系统公有数据/教师文件/orDBtest1的内容', 1);
INSERT INTO `log` VALUES (7237, '2021-06-24 20:07:43', 'Bob1', '获取数据库:ROOT/系统公有数据/教师文件/orDBtest1的内容', 1);
INSERT INTO `log` VALUES (7238, '2021-06-24 20:07:45', 'Bob1', '获取数据库:ROOT/系统公有数据/教师文件/test2DB的内容', 1);
INSERT INTO `log` VALUES (7239, '2021-06-24 20:07:46', 'Bob1', '获取数据库:ROOT/系统公有数据/教师文件/oraDB1的内容', 1);
INSERT INTO `log` VALUES (7240, '2021-06-24 20:08:00', 'tom', 'tom展开结点:ROOT/系统公有数据/教师文件', 1);
INSERT INTO `log` VALUES (7241, '2021-06-24 20:08:03', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/test2DB的内容', 1);
INSERT INTO `log` VALUES (7242, '2021-06-24 20:08:04', 'tom', '访问权限管理列表', 0);
INSERT INTO `log` VALUES (7243, '2021-06-24 20:08:17', 'tom', '对:ROOT/系统公有数据/教师文件/test2DB授权', 0);
INSERT INTO `log` VALUES (7244, '2021-06-24 20:08:17', 'tom', '访问权限管理列表', 0);
INSERT INTO `log` VALUES (7245, '2021-06-24 20:08:22', 'tom', '访问权限管理列表', 0);
INSERT INTO `log` VALUES (7246, '2021-06-24 20:08:29', 'Bob1', 'Bob1用户登录成功', 0);
INSERT INTO `log` VALUES (7247, '2021-06-24 20:08:32', 'Bob1', 'Bob1展开结点:ROOT', 1);
INSERT INTO `log` VALUES (7248, '2021-06-24 20:08:33', 'Bob1', '接受授权数据ROOT/被授权数据(私有)/test2DB', 0);
INSERT INTO `log` VALUES (7249, '2021-06-24 20:08:34', 'Bob1', 'Bob1展开结点:ROOT', 1);
INSERT INTO `log` VALUES (7250, '2021-06-24 20:08:36', 'Bob1', 'Bob1展开结点:ROOT/被授权数据(私有)', 1);
INSERT INTO `log` VALUES (7251, '2021-06-24 20:08:37', 'Bob1', '获取数据库:ROOT/被授权数据(私有)/test2DB的内容', 1);
INSERT INTO `log` VALUES (7252, '2021-06-24 20:09:02', 'Bob1', '访问权限管理列表', 0);
INSERT INTO `log` VALUES (7253, '2021-06-24 20:09:10', 'Bob1', '对:ROOT/被授权数据(私有)/test2DB授权', 0);
INSERT INTO `log` VALUES (7254, '2021-06-24 20:09:10', 'Bob1', '访问权限管理列表', 0);
INSERT INTO `log` VALUES (7255, '2021-06-24 20:09:11', 'Bob1', '访问权限管理列表', 0);
INSERT INTO `log` VALUES (7256, '2021-06-24 20:09:24', 'super', 'super用户登录成功', 0);
INSERT INTO `log` VALUES (7257, '2021-06-24 20:09:26', 'super', 'super展开结点:ROOT', 1);
INSERT INTO `log` VALUES (7258, '2021-06-24 20:09:28', 'super', '接受授权数据ROOT/被授权数据(私有)/test2DB', 0);
INSERT INTO `log` VALUES (7259, '2021-06-24 20:09:29', 'super', 'super展开结点:ROOT', 1);
INSERT INTO `log` VALUES (7260, '2021-06-24 20:09:31', 'super', 'super展开结点:ROOT/被授权数据(私有)', 1);
INSERT INTO `log` VALUES (7261, '2021-06-24 20:09:33', 'super', '获取数据库:ROOT/被授权数据(私有)/test2DB的内容', 1);
INSERT INTO `log` VALUES (7262, '2021-06-24 20:09:57', 'Bob1', '访问权限管理列表', 0);
INSERT INTO `log` VALUES (7263, '2021-06-24 20:10:03', 'Bob1', '撤销ROOT/被授权数据(私有)/test2DB数据授权', 0);
INSERT INTO `log` VALUES (7264, '2021-06-24 20:10:04', 'Bob1', '访问权限管理列表', 0);
INSERT INTO `log` VALUES (7265, '2021-06-24 20:10:07', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/test2DB的内容', 1);
INSERT INTO `log` VALUES (7266, '2021-06-24 20:10:07', 'tom', '获取文件:ROOT/系统公有数据/植物/水果文件/椰子的内容', 1);
INSERT INTO `log` VALUES (7267, '2021-06-24 20:10:22', 'super', 'super展开结点:ROOT', 1);
INSERT INTO `log` VALUES (7268, '2021-06-24 20:10:23', 'super', 'super展开结点:ROOT/被授权数据(私有)', 1);
INSERT INTO `log` VALUES (7269, '2021-06-24 20:10:24', 'super', 'super展开结点:ROOT/系统公有数据', 1);
INSERT INTO `log` VALUES (7270, '2021-06-24 20:10:32', 'super', '访问权限管理列表', 0);
INSERT INTO `log` VALUES (7271, '2021-06-24 20:10:41', 'super', '访问权限管理列表', 0);
INSERT INTO `log` VALUES (7272, '2021-06-24 20:11:14', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/orDBtest1的内容', 1);
INSERT INTO `log` VALUES (7273, '2021-06-24 20:11:17', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/test2DB的内容', 1);
INSERT INTO `log` VALUES (7274, '2021-06-24 20:11:18', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/test2DB的内容', 1);
INSERT INTO `log` VALUES (7275, '2021-06-24 20:11:30', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/oraDB1的内容', 1);
INSERT INTO `log` VALUES (7276, '2021-06-24 20:11:32', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/oraDB1的内容', 1);
INSERT INTO `log` VALUES (7277, '2021-06-24 20:11:33', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/orDBtest1的内容', 1);
INSERT INTO `log` VALUES (7278, '2021-06-24 20:11:40', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/test2DB的内容', 1);
INSERT INTO `log` VALUES (7279, '2021-06-24 20:11:42', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/orDBtest1的内容', 1);
INSERT INTO `log` VALUES (7280, '2021-06-24 20:11:54', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/orDBtest1的内容', 1);
INSERT INTO `log` VALUES (7281, '2021-06-24 20:11:56', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/orDBtest1的内容', 1);
INSERT INTO `log` VALUES (7282, '2021-06-24 20:14:00', 'tom', '对ROOT/系统公有数据/教师文件/orDBtest1进行管道式操作', 1);
INSERT INTO `log` VALUES (7283, '2021-06-24 20:14:35', 'tom', '对ROOT/系统公有数据/教师文件/orDBtest1进行求和操作', 1);
INSERT INTO `log` VALUES (7284, '2021-06-24 20:14:58', 'tom', '对ROOT/系统公有数据/教师文件/orDBtest1进行均值操作', 1);
INSERT INTO `log` VALUES (7285, '2021-06-24 20:15:08', 'tom', '对ROOT/系统公有数据/教师文件/orDBtest1进行找最大值操作', 1);
INSERT INTO `log` VALUES (7286, '2021-06-24 20:15:21', 'tom', '对ROOT/系统公有数据/教师文件/orDBtest1进行找最小值操作', 1);
INSERT INTO `log` VALUES (7287, '2021-06-24 20:15:36', 'tom', '对ROOT/系统公有数据/教师文件/orDBtest1进行找最小值操作', 1);
INSERT INTO `log` VALUES (7288, '2021-06-24 20:15:54', 'tom', '对ROOT/系统公有数据/教师文件/orDBtest1进行找最小值操作', 1);
INSERT INTO `log` VALUES (7289, '2021-06-24 20:35:03', 'tom', 'tom用户登录成功', 0);
INSERT INTO `log` VALUES (7290, '2021-06-24 20:35:04', 'tom', 'tom展开结点:ROOT', 1);
INSERT INTO `log` VALUES (7291, '2021-06-24 20:35:06', 'tom', 'tom展开结点:ROOT/系统公有数据', 1);
INSERT INTO `log` VALUES (7292, '2021-06-24 20:35:07', 'tom', 'tom展开结点:ROOT/系统公有数据/教师文件', 1);
INSERT INTO `log` VALUES (7293, '2021-06-24 20:35:11', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/test2DB的内容', 1);
INSERT INTO `log` VALUES (7294, '2021-06-24 20:35:11', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/orDBtest1的内容', 1);
INSERT INTO `log` VALUES (7295, '2021-06-24 20:35:50', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/test2DB的内容', 1);
INSERT INTO `log` VALUES (7296, '2021-06-24 20:35:51', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/orDBtest1的内容', 1);
INSERT INTO `log` VALUES (7297, '2021-06-24 20:35:51', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/test2DB的内容', 1);
INSERT INTO `log` VALUES (7298, '2021-06-24 20:35:52', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/test2DB的内容', 1);
INSERT INTO `log` VALUES (7299, '2021-06-24 20:35:58', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/test2DB的内容', 1);
INSERT INTO `log` VALUES (7300, '2021-06-24 20:35:58', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/test2DB的内容', 1);
INSERT INTO `log` VALUES (7301, '2021-06-24 20:36:00', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/oraDB1的内容', 1);
INSERT INTO `log` VALUES (7302, '2021-06-24 20:36:01', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/oraDB1的内容', 1);
INSERT INTO `log` VALUES (7303, '2021-06-24 20:36:02', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/test2DB的内容', 1);
INSERT INTO `log` VALUES (7304, '2021-06-24 20:36:03', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/test2DB的内容', 1);
INSERT INTO `log` VALUES (7305, '2021-06-24 20:36:03', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/test2DB的内容', 1);
INSERT INTO `log` VALUES (7306, '2021-06-24 20:36:04', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/test2DB的内容', 1);
INSERT INTO `log` VALUES (7307, '2021-06-24 20:36:04', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/test2DB的内容', 1);
INSERT INTO `log` VALUES (7308, '2021-06-24 20:36:04', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/test2DB的内容', 1);
INSERT INTO `log` VALUES (7309, '2021-06-24 20:36:05', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/orDBtest1的内容', 1);
INSERT INTO `log` VALUES (7310, '2021-06-24 20:36:06', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/orDBtest1的内容', 1);
INSERT INTO `log` VALUES (7311, '2021-06-24 20:36:17', 'tom', '对ROOT/系统公有数据/教师文件/orDBtest1进行找最小值操作', 1);
INSERT INTO `log` VALUES (7312, '2021-06-24 20:36:33', 'tom', '对ROOT/系统公有数据/教师文件/orDBtest1进行找最小值操作', 1);
INSERT INTO `log` VALUES (7313, '2021-06-24 20:36:44', 'tom', '对ROOT/系统公有数据/教师文件/orDBtest1进行找最小值操作', 1);
INSERT INTO `log` VALUES (7314, '2021-06-24 20:38:55', 'tom', 'tom用户登录成功', 0);
INSERT INTO `log` VALUES (7315, '2021-06-24 20:38:56', 'tom', 'tom展开结点:ROOT', 1);
INSERT INTO `log` VALUES (7316, '2021-06-24 20:38:57', 'tom', 'tom展开结点:ROOT/系统公有数据', 1);
INSERT INTO `log` VALUES (7317, '2021-06-24 20:38:59', 'tom', 'tom展开结点:ROOT/系统公有数据/教师文件', 1);
INSERT INTO `log` VALUES (7318, '2021-06-24 20:39:01', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/orDBtest1的内容', 1);
INSERT INTO `log` VALUES (7319, '2021-06-24 20:39:01', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/orDBtest1的内容', 1);
INSERT INTO `log` VALUES (7320, '2021-06-24 20:39:21', 'tom', '获取文件:ROOT/系统公有数据/教师文件/语文成绩1的内容', 1);
INSERT INTO `log` VALUES (7321, '2021-06-24 20:39:21', 'tom', '获取文件:ROOT/系统公有数据/教师文件/语文成绩1的内容', 1);
INSERT INTO `log` VALUES (7322, '2021-06-24 20:39:21', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/orDBtest1的内容', 1);
INSERT INTO `log` VALUES (7323, '2021-06-24 20:39:21', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/orDBtest1的内容', 1);
INSERT INTO `log` VALUES (7324, '2021-06-24 20:39:22', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/orDBtest1的内容', 1);
INSERT INTO `log` VALUES (7325, '2021-06-24 20:39:23', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/orDBtest1的内容', 1);
INSERT INTO `log` VALUES (7326, '2021-06-24 20:39:24', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/test2DB的内容', 1);
INSERT INTO `log` VALUES (7327, '2021-06-24 20:39:25', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/orDBtest1的内容', 1);
INSERT INTO `log` VALUES (7328, '2021-06-24 20:39:34', 'tom', '对ROOT/系统公有数据/教师文件/orDBtest1进行找最小值操作', 1);
INSERT INTO `log` VALUES (7329, '2021-06-24 20:39:51', 'tom', '对ROOT/系统公有数据/教师文件/orDBtest1进行找最大值操作', 1);
INSERT INTO `log` VALUES (7330, '2021-06-24 20:39:57', 'tom', '获取文件:ROOT/系统公有数据/教师文件/语文成绩1的内容', 1);
INSERT INTO `log` VALUES (7331, '2021-06-24 20:39:57', 'tom', '获取文件:ROOT/系统公有数据/教师文件/语文成绩1的内容', 1);
INSERT INTO `log` VALUES (7332, '2021-06-24 20:39:57', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/orDBtest1的内容', 1);
INSERT INTO `log` VALUES (7333, '2021-06-24 20:39:57', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/orDBtest1的内容', 1);
INSERT INTO `log` VALUES (7334, '2021-06-24 20:39:58', 'tom', '获取文件:ROOT/系统公有数据/教师文件/语文成绩1的内容', 1);
INSERT INTO `log` VALUES (7335, '2021-06-24 20:39:58', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/test2DB的内容', 1);
INSERT INTO `log` VALUES (7336, '2021-06-24 20:39:59', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7337, '2021-06-24 20:40:01', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7338, '2021-06-24 20:40:01', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7339, '2021-06-24 20:40:02', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7340, '2021-06-24 20:40:02', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/test2DB的内容', 1);
INSERT INTO `log` VALUES (7341, '2021-06-24 20:40:03', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/orDBtest1的内容', 1);
INSERT INTO `log` VALUES (7342, '2021-06-24 20:40:03', 'tom', '获取文件:ROOT/系统公有数据/教师文件/语文成绩1的内容', 1);
INSERT INTO `log` VALUES (7343, '2021-06-24 20:40:03', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/orDBtest1的内容', 1);
INSERT INTO `log` VALUES (7344, '2021-06-24 20:40:03', 'tom', '获取文件:ROOT/系统公有数据/教师文件/语文成绩1的内容', 1);
INSERT INTO `log` VALUES (7345, '2021-06-24 20:40:04', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/oraDB1的内容', 1);
INSERT INTO `log` VALUES (7346, '2021-06-24 20:40:04', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/oraDB1的内容', 1);
INSERT INTO `log` VALUES (7347, '2021-06-24 20:40:05', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7348, '2021-06-24 20:40:06', 'tom', 'tom展开结点:ROOT/系统公有数据/学生文件', 1);
INSERT INTO `log` VALUES (7349, '2021-06-24 20:40:08', 'tom', 'tom展开结点:ROOT/系统公有数据/学生文件/学习成绩', 1);
INSERT INTO `log` VALUES (7350, '2021-06-24 20:40:10', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7351, '2021-06-24 20:40:10', 'tom', '获取文件:ROOT/系统公有数据/学生文件/学习成绩/数学成绩.xlsx的内容', 1);
INSERT INTO `log` VALUES (7352, '2021-06-24 20:41:11', 'tom', '获取文件:ROOT/系统公有数据/学生文件/学习成绩/数学成绩.xlsx的内容', 1);
INSERT INTO `log` VALUES (7353, '2021-06-24 20:41:12', 'tom', '获取文件:ROOT/系统公有数据/学生文件/学习成绩/计算机成绩的内容', 1);
INSERT INTO `log` VALUES (7354, '2021-06-24 20:41:13', 'tom', '获取文件:ROOT/系统公有数据/学生文件/学习成绩/数学成绩.xlsx的内容', 1);
INSERT INTO `log` VALUES (7355, '2021-06-24 20:41:17', 'tom', '获取文件:ROOT/系统公有数据/学生文件/学习成绩/数学成绩.xlsx的内容', 1);
INSERT INTO `log` VALUES (7356, '2021-06-24 20:41:33', 'tom', '对ROOT/系统公有数据/学生文件/学习成绩/数学成绩.xlsx进行管道式操作', 1);
INSERT INTO `log` VALUES (7357, '2021-06-24 20:41:40', 'tom', '获取文件:ROOT/系统公有数据/学生文件/学习成绩/计算机成绩的内容', 1);
INSERT INTO `log` VALUES (7358, '2021-06-24 20:41:40', 'tom', '获取文件:ROOT/系统公有数据/学生文件/学习成绩/计算机成绩的内容', 1);
INSERT INTO `log` VALUES (7359, '2021-06-24 20:42:04', 'tom', '获取文件:ROOT/系统公有数据/学生文件/学习成绩/计算机成绩的内容', 1);
INSERT INTO `log` VALUES (7360, '2021-06-24 20:42:04', 'tom', '获取文件:ROOT/系统公有数据/学生文件/学习成绩/计算机成绩的内容', 1);
INSERT INTO `log` VALUES (7361, '2021-06-24 20:42:06', 'tom', '获取文件:ROOT/系统公有数据/学生文件/学习成绩/计算机成绩的内容', 1);
INSERT INTO `log` VALUES (7362, '2021-06-24 20:42:08', 'tom', '对ROOT/系统公有数据/学生文件/学习成绩/计算机成绩进行管道式操作', 1);
INSERT INTO `log` VALUES (7363, '2021-06-24 20:42:34', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7364, '2021-06-24 20:42:46', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7365, '2021-06-24 20:43:01', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7366, '2021-06-24 20:43:23', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7367, '2021-06-24 20:43:24', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7368, '2021-06-24 20:43:24', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/oraDB1的内容', 1);
INSERT INTO `log` VALUES (7369, '2021-06-24 20:43:25', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/oraDB1的内容', 1);
INSERT INTO `log` VALUES (7370, '2021-06-24 20:43:31', 'tom', 'tom展开结点:ROOT', 1);
INSERT INTO `log` VALUES (7371, '2021-06-24 20:43:33', 'tom', 'tom展开结点:ROOT/系统公有数据', 1);
INSERT INTO `log` VALUES (7372, '2021-06-24 20:43:34', 'tom', 'tom展开结点:ROOT/系统公有数据/教师文件', 1);
INSERT INTO `log` VALUES (7373, '2021-06-24 20:43:36', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7374, '2021-06-24 20:44:31', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/orDBtest1的内容', 1);
INSERT INTO `log` VALUES (7375, '2021-06-24 20:44:32', 'tom', '获取文件:ROOT/系统公有数据/教师文件/语文成绩1的内容', 1);
INSERT INTO `log` VALUES (7376, '2021-06-24 20:44:32', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/orDBtest1的内容', 1);
INSERT INTO `log` VALUES (7377, '2021-06-24 20:44:32', 'tom', '获取文件:ROOT/系统公有数据/教师文件/语文成绩1的内容', 1);
INSERT INTO `log` VALUES (7378, '2021-06-24 20:44:33', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/orDBtest1的内容', 1);
INSERT INTO `log` VALUES (7379, '2021-06-24 20:44:33', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7380, '2021-06-24 20:44:33', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7381, '2021-06-24 20:44:35', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7382, '2021-06-24 20:45:06', 'tom', 'tom用户登录成功', 0);
INSERT INTO `log` VALUES (7383, '2021-06-24 20:45:08', 'tom', 'tom展开结点:ROOT', 1);
INSERT INTO `log` VALUES (7384, '2021-06-24 20:45:09', 'tom', 'tom展开结点:ROOT/系统公有数据', 1);
INSERT INTO `log` VALUES (7385, '2021-06-24 20:45:11', 'tom', 'tom展开结点:ROOT/系统公有数据/动物', 1);
INSERT INTO `log` VALUES (7386, '2021-06-24 20:45:13', 'tom', 'tom展开结点:ROOT/系统公有数据/学生文件', 1);
INSERT INTO `log` VALUES (7387, '2021-06-24 20:45:14', 'tom', 'tom展开结点:ROOT/系统公有数据/教师文件', 1);
INSERT INTO `log` VALUES (7388, '2021-06-24 20:45:16', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7389, '2021-06-24 20:45:40', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7390, '2021-06-24 20:45:41', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7391, '2021-06-24 20:45:46', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7392, '2021-06-24 20:45:52', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7393, '2021-06-24 20:45:58', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7394, '2021-06-24 20:45:58', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7395, '2021-06-24 20:45:59', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7396, '2021-06-24 20:46:05', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7397, '2021-06-24 20:46:05', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7398, '2021-06-24 20:46:06', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7399, '2021-06-24 20:46:07', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7400, '2021-06-24 20:50:26', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/test2DB的内容', 1);
INSERT INTO `log` VALUES (7401, '2021-06-24 20:50:27', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/orDBtest1的内容', 1);
INSERT INTO `log` VALUES (7402, '2021-06-24 20:50:28', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/orDBtest1的内容', 1);
INSERT INTO `log` VALUES (7403, '2021-06-24 20:50:33', 'tom', 'tom用户登录成功', 0);
INSERT INTO `log` VALUES (7404, '2021-06-24 20:50:35', 'tom', 'tom展开结点:ROOT', 1);
INSERT INTO `log` VALUES (7405, '2021-06-24 20:50:36', 'tom', 'tom展开结点:ROOT/系统公有数据', 1);
INSERT INTO `log` VALUES (7406, '2021-06-24 20:50:38', 'tom', 'tom展开结点:ROOT/系统公有数据/教师文件', 1);
INSERT INTO `log` VALUES (7407, '2021-06-24 20:50:41', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7408, '2021-06-24 20:50:42', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7409, '2021-06-24 20:50:43', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/oraDB1的内容', 1);
INSERT INTO `log` VALUES (7410, '2021-06-24 20:51:01', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7411, '2021-06-24 20:51:01', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7412, '2021-06-24 20:52:30', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7413, '2021-06-24 20:52:30', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/oraDB1的内容', 1);
INSERT INTO `log` VALUES (7414, '2021-06-24 20:52:31', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7415, '2021-06-24 20:52:31', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7416, '2021-06-24 20:52:43', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7417, '2021-06-24 20:52:45', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/orDBtest1的内容', 1);
INSERT INTO `log` VALUES (7418, '2021-06-24 20:52:46', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7419, '2021-06-24 20:52:49', 'tom', '访问权限管理列表', 0);
INSERT INTO `log` VALUES (7420, '2021-06-24 20:52:50', 'tom', '访问权限管理列表', 0);
INSERT INTO `log` VALUES (7421, '2021-06-24 20:52:51', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7422, '2021-06-24 20:53:29', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7423, '2021-06-24 20:53:30', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/oraDB1的内容', 1);
INSERT INTO `log` VALUES (7424, '2021-06-24 20:53:30', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/oraDB1的内容', 1);
INSERT INTO `log` VALUES (7425, '2021-06-24 20:55:41', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/orDBtest1的内容', 1);
INSERT INTO `log` VALUES (7426, '2021-06-24 20:55:41', 'tom', '获取文件:ROOT/系统公有数据/教师文件/语文成绩1的内容', 1);
INSERT INTO `log` VALUES (7427, '2021-06-24 20:55:41', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/orDBtest1的内容', 1);
INSERT INTO `log` VALUES (7428, '2021-06-24 20:55:41', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/test2DB的内容', 1);
INSERT INTO `log` VALUES (7429, '2021-06-24 20:55:42', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/test2DB的内容', 1);
INSERT INTO `log` VALUES (7430, '2021-06-24 20:55:42', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/oraDB1的内容', 1);
INSERT INTO `log` VALUES (7431, '2021-06-24 20:55:42', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/test2DB的内容', 1);
INSERT INTO `log` VALUES (7432, '2021-06-24 20:55:43', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7433, '2021-06-24 20:57:08', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7434, '2021-06-24 20:57:09', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7435, '2021-06-24 20:57:09', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7436, '2021-06-24 20:57:10', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7437, '2021-06-24 21:01:54', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7438, '2021-06-24 21:01:55', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7439, '2021-06-24 21:01:55', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7440, '2021-06-24 21:01:55', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/oraDB1的内容', 1);
INSERT INTO `log` VALUES (7441, '2021-06-24 21:01:56', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/oraDB1的内容', 1);
INSERT INTO `log` VALUES (7442, '2021-06-24 21:17:25', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/test2DB的内容', 1);
INSERT INTO `log` VALUES (7443, '2021-06-24 21:17:25', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/test2DB的内容', 1);
INSERT INTO `log` VALUES (7444, '2021-06-24 21:17:26', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7445, '2021-06-24 21:17:27', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/orDBtest1的内容', 1);
INSERT INTO `log` VALUES (7446, '2021-06-24 21:17:49', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7447, '2021-06-24 21:17:50', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7448, '2021-06-24 21:17:50', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7449, '2021-06-24 21:18:01', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7450, '2021-06-24 21:18:09', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7451, '2021-06-24 21:18:21', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7452, '2021-06-24 21:18:28', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7453, '2021-06-24 21:18:29', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/test2DB的内容', 1);
INSERT INTO `log` VALUES (7454, '2021-06-24 21:18:29', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/oraDB1的内容', 1);
INSERT INTO `log` VALUES (7455, '2021-06-24 21:18:29', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7456, '2021-06-24 21:18:30', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7457, '2021-06-24 21:18:30', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7458, '2021-06-24 21:18:35', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7459, '2021-06-24 21:18:36', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7460, '2021-06-24 21:18:36', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7461, '2021-06-24 21:18:37', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7462, '2021-06-24 21:18:38', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7463, '2021-06-24 21:18:39', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7464, '2021-06-24 21:18:45', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7465, '2021-06-24 21:18:50', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7466, '2021-06-24 21:19:12', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7467, '2021-06-24 21:19:12', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7468, '2021-06-24 21:19:53', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7469, '2021-06-24 21:19:54', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7470, '2021-06-24 21:19:55', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7471, '2021-06-24 21:19:56', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7472, '2021-06-24 21:19:56', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7473, '2021-06-24 21:19:57', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7474, '2021-06-24 21:20:10', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7475, '2021-06-24 21:20:22', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7476, '2021-06-24 21:20:25', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7477, '2021-06-24 21:20:38', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7478, '2021-06-24 21:20:38', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7479, '2021-06-24 21:20:41', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7480, '2021-06-24 21:21:26', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7481, '2021-06-24 21:21:27', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7482, '2021-06-24 21:21:30', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7483, '2021-06-24 21:21:31', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7484, '2021-06-24 21:21:32', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7485, '2021-06-24 21:21:34', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7486, '2021-06-24 21:21:35', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7487, '2021-06-24 21:21:35', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7488, '2021-06-24 21:21:35', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7489, '2021-06-24 21:21:38', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7490, '2021-06-24 21:22:04', 'tom', '手动更新nodeROOT/系统公有数据/教师文件/手动同步数据库的缓存数据', 1);
INSERT INTO `log` VALUES (7491, '2021-06-24 21:22:06', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7492, '2021-06-24 21:22:51', 'tom', '手动更新nodeROOT/系统公有数据/教师文件/手动同步数据库的缓存数据', 1);
INSERT INTO `log` VALUES (7493, '2021-06-24 21:22:54', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7494, '2021-06-24 21:28:20', 'tom', 'tom用户登录成功', 0);
INSERT INTO `log` VALUES (7495, '2021-06-24 21:28:22', 'tom', 'tom展开结点:ROOT', 1);
INSERT INTO `log` VALUES (7496, '2021-06-24 21:28:24', 'tom', 'tom展开结点:ROOT/系统公有数据', 1);
INSERT INTO `log` VALUES (7497, '2021-06-24 21:28:25', 'tom', 'tom展开结点:ROOT/系统公有数据/教师文件', 1);
INSERT INTO `log` VALUES (7498, '2021-06-24 21:28:26', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7499, '2021-06-24 21:28:27', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7500, '2021-06-24 21:28:28', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7501, '2021-06-24 21:28:29', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7502, '2021-06-24 21:28:29', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7503, '2021-06-24 21:29:08', 'tom', '手动更新nodeROOT/系统公有数据/教师文件/手动同步数据库的缓存数据', 1);
INSERT INTO `log` VALUES (7504, '2021-06-24 21:29:11', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7505, '2021-06-24 21:30:19', 'tom', '开启HTTP数据服务', 1);
INSERT INTO `log` VALUES (7506, '2021-06-24 21:30:29', 'tom', '开启HTTP数据服务', 1);
INSERT INTO `log` VALUES (7507, '2021-06-24 21:30:30', 'tom', '开启TCP数据服务', 1);
INSERT INTO `log` VALUES (7508, '2021-06-24 21:30:40', 'tom', '开启TCP数据服务', 1);
INSERT INTO `log` VALUES (7509, '2021-06-24 21:30:41', 'tom', '开启WebService数据服务', 1);
INSERT INTO `log` VALUES (7510, '2021-06-24 21:30:41', 'tom', '开启HTTP数据服务', 1);
INSERT INTO `log` VALUES (7511, '2021-06-24 21:30:42', 'tom', '开启TCP数据服务', 1);
INSERT INTO `log` VALUES (7512, '2021-06-24 21:32:29', 'tom', '开启TCP数据服务', 1);
INSERT INTO `log` VALUES (7513, '2021-06-24 21:32:30', 'tom', '开启HTTP数据服务', 1);
INSERT INTO `log` VALUES (7514, '2021-06-24 21:32:30', 'tom', '开启WebService数据服务', 1);
INSERT INTO `log` VALUES (7515, '2021-06-25 11:36:24', 'tom', 'tom用户登录成功', 0);
INSERT INTO `log` VALUES (7516, '2021-06-25 11:36:26', 'tom', 'tom展开结点:ROOT', 1);
INSERT INTO `log` VALUES (7517, '2021-06-25 11:36:27', 'tom', 'tom展开结点:ROOT/系统公有数据', 1);
INSERT INTO `log` VALUES (7518, '2021-06-25 11:36:28', 'tom', 'tom展开结点:ROOT/系统公有数据/动物', 1);
INSERT INTO `log` VALUES (7519, '2021-06-25 11:36:28', 'tom', '获取文件:ROOT/系统公有数据/动物/猫的内容', 1);
INSERT INTO `log` VALUES (7520, '2021-06-25 11:36:29', 'tom', '获取文件:ROOT/系统公有数据/动物/狗的内容', 1);
INSERT INTO `log` VALUES (7521, '2021-06-25 11:36:29', 'tom', '获取文件:ROOT/系统公有数据/动物/鹰的内容', 1);
INSERT INTO `log` VALUES (7522, '2021-06-25 12:04:14', 'tom', 'tom用户登录成功', 0);
INSERT INTO `log` VALUES (7523, '2021-06-25 12:04:15', 'tom', 'tom展开结点:ROOT', 1);
INSERT INTO `log` VALUES (7524, '2021-06-25 12:04:16', 'tom', 'tom展开结点:ROOT/系统公有数据', 1);
INSERT INTO `log` VALUES (7525, '2021-06-25 12:04:17', 'tom', 'tom展开结点:ROOT/系统公有数据/动物', 1);
INSERT INTO `log` VALUES (7526, '2021-06-25 12:04:18', 'tom', '获取文件:ROOT/系统公有数据/动物/猫的内容', 1);
INSERT INTO `log` VALUES (7527, '2021-06-25 12:04:18', 'tom', '获取文件:ROOT/系统公有数据/动物/狗的内容', 1);
INSERT INTO `log` VALUES (7528, '2021-06-25 12:04:18', 'tom', '获取文件:ROOT/系统公有数据/动物/鹰的内容', 1);
INSERT INTO `log` VALUES (7529, '2021-06-25 12:04:19', 'tom', '获取文件:ROOT/系统公有数据/动物/虎的内容', 1);
INSERT INTO `log` VALUES (7530, '2021-06-25 12:04:20', 'tom', 'tom展开结点:ROOT/系统公有数据/教师文件', 1);
INSERT INTO `log` VALUES (7531, '2021-06-25 12:04:20', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7532, '2021-06-25 12:04:22', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7533, '2021-06-25 12:04:23', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7534, '2021-06-25 12:04:26', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7535, '2021-06-25 12:04:27', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/手动同步数据库的内容', 1);
INSERT INTO `log` VALUES (7536, '2021-06-25 12:04:28', 'tom', '获取数据库:ROOT/系统公有数据/教师文件/实时同步示例的内容', 1);
INSERT INTO `log` VALUES (7537, '2021-06-25 12:04:44', 'tom', '对ROOT/系统公有数据/教师文件/实时同步示例进行管道式操作', 1);
INSERT INTO `log` VALUES (7538, '2021-06-25 12:04:58', 'Lucy', 'Lucy用户登录成功', 0);
INSERT INTO `log` VALUES (7539, '2021-06-25 12:05:01', 'Lucy', 'Lucy展开结点:ROOT', 1);
INSERT INTO `log` VALUES (7540, '2021-06-25 12:05:03', 'Lucy', 'Lucy展开结点:ROOT/系统公有数据', 1);
INSERT INTO `log` VALUES (7541, '2021-06-25 12:05:04', 'Lucy', 'Lucy展开结点:ROOT/系统公有数据/动物', 1);
INSERT INTO `log` VALUES (7542, '2021-06-25 12:05:07', 'Lucy', 'Lucy展开结点:ROOT/被授权数据(私有)', 1);
INSERT INTO `log` VALUES (7543, '2021-06-25 12:05:08', 'Lucy', '获取文件:ROOT/被授权数据(私有)/语文成绩1的内容', 1);
INSERT INTO `log` VALUES (7544, '2021-06-25 15:11:33', 'tom', 'tom用户登录成功', 0);
INSERT INTO `log` VALUES (7545, '2021-06-25 15:11:42', 'tom', 'tom用户登录成功', 0);
INSERT INTO `log` VALUES (7546, '2021-06-25 15:11:58', 'super', 'super用户登录成功', 0);
INSERT INTO `log` VALUES (7547, '2021-06-25 15:12:05', 'super', 'super用户登录成功', 0);
INSERT INTO `log` VALUES (7548, '2021-06-25 15:12:09', 'super', 'super用户登录成功', 0);
INSERT INTO `log` VALUES (7549, '2021-06-25 15:12:11', 'super', 'super展开结点:ROOT', 1);
INSERT INTO `log` VALUES (7550, '2021-06-25 15:12:13', 'super', '访问权限管理列表', 0);
INSERT INTO `log` VALUES (7551, '2021-06-25 15:12:15', 'super', '访问权限管理列表', 0);
INSERT INTO `log` VALUES (7552, '2021-06-25 15:12:43', 'Bob', 'Bob用户登录成功', 0);
INSERT INTO `log` VALUES (7553, '2021-06-25 15:12:45', 'Bob', 'Bob展开结点:ROOT', 1);
INSERT INTO `log` VALUES (7554, '2021-06-25 15:12:46', 'Bob', 'Bob展开结点:ROOT/系统公有数据', 1);
INSERT INTO `log` VALUES (7555, '2021-06-25 15:12:47', 'Bob', 'Bob展开结点:ROOT/系统公有数据/动物', 1);
INSERT INTO `log` VALUES (7556, '2021-06-25 15:12:50', 'Bob', 'Bob展开结点:ROOT/系统公有数据/教师文件', 1);
INSERT INTO `log` VALUES (7557, '2021-06-25 15:12:58', 'Bob', 'Bob展开结点:ROOT/被授权数据(私有)', 1);
INSERT INTO `log` VALUES (7558, '2021-06-25 15:12:59', 'Bob', 'Bob展开结点:ROOT/被授权数据(私有)/Bob的文件夹1', 1);

-- ----------------------------
-- Table structure for node
-- ----------------------------
DROP TABLE IF EXISTS `node`;
CREATE TABLE `node`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `type` int(0) DEFAULT NULL,
  `shared` tinyint(1) DEFAULT NULL,
  `cache` tinyint(1) DEFAULT NULL,
  `keywords` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `synopsis` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 872 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of node
-- ----------------------------
INSERT INTO `node` VALUES (1, 'ROOT', 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `node` VALUES (2, '系统公有数据', 1, 0, 0, NULL, NULL, '2021-06-22 16:54:15');
INSERT INTO `node` VALUES (376, '被授权数据(私有)', 1, 0, 0, NULL, NULL, NULL);
INSERT INTO `node` VALUES (463, '西红柿', 3, 0, 0, '西红柿', '西红柿', NULL);
INSERT INTO `node` VALUES (465, '虎', 3, 0, 0, '虎', '老虎', NULL);
INSERT INTO `node` VALUES (507, '猫', 3, 0, 0, '猫', '布偶猫', NULL);
INSERT INTO `node` VALUES (607, 'excel1', 2, 0, 0, 'excel', 'excel', NULL);
INSERT INTO `node` VALUES (670, 'excel2', 6, 0, 0, 'excel', 'excel', NULL);
INSERT INTO `node` VALUES (698, 'excel均值示例', 6, 0, 0, 'excel', '均值', NULL);
INSERT INTO `node` VALUES (723, '数学成绩.xlsx', 6, 0, 0, NULL, NULL, NULL);
INSERT INTO `node` VALUES (725, '数学成绩', 6, 0, 0, '数学', '学生成绩', NULL);
INSERT INTO `node` VALUES (731, 'dbtable5429.txt', 2, 0, 0, NULL, NULL, NULL);
INSERT INTO `node` VALUES (735, 'dbtable1405.txt', 2, 0, 0, NULL, NULL, NULL);
INSERT INTO `node` VALUES (736, 'dbtable5083.txt', 2, 0, 0, NULL, NULL, NULL);
INSERT INTO `node` VALUES (738, 'dbtable8432.txt', 2, 0, 0, NULL, NULL, NULL);
INSERT INTO `node` VALUES (740, 'dbtable5813.txt', 2, 0, 0, NULL, NULL, NULL);
INSERT INTO `node` VALUES (799, '动物', 1, 0, 0, NULL, NULL, NULL);
INSERT INTO `node` VALUES (800, '猫', 3, 0, 0, '猫', '布偶猫', NULL);
INSERT INTO `node` VALUES (801, '狗', 3, 0, 0, 'dog', '可爱的狗', NULL);
INSERT INTO `node` VALUES (802, '鹰', 3, 0, 0, '鹰keywords', '老鹰', NULL);
INSERT INTO `node` VALUES (803, '虎', 3, 0, 0, '虎', '老虎', NULL);
INSERT INTO `node` VALUES (804, '植物', 1, 0, 0, NULL, NULL, NULL);
INSERT INTO `node` VALUES (805, '水果文件', 1, 0, 0, NULL, NULL, NULL);
INSERT INTO `node` VALUES (806, '苹果', 3, 0, 0, '苹果,水果,植物', '苹果图片', NULL);
INSERT INTO `node` VALUES (807, '西瓜的视频', 5, 0, 0, '西瓜,视频', '西瓜的视频', NULL);
INSERT INTO `node` VALUES (808, '樱桃', 3, 0, 0, '樱桃', '樱桃', NULL);
INSERT INTO `node` VALUES (809, '椰子', 3, 0, 0, '椰子', '椰子', NULL);
INSERT INTO `node` VALUES (810, '草莓', 3, 0, 0, '草莓', '草莓', NULL);
INSERT INTO `node` VALUES (811, '蓝莓', 3, 0, 0, '蓝莓', '蓝莓', NULL);
INSERT INTO `node` VALUES (812, '香蕉', 3, 0, 0, '香蕉', '香蕉', NULL);
INSERT INTO `node` VALUES (813, '橘子', 3, 0, 0, '橘子', '橘子', NULL);
INSERT INTO `node` VALUES (814, '芒果', 3, 0, 0, '芒果', '芒果', NULL);
INSERT INTO `node` VALUES (815, '石榴', 3, 0, 0, '石榴', '石榴', NULL);
INSERT INTO `node` VALUES (816, '蔬菜文件', 1, 0, 0, NULL, NULL, NULL);
INSERT INTO `node` VALUES (817, '白菜', 3, 0, 0, '蔬菜，白菜', '好吃的白菜，补充维生素', NULL);
INSERT INTO `node` VALUES (818, '玉米', 3, 0, 0, '玉米', '玉米', NULL);
INSERT INTO `node` VALUES (819, '土豆', 3, 0, 0, '土豆，植物，蔬菜', '土豆', NULL);
INSERT INTO `node` VALUES (820, '大蒜', 3, 0, 0, '大蒜', '大蒜', NULL);
INSERT INTO `node` VALUES (821, '西红柿', 3, 0, 0, '西红柿', '西红柿', NULL);
INSERT INTO `node` VALUES (823, '教师文件', 1, 0, 0, NULL, NULL, NULL);
INSERT INTO `node` VALUES (824, '学生文件', 1, 0, 0, NULL, NULL, NULL);
INSERT INTO `node` VALUES (825, '学习成绩', 1, 0, 0, NULL, NULL, NULL);
INSERT INTO `node` VALUES (826, '语文成绩.txt', 2, 0, 0, '', '', NULL);
INSERT INTO `node` VALUES (827, '数学成绩.xlsx', 6, 0, 0, '数学', '学生成绩', NULL);
INSERT INTO `node` VALUES (828, '计算机成绩', 2, 0, 0, '计算机', '成绩', NULL);
INSERT INTO `node` VALUES (829, '社会实践', 1, 0, 0, NULL, NULL, NULL);
INSERT INTO `node` VALUES (830, '手动同步数据库', 11, 0, 1, '手动', '同步', NULL);
INSERT INTO `node` VALUES (831, '实时同步示例', 11, 0, 1, '实时', '同步', NULL);
INSERT INTO `node` VALUES (832, 'oraDB1', 11, 0, 0, 'oracle', '数据库', NULL);
INSERT INTO `node` VALUES (833, 'test2DB', 11, 0, 0, '数据库', 'mysql数据库', NULL);
INSERT INTO `node` VALUES (834, 'orDBtest1', 11, 0, 0, 'oracle35', 'oracle数据库', NULL);
INSERT INTO `node` VALUES (835, '语文成绩1', 2, 0, 0, '1', '1', NULL);
INSERT INTO `node` VALUES (836, 'dbtable5479.txt', 2, 0, 0, NULL, NULL, NULL);
INSERT INTO `node` VALUES (837, 'dbtable5895.txt', 2, 0, 0, NULL, NULL, NULL);
INSERT INTO `node` VALUES (838, 'dbtable3695.txt', 2, 0, 0, NULL, NULL, NULL);
INSERT INTO `node` VALUES (839, 'dbtable5348.txt', 2, 0, 0, NULL, NULL, NULL);
INSERT INTO `node` VALUES (840, 'dbtable916.txt', 2, 0, 0, NULL, NULL, NULL);
INSERT INTO `node` VALUES (843, 'Bob的文件夹1', 1, 0, 0, NULL, NULL, '2021-06-22 19:50:17');
INSERT INTO `node` VALUES (844, '语文成绩1', 2, 0, 0, '1', '1', NULL);
INSERT INTO `node` VALUES (845, '语文成绩1', 2, 0, 0, '1', '1', NULL);
INSERT INTO `node` VALUES (846, '语文成绩1', 2, 0, 0, '1', '1', NULL);
INSERT INTO `node` VALUES (847, '语文成绩1', 2, 0, 0, '1', '1', NULL);
INSERT INTO `node` VALUES (848, '蔬菜文件', 1, 0, 0, NULL, NULL, NULL);
INSERT INTO `node` VALUES (849, '白菜', 3, 0, 0, '蔬菜，白菜', '好吃的白菜，补充维生素', NULL);
INSERT INTO `node` VALUES (850, '玉米', 3, 0, 0, '玉米', '玉米', NULL);
INSERT INTO `node` VALUES (851, '土豆', 3, 0, 0, '土豆，植物，蔬菜', '土豆', NULL);
INSERT INTO `node` VALUES (852, '大蒜', 3, 0, 0, '大蒜', '大蒜', NULL);
INSERT INTO `node` VALUES (853, '西红柿', 3, 0, 0, '西红柿', '西红柿', NULL);
INSERT INTO `node` VALUES (854, '蔬菜文件', 1, 0, 0, NULL, NULL, NULL);
INSERT INTO `node` VALUES (855, '白菜', 3, 0, 0, '蔬菜，白菜', '好吃的白菜，补充维生素', NULL);
INSERT INTO `node` VALUES (856, '玉米', 3, 0, 0, '玉米', '玉米', NULL);
INSERT INTO `node` VALUES (857, '土豆', 3, 0, 0, '土豆，植物，蔬菜', '土豆', NULL);
INSERT INTO `node` VALUES (858, '大蒜', 3, 0, 0, '大蒜', '大蒜', NULL);
INSERT INTO `node` VALUES (859, '西红柿', 3, 0, 0, '西红柿', '西红柿', NULL);
INSERT INTO `node` VALUES (860, '蔬菜文件', 1, 0, 0, NULL, NULL, NULL);
INSERT INTO `node` VALUES (861, '白菜', 3, 0, 0, '蔬菜，白菜', '好吃的白菜，补充维生素', NULL);
INSERT INTO `node` VALUES (862, '玉米', 3, 0, 0, '玉米', '玉米', NULL);
INSERT INTO `node` VALUES (863, '土豆', 3, 0, 0, '土豆，植物，蔬菜', '土豆', NULL);
INSERT INTO `node` VALUES (864, '大蒜', 3, 0, 0, '大蒜', '大蒜', NULL);
INSERT INTO `node` VALUES (865, '西红柿', 3, 0, 0, '西红柿', '西红柿', NULL);
INSERT INTO `node` VALUES (866, '西瓜的视频', 5, 0, 0, '西瓜,视频', '西瓜的视频', NULL);
INSERT INTO `node` VALUES (867, '西瓜的视频', 5, 0, 0, '西瓜,视频', '西瓜的视频', NULL);
INSERT INTO `node` VALUES (868, '橘子', 3, 0, 0, '橘子', '橘子', NULL);
INSERT INTO `node` VALUES (869, '语文成绩1', 2, 0, 0, '1', '1', NULL);
INSERT INTO `node` VALUES (870, '鹰', 3, 0, 0, '鹰keywords', '老鹰', NULL);
INSERT INTO `node` VALUES (871, '数学成绩.xlsx', 6, 0, 0, '数学', '学生成绩', NULL);
INSERT INTO `node` VALUES (872, 'test2DB', 11, 0, 0, '数据库', 'mysql数据库', NULL);
INSERT INTO `node` VALUES (873, 'dbtable7663.txt', 2, 0, 0, NULL, NULL, NULL);
INSERT INTO `node` VALUES (875, 'dbtable7123.txt', 2, 0, 0, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for node_level
-- ----------------------------
DROP TABLE IF EXISTS `node_level`;
CREATE TABLE `node_level`  (
  `id` int(0) NOT NULL,
  `level` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of node_level
-- ----------------------------
INSERT INTO `node_level` VALUES (1, '0');
INSERT INTO `node_level` VALUES (2, '1');
INSERT INTO `node_level` VALUES (376, '2');
INSERT INTO `node_level` VALUES (468, '1');
INSERT INTO `node_level` VALUES (469, '1');
INSERT INTO `node_level` VALUES (470, '1');
INSERT INTO `node_level` VALUES (506, '2');
INSERT INTO `node_level` VALUES (516, '2');
INSERT INTO `node_level` VALUES (682, '2');
INSERT INTO `node_level` VALUES (683, '2');
INSERT INTO `node_level` VALUES (749, '1');
INSERT INTO `node_level` VALUES (799, '1');
INSERT INTO `node_level` VALUES (804, '1');
INSERT INTO `node_level` VALUES (805, '1');
INSERT INTO `node_level` VALUES (816, '1');
INSERT INTO `node_level` VALUES (823, '1');
INSERT INTO `node_level` VALUES (824, '1');
INSERT INTO `node_level` VALUES (825, '1');
INSERT INTO `node_level` VALUES (829, '1');
INSERT INTO `node_level` VALUES (830, '1');
INSERT INTO `node_level` VALUES (831, '1');
INSERT INTO `node_level` VALUES (832, '1');
INSERT INTO `node_level` VALUES (833, '1');
INSERT INTO `node_level` VALUES (834, '1');
INSERT INTO `node_level` VALUES (835, '1');
INSERT INTO `node_level` VALUES (843, '2');
INSERT INTO `node_level` VALUES (844, '2');
INSERT INTO `node_level` VALUES (845, '2');
INSERT INTO `node_level` VALUES (846, '2');
INSERT INTO `node_level` VALUES (847, '2');
INSERT INTO `node_level` VALUES (848, '2');
INSERT INTO `node_level` VALUES (854, '2');
INSERT INTO `node_level` VALUES (860, '2');
INSERT INTO `node_level` VALUES (866, '2');
INSERT INTO `node_level` VALUES (867, '2');
INSERT INTO `node_level` VALUES (868, '2');
INSERT INTO `node_level` VALUES (869, '2');
INSERT INTO `node_level` VALUES (870, '2');
INSERT INTO `node_level` VALUES (872, '2');

-- ----------------------------
-- Table structure for node_test
-- ----------------------------
DROP TABLE IF EXISTS `node_test`;
CREATE TABLE `node_test`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `type` int(0) DEFAULT NULL,
  `shared` tinyint(1) DEFAULT NULL,
  `cache` tinyint(1) DEFAULT NULL,
  `keywords` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `synopsis` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 731 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of node_test
-- ----------------------------
INSERT INTO `node_test` VALUES (717, '学生文件(公有)', 1, 0, 0, NULL, NULL);
INSERT INTO `node_test` VALUES (718, '教师文件(公有)', 1, 0, 0, NULL, NULL);
INSERT INTO `node_test` VALUES (719, '学习成绩', 1, 0, 0, NULL, NULL);
INSERT INTO `node_test` VALUES (720, '社会实践', 1, 0, 0, NULL, NULL);
INSERT INTO `node_test` VALUES (721, '语文成绩.txt', 2, 0, 0, NULL, NULL);
INSERT INTO `node_test` VALUES (723, '英语成绩.xlsx', 6, 0, 0, NULL, NULL);
INSERT INTO `node_test` VALUES (724, '数据结构成绩.xlsx', 6, 0, 0, '数学', '学生成绩');
INSERT INTO `node_test` VALUES (725, '计算机组成原理成绩', 6, 0, 0, '数学', '学生成绩');
INSERT INTO `node_test` VALUES (726, '操作系统成绩.xlsx', 6, 0, 0, '数学', '学生成绩');
INSERT INTO `node_test` VALUES (727, '编译原理成绩.txt', 2, 0, 0, NULL, NULL);
INSERT INTO `node_test` VALUES (728, 'Java程序设计成绩.xlsx', 6, 0, 0, '数学', '学生成绩');
INSERT INTO `node_test` VALUES (730, '苹果2', 3, 0, 0, '好吃restful', '苹果图片restful');

-- ----------------------------
-- Table structure for pipe_result
-- ----------------------------
DROP TABLE IF EXISTS `pipe_result`;
CREATE TABLE `pipe_result`  (
  `rid` int(0) NOT NULL AUTO_INCREMENT,
  `cal_result` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `cal_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`rid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pipe_result
-- ----------------------------
INSERT INTO `pipe_result` VALUES (1, '6.5', '2021-06-09 23:26:10');
INSERT INTO `pipe_result` VALUES (2, '7.0', '2021-06-10 11:52:15');
INSERT INTO `pipe_result` VALUES (3, '5.0', '2021-06-10 11:54:34');
INSERT INTO `pipe_result` VALUES (4, '5.0', '2021-06-10 11:54:37');
INSERT INTO `pipe_result` VALUES (5, '5.0', '2021-06-10 11:54:46');
INSERT INTO `pipe_result` VALUES (6, '5.0', '2021-06-10 11:54:50');
INSERT INTO `pipe_result` VALUES (7, '5.0', '2021-06-10 11:54:52');
INSERT INTO `pipe_result` VALUES (8, '5.0', '2021-06-10 11:58:22');
INSERT INTO `pipe_result` VALUES (9, '5.0,4.0', '2021-06-10 14:30:58');
INSERT INTO `pipe_result` VALUES (10, '2.0,2.0', '2021-06-10 14:31:21');
INSERT INTO `pipe_result` VALUES (11, '22.0', '2021-06-10 16:01:43');
INSERT INTO `pipe_result` VALUES (12, '1.0,5.0,2.0,6.0,2.0,6.0,3.0,5.0,3.0,7.0,8.0,5.0,4.0,8.0,5.0,6.0', '2021-06-10 16:04:41');
INSERT INTO `pipe_result` VALUES (13, '13.0,7.0', '2021-06-18 15:52:20');
INSERT INTO `pipe_result` VALUES (14, '10.75', '2021-06-18 15:59:27');
INSERT INTO `pipe_result` VALUES (15, '37.0', '2021-06-18 16:04:55');
INSERT INTO `pipe_result` VALUES (16, '220.0', '2021-06-18 16:36:36');
INSERT INTO `pipe_result` VALUES (17, '3.0,61.0', '2021-06-19 09:01:52');
INSERT INTO `pipe_result` VALUES (18, '22.0', '2021-06-19 11:29:38');
INSERT INTO `pipe_result` VALUES (19, '102.0', '2021-06-21 12:06:53');
INSERT INTO `pipe_result` VALUES (20, '102.0', '2021-06-21 12:11:15');
INSERT INTO `pipe_result` VALUES (21, '102.0', '2021-06-21 12:15:32');
INSERT INTO `pipe_result` VALUES (22, '102.0', '2021-06-21 12:17:02');
INSERT INTO `pipe_result` VALUES (23, '102.0', '2021-06-21 12:18:00');
INSERT INTO `pipe_result` VALUES (24, '89.0,13.0', '2021-06-21 12:20:45');
INSERT INTO `pipe_result` VALUES (25, '102.0', '2021-06-21 12:20:57');
INSERT INTO `pipe_result` VALUES (26, '102.0', '2021-06-21 12:23:45');
INSERT INTO `pipe_result` VALUES (27, '89.0,13.0', '2021-06-24 17:24:22');
INSERT INTO `pipe_result` VALUES (28, '5.0,7.0,7.0', '2021-06-24 20:14:00');
INSERT INTO `pipe_result` VALUES (29, '544.5', '2021-06-24 20:41:33');
INSERT INTO `pipe_result` VALUES (30, '79.75', '2021-06-24 20:42:08');
INSERT INTO `pipe_result` VALUES (31, '69.0', '2021-06-25 12:04:44');

-- ----------------------------
-- Table structure for privilege_list
-- ----------------------------
DROP TABLE IF EXISTS `privilege_list`;
CREATE TABLE `privilege_list`  (
  `prvid` int(0) NOT NULL AUTO_INCREMENT,
  `createfolder` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `createleaf` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `editdata` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `cut` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `remove_op` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `delete_all` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `delete_link` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `rename_op` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `move` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `append` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `insert_op` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `merge_to` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `merge_from` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `replace_op` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `sync_op` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`prvid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 160 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of privilege_list
-- ----------------------------
INSERT INTO `privilege_list` VALUES (132, 'true', 'true', 'true', 'true', 'true', 'true', 'true', 'true', 'true', 'true', 'true', 'true', 'true', 'true', 'true');
INSERT INTO `privilege_list` VALUES (133, 'true', 'true', 'true', 'false', 'true', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false');
INSERT INTO `privilege_list` VALUES (134, 'true', 'true', 'true', 'false', 'true', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false');
INSERT INTO `privilege_list` VALUES (135, 'true', 'true', 'true', 'true', 'true', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false');
INSERT INTO `privilege_list` VALUES (136, 'true', 'true', 'true', 'true', 'true', 'false', 'false', 'true', 'false', 'false', 'false', 'false', 'false', 'false', 'false');
INSERT INTO `privilege_list` VALUES (137, 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false');
INSERT INTO `privilege_list` VALUES (138, 'true', 'false', 'false', 'false', 'true', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false');
INSERT INTO `privilege_list` VALUES (139, 'true', 'false', 'false', 'false', 'true', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false');
INSERT INTO `privilege_list` VALUES (140, 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false');
INSERT INTO `privilege_list` VALUES (141, 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false');
INSERT INTO `privilege_list` VALUES (142, 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false');
INSERT INTO `privilege_list` VALUES (143, 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false');
INSERT INTO `privilege_list` VALUES (144, 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false');
INSERT INTO `privilege_list` VALUES (145, 'true', 'false', 'false', 'false', 'true', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false');
INSERT INTO `privilege_list` VALUES (146, 'true', 'false', 'false', 'false', 'true', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false');
INSERT INTO `privilege_list` VALUES (147, 'true', 'false', 'false', 'false', 'true', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false');
INSERT INTO `privilege_list` VALUES (148, 'true', 'false', 'false', 'false', 'true', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false');
INSERT INTO `privilege_list` VALUES (149, 'true', 'false', 'false', 'false', 'true', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false');
INSERT INTO `privilege_list` VALUES (150, 'true', 'false', 'false', 'false', 'true', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false');
INSERT INTO `privilege_list` VALUES (151, 'true', 'false', 'false', 'false', 'true', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false');
INSERT INTO `privilege_list` VALUES (152, 'true', 'false', 'false', 'false', 'true', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false');
INSERT INTO `privilege_list` VALUES (153, 'true', 'false', 'false', 'false', 'true', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false');
INSERT INTO `privilege_list` VALUES (154, 'true', 'false', 'false', 'false', 'true', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false');
INSERT INTO `privilege_list` VALUES (155, 'true', 'true', 'true', 'false', 'true', 'false', 'false', 'true', 'false', 'false', 'false', 'false', 'false', 'false', 'false');
INSERT INTO `privilege_list` VALUES (156, 'true', 'true', 'true', 'false', 'true', 'false', 'false', 'true', 'false', 'false', 'false', 'false', 'false', 'false', 'false');
INSERT INTO `privilege_list` VALUES (157, 'true', 'true', 'true', 'false', 'true', 'false', 'false', 'true', 'false', 'false', 'false', 'false', 'false', 'false', 'false');
INSERT INTO `privilege_list` VALUES (158, 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false');
INSERT INTO `privilege_list` VALUES (159, 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false');
INSERT INTO `privilege_list` VALUES (160, 'true', 'true', 'false', 'false', 'true', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'true');

-- ----------------------------
-- Table structure for privilege_relation
-- ----------------------------
DROP TABLE IF EXISTS `privilege_relation`;
CREATE TABLE `privilege_relation`  (
  `prvid` int(0) NOT NULL,
  `id` int(0) NOT NULL,
  PRIMARY KEY (`prvid`, `id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of privilege_relation
-- ----------------------------
INSERT INTO `privilege_relation` VALUES (132, 843);
INSERT INTO `privilege_relation` VALUES (133, 844);
INSERT INTO `privilege_relation` VALUES (134, 845);
INSERT INTO `privilege_relation` VALUES (135, 846);
INSERT INTO `privilege_relation` VALUES (136, 847);
INSERT INTO `privilege_relation` VALUES (137, 848);
INSERT INTO `privilege_relation` VALUES (138, 854);
INSERT INTO `privilege_relation` VALUES (139, 860);
INSERT INTO `privilege_relation` VALUES (140, 849);
INSERT INTO `privilege_relation` VALUES (141, 850);
INSERT INTO `privilege_relation` VALUES (142, 851);
INSERT INTO `privilege_relation` VALUES (143, 852);
INSERT INTO `privilege_relation` VALUES (144, 853);
INSERT INTO `privilege_relation` VALUES (145, 855);
INSERT INTO `privilege_relation` VALUES (146, 856);
INSERT INTO `privilege_relation` VALUES (147, 857);
INSERT INTO `privilege_relation` VALUES (148, 858);
INSERT INTO `privilege_relation` VALUES (149, 859);
INSERT INTO `privilege_relation` VALUES (150, 861);
INSERT INTO `privilege_relation` VALUES (151, 862);
INSERT INTO `privilege_relation` VALUES (152, 863);
INSERT INTO `privilege_relation` VALUES (153, 864);
INSERT INTO `privilege_relation` VALUES (154, 865);
INSERT INTO `privilege_relation` VALUES (155, 866);
INSERT INTO `privilege_relation` VALUES (156, 867);
INSERT INTO `privilege_relation` VALUES (157, 868);
INSERT INTO `privilege_relation` VALUES (158, 869);
INSERT INTO `privilege_relation` VALUES (159, 870);
INSERT INTO `privilege_relation` VALUES (160, 872);

-- ----------------------------
-- Table structure for relation
-- ----------------------------
DROP TABLE IF EXISTS `relation`;
CREATE TABLE `relation`  (
  `parent` int(0) NOT NULL,
  `child` int(0) NOT NULL,
  PRIMARY KEY (`parent`, `child`) USING BTREE,
  INDEX `id`(`child`) USING BTREE,
  CONSTRAINT `relation_ibfk_1` FOREIGN KEY (`parent`) REFERENCES `node` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `relation_ibfk_2` FOREIGN KEY (`child`) REFERENCES `node` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of relation
-- ----------------------------
INSERT INTO `relation` VALUES (1, 2);
INSERT INTO `relation` VALUES (1, 376);
INSERT INTO `relation` VALUES (2, 799);
INSERT INTO `relation` VALUES (799, 800);
INSERT INTO `relation` VALUES (799, 801);
INSERT INTO `relation` VALUES (799, 802);
INSERT INTO `relation` VALUES (799, 803);
INSERT INTO `relation` VALUES (2, 804);
INSERT INTO `relation` VALUES (804, 805);
INSERT INTO `relation` VALUES (805, 806);
INSERT INTO `relation` VALUES (805, 807);
INSERT INTO `relation` VALUES (805, 808);
INSERT INTO `relation` VALUES (805, 809);
INSERT INTO `relation` VALUES (805, 810);
INSERT INTO `relation` VALUES (805, 811);
INSERT INTO `relation` VALUES (805, 812);
INSERT INTO `relation` VALUES (805, 813);
INSERT INTO `relation` VALUES (805, 814);
INSERT INTO `relation` VALUES (805, 815);
INSERT INTO `relation` VALUES (804, 816);
INSERT INTO `relation` VALUES (816, 817);
INSERT INTO `relation` VALUES (816, 818);
INSERT INTO `relation` VALUES (816, 819);
INSERT INTO `relation` VALUES (816, 820);
INSERT INTO `relation` VALUES (816, 821);
INSERT INTO `relation` VALUES (2, 823);
INSERT INTO `relation` VALUES (2, 824);
INSERT INTO `relation` VALUES (824, 825);
INSERT INTO `relation` VALUES (825, 826);
INSERT INTO `relation` VALUES (825, 827);
INSERT INTO `relation` VALUES (825, 828);
INSERT INTO `relation` VALUES (824, 829);
INSERT INTO `relation` VALUES (823, 830);
INSERT INTO `relation` VALUES (823, 831);
INSERT INTO `relation` VALUES (823, 832);
INSERT INTO `relation` VALUES (823, 833);
INSERT INTO `relation` VALUES (823, 834);
INSERT INTO `relation` VALUES (823, 835);
INSERT INTO `relation` VALUES (376, 843);
INSERT INTO `relation` VALUES (376, 844);
INSERT INTO `relation` VALUES (376, 845);
INSERT INTO `relation` VALUES (376, 846);
INSERT INTO `relation` VALUES (376, 847);
INSERT INTO `relation` VALUES (376, 848);
INSERT INTO `relation` VALUES (848, 849);
INSERT INTO `relation` VALUES (848, 850);
INSERT INTO `relation` VALUES (848, 851);
INSERT INTO `relation` VALUES (848, 852);
INSERT INTO `relation` VALUES (848, 853);
INSERT INTO `relation` VALUES (376, 854);
INSERT INTO `relation` VALUES (854, 855);
INSERT INTO `relation` VALUES (854, 856);
INSERT INTO `relation` VALUES (854, 857);
INSERT INTO `relation` VALUES (854, 858);
INSERT INTO `relation` VALUES (854, 859);
INSERT INTO `relation` VALUES (376, 860);
INSERT INTO `relation` VALUES (860, 861);
INSERT INTO `relation` VALUES (860, 862);
INSERT INTO `relation` VALUES (860, 863);
INSERT INTO `relation` VALUES (860, 864);
INSERT INTO `relation` VALUES (860, 865);
INSERT INTO `relation` VALUES (376, 866);
INSERT INTO `relation` VALUES (376, 867);
INSERT INTO `relation` VALUES (376, 868);
INSERT INTO `relation` VALUES (376, 869);
INSERT INTO `relation` VALUES (376, 870);
INSERT INTO `relation` VALUES (376, 872);

-- ----------------------------
-- Table structure for remind_relation
-- ----------------------------
DROP TABLE IF EXISTS `remind_relation`;
CREATE TABLE `remind_relation`  (
  `id` int(0) NOT NULL,
  `start_hour` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `start_minute` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `end_hour` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `end_minute` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of remind_relation
-- ----------------------------
INSERT INTO `remind_relation` VALUES (443, '0', '0', '0', '0');
INSERT INTO `remind_relation` VALUES (651, '12', '51', '13', '51');
INSERT INTO `remind_relation` VALUES (653, '21', '19', '21', '19');
INSERT INTO `remind_relation` VALUES (667, '8', '39', '8', '39');
INSERT INTO `remind_relation` VALUES (669, '8', '55', '8', '55');
INSERT INTO `remind_relation` VALUES (672, '0', '51', '23', '51');
INSERT INTO `remind_relation` VALUES (673, '1', '0', '22', '17');
INSERT INTO `remind_relation` VALUES (676, '14', '42', '14', '42');
INSERT INTO `remind_relation` VALUES (679, '1', '40', '22', '40');
INSERT INTO `remind_relation` VALUES (696, '14', '21', '14', '21');
INSERT INTO `remind_relation` VALUES (697, '14', '22', '14', '22');
INSERT INTO `remind_relation` VALUES (699, '14', '24', '14', '24');
INSERT INTO `remind_relation` VALUES (700, '14', '27', '14', '27');
INSERT INTO `remind_relation` VALUES (701, '10', '32', '19', '33');
INSERT INTO `remind_relation` VALUES (702, '11', '24', '23', '24');
INSERT INTO `remind_relation` VALUES (721, NULL, NULL, NULL, NULL);
INSERT INTO `remind_relation` VALUES (722, NULL, NULL, NULL, NULL);
INSERT INTO `remind_relation` VALUES (724, '9', '0', '9', '0');
INSERT INTO `remind_relation` VALUES (729, '12', '14', '12', '14');
INSERT INTO `remind_relation` VALUES (730, '23', '3', '23', '3');
INSERT INTO `remind_relation` VALUES (737, '15', '47', '15', '47');
INSERT INTO `remind_relation` VALUES (739, '15', '56', '15', '56');
INSERT INTO `remind_relation` VALUES (741, '0', '0', '0', '0');
INSERT INTO `remind_relation` VALUES (744, '11', '43', '11', '43');
INSERT INTO `remind_relation` VALUES (830, '19', '29', '23', '29');
INSERT INTO `remind_relation` VALUES (831, '5', '57', '23', '59');

-- ----------------------------
-- Table structure for sync
-- ----------------------------
DROP TABLE IF EXISTS `sync`;
CREATE TABLE `sync`  (
  `link` int(0) NOT NULL,
  `strategy` int(0) DEFAULT NULL,
  `next` bigint(0) DEFAULT NULL,
  `intervallum` int(0) DEFAULT NULL,
  PRIMARY KEY (`link`) USING BTREE,
  CONSTRAINT `sync_ibfk_1` FOREIGN KEY (`link`) REFERENCES `node` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sync
-- ----------------------------
INSERT INTO `sync` VALUES (830, 2, -1, 0);
INSERT INTO `sync` VALUES (831, 1, -1, 0);

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test`  (
  `id` int(0) NOT NULL,
  `t1` int(0) DEFAULT NULL,
  `t2` int(0) DEFAULT NULL,
  `t3` int(0) DEFAULT NULL,
  `t4` int(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES (1, 20, 2, 5, 9);
INSERT INTO `test` VALUES (2, 55, 4, 3, 7);
INSERT INTO `test` VALUES (3, 5, 5, 6, 8);
INSERT INTO `test` VALUES (4, 9, 11, 7, 19);
INSERT INTO `test` VALUES (5, 6, 1, 2, 2);
INSERT INTO `test` VALUES (6, 2, 2, 2, 3);
INSERT INTO `test` VALUES (7, 1, 2, 3, 4);
INSERT INTO `test` VALUES (8, 1, 2, 3, 4);
INSERT INTO `test` VALUES (9, 2, 2, 1, 2);
INSERT INTO `test` VALUES (10, 11, 2, 1, 1);
INSERT INTO `test` VALUES (11, 2, 3, 2, 8);
INSERT INTO `test` VALUES (12, 2, 6, 6, 8);
INSERT INTO `test` VALUES (13, 8, 6, 6, 8);

-- ----------------------------
-- Table structure for test2
-- ----------------------------
DROP TABLE IF EXISTS `test2`;
CREATE TABLE `test2`  (
  `id` int(0) NOT NULL,
  `t1` int(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test2
-- ----------------------------
INSERT INTO `test2` VALUES (1, 88);
INSERT INTO `test2` VALUES (2, 11);
INSERT INTO `test2` VALUES (3, 4);

-- ----------------------------
-- Table structure for test_cycle
-- ----------------------------
DROP TABLE IF EXISTS `test_cycle`;
CREATE TABLE `test_cycle`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `t1` int(0) DEFAULT NULL,
  `t2` int(0) DEFAULT NULL,
  `t3` int(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_cycle
-- ----------------------------
INSERT INTO `test_cycle` VALUES (1, 2, 1, 1);
INSERT INTO `test_cycle` VALUES (2, 3, 2, 6);
INSERT INTO `test_cycle` VALUES (3, 9, 9, 7);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `authority` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (15, 'admin', '123', 'admin');
INSERT INTO `user` VALUES (16, 'tom', '123', 'admin');
INSERT INTO `user` VALUES (17, 'Bob', '123', 'reader');
INSERT INTO `user` VALUES (18, 'Lucy', '123', 'writer');
INSERT INTO `user` VALUES (19, 'Eric', '123', 'reader');
INSERT INTO `user` VALUES (20, 'Susan', '123', 'reader');
INSERT INTO `user` VALUES (21, 'Joe', '123', 'reader');
INSERT INTO `user` VALUES (22, 'Ada', '123', 'reader');
INSERT INTO `user` VALUES (23, 'Liz', '123', 'admin');
INSERT INTO `user` VALUES (24, 'super', '123', 'admin_super');
INSERT INTO `user` VALUES (26, 'Bob1', '123', 'reader');
INSERT INTO `user` VALUES (27, 'tom2', '123', 'reader');
INSERT INTO `user` VALUES (28, 'Bob2', '123', 'reader');
INSERT INTO `user` VALUES (29, 'Alice', '123', 'writer');

-- ----------------------------
-- Table structure for user_op_authority
-- ----------------------------
DROP TABLE IF EXISTS `user_op_authority`;
CREATE TABLE `user_op_authority`  (
  `id` int(0) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `op_authority` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `licensor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `tabletype` int(0) DEFAULT NULL,
  `nodepath` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`, `username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_op_authority
-- ----------------------------
INSERT INTO `user_op_authority` VALUES (843, 'Bob', 'writer', '接受', 'Bob', NULL, 'ROOT/被授权数据(私有)/Bob的文件夹1');
INSERT INTO `user_op_authority` VALUES (844, 'Eric', 'writer', '接受', 'tom', 0, 'ROOT/被授权数据(私有)/语文成绩1');
INSERT INTO `user_op_authority` VALUES (845, 'admin', 'writer', '接受', 'Eric', 1, 'ROOT/被授权数据(私有)/语文成绩1');
INSERT INTO `user_op_authority` VALUES (846, 'Lucy', 'writer', '接受', 'Eric', 1, 'ROOT/被授权数据(私有)/语文成绩1');
INSERT INTO `user_op_authority` VALUES (847, 'Bob', 'writer', '接受', 'Eric', 1, 'ROOT/被授权数据(私有)/语文成绩1');
INSERT INTO `user_op_authority` VALUES (848, 'super', 'reader', '接受', 'Lucy', 1, 'ROOT/被授权数据(私有)/蔬菜文件');
INSERT INTO `user_op_authority` VALUES (849, 'super', 'reader', '接受', 'Lucy', 1, 'ROOT/被授权数据(私有)/蔬菜文件/白菜');
INSERT INTO `user_op_authority` VALUES (850, 'super', 'reader', '接受', 'Lucy', 1, 'ROOT/被授权数据(私有)/蔬菜文件/玉米');
INSERT INTO `user_op_authority` VALUES (851, 'super', 'reader', '接受', 'Lucy', 1, 'ROOT/被授权数据(私有)/蔬菜文件/土豆');
INSERT INTO `user_op_authority` VALUES (852, 'super', 'reader', '接受', 'Lucy', 1, 'ROOT/被授权数据(私有)/蔬菜文件/大蒜');
INSERT INTO `user_op_authority` VALUES (853, 'super', 'reader', '接受', 'Lucy', 1, 'ROOT/被授权数据(私有)/蔬菜文件/西红柿');
INSERT INTO `user_op_authority` VALUES (854, 'Joe', 'writer', '接受', 'Lucy', 1, 'ROOT/被授权数据(私有)/蔬菜文件');
INSERT INTO `user_op_authority` VALUES (855, 'Joe', 'writer', '接受', 'Lucy', 1, 'ROOT/被授权数据(私有)/蔬菜文件/白菜');
INSERT INTO `user_op_authority` VALUES (856, 'Joe', 'writer', '接受', 'Lucy', 1, 'ROOT/被授权数据(私有)/蔬菜文件/玉米');
INSERT INTO `user_op_authority` VALUES (857, 'Joe', 'writer', '接受', 'Lucy', 1, 'ROOT/被授权数据(私有)/蔬菜文件/土豆');
INSERT INTO `user_op_authority` VALUES (858, 'Joe', 'writer', '接受', 'Lucy', 1, 'ROOT/被授权数据(私有)/蔬菜文件/大蒜');
INSERT INTO `user_op_authority` VALUES (859, 'Joe', 'writer', '接受', 'Lucy', 1, 'ROOT/被授权数据(私有)/蔬菜文件/西红柿');
INSERT INTO `user_op_authority` VALUES (860, 'Alice', 'writer', '接受', 'Lucy', 1, 'ROOT/被授权数据(私有)/蔬菜文件');
INSERT INTO `user_op_authority` VALUES (861, 'Alice', 'writer', '接受', 'Lucy', 1, 'ROOT/被授权数据(私有)/蔬菜文件/白菜');
INSERT INTO `user_op_authority` VALUES (862, 'Alice', 'writer', '接受', 'Lucy', 1, 'ROOT/被授权数据(私有)/蔬菜文件/玉米');
INSERT INTO `user_op_authority` VALUES (863, 'Alice', 'writer', '接受', 'Lucy', 1, 'ROOT/被授权数据(私有)/蔬菜文件/土豆');
INSERT INTO `user_op_authority` VALUES (864, 'Alice', 'writer', '接受', 'Lucy', 1, 'ROOT/被授权数据(私有)/蔬菜文件/大蒜');
INSERT INTO `user_op_authority` VALUES (865, 'Alice', 'writer', '接受', 'Lucy', 1, 'ROOT/被授权数据(私有)/蔬菜文件/西红柿');
INSERT INTO `user_op_authority` VALUES (866, 'Alice', 'writer', '接受', 'admin', 0, 'ROOT/被授权数据(私有)/西瓜的视频');
INSERT INTO `user_op_authority` VALUES (867, 'tom', 'writer', '接受', 'admin', 0, 'ROOT/被授权数据(私有)/西瓜的视频');
INSERT INTO `user_op_authority` VALUES (868, 'super', 'writer', '接受', 'admin', 0, 'ROOT/被授权数据(私有)/橘子');
INSERT INTO `user_op_authority` VALUES (869, 'super', 'reader', '接受', 'Bob', 1, 'ROOT/被授权数据(私有)/语文成绩1');
INSERT INTO `user_op_authority` VALUES (870, 'super', 'reader', '接受', 'Alice', 1, 'ROOT/被授权数据(私有)/鹰');
INSERT INTO `user_op_authority` VALUES (872, 'Bob1', 'writer', '接受', 'tom', 0, 'ROOT/被授权数据(私有)/test2DB');

-- ----------------------------
-- Table structure for wait_confirm
-- ----------------------------
DROP TABLE IF EXISTS `wait_confirm`;
CREATE TABLE `wait_confirm`  (
  `id` int(0) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `licensor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for wait_mail
-- ----------------------------
DROP TABLE IF EXISTS `wait_mail`;
CREATE TABLE `wait_mail`  (
  `wmid` int(0) NOT NULL AUTO_INCREMENT,
  `id` int(0) NOT NULL,
  `e_to` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `e_subject` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `e_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`wmid`, `id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
