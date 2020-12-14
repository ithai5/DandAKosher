-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: den1.mysql1.gear.host    Database: dakosher
-- ------------------------------------------------------
-- Server version	5.7.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(45) NOT NULL,
  `phone` varchar(12) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `is_subscribed` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Snoop Dog','12341234','snoop_dog@mail.com',0),(2,'Tupac Shakor','12121212','2pac@mail.com',1),(3,'Ice Cube','11111111','ice_cube@mail.com',0),(4,'Slim Shady','99999999','slim_shady@mail.com',1),(5,'Busta Rhymes','4444444','busta_rhymes@mail.com',1),(6,'J. Cole','42042069','noRoleModelz@hollywood.go',0),(7,'Test Hansen','26252928','testmail@aa.dk',1),(8,'Test Hansen','45222949','ap@malibu.dk',1),(9,'test name','12341241','testmail@test.com',1),(10,'Anderson Paak','','andersonpaak@bubblin.com',1),(11,'T.I','','ti@it.ti',1),(12,'Chance The Rapper','','chance@rapper.com',1),(13,'post melone','','melone@post.com',0),(14,'Rapper Man','29456895','rapMan@rapMail.rp',0),(16,'Mac miller','66677766','miller@mac.com',1),(17,'',NULL,'',1),(18,'lil wayne',NULL,'mrcarter@mail.com',1),(19,'',NULL,'',1),(20,'asdfasdf',NULL,'mail@mail.com',1),(21,'senur tomasas',NULL,'thomases@yahoo.com',0),(22,'mads Kristensen',NULL,'mk@mk.com',0),(23,'Mike Muller',NULL,'MikeMuller@gmail.com',0),(24,'Mads Christensen',NULL,'MadChris@lovesocks.com',0);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `customermessage`
--

