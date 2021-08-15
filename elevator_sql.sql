/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : elevator

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 15/08/2021 18:24:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for elevator
-- ----------------------------
DROP TABLE IF EXISTS `elevator`;
CREATE TABLE `elevator` (
  `elevatorId` int(100) NOT NULL AUTO_INCREMENT,
  `elevatorName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`elevatorId`)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of elevator
-- ----------------------------
BEGIN;
INSERT INTO `elevator` VALUES (1000, 'MYlindaxia');
INSERT INTO `elevator` VALUES (1001, 'HDD');
COMMIT;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menuId` int(10) NOT NULL AUTO_INCREMENT,
  `menuName` varchar(255) DEFAULT NULL,
  `menuWritePower` int(10) DEFAULT NULL,
  `menuReadPower` int(10) DEFAULT NULL,
  PRIMARY KEY (`menuId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
BEGIN;
INSERT INTO `menu` VALUES (1, '订单管理', 0, 1);
INSERT INTO `menu` VALUES (2, '用户管理', 0, 1);
INSERT INTO `menu` VALUES (3, '电梯管理', 0, 1);
COMMIT;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `orderId` int(100) NOT NULL AUTO_INCREMENT,
  `elevatorId` int(100) NOT NULL COMMENT '出错电梯id\n',
  `createTime` datetime(6) DEFAULT NULL,
  `createVillage` varchar(255) DEFAULT NULL,
  `problem` varchar(255) DEFAULT NULL,
  `result` enum('0','1','2') DEFAULT NULL,
  `resultTime` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`orderId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
BEGIN;
INSERT INTO `order` VALUES (2, 1002, '2021-07-13 10:36:58.000000', '璧山大别墅', '未知', '1', NULL);
INSERT INTO `order` VALUES (4, 1002, '2021-07-25 07:46:30.000000', '丁家大别墅', '电梯老化', '1', '2021-07-29 07:46:45.000000');
INSERT INTO `order` VALUES (5, 1002, '2021-07-13 10:43:42.000000', '丁家大别墅', '未知', '1', '2021-07-13 10:43:42.000000');
INSERT INTO `order` VALUES (7, 1001, NULL, '丁家', '未知', '0', NULL);
INSERT INTO `order` VALUES (8, 1001, '2000-11-02 12:12:12.000000', '丁家', '未知', '0', '2000-12-02 12:12:13.000000');
INSERT INTO `order` VALUES (9, 1001, '2000-11-02 12:12:12.000000', '丁家', '预估机器出问题了', '0', NULL);
INSERT INTO `order` VALUES (10, 1001, '2021-07-13 09:06:39.000000', 'test', 'test', '2', NULL);
INSERT INTO `order` VALUES (11, 1001, '2021-07-13 09:07:01.000000', 'test', 'test', '0', '2021-07-13 09:07:01.000000');
INSERT INTO `order` VALUES (12, 1001, '2021-07-13 09:26:44.000000', 'test1', 'test1', '2', NULL);
INSERT INTO `order` VALUES (13, 1001, '2021-07-13 09:27:04.000000', 'test12', 'test1', '0', '2021-07-13 09:27:04.000000');
INSERT INTO `order` VALUES (14, 1001, '2021-07-13 10:10:02.000000', '123', '123', '1', NULL);
INSERT INTO `order` VALUES (15, 1001, '2021-07-13 10:10:14.000000', '123', '123', '0', '2021-07-13 10:10:14.000000');
INSERT INTO `order` VALUES (16, 1001, '2021-07-13 14:44:56.000000', '大侠', '未知', '1', NULL);
INSERT INTO `order` VALUES (17, 1001, '2021-07-13 14:45:08.000000', '何丹', '未知', '0', '2021-07-13 14:45:08.000000');
INSERT INTO `order` VALUES (18, 1001, '2021-07-13 14:45:39.000000', '何丹', '未知', '2', '2021-07-13 14:45:39.000000');
INSERT INTO `order` VALUES (19, 1001, '2021-07-13 14:46:25.000000', '大侠', '未知', '1', NULL);
COMMIT;

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token` (
  `tokenId` int(10) NOT NULL AUTO_INCREMENT,
  `token` varchar(255) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tokenId`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of token
-- ----------------------------
BEGIN;
INSERT INTO `token` VALUES (5, '18acc8e393ea0bf9761b72341f80465cdda43176', 'root');
INSERT INTO `token` VALUES (8, '3a0c462c30c8a39b624f0f7f21285688918cc6ad', 'root');
INSERT INTO `token` VALUES (9, '0ad26887c85f7c10f73fa5c574cb935b7dc05fd8', 'root');
INSERT INTO `token` VALUES (10, '5a3091caf611105c54685185de1cd0aa0bc6fc19', 'root');
INSERT INTO `token` VALUES (11, 'bf4e1b0023b149e3ee4cd080d40aadaa9d348e53', 'root');
INSERT INTO `token` VALUES (12, 'd285ace61f040137f18b9d9e295f96a5c7b8cc82', 'root');
INSERT INTO `token` VALUES (13, NULL, 'root');
INSERT INTO `token` VALUES (14, NULL, 'root');
INSERT INTO `token` VALUES (15, '18810d5dec79ad022b013dc96879145961485489', 'root');
INSERT INTO `token` VALUES (16, '7852efe15965db2574d41e4acc2108bfb45dee95', 'root');
INSERT INTO `token` VALUES (17, '145c938f90421cea9c6041eaf9eef54bc9146eeb', 'root');
INSERT INTO `token` VALUES (18, '342cc226f0b58b436195d8e8acf821861303409c', 'root');
INSERT INTO `token` VALUES (19, '8abe88c5255c7089378d66ad0453bc8bc8bf0ab9', 'root');
INSERT INTO `token` VALUES (20, '4e089b897bff8dbf73c78f64b069b0badc5ac93a', 'root');
INSERT INTO `token` VALUES (21, '8dfed932035c666e2e41f312134c82b6287ff3e9', 'root');
INSERT INTO `token` VALUES (22, NULL, 'root');
INSERT INTO `token` VALUES (23, '50bd0b7104b9a159d0e8ba458d6b58bf811e987b', 'root');
INSERT INTO `token` VALUES (24, 'e04af17b89c443848dc409012bb55f33237f1a86', 'root');
INSERT INTO `token` VALUES (25, 'd87b48aeb957b6e23fa63e24374d186db2f6021d', 'root');
INSERT INTO `token` VALUES (26, '007994ef4882a804bffa77b221cae38e3884feb4', 'root');
INSERT INTO `token` VALUES (27, '09ef7aa2eeb80459674813c1d247002423d1a482', 'root');
INSERT INTO `token` VALUES (28, '891ab801d11ac08cf7debc20dd714b4de912d3e1', 'root');
INSERT INTO `token` VALUES (29, '3f0e37276d48525624913cc5946e95820059a7df', 'root');
INSERT INTO `token` VALUES (30, '1150a10b51b630b0427ab771ebc0f0621246618d', 'root');
INSERT INTO `token` VALUES (31, NULL, NULL);
INSERT INTO `token` VALUES (32, NULL, 'root');
INSERT INTO `token` VALUES (33, '9eca860239bd773870854d9766f406812e2ffa59', 'root');
INSERT INTO `token` VALUES (34, 'd8306a9cae60ec31794f0ef520d35002d8b69dc6', 'MYlindaxia');
INSERT INTO `token` VALUES (35, '5a9e1280360c59bc717403f82eb4cf575274c7ab', 'MYlindaxia');
INSERT INTO `token` VALUES (36, 'd06ed12c4009c782c409c7ad2517ded95f98501d', 'root');
INSERT INTO `token` VALUES (37, '3e3ad41fdae2ee34675d2515a546f74cbf72767c', 'root');
INSERT INTO `token` VALUES (38, '0d098fdcfeb7d61f8c3bd54889a3bb0e23ae4be1', 'root');
INSERT INTO `token` VALUES (39, 'f8888328762a4da13da7d1f08ca5372e2e44e71c', 'root');
INSERT INTO `token` VALUES (40, 'ef05bdb5c67b64f5ebd155732610e5700f3ca479', 'root');
INSERT INTO `token` VALUES (41, 'ca3de06b8e75366580ecc30d02d6c3df8c29561e', 'root');
INSERT INTO `token` VALUES (42, '1684d0ac9aa9e79b7c020c7936db46d9af6361dc', 'MYlindaxia');
INSERT INTO `token` VALUES (43, '4cd93c87ca283ab8cb63834c3bc5e42516bcad1f', 'admin');
INSERT INTO `token` VALUES (44, '5d95013a765f2b55c386dfb7a6421675b94dfb3a', 'MYlindaxia');
INSERT INTO `token` VALUES (45, 'a31d9ab25c23241be92007a8264af5c4f5d5dc58', 'root');
INSERT INTO `token` VALUES (46, 'daa7989d82ec458d62ef96ea9985f04596922a35', 'admin');
INSERT INTO `token` VALUES (47, '4b7be0db93bbb92e0b370709271078df4277814f', 'MYlindaxia');
INSERT INTO `token` VALUES (48, '7a65c9a54be6e23280cfffe403be869cd42f80b8', 'root');
INSERT INTO `token` VALUES (49, '214cd79dcc5009638c2010a19700d6db7df44788', 'root');
INSERT INTO `token` VALUES (50, '0049656bbfee9c1bc77c32830b7d2a12df63c23a', 'root');
INSERT INTO `token` VALUES (51, '0a5e36f28e4214d738bc3fa585a7abb05ee73920', 'MYlindaxia');
INSERT INTO `token` VALUES (52, '126182f29048106264c6d8b343bea2f9791da4fd', 'admin');
INSERT INTO `token` VALUES (53, 'c071f19dc1e2fbdb85e1b31258aa6498ed2f23f8', 'root');
INSERT INTO `token` VALUES (54, '4a366a6bf0126132eb43a40f92f11b5743cda439', 'root');
INSERT INTO `token` VALUES (55, '38b52d553b1a26fde498dbd10cdf3678b7064790', 'MYlindaxia');
INSERT INTO `token` VALUES (56, 'c1c7aac99a4d4c5fd8ee933c48d319fa48fc7028', 'admin');
INSERT INTO `token` VALUES (57, '0fd3fc3b197ec7fdbe463544c5b63668295415d2', 'root');
INSERT INTO `token` VALUES (58, 'e5bb2d31e048441dce8d3911fbe9083f8a12a87d', 'root');
INSERT INTO `token` VALUES (59, '7b7386de6b8391960160aec08e9099fcd46b8f6e', 'root');
INSERT INTO `token` VALUES (60, '8d72f45a31869a7562828efea8585dddb6d74b80', 'root');
INSERT INTO `token` VALUES (61, '0bd5166bba04d70c4a326a59db5dde2665c23cc4', 'root');
INSERT INTO `token` VALUES (62, 'ef41137722bf5dac13c2d429306bebf86bc5fb88', 'root');
INSERT INTO `token` VALUES (63, '974db0bb3e34ae39755d45aaeb196e43f93c4e41', 'root');
INSERT INTO `token` VALUES (64, 'fc4be10f5a956643b8bfcc124edcfc66e0e4ace0', 'root');
INSERT INTO `token` VALUES (65, '26457b078bd333ef55dd345a3c67a378bbe5d6f8', 'root');
INSERT INTO `token` VALUES (66, '4f8f3abe2288e4159eb37d15f2c6611b07e33ae1', 'root');
INSERT INTO `token` VALUES (67, 'adf1742fdafd0582222aad45a3f68db1dedc43ab', 'root');
INSERT INTO `token` VALUES (68, 'e201f808e6d8bb6282a755a31f256e77bc585d81', 'root');
INSERT INTO `token` VALUES (69, '26af4570941aa6269f82b63c1e07febe26ee0708', 'root');
INSERT INTO `token` VALUES (70, '2ac339c99752f1fa4554c436cd082fc24e09f41a', 'root');
INSERT INTO `token` VALUES (71, '1e4a640639dc1361662248a94a115feb58673977', 'root');
INSERT INTO `token` VALUES (72, 'c096b2441f6917660e36efb5c79a59b989ce8948', 'root');
INSERT INTO `token` VALUES (73, 'c08c87e040ddfe179a17690ea0941c918287fc86', 'root');
INSERT INTO `token` VALUES (74, '52b0c8c04c92e44d3961d1670fd45f408df36492', 'root');
INSERT INTO `token` VALUES (75, 'f5435c3c57c26ee684ab19311a3bc82c4b012dad', 'root');
INSERT INTO `token` VALUES (76, '9a4fa5c599b422203a1acf43430bc98d47e7a164', 'root');
INSERT INTO `token` VALUES (77, 'bcb9871877e88770ae2e0d5efe0a92da0c4c122e', 'root');
INSERT INTO `token` VALUES (78, '345e391e55001c0966b2985e6879f60ca2025322', 'root');
INSERT INTO `token` VALUES (79, 'a2cf51b9f33ee2fc1843d9ac0859db6dd1f2c364', 'root');
INSERT INTO `token` VALUES (80, 'e2e86392e75c5fe056875ca849ae47b27bf2095e', 'root');
INSERT INTO `token` VALUES (81, 'e198cb5bf61d863d51d49605caf94083f5359d80', 'MYlindaxia');
INSERT INTO `token` VALUES (82, 'fa3c87fc1f15de1942d30dfb5739ebec3cae7d62', 'root');
INSERT INTO `token` VALUES (83, '31771a5266f418fc699476ba6654d8d5dec783c3', 'MYlindaxia');
INSERT INTO `token` VALUES (84, '8487a4824dfbff3509c4e97007d2bd73e21f6b63', 'root');
INSERT INTO `token` VALUES (85, '98a531abfb7b185572283d23e848bd53c12fe9b7', 'root');
INSERT INTO `token` VALUES (86, '8a03921705b963f4dd25479b1ed741ea4502d976', 'root');
INSERT INTO `token` VALUES (87, '8204138cae86b613cce35d72f9a7d01da81bd016', 'root');
INSERT INTO `token` VALUES (88, '02b2f1a3a3af7f258c72f193f279f5d2ea8755a8', 'root');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(10) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `userPwd` varchar(255) DEFAULT NULL,
  `userPower` int(10) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'root', 'root', 0);
INSERT INTO `user` VALUES (2, 'admin', 'admin', 1);
INSERT INTO `user` VALUES (3, 'MYlindaxia', 'root', 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
