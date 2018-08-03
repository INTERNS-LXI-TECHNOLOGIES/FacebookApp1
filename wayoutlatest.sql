-- MySQL dump 10.13  Distrib 5.5.23, for Win64 (x86)
--
-- Host: localhost    Database: way_out
-- ------------------------------------------------------
-- Server version	5.5.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `question_option`
--

DROP TABLE IF EXISTS `question_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question_option` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `opt` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_option`
--

LOCK TABLES `question_option` WRITE;
/*!40000 ALTER TABLE `question_option` DISABLE KEYS */;
INSERT INTO `question_option` VALUES (1,'1'),(2,'2'),(3,'3'),(4,'4'),(5,'A room without door is impossible so she took the aid of the door to hang herself'),(6,'The incident was a mureder, someone trespassed into the house and murdered the lady and to bypass trial he created a scene that looks as if it is a suicide'),(7,'The puddle of water seen over there was the result of melted ice cubes which was present over there'),(8,'The lady used dinning table in order to hang herself'),(9,'Mr.Smith said she was having breakfast but the breakfast is still seen on the table'),(10,'Mr.Smith didn not mention why he left the home'),(11,'The investigating officer felt that it is a cooked up story because of his attitude'),(12,'The Breakfast is still hot when investigating officer enters into the scene'),(13,'Tom'),(14,'Henry'),(15,'Kit'),(16,'Noah'),(17,'Mary'),(18,'Emily'),(19,'Nancy'),(20,'Emily and Noah'),(21,'Emily and Nancy'),(22,'Suspect 1'),(23,'Suspect 2'),(24,'Suspect 3'),(25,'Suspect 4'),(26,'murder'),(27,'suicide'),(28,'wife and gardener'),(29,'maid and cook'),(30,'wife and cook'),(31,'maid and gardener'),(32,'sister and gardener'),(33,'murder'),(34,'suicide'),(35,'The unknown man was wearing a black hat which made him look like a thief'),(36,'A person would not mistake his/her room being in the same floor'),(37,'A person would not knock the door before entering into his own room'),(38,'Appearance of the man made the lady to doubt him as a wrong person'),(39,'Ariana'),(40,'Taylor'),(41,'selena'),(42,' someone trespassed into the house and murdered the lady and to bypass trial he created a scene that looks as if it is a suicide'),(43,'The incident was a mureder'),(44,'The puddle of water seen over there was the result of melted ice cubes which was present over there'),(45,' someone trespassed into the house and murdered the lady and to bypass trial he created a scene that looks as if it is a suicide'),(46,'The incident was a mureder'),(47,'The puddle of water seen over there was the result of melted ice cubes which was present over there');
/*!40000 ALTER TABLE `question_option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `security_question`
--

DROP TABLE IF EXISTS `security_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `security_question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `image_path` varchar(254) NOT NULL,
  `question` text NOT NULL,
  `answer` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `security_question`
--

LOCK TABLES `security_question` WRITE;
/*!40000 ALTER TABLE `security_question` DISABLE KEYS */;
INSERT INTO `security_question` VALUES (1,'images/questionimages/1.jpg','Who is the killer?','3'),(2,'images/questionimages/2.jpg','Which bullet hole was made first?','2'),(3,'images/questionimages/3.jpg','Who is the spy','Henry'),(4,'images/questionimages/4.jpg','How did she hang herself?','The puddle of water seen over there was the result of melted ice cubes which was present over there'),(5,'images/questionimages/5.jpg','Who is the murderer','Emily and Noah'),(6,'images/questionimages/6.jpg','Why detective arrested Smith?','The Breakfast is still hot when investigating officer enters into the scene'),(7,'images/questionimages/7.jpg','Who is the murderer','Suspect 3'),(8,'images/questionimages/8.jpg','Is this a murder or a suicide','murder'),(9,'images/questionimages/9.jpg','Who is the culprit','wife and cook'),(10,'images/questionimages/10.jpg','murder or suicide','murder'),(11,'images/questionimages/11.jpg','Who was she so suspicious','A person would not knock the door before entering into his own room'),(12,'images/questionimages/12.jpg','Who is the murderer','selena');
/*!40000 ALTER TABLE `security_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `security_question_options`
--

DROP TABLE IF EXISTS `security_question_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `security_question_options` (
  `question_id` bigint(20) DEFAULT NULL,
  `option_id` bigint(20) DEFAULT NULL,
  KEY `question_id` (`question_id`),
  KEY `option_id` (`option_id`),
  CONSTRAINT `security_question_options_ibfk_1` FOREIGN KEY (`question_id`) REFERENCES `security_question` (`id`) ON DELETE CASCADE,
  CONSTRAINT `security_question_options_ibfk_2` FOREIGN KEY (`option_id`) REFERENCES `question_option` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `security_question_options`
--

LOCK TABLES `security_question_options` WRITE;
/*!40000 ALTER TABLE `security_question_options` DISABLE KEYS */;
INSERT INTO `security_question_options` VALUES (1,1),(1,2),(1,3),(1,4),(2,1),(2,2),(2,3),(4,5),(4,6),(4,7),(4,8),(6,9),(6,10),(6,11),(6,12),(3,13),(3,14),(3,15),(5,16),(5,17),(5,18),(5,19),(5,20),(5,21),(7,22),(7,23),(7,24),(7,25),(8,26),(8,27),(10,33),(10,34),(9,16),(9,17),(9,18),(9,19),(9,20),(9,21),(11,35),(11,36),(11,37),(11,38),(12,39),(12,40),(12,41);
/*!40000 ALTER TABLE `security_question_options` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-02 19:45:54
