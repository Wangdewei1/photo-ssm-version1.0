/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80031 (8.0.31)
 Source Host           : localhost:3306
 Source Schema         : picture

 Target Server Type    : MySQL
 Target Server Version : 80031 (8.0.31)
 File Encoding         : 65001

 Date: 23/06/2023 18:59:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `log_id` int NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `log_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `log_date` datetime NULL DEFAULT NULL COMMENT '日志记录日期',
  PRIMARY KEY (`log_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES (1, 'findAll', '2023-06-23 17:34:35');
INSERT INTO `log` VALUES (2, NULL, NULL);
INSERT INTO `log` VALUES (3, 'findAllPicturecom.auto.service.impl.PictureServiceImpl1658', '2023-06-23 18:22:22');
INSERT INTO `log` VALUES (4, NULL, NULL);
INSERT INTO `log` VALUES (5, 'findPagecom.auto.service.impl.PictureServiceImpl543', '2023-06-23 18:31:02');
INSERT INTO `log` VALUES (6, NULL, NULL);
INSERT INTO `log` VALUES (7, 'findAllcom.auto.service.impl.UserServiceImpl2', '2023-06-23 18:50:57');
INSERT INTO `log` VALUES (8, 'findAllcom.auto.service.impl.UserServiceImpl0', '2023-06-23 18:51:08');
INSERT INTO `log` VALUES (9, 'findAllcom.auto.service.impl.UserServiceImpl0', '2023-06-23 18:51:14');
INSERT INTO `log` VALUES (10, 'findAllcom.auto.service.impl.UserServiceImpl0', '2023-06-23 18:51:25');
INSERT INTO `log` VALUES (11, 'getUserByIdcom.auto.service.impl.UserServiceImpl0', '2023-06-23 18:53:26');
INSERT INTO `log` VALUES (12, 'findAllPicturecom.auto.service.impl.PictureServiceImpl3', '2023-06-23 18:55:21');
INSERT INTO `log` VALUES (13, 'findPagecom.auto.service.impl.PictureServiceImpl0', '2023-06-23 18:55:33');
INSERT INTO `log` VALUES (14, 'findAllcom.auto.service.impl.UserServiceImpl0', '2023-06-23 18:55:49');

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '相册id',
  `pic_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '相册名称',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '相册路径\r\n相册路径',
  `img_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图片路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of picture
-- ----------------------------
INSERT INTO `picture` VALUES (1, '美女', '美女图片1', '/photo/img/boke/1a160d77f4.jpg');
INSERT INTO `picture` VALUES (2, '帅哥', '帅哥图片1', '/photo/img/boke/1a160d77f4.jpg');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `pwd` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '五阿哥', 'wuage');
INSERT INTO `user` VALUES (3, '赵七', '123123');
INSERT INTO `user` VALUES (4, '赵八', '123123');
INSERT INTO `user` VALUES (5, '李元霸', '123123');

SET FOREIGN_KEY_CHECKS = 1;
