-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: project
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `CID` int NOT NULL AUTO_INCREMENT,
  `fk_LID` int NOT NULL,
  `firstName` varchar(32) NOT NULL,
  `lastName` varchar(32) NOT NULL,
  `age` smallint NOT NULL,
  `loyalty` tinyint(1) NOT NULL,
  PRIMARY KEY (`CID`),
  KEY `fk_LID` (`fk_LID`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`fk_LID`) REFERENCES `location` (`LID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `games`
--

DROP TABLE IF EXISTS `games`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `games` (
  `PID` int NOT NULL AUTO_INCREMENT,
  `gameName` varchar(32) NOT NULL,
  `ageRating` tinyint NOT NULL,
  `dateReleased` date NOT NULL,
  `genre` varchar(32) NOT NULL,
  `gamePrice` decimal(5,2) NOT NULL,
  PRIMARY KEY (`PID`),
  UNIQUE KEY `gameName` (`gameName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `games`
--

LOCK TABLES `games` WRITE;
/*!40000 ALTER TABLE `games` DISABLE KEYS */;
/*!40000 ALTER TABLE `games` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location` (
  `LID` int NOT NULL AUTO_INCREMENT,
  `streetAddress` varchar(64) NOT NULL,
  `postCode` char(6) NOT NULL,
  `city` varchar(32) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`LID`),
  UNIQUE KEY `LID` (`LID`,`streetAddress`,`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `OID` int NOT NULL AUTO_INCREMENT,
  `fk_CID` int NOT NULL,
  `orderDate` date NOT NULL,
  PRIMARY KEY (`OID`),
  KEY `fk_CID` (`fk_CID`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`fk_CID`) REFERENCES `customer` (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders_games`
--

DROP TABLE IF EXISTS `orders_games`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders_games` (
  `fk_OID` int NOT NULL,
  `fk_PID` int NOT NULL,
  `orderAmount` int NOT NULL,
  KEY `fk_OID` (`fk_OID`),
  KEY `fk_PID` (`fk_PID`),
  CONSTRAINT `orders_games_ibfk_1` FOREIGN KEY (`fk_OID`) REFERENCES `orders` (`OID`),
  CONSTRAINT `orders_games_ibfk_2` FOREIGN KEY (`fk_PID`) REFERENCES `games` (`PID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_games`
--

LOCK TABLES `orders_games` WRITE;
/*!40000 ALTER TABLE `orders_games` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders_games` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-04  0:38:35
