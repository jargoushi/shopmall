/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50540
 Source Host           : localhost:3306
 Source Schema         : shop

 Target Server Type    : MySQL
 Target Server Version : 50540
 File Encoding         : 65001

 Date: 28/07/2020 14:07:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`  (
  `activityId` int(12) NOT NULL AUTO_INCREMENT,
  `activityName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `activityDes` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `discount` float NULL DEFAULT 1,
  `fullPrice` int(12) NULL DEFAULT NULL,
  `reducePrice` int(12) NULL DEFAULT NULL,
  `fullNum` int(12) NULL DEFAULT NULL,
  `reduceNum` int(12) NULL DEFAULT NULL,
  PRIMARY KEY (`activityId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES (1, 'default', 'default activity', 1, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `addressID` int(12) NOT NULL AUTO_INCREMENT,
  `userId` int(12) NOT NULL,
  `province` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `city` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `county` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `detailAddr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `conName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `conTel` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`addressID`) USING BTREE,
  INDEX `addressID`(`addressID`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE,
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of address
-- ----------------------------

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `adminId` int(12) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`adminId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'wuxihao', '123456789');
INSERT INTO `admin` VALUES (2, 'zhangsan', '1111');
INSERT INTO `admin` VALUES (3, 'admin', 'admin');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `cateId` int(12) NOT NULL AUTO_INCREMENT,
  `cateName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`cateId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '数码');
INSERT INTO `category` VALUES (2, '服饰');
INSERT INTO `category` VALUES (3, '家电');
INSERT INTO `category` VALUES (4, '书籍');

