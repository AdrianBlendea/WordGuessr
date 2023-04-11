-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: wordguessr
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `idUser` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `guessed` int(10) unsigned zerofill DEFAULT '0000000000',
  `firstTry` int(10) unsigned zerofill DEFAULT '0000000000',
  `inarow` int(10) unsigned zerofill DEFAULT '0000000000',
  `word` varchar(45) NOT NULL,
  `found` tinyint NOT NULL,
  `descriere` varchar(45) NOT NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'player1','password',0000000014,0000000010,0000000004,'cuvant1',0,'descriere1'),(2,'player2','password',0000000010,0000000006,0000000003,'cuvant2',1,'descriere2'),(3,'player3','password',0000000001,0000000000,0000000000,'cuvant3',1,'descriere3'),(4,'player4','password',0000000001,0000000000,0000000003,'cuvant4',1,'descriere4'),(5,'player5','password',0000000000,0000000000,0000000000,'cuvant5',0,'descriere5'),(6,'player6','password',0000000000,0000000000,0000000000,'cuvant6',0,'descriere6'),(7,'player7','password',0000000000,0000000000,0000000000,'cuvant7',0,'descriere7'),(8,'player8','password',0000000000,0000000000,0000000000,'cuvant8',0,'descriere8'),(9,'player9','password',0000000000,0000000000,0000000000,'cuvant9',0,'descriere9'),(10,'player10','password',0000000000,0000000000,0000000000,'cuvant10',0,'descriere10'),(11,'player11','password',0000000001,0000000001,0000000000,'cuvant11',0,'descriere11');
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

-- Dump completed on 2023-04-11 16:29:35
