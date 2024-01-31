CREATE DATABASE  IF NOT EXISTS `eventmaster` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `eventmaster`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: eventmaster
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event` (
  `EventID` int NOT NULL AUTO_INCREMENT,
  `EventName` varchar(100) DEFAULT NULL,
  `VerifyStatus` tinyint(1) DEFAULT '0',
  `EventType` varchar(50) DEFAULT NULL,
  `EventDescription` text,
  `EventVenue` varchar(100) DEFAULT NULL,
  `EventDate` date DEFAULT NULL,
  `EnableTicketBooking` tinyint(1) DEFAULT '0',
  `AdminID` int DEFAULT NULL,
  `evtplID` int DEFAULT NULL,
  PRIMARY KEY (`EventID`),
  KEY `AdminID` (`AdminID`),
  KEY `evtplID` (`evtplID`),
  CONSTRAINT `event_ibfk_1` FOREIGN KEY (`AdminID`) REFERENCES `admin` (`AdminID`),
  CONSTRAINT `event_ibfk_2` FOREIGN KEY (`evtplID`) REFERENCES `eventplanner` (`evtplID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (2,'Musical Show',1,'Concert','An amazing concert event','Concert Hall',NULL,1,1,NULL),(3,'Sample Event 2',1,'Conference','A tech conference','Conference Center','2023-11-15',0,2,NULL),(4,'Sample Event 3',1,'Festival','Annual music festival','Outdoor Park','2023-12-12',1,1,NULL),(5,'SLIIT Seminar',1,'Seminar','Educational seminar','Conference Center','2023-12-10',1,3,NULL),(6,'Sample Event 5',1,'Exhibition','Art exhibition','Art Gallery',NULL,0,2,NULL),(14,'Maths And Science O/L',0,'Seminar','Maths And Science O/L\r\nSpecial Seminar','SLIIT','2023-10-27',0,NULL,4),(15,'Maths And Science O/L',0,'Seminar','Maths And Science O/L\r\nSpecial Seminar','SLIIT','2023-10-27',0,NULL,4);
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-23 14:47:11
