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
-- Table structure for table `authors`
--

DROP TABLE IF EXISTS `authors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authors` (
  `id` bigint(11) NOT NULL,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `gender` enum('MALE','FEMALE') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authors`
--

LOCK TABLES `authors` WRITE;
/*!40000 ALTER TABLE `authors` DISABLE KEYS */;
INSERT INTO `authors` VALUES (1,'Napoleon','Hill','MALE'),(2,'Ekhart','Tolle','MALE'),(3,'Jack','Canfield','MALE'),(4,'Timothy','Ferriss','MALE'),(5,'Norman','Vincent','MALE'),(6,'Charles','Duhigg','MALE'),(7,'Anthony','Robbins','MALE'),(8,'Rhonda','Byrne','FEMALE'),(9,'Marianne','Williamson','FEMALE'),(10,'David','Burns','MALE'),(11,'Stephen','Covey','MALE'),(12,'Gretchen','Rubin','FEMALE'),(13,'Louise','Hay','FEMALE');
/*!40000 ALTER TABLE `authors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `books` (
  `id` bigint(10) NOT NULL,
  `title` varchar(45) DEFAULT NULL,
  `releaseYear` int(4) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'Think and Grow Rich',1937,'Napoleon Hill'),(2,'The Power of Now',1997,'Ekhart Tolle'),(3,'The Success Principles',2004,'Jack Canfield'),(4,'The 4-Hour Workweek',2007,'Timothy Ferriss'),(5,'The Power of Positive Thinking',1952,'Norman Vincent'),(6,'The Power of Habit',2012,'Charles Duhigg'),(7,'Unlimited Power',1986,'Anthony Robbins'),(8,'The Power',2010,'Rhonda Byrne'),(9,'Tears to Triumph',2016,'Marianne Williamson'),(10,'Feeling Good',1980,'David Burns'),(11,'The 7 Habits of Highly Effective People',1989,'Stephen Covey'),(12,'Better Than Before',2015,'Gretchen Rubin'),(13,'I Think, I Am',2008,'Louise Hay');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reviews` (
  `id` bigint(20) NOT NULL,
  `reviewersFirstName` varchar(45) DEFAULT NULL,
  `reviewersLastName` varchar(45) DEFAULT NULL,
  `rank` decimal(10,0) DEFAULT NULL,
  `created` time DEFAULT NULL,
  `bookId` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviews`
--

LOCK TABLES `reviews` WRITE;
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;
INSERT INTO `reviews` VALUES (1,'Mika','Peric',9,'19:58:15',1),(2,'Jovana','Lazic',9,'19:59:43',2),(3,'Marko','Jovanovic',8,'18:43:12',3),(4,'Nevena','Mitic',8,'17:43:52',4),(5,'Luna','Jokic',9,'16:46:07',5),(6,'Jelena','Maric',10,'13:06:05',6),(7,'Nenad','Andric',9,'15:08:34',7),(8,'Jovan','Gocic',8,'17:34:02',8),(9,'Lazar','Maricic',9,'18:56:47',9),(10,'Ana','Nesic',9,'13:23:53',10),(11,'Marija','Petronijevic',10,'09:43:17',11),(12,'Milan','Jovanovic',9,'12:24:14',12),(13,'Petar','Bogdanovic',8,'16:15:13',13);
/*!40000 ALTER TABLE `reviews` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-20 13:15:37
