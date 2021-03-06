-- --------------------------------------------------------
-- 主机:                           localhost
-- 服务器版本:                        10.6.5-MariaDB-1:10.6.5+maria~focal - mariadb.org binary distribution
-- 服务器操作系统:                      debian-linux-gnu
-- HeidiSQL 版本:                  11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 school_life 的数据库结构
CREATE DATABASE IF NOT EXISTS `school_life` /*!40100 DEFAULT CHARACTER SET utf8mb3 */;
USE `school_life`;

-- 导出  表 school_life.actionpower 结构
CREATE TABLE IF NOT EXISTS `actionpower` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'action编号',
  `name` varchar(256) NOT NULL COMMENT 'action名',
  `perm` varchar(256) NOT NULL COMMENT '权限',
  `create_gtm` datetime NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `update_gtm` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '修改时间',
  `is_deleted` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
  `is_locked` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否冻结',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 正在导出表  school_life.actionpower 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `actionpower` DISABLE KEYS */;
/*!40000 ALTER TABLE `actionpower` ENABLE KEYS */;

-- 导出  表 school_life.canteen 结构
CREATE TABLE IF NOT EXISTS `canteen` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(128) NOT NULL COMMENT '饭堂名',
  `pictures` text DEFAULT NULL COMMENT '饭堂图片',
  `location` varchar(128) NOT NULL COMMENT '饭堂地点',
  `open_time` varchar(128) NOT NULL COMMENT '营业时间',
  `create_gtm` datetime NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `update_gtm` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '修改时间',
  `is_deleted` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
  `is_locked` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否冻结',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1518653901995003907 DEFAULT CHARSET=utf8mb3;

-- 正在导出表  school_life.canteen 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `canteen` DISABLE KEYS */;
INSERT INTO `canteen` (`id`, `name`, `pictures`, `location`, `open_time`, `create_gtm`, `update_gtm`, `is_deleted`, `is_locked`) VALUES
	(1508518788654669826, '四饭', '["/school/20220509035153a.png"]', '第一饭堂后面', '08:00:00-22:30:00', '2022-03-28 18:58:00', '2022-03-29 08:13:53', 0, 0),
	(1508719353228591106, '一饭', NULL, '一区、四区、二区宿舍之间', '7:00-22:30', '2022-03-29 16:14:59', NULL, 0, 0);
/*!40000 ALTER TABLE `canteen` ENABLE KEYS */;

-- 导出  表 school_life.car 结构
CREATE TABLE IF NOT EXISTS `car` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `number` varchar(16) NOT NULL COMMENT '车牌号',
  `create_gtm` datetime NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `update_gtm` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '修改时间',
  `is_deleted` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
  `is_locked` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否冻结',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1523558891867893763 DEFAULT CHARSET=utf8mb3;

