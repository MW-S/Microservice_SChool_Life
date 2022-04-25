-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: school_life
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `school_life`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `school_life` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `school_life`;

--
-- Table structure for table `actionpower`
--

DROP TABLE IF EXISTS `actionpower`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actionpower` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'action缂栧彿',
  `name` varchar(256) NOT NULL COMMENT 'action鍚?,
  `perm` varchar(256) NOT NULL COMMENT '鏉冮檺',
  `create_gtm` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '鍒涘缓鏃堕棿',
  `update_gtm` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '淇敼鏃堕棿',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍒犻櫎',
  `is_locked` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍐荤粨',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actionpower`
--

LOCK TABLES `actionpower` WRITE;
/*!40000 ALTER TABLE `actionpower` DISABLE KEYS */;
/*!40000 ALTER TABLE `actionpower` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `canteen`
--

DROP TABLE IF EXISTS `canteen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `canteen` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '缂栧彿',
  `name` varchar(128) NOT NULL COMMENT '楗爞鍚?,
  `pictures` text COMMENT '楗爞鍥剧墖',
  `location` varchar(128) NOT NULL COMMENT '楗爞鍦扮偣',
  `open_time` varchar(128) NOT NULL COMMENT '钀ヤ笟鏃堕棿',
  `create_gtm` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '鍒涘缓鏃堕棿',
  `update_gtm` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '淇敼鏃堕棿',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍒犻櫎',
  `is_locked` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍐荤粨',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1508719353228591107 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `canteen`
--

LOCK TABLES `canteen` WRITE;
/*!40000 ALTER TABLE `canteen` DISABLE KEYS */;
INSERT INTO `canteen` VALUES (1508518788654669826,'鍥涢キ',NULL,'绗竴楗爞鍚庨潰','8:00-22:00','2022-03-29 02:58:00','2022-03-29 16:13:53',0,0),(1508719353228591106,'涓€楗?,NULL,'涓€鍖恒€佸洓鍖恒€佷簩鍖哄鑸嶄箣闂?,'7:00-22:30','2022-03-29 16:14:59',NULL,0,0);
/*!40000 ALTER TABLE `canteen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '缂栧彿',
  `number` varchar(16) NOT NULL COMMENT '杞︾墝鍙?,
  `create_gtm` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '鍒涘缓鏃堕棿',
  `update_gtm` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '淇敼鏃堕棿',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍒犻櫎',
  `is_locked` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍐荤粨',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1509543928354983938 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES (1509369384998674434,'绮23138','2022-03-30 11:17:58','2022-03-31 05:49:02',0,0),(1509543928354983937,'绮88888','2022-03-31 14:51:33','2022-03-31 22:51:48',0,0);
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_room`
--

DROP TABLE IF EXISTS `class_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_room` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '缂栧彿',
  `code` varchar(16) NOT NULL COMMENT '鏁欏鍙?,
  `location` varchar(128) NOT NULL COMMENT '鎵€鍦ㄦゼ',
  `school` tinyint DEFAULT '0' COMMENT '鎵€灞炴牎鍖猴細0-瀹樻浮鏍″尯 1-瑗垮煄鏍″尯 2-鍏夊崕鏍″尯',
  `state` tinyint(1) DEFAULT '0' COMMENT '鏁欏鐘舵€?1-宸插崰鐢? 0-绌洪棽',
  `create_gtm` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '鍒涘缓鏃堕棿',
  `update_gtm` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '淇敼鏃堕棿',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍒犻櫎',
  `is_locked` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍐荤粨',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1516659279403941891 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_room`
--

LOCK TABLES `class_room` WRITE;
/*!40000 ALTER TABLE `class_room` DISABLE KEYS */;
INSERT INTO `class_room` VALUES (1,'201','浜屾暀A',0,0,'2022-04-15 20:33:25','2022-04-15 20:36:37',0,0),(2,'涓?01','涓绘暀',0,0,'2022-04-15 20:33:25',NULL,0,0),(3,'301','浜屾暀A',0,0,'2022-04-15 20:33:25','2022-04-15 20:36:43',0,0),(4,'301','浜屾暀B',0,0,'2022-04-15 20:33:25','2022-04-15 20:36:47',0,0),(1516659265202028545,'129','712',0,0,'2022-04-20 14:05:21',NULL,0,0),(1516659279403941890,'129','712',0,0,'2022-04-20 14:05:25',NULL,0,0);
/*!40000 ALTER TABLE `class_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_order`
--

DROP TABLE IF EXISTS `delivery_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_order` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '缂栧彿',
  `name` varchar(128) NOT NULL COMMENT '鍟嗗搧鍚?,
  `school` tinyint DEFAULT '0' COMMENT '鎵€灞炴牎鍖猴細0-瀹樻浮鏍″尯 1-瑗垮煄鏍″尯 2-鍏夊崕鏍″尯',
  `price` varchar(16) NOT NULL COMMENT '浠锋牸',
  `commission` varchar(128) NOT NULL COMMENT '浣ｉ噾',
  `tag` varchar(128) DEFAULT NULL COMMENT '澶囨敞',
  `address` text COMMENT '鐗瑰畾璐拱鍦扮偣',
  `user_phone` varchar(16) NOT NULL COMMENT '鐢ㄦ埛鐢佃瘽',
  `server_phone` varchar(16) DEFAULT NULL COMMENT '楠戞墜鐢佃瘽',
  `state` tinyint DEFAULT '0' COMMENT '璁㈠崟鐘舵€?2-宸查€佽揪 1-閰嶉€佷腑  0-鍙栬揣涓?,
  `user_id` bigint unsigned NOT NULL COMMENT '璁㈠崟鍒涘缓浜篒D',
  `server_id` bigint unsigned DEFAULT NULL COMMENT '璁㈠崟楠戞墜ID',
  `create_gtm` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '鍒涘缓鏃堕棿',
  `update_gtm` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '淇敼鏃堕棿',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍒犻櫎',
  `is_locked` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍐荤粨',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `server_id` (`server_id`),
  CONSTRAINT `delivery_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `delivery_order_ibfk_2` FOREIGN KEY (`server_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1514801100235816962 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_order`
--

LOCK TABLES `delivery_order` WRITE;
/*!40000 ALTER TABLE `delivery_order` DISABLE KEYS */;
INSERT INTO `delivery_order` VALUES (1509567480546340865,'涓摱鎬″疂鐭挎硥姘?,0,'2鍏?,'0.5鍏?,'鍙婃椂閫佽揪','澶╁爞','13172726161',NULL,0,1,1,'2022-04-01 00:25:08','2022-04-15 11:04:41',0,0),(1514801051695136770,'鍙瘮鍏嬭柉鐗?,0,'3','0.5','灏藉揩閫佽揪','4D407','13541313123',NULL,1,1,1,'2022-04-15 11:01:29','2022-04-15 11:05:33',0,0),(1514801100235816961,'鍙瘮鍏嬭柉鐗?,0,'3','0.5','灏藉揩閫佽揪','4D407','13541313123',NULL,0,1,NULL,'2022-04-15 11:01:40',NULL,0,0);
/*!40000 ALTER TABLE `delivery_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dormitory`
--

DROP TABLE IF EXISTS `dormitory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dormitory` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '瀹胯垗缂栧彿',
  `name` varchar(256) NOT NULL COMMENT '瀹胯垗鐗屽彿',
  `location` varchar(128) NOT NULL COMMENT '瀹胯垗鎵€灞炴爧',
  `create_gtm` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '鍒涘缓鏃堕棿',
  `update_gtm` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '淇敼鏃堕棿',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍒犻櫎',
  `is_locked` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍐荤粨',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1509460046163202051 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dormitory`
--

LOCK TABLES `dormitory` WRITE;
/*!40000 ALTER TABLE `dormitory` DISABLE KEYS */;
INSERT INTO `dormitory` VALUES (1509460004035612674,'407','4D','2022-03-31 17:18:04',NULL,0,0),(1509460046163202050,'408','4D','2022-03-31 17:18:14',NULL,0,0);
/*!40000 ALTER TABLE `dormitory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dormitory_user`
--

DROP TABLE IF EXISTS `dormitory_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dormitory_user` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '缂栧彿',
  `user_id` bigint unsigned NOT NULL COMMENT '浣忓浜篒D',
  `dormitory_id` bigint unsigned NOT NULL COMMENT '瀹胯垗ID',
  `create_gtm` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '鍒涘缓鏃堕棿',
  `update_gtm` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '淇敼鏃堕棿',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍒犻櫎',
  `is_locked` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍐荤粨',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `dormitory_id` (`dormitory_id`),
  CONSTRAINT `dormitory_user_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `dormitory_user_ibfk_2` FOREIGN KEY (`dormitory_id`) REFERENCES `dormitory` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1515222692539654146 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dormitory_user`
--

LOCK TABLES `dormitory_user` WRITE;
/*!40000 ALTER TABLE `dormitory_user` DISABLE KEYS */;
INSERT INTO `dormitory_user` VALUES (1515222692539654145,1,1509460004035612674,'2022-04-16 14:56:56',NULL,0,0);
/*!40000 ALTER TABLE `dormitory_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '缂栧彿',
  `name` varchar(128) NOT NULL COMMENT '椋熺墿鍚?,
  `type` tinyint DEFAULT '0' COMMENT '椋熺墿绫诲瀷锛?-鏃╅ 1-鍗堥 2-鏅氶 3-瀹靛',
  `price` varchar(16) DEFAULT NULL COMMENT '浠锋牸',
  `pictures` text COMMENT '椋熺墿鍥剧墖',
  `offer_date` date NOT NULL COMMENT '鎻愪緵鏃ユ湡',
  `canteen_id` bigint unsigned NOT NULL COMMENT '楗爞ID',
  `create_gtm` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '鍒涘缓鏃堕棿',
  `update_gtm` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '淇敼鏃堕棿',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍒犻櫎',
  `is_locked` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍐荤粨',
  PRIMARY KEY (`id`),
  KEY `canteen_id` (`canteen_id`),
  CONSTRAINT `food_ibfk_1` FOREIGN KEY (`canteen_id`) REFERENCES `canteen` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1509490991234703363 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food`
--

LOCK TABLES `food` WRITE;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
INSERT INTO `food` VALUES (1509470895959334913,'鐓庨吙鑼勫瓙',0,'3.2','[\"http://tmp/3lYLATbe7OX783eb2eb31d5107bd96f1dcf4307be3ea.png\",\"http://tmp/DbmCf347uAVm83eb2eb31d5107bd96f1dcf4307be3ea.png\"]','2022-04-15',1508719353228591106,'2022-03-31 02:01:20','2022-04-15 01:45:34',0,0),(1509490991234703362,'姊呰彍鑲夐ゼ',0,'4.5','[\"http://tmp/3lYLATbe7OX783eb2eb31d5107bd96f1dcf4307be3ea.png\",\"http://tmp/DbmCf347uAVm83eb2eb31d5107bd96f1dcf4307be3ea.png\"]','2022-04-15',1508518788654669826,'2022-03-31 19:21:11','2022-04-15 01:51:12',0,0);
/*!40000 ALTER TABLE `food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `goods` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '闂茬疆鐗╁搧缂栧彿',
  `name` varchar(256) NOT NULL COMMENT '闂茬疆鐗╁搧鍚?,
  `type` varchar(128) NOT NULL COMMENT '闂茬疆鐗╁搧绉嶇被',
  `info` text NOT NULL COMMENT '鐗╁搧淇℃伅---瀵屾枃鏈?,
  `price` varchar(16) NOT NULL COMMENT '浠锋牸',
  `pictures` varchar(128) NOT NULL COMMENT 'JSON鏍煎紡鐨勫浘鐗囧湴鍧€鏁扮粍',
  `phone` varchar(16) NOT NULL COMMENT '鎵嬫満鍙?,
  `wechat_id` varchar(128) NOT NULL COMMENT '寰俊鍙?,
  `user_id` bigint unsigned NOT NULL COMMENT '鍙戝竷浜篒D',
  `buyer_id` bigint unsigned DEFAULT NULL COMMENT '璐拱浜篒D',
  `audit_state` tinyint DEFAULT '0' COMMENT '鐗╁搧瀹℃牳鐘舵€?2-鏈繃瀹?1-宸茶繃瀹? 0-寰呭鏍?,
  `state` tinyint(1) DEFAULT '0' COMMENT '鐗╁搧鐘舵€?1-宸插嚭鍞? 0-鏈嚭鍞?,
  `create_gtm` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '鍒涘缓鏃堕棿',
  `update_gtm` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '淇敼鏃堕棿',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍒犻櫎',
  `is_locked` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍐荤粨',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `buyer_id` (`buyer_id`),
  CONSTRAINT `goods_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `goods_ibfk_2` FOREIGN KEY (`buyer_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1514653783725789187 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` VALUES (1509570773070786561,'AJ','闉嬪瓙','浜屾墜AJ闉嬪瓙','100','[\"../../img/add.png\",\"../../img/add.png\",\"../../img/add.png\"]','415135113','113311231sz32d41a3',1,NULL,0,0,'2022-04-01 00:38:13','2022-04-15 00:50:19',0,0),(1509570773070786562,'ADIDAS','琛ｆ湇','瓒呯骇濂界湅鐨勮。鏈?,'10001','[\"../../img/add.png\",\"../../img/add.png\",\"../../img/add.png\"]','415135113','113311231sz32d41a3',2,NULL,0,0,'2022-04-01 00:38:13','2022-04-15 21:11:28',0,0),(1514653783725789186,'闆堕澶хぜ鍖?,'椋熺墿','瓒呯骇濂藉悆鐨勯浂椋熷ぇ绀煎寘','20','[\"http://tmp/3lYLATbe7OX783eb2eb31d5107bd96f1dcf4307be3ea.png\",\"http://tmp/DbmCf347uAVm83eb2eb31d5107bd96f1dcf4307be3ea.png\"]','13172726164','asda12313',1,NULL,0,0,'2022-04-15 01:16:17',NULL,0,0);
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `note`
--

DROP TABLE IF EXISTS `note`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `note` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '涓汉鍔ㄦ€佸唴瀹圭紪鍙?,
  `content` text NOT NULL COMMENT '鍐呭',
  `user_id` bigint unsigned NOT NULL COMMENT '鍒涘缓浜篒D',
  `state` tinyint(1) DEFAULT '0' COMMENT '鐘舵€?1-鍙  0-涓嶅彲瑙?,
  `create_gtm` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '鍒涘缓鏃堕棿',
  `update_gtm` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '淇敼鏃堕棿',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍒犻櫎',
  `is_locked` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍐荤粨',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `note_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1514186287642542082 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `note`
--

LOCK TABLES `note` WRITE;
/*!40000 ALTER TABLE `note` DISABLE KEYS */;
INSERT INTO `note` VALUES (1508762212598214658,'浠婂ぉ蹇冩儏涓嶉敊',1,1,'2022-03-29 11:05:17','2022-03-31 23:34:45',0,0),(1514180736766341122,'娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?',2,0,'2022-04-13 17:56:34','2022-04-15 21:36:31',0,0),(1514180760749371393,'娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?',1,0,'2022-04-13 17:56:40',NULL,0,0),(1514180773386809345,'娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?',1,0,'2022-04-13 17:56:43',NULL,0,0),(1514180877938225153,'娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?',1,0,'2022-04-13 17:57:08',NULL,0,0),(1514180888377847809,'娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?',1,0,'2022-04-13 17:57:10',NULL,0,0),(1514180940273971201,'娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?娴嬭瘯鍔ㄦ€?',1,0,'2022-04-13 17:57:22',NULL,0,0),(1514186064774004737,'娴嬭瘯娴嬭瘯鍐呭',1,0,'2022-04-13 18:17:44',NULL,0,0),(1514186287642542081,'娴嬭瘯娴嬭瘯娴嬭瘯娴嬭瘯',1,0,'2022-04-13 18:18:37',NULL,0,0);
/*!40000 ALTER TABLE `note` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parking`
--

DROP TABLE IF EXISTS `parking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parking` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '缂栧彿',
  `code` varchar(128) NOT NULL COMMENT '杞︿綅鍙?,
  `state` tinyint(1) DEFAULT '0' COMMENT '杞︿綅鐘舵€?1-宸插崰鐢? 0-绌洪棽',
  `create_gtm` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '鍒涘缓鏃堕棿',
  `update_gtm` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '淇敼鏃堕棿',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍒犻櫎',
  `is_locked` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍐荤粨',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1509514539084976130 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parking`
--

LOCK TABLES `parking` WRITE;
/*!40000 ALTER TABLE `parking` DISABLE KEYS */;
INSERT INTO `parking` VALUES (1509514511272546306,'4D1',1,'2022-03-31 20:54:39','2022-03-31 22:34:50',0,0),(1509514539084976129,'4D2',0,'2022-03-31 20:54:46','2022-03-31 22:23:43',0,0);
/*!40000 ALTER TABLE `parking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parking_order`
--

DROP TABLE IF EXISTS `parking_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parking_order` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '缂栧彿',
  `parking_id` bigint unsigned NOT NULL COMMENT '杞︿綅ID',
  `car_id` bigint unsigned DEFAULT NULL COMMENT '杞﹁締ID',
  `create_gtm` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '鍏ュ満鏃堕棿',
  `update_gtm` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '淇敼鏃堕棿',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍒犻櫎',
  `is_locked` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍐荤粨',
  PRIMARY KEY (`id`),
  KEY `parking_id` (`parking_id`),
  KEY `car_id` (`car_id`),
  CONSTRAINT `parking_order_ibfk_1` FOREIGN KEY (`parking_id`) REFERENCES `parking` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `parking_order_ibfk_2` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1509539722785083395 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parking_order`
--

LOCK TABLES `parking_order` WRITE;
/*!40000 ALTER TABLE `parking_order` DISABLE KEYS */;
INSERT INTO `parking_order` VALUES (1509539722785083394,1509514511272546306,1509369384998674434,'2022-03-31 22:34:50',NULL,0,0);
/*!40000 ALTER TABLE `parking_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permissions`
--

DROP TABLE IF EXISTS `permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permissions` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '鏉冮檺缂栧彿',
  `name` varchar(256) NOT NULL COMMENT '鏉冮檺鍚?,
  `parent` bigint unsigned DEFAULT NULL COMMENT '鐖剁骇鏉冮檺',
  `perms` varchar(256) NOT NULL COMMENT '鏉冮檺鏍囪瘑',
  `create_gtm` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '鍒涘缓鏃堕棿',
  `update_gtm` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '淇敼鏃堕棿',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍒犻櫎',
  `is_locked` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍐荤粨',
  PRIMARY KEY (`id`),
  KEY `parent` (`parent`),
  CONSTRAINT `permissions_ibfk_1` FOREIGN KEY (`parent`) REFERENCES `permissions` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permissions`
--

LOCK TABLES `permissions` WRITE;
/*!40000 ALTER TABLE `permissions` DISABLE KEYS */;
/*!40000 ALTER TABLE `permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '瑙掕壊缂栧彿',
  `name` varchar(256) NOT NULL COMMENT '瑙掕壊鍚?,
  `create_gtm` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '鍒涘缓鏃堕棿',
  `update_gtm` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '淇敼鏃堕棿',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍒犻櫎',
  `is_locked` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍐荤粨',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1509763123856490498 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin','2022-03-28 17:37:20',NULL,0,0),(2,'editor','2022-03-28 17:37:27',NULL,0,0),(1509763123856490497,'customer','2022-04-01 13:22:33',NULL,0,0);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rolepermissionmap`
--

DROP TABLE IF EXISTS `rolepermissionmap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rolepermissionmap` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '缂栧彿',
  `roleid` bigint unsigned NOT NULL COMMENT '瑙掕壊ID',
  `permissionid` bigint unsigned NOT NULL COMMENT '鏉冮檺ID',
  `create_gtm` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '鍒涘缓鏃堕棿',
  `update_gtm` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '淇敼鏃堕棿',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍒犻櫎',
  `is_locked` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍐荤粨',
  PRIMARY KEY (`id`),
  KEY `roleid` (`roleid`),
  KEY `permissionid` (`permissionid`),
  CONSTRAINT `rolepermissionmap_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `rolepermissionmap_ibfk_2` FOREIGN KEY (`permissionid`) REFERENCES `permissions` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rolepermissionmap`
--

LOCK TABLES `rolepermissionmap` WRITE;
/*!40000 ALTER TABLE `rolepermissionmap` DISABLE KEYS */;
/*!40000 ALTER TABLE `rolepermissionmap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat`
--

DROP TABLE IF EXISTS `seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '缂栧彿',
  `code` varchar(16) NOT NULL COMMENT '搴т綅鍙?,
  `location` varchar(128) NOT NULL COMMENT '鎵€鍦ㄦ暀瀹?,
  `school` tinyint DEFAULT '0' COMMENT '鎵€灞炴牎鍖猴細0-瀹樻浮鏍″尯 1-瑗垮煄鏍″尯 2-鍏夊崕鏍″尯',
  `state` tinyint(1) DEFAULT '0' COMMENT '搴т綅鐘舵€?1-宸插崰鐢? 0-绌洪棽',
  `create_gtm` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '鍒涘缓鏃堕棿',
  `update_gtm` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '淇敼鏃堕棿',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍒犻櫎',
  `is_locked` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍐荤粨',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1509544382153510918 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat`
--

LOCK TABLES `seat` WRITE;
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
INSERT INTO `seat` VALUES (1509544335240220673,'012','612',0,1,'2022-03-31 22:53:10','2022-04-15 22:51:10',0,0),(1509544382153510914,'001','612',0,0,'2022-03-31 22:53:21','2022-04-15 22:49:16',0,0),(1509544382153510915,'002','612',0,0,'2022-03-31 22:53:21','2022-04-15 13:47:48',0,0),(1509544382153510916,'003','612',0,0,'2022-03-31 22:53:21','2022-04-15 22:49:08',0,0),(1509544382153510917,'001','611',0,0,'2022-03-31 22:53:21',NULL,0,0);
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat_order`
--

DROP TABLE IF EXISTS `seat_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat_order` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '缂栧彿',
  `user_id` bigint unsigned NOT NULL COMMENT '浣跨敤浜篒D',
  `state` tinyint DEFAULT '0' COMMENT '0-姝ｅ湪浣跨敤 1-宸茬粨鏉熶娇鐢?,
  `seat_id` bigint unsigned NOT NULL COMMENT '搴т綅ID',
  `use_time` varchar(16) NOT NULL COMMENT '浣跨敤鏃堕暱',
  `create_gtm` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '鍒涘缓鏃堕棿',
  `update_gtm` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '淇敼鏃堕棿',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍒犻櫎',
  `is_locked` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍐荤粨',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `seat_id` (`seat_id`),
  CONSTRAINT `seat_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `seat_order_ibfk_2` FOREIGN KEY (`seat_id`) REFERENCES `seat` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1514979652398850051 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat_order`
--

LOCK TABLES `seat_order` WRITE;
/*!40000 ALTER TABLE `seat_order` DISABLE KEYS */;
INSERT INTO `seat_order` VALUES (1509582730025959426,2,0,1509544335240220673,'3','2022-03-31 17:25:44','2022-04-15 22:51:31',0,0),(1514845818504142849,1,1,1509544335240220673,'2','2022-04-15 13:59:22','2022-04-15 22:51:38',0,0),(1514845998922129410,1,1,1509544382153510916,'3','2022-04-15 14:00:05','2022-04-15 22:51:40',0,0),(1514973177731387393,1,1,1509544382153510914,'2','2022-04-15 22:25:27','2022-04-15 22:51:42',0,0),(1514979652398850050,1,0,1509544335240220673,'2','2022-04-15 22:51:10',NULL,0,0);
/*!40000 ALTER TABLE `seat_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '鐢ㄦ埛缂栧彿',
  `avatar_url` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '澶村儚',
  `name` varchar(256) NOT NULL COMMENT '鐢ㄦ埛鍚?,
  `type` int NOT NULL DEFAULT '0' COMMENT '鐢ㄦ埛绫诲瀷',
  `account` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '鐧诲綍璐﹀彿',
  `password` text NOT NULL COMMENT '瀵嗙爜',
  `gender` tinyint(1) NOT NULL DEFAULT '0' COMMENT '鎬у埆锛?:鏈煡,1:濂?2:鐢?,
  `phone` bigint NOT NULL DEFAULT '0' COMMENT '鎵嬫満鍙风爜',
  `session_key` varchar(256) DEFAULT NULL COMMENT '浼氳瘽瀵嗛挜',
  `salt` varchar(64) DEFAULT NULL COMMENT '鐩愬€?,
  `state` tinyint(1) DEFAULT '1' COMMENT '璐﹀彿鐘舵€?1鏄甯?0鏄鐢?,
  `carId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '杞﹁締ID',
  `create_gtm` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '鍒涘缓鏃堕棿',
  `update_gtm` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '淇敼鏃堕棿',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍒犻櫎',
  `is_locked` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍐荤粨',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,NULL,'10000',1,'10000','e097c81d6fc0a8d8ffbdded971da103e402ae2089b20aaaad380212af160cf02',1,13172726161,NULL,'y9yKaSm6xZfz0jxVQwkE',1,'1509543928354983937','2022-03-28 17:30:11','2022-04-16 14:57:00',0,0),(2,NULL,'10001',0,'10001','6663f13c30f70ffe657b35aff883fe298f877013400bc31733b95b8b680326e4',0,13172726161,NULL,'DOxDVqlW6wytAJBKLTI9',1,NULL,'2022-03-28 17:30:32',NULL,0,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userrolemap`
--

DROP TABLE IF EXISTS `userrolemap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userrolemap` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '鐢ㄦ埛瑙掕壊缂栧彿',
  `userid` bigint unsigned NOT NULL COMMENT '鐢ㄦ埛ID',
  `roleid` bigint unsigned NOT NULL COMMENT '瑙掕壊ID',
  `create_gtm` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '鍒涘缓鏃堕棿',
  `update_gtm` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '淇敼鏃堕棿',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍒犻櫎',
  `is_locked` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍐荤粨',
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  KEY `roleid` (`roleid`),
  CONSTRAINT `userrolemap_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `userrolemap_ibfk_2` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userrolemap`
--

LOCK TABLES `userrolemap` WRITE;
/*!40000 ALTER TABLE `userrolemap` DISABLE KEYS */;
INSERT INTO `userrolemap` VALUES (1,1,1,'2022-03-28 17:37:40',NULL,0,0),(2,2,2,'2022-03-28 17:37:44',NULL,0,0);
/*!40000 ALTER TABLE `userrolemap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vindicate`
--

DROP TABLE IF EXISTS `vindicate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vindicate` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '琛ㄧ櫧鍐呭缂栧彿',
  `content` text NOT NULL COMMENT '鍐呭',
  `receiver` varchar(128) NOT NULL COMMENT '鏀朵俊浜?,
  `writer` varchar(128) NOT NULL COMMENT '鏀朵俊浜?,
  `user_id` bigint unsigned NOT NULL COMMENT '鍒涘缓浜篒D',
  `state` tinyint(1) DEFAULT '0' COMMENT '鐘舵€?1-鍙  0-涓嶅彲瑙?,
  `create_gtm` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '鍒涘缓鏃堕棿',
  `update_gtm` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '淇敼鏃堕棿',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍒犻櫎',
  `is_locked` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '鏄惁鍐荤粨',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `vindicate_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1514196395520901122 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vindicate`
--

LOCK TABLES `vindicate` WRITE;
/*!40000 ALTER TABLE `vindicate` DISABLE KEYS */;
INSERT INTO `vindicate` VALUES (1509556982996152321,'瀹濆疂锛屾垜鍠滄浣?,'receiver','writer',1,1,'2022-03-31 15:43:25','2022-04-13 18:42:18',0,0),(1514195629359972353,'Google缈昏瘧鏄竴椤圭敱Google浜?006骞村紑濮嬫彁渚涚殑缈昏瘧鏂囨鍙婄綉椤电殑鏈嶅姟銆備笌鍏朵粬缃戠珯宸村埆楸笺€佺編鍥藉湪绾垮強闆呰檸浣跨敤鐨凷YSTRAN寮曟搸涓嶅悓鐨勬槸锛孏oogle浣跨敤鑷繁寮€鍙戠殑缈昏瘧杞欢銆傝嚦2015骞?鏈堬紝Google缈昏瘧绉版瘡澶╅渶瑕佸鐞嗚秴杩?000浜跨瑪瀛楄瘝','XXX','鍖垮悕鑰?,1,0,'2022-04-13 18:55:45',NULL,0,0),(1514196395520901121,'maxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlengthmaxlength','XXX','鍖垮悕鑰?,2,0,'2022-04-13 18:58:47','2022-04-15 21:23:47',0,0);
/*!40000 ALTER TABLE `vindicate` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-24 17:20:01