-- ----------------------------
-- Table structure for chat
-- ----------------------------
DROP TABLE IF EXISTS `chat`;
CREATE TABLE `chat`  (
  `chatId` int(20) NOT NULL AUTO_INCREMENT,
  `sendUser` int(12) NOT NULL,
  `receiveUser` int(12) NOT NULL,
  `MsgContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `MsgTime` datetime NOT NULL,
  PRIMARY KEY (`chatId`) USING BTREE,
  INDEX `sendUser`(`sendUser`) USING BTREE,
  INDEX `receiveUser`(`receiveUser`) USING BTREE,
  CONSTRAINT `chat_ibfk_1` FOREIGN KEY (`sendUser`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `chat_ibfk_2` FOREIGN KEY (`receiveUser`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of chat
-- ----------------------------

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection`  (
  `userId` int(12) NOT NULL,
  `goodsId` int(12) NOT NULL,
  `collectTime` datetime NOT NULL,
  PRIMARY KEY (`userId`, `goodsId`) USING BTREE,
  INDEX `collection_ibfk_2`(`goodsId`) USING BTREE,
  CONSTRAINT `collection_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `collection_ibfk_2` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`goodsId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of collection
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `commentId` int(12) NOT NULL AUTO_INCREMENT,
  `userId` int(12) NOT NULL,
  `goodsId` int(12) NOT NULL,
  `point` int(8) NOT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `commentTime` datetime NOT NULL,
  PRIMARY KEY (`commentId`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE,
  INDEX `goodsId`(`goodsId`) USING BTREE,
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`goodsId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for deliver
-- ----------------------------
DROP TABLE IF EXISTS `deliver`;
CREATE TABLE `deliver`  (
  `deliverId` int(12) NOT NULL AUTO_INCREMENT,
  `orderId` int(12) NOT NULL,
  `sendId` int(12) NOT NULL,
  PRIMARY KEY (`deliverId`) USING BTREE,
  INDEX `orderId`(`orderId`) USING BTREE,
  CONSTRAINT `deliver_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `indent` (`orderId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of deliver
-- ----------------------------

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `goodsId` int(12) NOT NULL AUTO_INCREMENT,
  `goodsName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` int(12) NOT NULL,
  `num` int(12) NOT NULL,
  `upTime` datetime NOT NULL,
  `category` int(12) NOT NULL,
  `detailCate` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `activityId` int(12) NOT NULL DEFAULT 1,
  PRIMARY KEY (`goodsId`) USING BTREE,
  INDEX `activityId`(`activityId`) USING BTREE,
  INDEX `category`(`category`) USING BTREE,
  CONSTRAINT `goods_ibfk_1` FOREIGN KEY (`activityId`) REFERENCES `activity` (`activityId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `goods_ibfk_2` FOREIGN KEY (`category`) REFERENCES `category` (`cateId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (8, '志高移动空调', 899, 9002, '2020-07-28 03:11:27', 3, '空调', '免安装空调 冷暖双用 送榨汁杯 全国联保', 1);
INSERT INTO `goods` VALUES (9, '美的空调一级变频冷暖大3匹智', 6199, 6000, '2020-07-28 03:24:58', 3, '空调', '新能效升级 晒单立返100元KFR-72LW/N8MHA1\r\n\r\n承诺送货入户，未履约赔付10000积分', 1);
INSERT INTO `goods` VALUES (10, '美的空调一级变频冷暖大3匹智能', 6199, 6000, '2020-07-28 03:25:50', 3, '空调', '新能效升级 晒单立返100元KFR-72LW/N8MHA1\r\n\r\n承诺送货入户，未履约赔付10000积分', 1);
INSERT INTO `goods` VALUES (11, '美的空调一级变频冷暖大3匹智能', 6199, 6000, '2020-07-28 03:29:18', 3, '空调', '新能效升级 晒单立返100元KFR-72LW/N8MHA1\r\n\r\n承诺送货入户，未履约赔付10000积分', 1);
INSERT INTO `goods` VALUES (12, '志高移动空调可冷暖家用', 899, 9002, '2020-07-28 03:32:05', 3, '空调', '免安装空调 冷暖双用 送榨汁杯 全国联保', 1);

-- ----------------------------
-- Table structure for imagepath
-- ----------------------------
DROP TABLE IF EXISTS `imagepath`;
CREATE TABLE `imagepath`  (
  `pathId` int(12) NOT NULL AUTO_INCREMENT,
  `goodId` int(12) NOT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`pathId`) USING BTREE,
  INDEX `goodid`(`goodId`) USING BTREE,
  CONSTRAINT `imagepath_ibfk_1` FOREIGN KEY (`goodId`) REFERENCES `goods` (`goodsId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of imagepath
-- ----------------------------
INSERT INTO `imagepath` VALUES (2, 8, 'http://bookmanage.oss-cn-shanghai.aliyuncs.com/20200728/1595907128417877.jpg');
INSERT INTO `imagepath` VALUES (3, 9, 'http://bookmanage.oss-cn-shanghai.aliyuncs.com/20200728/1595907128417877.jpg');
INSERT INTO `imagepath` VALUES (4, 10, 'http://bookmanage.oss-cn-shanghai.aliyuncs.com/20200728/1595907128417877.jpg');
INSERT INTO `imagepath` VALUES (5, 11, 'http://bookmanage.oss-cn-shanghai.aliyuncs.com/20200728/1595907128417877.jpg');
INSERT INTO `imagepath` VALUES (6, 12, 'http://bookmanage.oss-cn-shanghai.aliyuncs.com/20200728/1595907128417877.jpg');

-- ----------------------------
-- Table structure for indent
-- ----------------------------
DROP TABLE IF EXISTS `indent`;
CREATE TABLE `indent`  (
  `orderId` int(12) NOT NULL AUTO_INCREMENT,
  `userId` int(12) NOT NULL,
  `orderTime` datetime NOT NULL,
  `oldPrice` float NOT NULL,
  `newPrice` float NOT NULL,
  `isPay` tinyint(1) NOT NULL,
  `isSend` tinyint(1) NOT NULL,
  `isReceive` tinyint(1) NOT NULL,
  `isComplete` tinyint(1) NOT NULL,
  `addressId` int(12) NOT NULL,
  PRIMARY KEY (`orderId`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE,
  INDEX `orderGoods`(`orderTime`) USING BTREE,
  INDEX `addressId`(`addressId`) USING BTREE,
  CONSTRAINT `indent_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `indent_ibfk_2` FOREIGN KEY (`addressId`) REFERENCES `address` (`addressID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of indent
-- ----------------------------

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem`  (
  `itemId` int(12) NOT NULL AUTO_INCREMENT,
  `orderId` int(12) NOT NULL,
  `goodsId` int(12) NOT NULL,
  `num` int(12) NOT NULL,
  PRIMARY KEY (`itemId`) USING BTREE,
  INDEX `orderId`(`orderId`) USING BTREE,
  INDEX `goodsId`(`goodsId`) USING BTREE,
  CONSTRAINT `orderitem_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `indent` (`orderId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `orderitem_ibfk_2` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`goodsId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of orderitem
-- ----------------------------

-- ----------------------------
-- Table structure for shopcart
-- ----------------------------
DROP TABLE IF EXISTS `shopcart`;
CREATE TABLE `shopcart`  (
  `userId` int(12) NOT NULL,
  `goodsid` int(12) NOT NULL,
  `cateDate` datetime NOT NULL,
  `goodsNum` int(12) NOT NULL,
  PRIMARY KEY (`userId`, `goodsid`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE,
  INDEX `goodsid`(`goodsid`) USING BTREE,
  CONSTRAINT `shopcart_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `shopcart_ibfk_2` FOREIGN KEY (`goodsid`) REFERENCES `goods` (`goodsId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of shopcart
-- ----------------------------
INSERT INTO `shopcart` VALUES (16, 10, '2020-07-28 06:05:15', 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userId` int(12) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `regTime` datetime NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `telephone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`userId`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (16, 'admin', 'admin', '2020-07-28 11:06:12', '894746069@qq.com', '19521366642');

SET FOREIGN_KEY_CHECKS = 1;
