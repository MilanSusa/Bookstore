-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: bookstore
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `author` (
  `id` bigint(11) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `gender` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` VALUES (1,'Napoleon','Hill','0'),(2,'Ekhart','Tolle','0'),(3,'Jack','Canfield','0'),(4,'Timothy','Ferriss','0'),(5,'Norman','Vincent','0'),(6,'Charles','Duhigg','0'),(7,'Anthony','Robbins','0'),(8,'Rhonda','Byrne','1'),(9,'Marianne','Williamson','1'),(10,'David','Burns','0'),(11,'Stephen','Covey','0'),(12,'Gretchen','Rubin','1'),(13,'Louise','Hay','1');
/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `author_book`
--

DROP TABLE IF EXISTS `author_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `author_book` (
  `authorId` bigint(20) NOT NULL,
  `bookId` bigint(20) NOT NULL,
  PRIMARY KEY (`authorId`,`bookId`),
  KEY `FKdg6286iyev5m58e4j6a7e058w` (`bookId`),
  CONSTRAINT `FKdg6286iyev5m58e4j6a7e058w` FOREIGN KEY (`bookId`) REFERENCES `book` (`id`),
  CONSTRAINT `FKnvtqx2anpyi9ddrn0nuwh1h05` FOREIGN KEY (`authorId`) REFERENCES `author` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author_book`
--

LOCK TABLES `author_book` WRITE;
/*!40000 ALTER TABLE `author_book` DISABLE KEYS */;
/*!40000 ALTER TABLE `author_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` bigint(10) NOT NULL,
  `title` varchar(45) NOT NULL,
  `releaseYear` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'Think and Grow Rich',1937),(2,'The Power of Now',1997),(3,'The Success Principles',2004),(4,'The 4-Hour Workweek',2007),(5,'The Power of Positive Thinking',1952),(6,'The Power of Habit',2012),(7,'Unlimited Power',1986),(8,'The Power',2010),(9,'Tears to Triumph',2016),(10,'Feeling Good',1980),(11,'The 7 Habits of Highly Effective People',1989),(12,'Better Than Before',2015),(13,'I Think, I Am',2008);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (10),(10),(10);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `review` (
  `id` bigint(20) NOT NULL,
  `reviewerFirstName` varchar(45) NOT NULL,
  `reviewerLastName` varchar(45) NOT NULL,
  `rank` decimal(10,0) NOT NULL,
  `created` time NOT NULL,
  `bookId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKat7tquw52hvs84svjwfvl52rw` (`bookId`),
  CONSTRAINT `FKat7tquw52hvs84svjwfvl52rw` FOREIGN KEY (`bookId`) REFERENCES `book` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (1,'Mika','Peric',9,'19:58:15',1),(2,'Jovana','Lazic',9,'19:59:43',2),(3,'Marko','Jovanovic',8,'18:43:12',3),(4,'Nevena','Mitic',8,'17:43:52',4),(5,'Luna','Jokic',9,'16:46:07',5),(6,'Jelena','Maric',10,'13:06:05',6),(7,'Nenad','Andric',9,'15:08:34',7),(8,'Jovan','Gocic',8,'17:34:02',8),(9,'Lazar','Maricic',9,'18:56:47',9),(10,'Ana','Nesic',9,'13:23:53',10),(11,'Marija','Petronijevic',10,'09:43:17',11),(12,'Milan','Jovanovic',9,'12:24:14',12),(13,'Petar','Bogdanovic',8,'16:15:13',13);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `roleId` int(11) NOT NULL,
  `roleName` varchar(45) NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`roleId`),
  KEY `FKdjnknm24nt462vrd3roe68i9c` (`userId`),
  CONSTRAINT `FKdjnknm24nt462vrd3roe68i9c` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'USER',1),(2,'USER',2);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Milan','$2a$10$moqUa4U4r62erJTQId./IegISoy6o11d.zPogCiHZ3PXNo1H9GQbS'),(2,'m','$2a$10$mtjDMeLdrvY9POv1vKdLYeVOcp4sOgEY4Lz2JzGqXsRWmvws5ISdK');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-24  0:16:51