-- 正在导出表  school_life.car 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` (`id`, `number`, `create_gtm`, `update_gtm`, `is_deleted`, `is_locked`) VALUES
	(1509543928354983937, '粤A88888', '2022-03-31 14:51:33', '2022-03-31 22:51:48', 0, 0),
	(1523558891867893762, '粤K23138', '2022-05-09 15:02:00', NULL, 0, 0);
/*!40000 ALTER TABLE `car` ENABLE KEYS */;

-- 导出  表 school_life.class_room 结构
CREATE TABLE IF NOT EXISTS `class_room` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(16) NOT NULL COMMENT '教室号',
  `location` varchar(128) NOT NULL COMMENT '所在楼',
  `school` tinyint(4) DEFAULT 0 COMMENT '所属校区：0-官渡校区 1-西城校区 2-光华校区',
  `state` tinyint(1) DEFAULT 0 COMMENT '教室状态 1-已占用  0-空闲',
  `create_gtm` datetime NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `update_gtm` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '修改时间',
  `is_deleted` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
  `is_locked` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否冻结',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1518705840753602563 DEFAULT CHARSET=utf8mb3;

-- 正在导出表  school_life.class_room 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `class_room` DISABLE KEYS */;
INSERT INTO `class_room` (`id`, `code`, `location`, `school`, `state`, `create_gtm`, `update_gtm`, `is_deleted`, `is_locked`) VALUES
	(1, '201', '二教A', 0, 0, '2022-04-15 20:33:25', '2022-04-15 20:36:37', 0, 0),
	(2, '东201', '主教', 0, 0, '2022-04-15 20:33:25', NULL, 0, 0),
	(3, '301', '二教A', 0, 0, '2022-04-15 20:33:25', '2022-04-15 20:36:43', 0, 0),
	(4, '301', '二教B', 0, 0, '2022-04-15 20:33:25', '2022-04-15 20:36:47', 0, 0),
	(1516659265202028545, '129', '712', 0, 0, '2022-04-20 14:05:21', NULL, 0, 0),
	(1516659279403941890, '129', '712', 0, 0, '2022-04-20 14:05:25', '2022-04-26 05:39:32', 0, 0);
/*!40000 ALTER TABLE `class_room` ENABLE KEYS */;

-- 导出  表 school_life.delivery_order 结构
CREATE TABLE IF NOT EXISTS `delivery_order` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(128) NOT NULL COMMENT '商品名',
  `school` tinyint(4) DEFAULT 0 COMMENT '所属校区：0-官渡校区 1-西城校区 2-光华校区',
  `price` varchar(16) NOT NULL COMMENT '价格',
  `commission` varchar(128) NOT NULL COMMENT '佣金',
  `tag` varchar(128) DEFAULT NULL COMMENT '备注',
  `address` text DEFAULT NULL COMMENT '特定购买地点',
  `user_phone` varchar(16) NOT NULL COMMENT '用户电话',
  `server_phone` varchar(16) DEFAULT NULL COMMENT '骑手电话',
  `state` tinyint(4) DEFAULT 0 COMMENT '订单状态 2-已送达 1-配送中  0-取货中',
  `user_id` bigint(20) unsigned NOT NULL COMMENT '订单创建人ID',
  `server_id` bigint(20) unsigned DEFAULT NULL COMMENT '订单骑手ID',
  `create_gtm` datetime NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `update_gtm` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '修改时间',
  `is_deleted` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
  `is_locked` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否冻结',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `server_id` (`server_id`),
  CONSTRAINT `delivery_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `delivery_order_ibfk_2` FOREIGN KEY (`server_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1518675593978990594 DEFAULT CHARSET=utf8mb3;

-- 正在导出表  school_life.delivery_order 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `delivery_order` DISABLE KEYS */;
INSERT INTO `delivery_order` (`id`, `name`, `school`, `price`, `commission`, `tag`, `address`, `user_phone`, `server_phone`, `state`, `user_id`, `server_id`, `create_gtm`, `update_gtm`, `is_deleted`, `is_locked`) VALUES
	(1514801100235816961, '可比克薯片', 0, '3', '0.5', '尽快送达', '4D407', '13541313123', NULL, 1, 4, 1, '2022-04-15 11:01:40', '2022-04-26 03:56:38', 0, 0),
	(1518675593978990593, '测试物品', 0, '20', '2', '测试备注', '广油', '13172726161', NULL, 0, 4, 1, '2022-04-26 03:37:31', '2022-04-26 03:56:47', 0, 0);
/*!40000 ALTER TABLE `delivery_order` ENABLE KEYS */;

-- 导出  表 school_life.dormitory 结构
CREATE TABLE IF NOT EXISTS `dormitory` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '宿舍编号',
  `name` varchar(256) NOT NULL COMMENT '宿舍牌号',
  `location` varchar(128) NOT NULL COMMENT '宿舍所属栋',
  `create_gtm` datetime NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `update_gtm` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '修改时间',
  `is_deleted` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
  `is_locked` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否冻结',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1518670405545287682 DEFAULT CHARSET=utf8mb3;

-- 正在导出表  school_life.dormitory 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `dormitory` DISABLE KEYS */;
INSERT INTO `dormitory` (`id`, `name`, `location`, `create_gtm`, `update_gtm`, `is_deleted`, `is_locked`) VALUES
	(1509460004035612674, '407', '4D', '2022-03-31 17:18:04', NULL, 0, 0),
	(1509460046163202050, '408', '4D', '2022-03-31 17:18:14', NULL, 0, 0);
/*!40000 ALTER TABLE `dormitory` ENABLE KEYS */;

-- 导出  表 school_life.dormitory_user 结构
CREATE TABLE IF NOT EXISTS `dormitory_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(20) unsigned NOT NULL COMMENT '住宿人ID',
  `dormitory_id` bigint(20) unsigned NOT NULL COMMENT '宿舍ID',
  `create_gtm` datetime NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `update_gtm` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '修改时间',
  `is_deleted` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
  `is_locked` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否冻结',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `dormitory_id` (`dormitory_id`),
  CONSTRAINT `dormitory_user_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `dormitory_user_ibfk_2` FOREIGN KEY (`dormitory_id`) REFERENCES `dormitory` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1515222692539654146 DEFAULT CHARSET=utf8mb3;

-- 正在导出表  school_life.dormitory_user 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `dormitory_user` DISABLE KEYS */;
INSERT INTO `dormitory_user` (`id`, `user_id`, `dormitory_id`, `create_gtm`, `update_gtm`, `is_deleted`, `is_locked`) VALUES
	(1515222692539654145, 1, 1509460004035612674, '2022-04-16 14:56:56', NULL, 0, 0);
/*!40000 ALTER TABLE `dormitory_user` ENABLE KEYS */;

-- 导出  表 school_life.food 结构
CREATE TABLE IF NOT EXISTS `food` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(128) NOT NULL COMMENT '食物名',
  `type` tinyint(4) DEFAULT 0 COMMENT '食物类型：0-早餐 1-午餐 2-晚餐 3-宵夜',
  `price` varchar(16) DEFAULT NULL COMMENT '价格',
  `pictures` text DEFAULT NULL COMMENT '食物图片',
  `offer_date` date NOT NULL COMMENT '提供日期',
  `canteen_id` bigint(20) unsigned NOT NULL COMMENT '饭堂ID',
  `create_gtm` datetime NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `update_gtm` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '修改时间',
  `is_deleted` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
  `is_locked` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否冻结',
  PRIMARY KEY (`id`),
  KEY `canteen_id` (`canteen_id`),
  CONSTRAINT `food_ibfk_1` FOREIGN KEY (`canteen_id`) REFERENCES `canteen` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1518661516867162115 DEFAULT CHARSET=utf8mb3;

-- 正在导出表  school_life.food 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
INSERT INTO `food` (`id`, `name`, `type`, `price`, `pictures`, `offer_date`, `canteen_id`, `create_gtm`, `update_gtm`, `is_deleted`, `is_locked`) VALUES
	(1509470895959334913, '煎酿茄子', 0, '3.2', '["/school/20220509041402a.png"]', '2022-04-15', 1508719353228591106, '2022-03-30 18:01:20', '2022-04-25 19:47:16', 0, 0),
	(1509490991234703362, '梅菜肉饼', 0, '4.5', '["/school/20220509041429b.png"]', '2022-04-15', 1508518788654669826, '2022-03-31 11:21:11', '2022-04-14 17:51:12', 0, 0),
	(1518661516867162114, '梅菜肉饼', 0, '4.5', '["/school/20220509041534c.png"]', '2022-04-26', 1508518788654669826, '2022-03-31 03:21:11', '2022-04-25 11:48:48', 0, 0);
/*!40000 ALTER TABLE `food` ENABLE KEYS */;

-- 导出  表 school_life.goods 结构
CREATE TABLE IF NOT EXISTS `goods` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '闲置物品编号',
  `name` varchar(256) NOT NULL COMMENT '闲置物品名',
  `type` varchar(128) NOT NULL COMMENT '闲置物品种类',
  `info` text NOT NULL COMMENT '物品信息---富文本',
  `price` varchar(16) NOT NULL COMMENT '价格',
  `pictures` varchar(128) NOT NULL COMMENT 'JSON格式的图片地址数组',
  `phone` varchar(16) NOT NULL COMMENT '手机号',
  `wechat_id` varchar(128) NOT NULL COMMENT '微信号',
  `user_id` bigint(20) unsigned NOT NULL COMMENT '发布人ID',
  `buyer_id` bigint(20) unsigned DEFAULT NULL COMMENT '购买人ID',
  `audit_state` tinyint(4) DEFAULT 0 COMMENT '物品审核状态 2-未过审 1-已过审  0-待审核',
  `state` tinyint(1) DEFAULT 0 COMMENT '物品状态 1-已出售  0-未出售',
  `create_gtm` datetime NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `update_gtm` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '修改时间',
  `is_deleted` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
  `is_locked` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否冻结',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `buyer_id` (`buyer_id`),
  CONSTRAINT `goods_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `goods_ibfk_2` FOREIGN KEY (`buyer_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1518690673193992195 DEFAULT CHARSET=utf8mb3;

-- 正在导出表  school_life.goods 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` (`id`, `name`, `type`, `info`, `price`, `pictures`, `phone`, `wechat_id`, `user_id`, `buyer_id`, `audit_state`, `state`, `create_gtm`, `update_gtm`, `is_deleted`, `is_locked`) VALUES
	(1518690673193992194, '测试商品', '测试类型', '测试介绍', '100', '["/school/20220509043249a.png","/school/20220509043254b.png"]', '1235313131', 'ce513521', 1, NULL, 0, 0, '2022-04-25 20:37:27', '2022-05-09 16:32:56', 0, 0);
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;

-- 导出  表 school_life.note 结构
CREATE TABLE IF NOT EXISTS `note` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '个人动态内容编号',
  `content` text NOT NULL COMMENT '内容',
  `user_id` bigint(20) unsigned NOT NULL COMMENT '创建人ID',
  `state` tinyint(1) DEFAULT 0 COMMENT '状态 1-可见  0-不可见',
  `create_gtm` datetime NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `update_gtm` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '修改时间',
  `is_deleted` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
  `is_locked` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否冻结',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `note_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1518710019001753603 DEFAULT CHARSET=utf8mb3;

-- 正在导出表  school_life.note 的数据：~9 rows (大约)
/*!40000 ALTER TABLE `note` DISABLE KEYS */;
INSERT INTO `note` (`id`, `content`, `user_id`, `state`, `create_gtm`, `update_gtm`, `is_deleted`, `is_locked`) VALUES
	(1508762212598214658, '今天心情不错', 1, 1, '2022-03-29 11:05:17', '2022-03-31 23:34:45', 0, 0),
	(1514180760749371393, '测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1', 1, 0, '2022-04-13 17:56:40', NULL, 0, 0),
	(1514180773386809345, '测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1', 1, 0, '2022-04-13 17:56:43', NULL, 0, 0),
	(1514180877938225153, '测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1', 1, 0, '2022-04-13 17:57:08', NULL, 0, 0),
	(1514180888377847809, '测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1', 1, 0, '2022-04-13 17:57:10', NULL, 0, 0),
	(1514180940273971201, '测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1测试动态1', 1, 0, '2022-04-13 17:57:22', NULL, 0, 0),
	(1514186064774004737, '测试测试内容', 1, 0, '2022-04-13 18:17:44', NULL, 0, 0),
	(1514186287642542081, '测试测试测试测试', 1, 0, '2022-04-13 18:18:37', NULL, 0, 0),
	(1518710019001753602, '测试内容测试内容', 1, 0, '2022-04-26 05:54:19', NULL, 0, 0);
/*!40000 ALTER TABLE `note` ENABLE KEYS */;

-- 导出  表 school_life.parking 结构
CREATE TABLE IF NOT EXISTS `parking` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(128) NOT NULL COMMENT '车位号',
  `state` tinyint(1) DEFAULT 0 COMMENT '车位状态 1-已占用  0-空闲',
  `create_gtm` datetime NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `update_gtm` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '修改时间',
  `is_deleted` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
  `is_locked` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否冻结',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1518714121978994690 DEFAULT CHARSET=utf8mb3;

-- 正在导出表  school_life.parking 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `parking` DISABLE KEYS */;
INSERT INTO `parking` (`id`, `code`, `state`, `create_gtm`, `update_gtm`, `is_deleted`, `is_locked`) VALUES
	(1509514511272546306, '4D1', 1, '2022-03-31 20:54:39', '2022-05-09 15:43:10', 0, 0),
	(1509514539084976129, '4D2', 0, '2022-03-31 20:54:46', '2022-03-31 22:23:43', 0, 0);
/*!40000 ALTER TABLE `parking` ENABLE KEYS */;

-- 导出  表 school_life.parking_order 结构
CREATE TABLE IF NOT EXISTS `parking_order` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parking_id` bigint(20) unsigned NOT NULL COMMENT '车位ID',
  `car_id` bigint(20) unsigned DEFAULT NULL COMMENT '车辆ID',
  `create_gtm` datetime NOT NULL DEFAULT current_timestamp() COMMENT '入场时间',
  `update_gtm` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '修改时间',
  `is_deleted` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
  `is_locked` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否冻结',
  PRIMARY KEY (`id`),
  KEY `parking_id` (`parking_id`),
  KEY `car_id` (`car_id`),
  CONSTRAINT `parking_order_ibfk_1` FOREIGN KEY (`parking_id`) REFERENCES `parking` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `parking_order_ibfk_2` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1523569249005461507 DEFAULT CHARSET=utf8mb3;

-- 正在导出表  school_life.parking_order 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `parking_order` DISABLE KEYS */;
INSERT INTO `parking_order` (`id`, `parking_id`, `car_id`, `create_gtm`, `update_gtm`, `is_deleted`, `is_locked`) VALUES
	(1523569249005461506, 1509514511272546306, 1523558891867893762, '2022-05-09 15:43:10', NULL, 0, 0);
/*!40000 ALTER TABLE `parking_order` ENABLE KEYS */;

-- 导出  表 school_life.permissions 结构
CREATE TABLE IF NOT EXISTS `permissions` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '权限编号',
  `name` varchar(256) NOT NULL COMMENT '权限名',
  `parent` bigint(20) unsigned DEFAULT NULL COMMENT '父级权限',
  `perms` varchar(256) NOT NULL COMMENT '权限标识',
  `create_gtm` datetime NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `update_gtm` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '修改时间',
  `is_deleted` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
  `is_locked` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否冻结',
  PRIMARY KEY (`id`),
  KEY `parent` (`parent`),
  CONSTRAINT `permissions_ibfk_1` FOREIGN KEY (`parent`) REFERENCES `permissions` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 正在导出表  school_life.permissions 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `permissions` DISABLE KEYS */;
/*!40000 ALTER TABLE `permissions` ENABLE KEYS */;

-- 导出  表 school_life.role 结构
CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `name` varchar(256) NOT NULL COMMENT '角色名',
  `create_gtm` datetime NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `update_gtm` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '修改时间',
  `is_deleted` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
  `is_locked` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否冻结',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1509763123856490498 DEFAULT CHARSET=utf8mb3;

-- 正在导出表  school_life.role 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `name`, `create_gtm`, `update_gtm`, `is_deleted`, `is_locked`) VALUES
	(1, 'admin', '2022-03-28 17:37:20', NULL, 0, 0),
	(2, 'editor', '2022-03-28 17:37:27', NULL, 0, 0),
	(1509763123856490497, 'customer', '2022-04-01 13:22:33', NULL, 0, 0);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- 导出  表 school_life.rolepermissionmap 结构
CREATE TABLE IF NOT EXISTS `rolepermissionmap` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `roleid` bigint(20) unsigned NOT NULL COMMENT '角色ID',
  `permissionid` bigint(20) unsigned NOT NULL COMMENT '权限ID',
  `create_gtm` datetime NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `update_gtm` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '修改时间',
  `is_deleted` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
  `is_locked` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否冻结',
  PRIMARY KEY (`id`),
  KEY `roleid` (`roleid`),
  KEY `permissionid` (`permissionid`),
  CONSTRAINT `rolepermissionmap_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `rolepermissionmap_ibfk_2` FOREIGN KEY (`permissionid`) REFERENCES `permissions` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 正在导出表  school_life.rolepermissionmap 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `rolepermissionmap` DISABLE KEYS */;
/*!40000 ALTER TABLE `rolepermissionmap` ENABLE KEYS */;

-- 导出  表 school_life.seat 结构
CREATE TABLE IF NOT EXISTS `seat` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` varchar(16) NOT NULL COMMENT '座位号',
  `location` varchar(128) NOT NULL COMMENT '所在教室',
  `school` tinyint(4) DEFAULT 0 COMMENT '所属校区：0-官渡校区 1-西城校区 2-光华校区',
  `state` tinyint(1) DEFAULT 0 COMMENT '座位状态 1-已占用  0-空闲',
  `create_gtm` datetime NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `update_gtm` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '修改时间',
  `is_deleted` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
  `is_locked` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否冻结',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1518706548919889922 DEFAULT CHARSET=utf8mb3;

-- 正在导出表  school_life.seat 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
INSERT INTO `seat` (`id`, `code`, `location`, `school`, `state`, `create_gtm`, `update_gtm`, `is_deleted`, `is_locked`) VALUES
	(1509544335240220673, '012', '612', 0, 0, '2022-03-31 22:53:10', '2022-05-09 17:01:15', 0, 0),
	(1509544382153510914, '001', '612', 0, 0, '2022-03-31 22:53:21', '2022-04-15 22:49:16', 0, 0),
	(1509544382153510915, '002', '612', 0, 0, '2022-03-31 22:53:21', '2022-04-15 13:47:48', 0, 0),
	(1509544382153510916, '003', '612', 0, 0, '2022-03-31 22:53:21', '2022-04-26 05:49:49', 0, 0),
	(1509544382153510917, '001', '611', 0, 0, '2022-03-31 22:53:21', NULL, 0, 0);
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;

-- 导出  表 school_life.seat_order 结构
CREATE TABLE IF NOT EXISTS `seat_order` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(20) unsigned NOT NULL COMMENT '使用人ID',
  `state` tinyint(4) DEFAULT 0 COMMENT '0-正在使用 1-已结束使用',
  `seat_id` bigint(20) unsigned NOT NULL COMMENT '座位ID',
  `use_time` varchar(16) NOT NULL COMMENT '使用时长',
  `create_gtm` datetime NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `update_gtm` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '修改时间',
  `is_deleted` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
  `is_locked` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否冻结',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `seat_id` (`seat_id`),
  CONSTRAINT `seat_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `seat_order_ibfk_2` FOREIGN KEY (`seat_id`) REFERENCES `seat` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1518708603118022659 DEFAULT CHARSET=utf8mb3;

-- 正在导出表  school_life.seat_order 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `seat_order` DISABLE KEYS */;
INSERT INTO `seat_order` (`id`, `user_id`, `state`, `seat_id`, `use_time`, `create_gtm`, `update_gtm`, `is_deleted`, `is_locked`) VALUES
	(1514845818504142849, 1, 1, 1509544335240220673, '2', '2022-04-14 21:59:22', '2022-05-09 01:00:43', 0, 0),
	(1514845998922129410, 1, 1, 1509544382153510916, '3', '2022-04-15 14:00:05', '2022-05-09 17:00:43', 0, 0),
	(1514973177731387393, 1, 1, 1509544382153510914, '2', '2022-04-15 22:25:27', '2022-05-09 17:00:45', 0, 0),
	(1514979652398850050, 1, 1, 1509544335240220673, '2', '2022-04-15 22:51:10', '2022-05-09 17:00:47', 0, 0),
	(1518708603118022658, 1, 1, 1509544382153510916, '2', '2022-04-26 05:48:41', '2022-05-09 17:00:48', 0, 0);
/*!40000 ALTER TABLE `seat_order` ENABLE KEYS */;

-- 导出  表 school_life.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `avatar_url` varchar(256) DEFAULT NULL COMMENT '头像',
  `name` varchar(256) NOT NULL COMMENT '用户名',
  `type` int(11) NOT NULL DEFAULT 0 COMMENT '用户类型',
  `account` varchar(256) NOT NULL COMMENT '登录账号',
  `password` text NOT NULL COMMENT '密码',
  `number` text DEFAULT NULL COMMENT '学号',
  `gender` tinyint(1) NOT NULL DEFAULT 0 COMMENT '性别：0:未知,1:女,2:男',
  `phone` varchar(15) DEFAULT NULL COMMENT '手机号码',
  `session_key` varchar(256) DEFAULT NULL COMMENT '会话密钥',
  `salt` varchar(64) DEFAULT NULL COMMENT '盐值',
  `state` tinyint(1) DEFAULT 1 COMMENT '账号状态 1是正常 0是禁用',
  `car_id` varchar(20) DEFAULT NULL COMMENT '车辆ID',
  `car_picture` text DEFAULT NULL COMMENT '车辆照片',
  `create_gtm` datetime NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `update_gtm` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '修改时间',
  `is_deleted` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
  `is_locked` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否冻结',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;

-- 正在导出表  school_life.user 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `avatar_url`, `name`, `type`, `account`, `password`, `number`, `gender`, `phone`, `session_key`, `salt`, `state`, `car_id`, `car_picture`, `create_gtm`, `update_gtm`, `is_deleted`, `is_locked`) VALUES
	(1, '/school/20220509013605a.png', '10000', 1, '10000', 'e097c81d6fc0a8d8ffbdded971da103e402ae2089b20aaaad380212af160cf02', NULL, 1, '13172726161', NULL, 'y9yKaSm6xZfz0jxVQwkE', 1, '1509543928354983937', NULL, '2022-03-28 17:30:11', '2022-05-09 13:36:13', 0, 0),
	(4, '/school/20220509013648wechat.png', '测试', 1, '10002', 'f0d59803393cfd844226e78151c766d022afba629d1a532b1ef06f6349eccf9f', NULL, 1, '测试', NULL, '0MYjvEfiBvxA3iIButqH', 1, NULL, NULL, '2022-04-26 00:58:38', '2022-05-09 13:55:59', 0, 0),
	(5, '/school/20220509013703b.png', '测试添加', 1, '10004', 'f21f1b47f20ba66456f04db3ebcc0fc9aadd11e7ab1a2e1d04615a880a145796', NULL, 1, '测试', NULL, 'wQNW239VggRZGET1NzUF', 1, NULL, NULL, '2022-04-26 01:11:09', '2022-05-09 13:37:12', 0, 0),
	(11, '/school/f6752ea1-838f-4161-bff4-2b1e749f0b71.jpg', 'M&W', 0, 'ocOE75IBFASjAoZR_ciAzpTaMVuU', '1b9b69ef1dcba94676410be3ae69300fa0e8b9aad84d409b6e88758df1a0ad73', NULL, 1, NULL, NULL, '7EX6yDQ7deEWzmqjzs3k', 1, NULL, NULL, '2022-05-07 12:51:47', '2022-05-09 13:37:54', 0, 0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- 导出  表 school_life.userrolemap 结构
CREATE TABLE IF NOT EXISTS `userrolemap` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户角色编号',
  `userid` bigint(20) unsigned NOT NULL COMMENT '用户ID',
  `roleid` bigint(20) unsigned NOT NULL COMMENT '角色ID',
  `create_gtm` datetime NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `update_gtm` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '修改时间',
  `is_deleted` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
  `is_locked` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否冻结',
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  KEY `roleid` (`roleid`),
  CONSTRAINT `userrolemap_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `userrolemap_ibfk_2` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- 正在导出表  school_life.userrolemap 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `userrolemap` DISABLE KEYS */;
INSERT INTO `userrolemap` (`id`, `userid`, `roleid`, `create_gtm`, `update_gtm`, `is_deleted`, `is_locked`) VALUES
	(1, 1, 1, '2022-03-28 17:37:40', NULL, 0, 0);
/*!40000 ALTER TABLE `userrolemap` ENABLE KEYS */;

-- 导出  表 school_life.vindicate 结构
CREATE TABLE IF NOT EXISTS `vindicate` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '表白内容编号',
  `content` text NOT NULL COMMENT '内容',
  `receiver` varchar(128) NOT NULL COMMENT '收信人',
  `writer` varchar(128) NOT NULL COMMENT '收信人',
  `user_id` bigint(20) unsigned NOT NULL COMMENT '创建人ID',
  `state` tinyint(1) DEFAULT 0 COMMENT '状态 1-可见  0-不可见',
  `create_gtm` datetime NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `update_gtm` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '修改时间',
  `is_deleted` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
  `is_locked` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '是否冻结',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `vindicate_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1518712225331486723 DEFAULT CHARSET=utf8mb3;

-- 正在导出表  school_life.vindicate 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `vindicate` DISABLE KEYS */;
INSERT INTO `vindicate` (`id`, `content`, `receiver`, `writer`, `user_id`, `state`, `create_gtm`, `update_gtm`, `is_deleted`, `is_locked`) VALUES
	(1509556982996152321, '宝宝，我喜欢你', 'receiver', 'writer', 1, 1, '2022-03-31 15:43:25', '2022-04-13 18:42:18', 0, 0),
	(1514195629359972353, 'Google翻译是一项由Google于2006年开始提供的翻译文段及网页的服务。与其他网站巴别鱼、美国在线及雅虎使用的SYSTRAN引擎不同的是，Google使用自己开发的翻译软件。至2015年6月，Google翻译称每天需要处理超过1000亿笔字词', 'XXX', '匿名者', 1, 0, '2022-04-13 18:55:45', NULL, 0, 0),
	(1518712225331486722, '测试表白内容，测试', '测试表白对象', '匿名者', 1, 0, '2022-04-26 06:03:05', NULL, 0, 0);
/*!40000 ALTER TABLE `vindicate` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