DROP TABLE IF EXISTS `customermessage`;
/*!50001 DROP VIEW IF EXISTS `customermessage`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `customermessage` AS SELECT 
 1 AS `id`,
 1 AS `full_name`,
 1 AS `phone`,
 1 AS `email`,
 1 AS `is_subscribed`,
 1 AS `subject`,
 1 AS `content`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `dish`
--

DROP TABLE IF EXISTS `dish`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dish` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `price` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dish`
--

LOCK TABLES `dish` WRITE;
/*!40000 ALTER TABLE `dish` DISABLE KEYS */;
INSERT INTO `dish` VALUES (1,'Chicken Wrap',50.00),(2,'Hummus',25.00),(3,'Big Cola',15.00),(4,'Israeli Sweets',20.00),(5,'Moussaka',55.00),(6,'Shakshouka',45.00),(7,'Couscous',45.00),(8,'Jakhnun',50.00),(9,'Hamin',80.00),(10,'Fatah',100.00),(11,'Shoko Bsakit',35.00),(12,'Sahlab',35.00),(13,'Arak',35.00),(14,'Limonana',20.00);
/*!40000 ALTER TABLE `dish` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `event_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,'Hannukkah'),(2,'Wedding'),(3,'Bar Mitzvah');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `price` decimal(7,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'Deluxe',500.00),(2,'Basic',200.00),(7,'deluxePlus',100.75);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `menu_content`
--

DROP TABLE IF EXISTS `menu_content`;
/*!50001 DROP VIEW IF EXISTS `menu_content`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `menu_content` AS SELECT 
 1 AS `menu_name`,
 1 AS `price`,
 1 AS `dish_name`,
 1 AS `id`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `menu_has_dish`
--

DROP TABLE IF EXISTS `menu_has_dish`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu_has_dish` (
  `menu_id` int(11) NOT NULL,
  `dish_id` int(11) NOT NULL,
  PRIMARY KEY (`menu_id`,`dish_id`),
  KEY `menu_has_dish_ibfk_2` (`dish_id`),
  CONSTRAINT `menu_has_dish_ibfk_1` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `menu_has_dish_ibfk_2` FOREIGN KEY (`dish_id`) REFERENCES `dish` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_has_dish`
--

LOCK TABLES `menu_has_dish` WRITE;
/*!40000 ALTER TABLE `menu_has_dish` DISABLE KEYS */;
INSERT INTO `menu_has_dish` VALUES (1,1),(7,1),(1,2),(7,2),(1,3),(2,3),(1,4),(2,6),(7,7),(7,8),(7,9),(2,10),(7,13);
/*!40000 ALTER TABLE `menu_has_dish` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(45) DEFAULT NULL,
  `content` varchar(256) DEFAULT NULL,
  `customer_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_message_customer_idx` (`customer_id`),
  CONSTRAINT `fk_message_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (1,'issue1','blablablablablablablablabla',1),(2,'issue2','2bla2bla2bla2bla2bla2bla2bla2bla2bla2bla2bla2bla2bla',2),(3,'issue3','3bla3bla3bla3bla3bla3bla',3),(4,'we test','Supertesttesttesttesttesttesttesttest',6),(6,'Glitter Style',NULL,7),(7,'Glitter Style',NULL,7),(9,'Glitter Style','Loool xD',8),(11,'hello test','super hello test',9),(12,'hello test','super hello test',9),(13,'hello test','super hello test',9),(14,'hello test','super hello test',9),(16,'Anderson Paak Bar Mizva','Shalom ',10),(17,'ti Bar Mizva','Shalom ',11),(18,'Change Feast','Shalom ',12),(19,'Change Feast','Shalom ',12),(20,'Melone Feast','Shalom ',13),(21,'Sup Foo','Sup food\r\nCan you give me catering yo yo',14),(22,'Sup Foo','Sup food\r\nCan you give me catering yo yo',14),(26,'woop woop','bar mitzva ',16);
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `total_people` int(11) DEFAULT NULL,
  `total_price` decimal(7,2) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  `event_id` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `message_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `event_id` (`event_id`),
  KEY `customer_id` (`customer_id`),
  KEY `message_id` (`message_id`),
  KEY `order_ibfk_1` (`menu_id`),
  CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`),
  CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`),
  CONSTRAINT `reservation_ibfk_3` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `reservation_ibfk_4` FOREIGN KEY (`message_id`) REFERENCES `message` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES (1,5,2000.00,1,3,4,NULL),(2,2,500.00,2,1,6,3),(7,6,1380.00,2,3,14,NULL),(8,7,1610.00,2,3,14,NULL),(9,7,1610.00,2,3,14,NULL),(10,7,1610.00,2,3,14,NULL),(11,7,NULL,2,3,14,NULL),(12,7,NULL,2,3,14,NULL),(13,7,NULL,2,3,14,NULL),(14,7,NULL,2,3,14,NULL),(15,7,NULL,2,3,14,NULL),(16,7,1610.00,2,3,14,NULL),(17,7,1610.00,2,3,14,NULL),(18,7,1610.00,2,3,14,NULL),(19,7,1610.00,2,3,14,NULL),(20,7,1610.00,2,3,14,NULL),(21,7,1610.00,2,3,14,NULL),(22,7,1610.00,2,3,14,NULL),(23,7,1610.00,2,3,14,NULL),(24,7,1610.00,2,3,14,NULL),(25,9,2070.00,2,3,14,NULL),(26,9,2070.00,2,3,14,NULL),(27,9,2070.00,2,3,14,NULL),(28,9,2070.00,2,3,14,NULL),(29,9,2070.00,2,3,14,NULL),(30,4,800.00,2,2,14,NULL),(31,4,920.00,2,1,14,NULL),(47,4,920.00,2,1,14,NULL),(48,4,920.00,2,1,14,NULL),(49,4,920.00,2,1,14,NULL),(50,10,1307.50,7,1,21,NULL),(53,4,2000.00,1,1,23,NULL),(55,4,2120.00,1,1,21,NULL),(56,6,3180.00,1,3,21,NULL),(57,8,4240.00,1,1,24,NULL);
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation_has_dish`
--

DROP TABLE IF EXISTS `reservation_has_dish`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation_has_dish` (
  `reservation_id` int(11) NOT NULL,
  `dish_id` int(11) NOT NULL,
  PRIMARY KEY (`reservation_id`,`dish_id`),
  KEY `reservation_has_dish_ibfk_1` (`dish_id`),
  CONSTRAINT `reservation_has_dish_ibfk_1` FOREIGN KEY (`dish_id`) REFERENCES `dish` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `reservation_has_dish_ibfk_2` FOREIGN KEY (`reservation_id`) REFERENCES `reservation` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation_has_dish`
--

LOCK TABLES `reservation_has_dish` WRITE;
/*!40000 ALTER TABLE `reservation_has_dish` DISABLE KEYS */;
INSERT INTO `reservation_has_dish` VALUES (24,1),(25,1),(29,1),(31,1),(24,2),(2,3),(50,3),(2,4),(25,4),(29,4),(47,5),(48,5),(49,5),(50,5),(55,5),(55,6),(56,6),(7,7),(47,7),(48,7),(49,7),(1,8),(7,8),(25,8),(29,8),(47,8),(49,8),(56,8),(57,8),(25,9),(29,9),(55,9),(50,10),(57,10),(7,11),(24,11),(24,12),(55,12),(57,12),(24,13),(56,13),(24,14),(57,14);
/*!40000 ALTER TABLE `reservation_has_dish` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `reservationinfo`
--

DROP TABLE IF EXISTS `reservationinfo`;
/*!50001 DROP VIEW IF EXISTS `reservationinfo`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `reservationinfo` AS SELECT 
 1 AS `id`,
 1 AS `total_people`,
 1 AS `total_price`,
 1 AS `menu_name`,
 1 AS `event_name`,
 1 AS `email`,
 1 AS `dish_name`,
 1 AS `content`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `customermessage`
--

/*!50001 DROP VIEW IF EXISTS `customermessage`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`dakosher`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `customermessage` AS select `m`.`id` AS `id`,`c`.`full_name` AS `full_name`,`c`.`phone` AS `phone`,`c`.`email` AS `email`,`c`.`is_subscribed` AS `is_subscribed`,`m`.`subject` AS `subject`,`m`.`content` AS `content` from (`customer` `c` join `message` `m` on((`c`.`id` = `m`.`customer_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `menu_content`
--

/*!50001 DROP VIEW IF EXISTS `menu_content`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`dakosher`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `menu_content` AS select `m`.`name` AS `menu_name`,`m`.`price` AS `price`,`d`.`name` AS `dish_name`,uuid() AS `id` from ((`menu` `m` join `menu_has_dish` `md` on((`m`.`id` = `md`.`menu_id`))) join `dish` `d` on((`d`.`id` = `md`.`dish_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `reservationinfo`
--

/*!50001 DROP VIEW IF EXISTS `reservationinfo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`dakosher`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `reservationinfo` AS select `r`.`id` AS `id`,`r`.`total_people` AS `total_people`,`r`.`total_price` AS `total_price`,`m`.`name` AS `menu_name`,`e`.`event_name` AS `event_name`,`c`.`email` AS `email`,`d`.`name` AS `dish_name`,`ms`.`content` AS `content` from ((((((`reservation` `r` join `menu` `m` on((`m`.`id` = `r`.`menu_id`))) join `event` `e` on((`e`.`id` = `r`.`event_id`))) join `customer` `c` on((`c`.`id` = `r`.`customer_id`))) join `reservation_has_dish` `rd` on((`rd`.`reservation_id` = `r`.`id`))) join `dish` `d` on((`d`.`id` = `rd`.`dish_id`))) join `message` `ms` on((`ms`.`id` = `r`.`message_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-14 15:12:30
