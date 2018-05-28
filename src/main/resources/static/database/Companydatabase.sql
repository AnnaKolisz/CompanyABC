-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: localhost    Database: Company
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu0.16.04.1

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
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `position` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES (1,'Prezes'),(2,'Dyrektor'),(3,'Kierownik'),(4,'Specjalista'),(5,'Asystent');
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position_users`
--

DROP TABLE IF EXISTS `position_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `position_users` (
  `position_id` int(11) NOT NULL,
  `users_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_ram5bmw911mk82pxvryrkmp75` (`users_id`),
  KEY `FKisnjnngu4ho6b31alsudgcfr1` (`position_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position_users`
--

LOCK TABLES `position_users` WRITE;
/*!40000 ALTER TABLE `position_users` DISABLE KEYS */;
/*!40000 ALTER TABLE `position_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `surname` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `position_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4ej0twvfqwwu5xdcns6u2qne3` (`position_id`)
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'jduczek@abc.com','Jan','Duczek',1),(2,'azeles@abc.com','Agnieszka ','Żeleś',2),(3,'mnowak@abc.com','Marcin','Nowakowski',2),(4,'mkowalczyk@abc.com','Magdalena','Kowalczyk',3),(5,'aswierk@abc.com','Antonina','Świerk',5),(6,'mlis@abc.com','Maciej','Lis',3),(7,'tlewandowski@abc.com','Tomasz','Lewandowski',3),(12,'kbuk@abc.com','Karol ','Buk',5),(14,'atomik@abc.com','Alicja','Tomik',5),(15,'pluczak@abc.com','Piotr','Łuczak',5),(16,'akoszyk@abc.com','Alicja','Koszyk',5),(17,'m.krawiec@abc.com','Michał','Krawiec',4),(18,'mpaw@abc.com','Michał','Paw',4),(19,'awojak@abc.com','Adam','Wojak',4),(20,'mchojnacki@abc.com','Marek','Chojnacki',4),(21,'jstefanska@abc.com','Joanna','Stefańska',4),(22,'dkrawczyk@abc.com','Dominika','Krawczyk',4),(23,'ajankowska@abc.com','Agata ','Jankowska',4),(24,'mdebska@abc.com','Marta','Dębska',5),(26,'abretomski@abc.com','Antoni','Bretomski',3);
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

-- Dump completed on 2018-05-28 23:35:08
