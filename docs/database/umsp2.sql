/*
SQLyog Community v12.2.2 (64 bit)
MySQL - 5.7.12-enterprise-commercial-advanced-log : Database - intern
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`intern` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `intern`;

/*Table structure for table `group_role_map` */

DROP TABLE IF EXISTS `group_role_map`;

CREATE TABLE `group_role_map` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `GROUP_ID` bigint(20) NOT NULL,
  `ROLE_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_user_roles_map` (`ROLE_ID`),
  KEY `FK_GROUP_ID_UR` (`GROUP_ID`),
  CONSTRAINT `FK_GROUP_ID_UR` FOREIGN KEY (`GROUP_ID`) REFERENCES `user_group` (`ID`),
  CONSTRAINT `FK_user_roles_map` FOREIGN KEY (`ROLE_ID`) REFERENCES `user_role` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `group_role_map` */

insert  into `group_role_map`(`ID`,`GROUP_ID`,`ROLE_ID`) values 

(2,1,1),

(3,1,2),

(4,1,3),

(5,1,4),

(6,2,2),

(7,2,3),

(8,2,4),

(11,1,5),

(12,2,5);

/*Table structure for table `intern_log` */

DROP TABLE IF EXISTS `intern_log`;

CREATE TABLE `intern_log` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `SOURCE_IP` varchar(20) NOT NULL,
  `CASE_STATUS` varchar(20) NOT NULL COMMENT 'HDM,NETOP,MODEM_RESTART',
  `OPERATION_STATUS` varchar(20) NOT NULL COMMENT 'SUCCESS,NOT_SUCC.',
  `SPB_RESULT` varchar(20) DEFAULT NULL COMMENT 'SEND sonucu',
  `PTS_NAME` varchar(20) DEFAULT NULL,
  `OPERATION_START_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `OPERATION_TIME_IN_MILLIS` int(11) NOT NULL COMMENT 'islem suresi',
  `DEV_SESSION_INFO_ID` int(11) NOT NULL,
  `DEV_LOGIN_BEAN_ID` int(11) NOT NULL,
  `DEV_SESSION_ID` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`),
  FULLTEXT KEY `IP` (`SOURCE_IP`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `intern_log` */

insert  into `intern_log`(`ID`,`SOURCE_IP`,`CASE_STATUS`,`OPERATION_STATUS`,`SPB_RESULT`,`PTS_NAME`,`OPERATION_START_TIME`,`OPERATION_TIME_IN_MILLIS`,`DEV_SESSION_INFO_ID`,`DEV_LOGIN_BEAN_ID`,`DEV_SESSION_ID`) values

(3,'127.0.0.1','NETOP','OPERATION_FAILED',NULL,'pts1','2016-05-10 14:44:55',21687,1401785890,2026064469,'4A665B0EC355814F8DBD501628493E35'),

(4,'127.0.0.1','HDM','OPERATION_FAILED',NULL,'pts1','2016-05-10 14:45:22',22115,1401785890,2026064469,'4A665B0EC355814F8DBD501628493E35');

/*Table structure for table `user_group` */

DROP TABLE IF EXISTS `user_group`;

CREATE TABLE `user_group` (
  `ID` bigint(20) NOT NULL,
  `ACTIVE` tinyint(1) DEFAULT '1',
  `GROUP_NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_group` */

insert  into `user_group`(`ID`,`ACTIVE`,`GROUP_NAME`) values 

(1,1,'ADMIN'),

(2,1,'OPERATOR');

/*Table structure for table `user_group_map` */

DROP TABLE IF EXISTS `user_group_map`;

CREATE TABLE `user_group_map` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `GROUP_ID` bigint(20) NOT NULL,
  `USER_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_user_group_map` (`USER_ID`),
  KEY `FK_GROUP_ID_GM` (`GROUP_ID`),
  CONSTRAINT `FK_GROUP_ID_GM` FOREIGN KEY (`GROUP_ID`) REFERENCES `user_group` (`ID`),
  CONSTRAINT `FK_user_group_map` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `user_group_map` */

insert  into `user_group_map`(`ID`,`GROUP_ID`,`USER_ID`) values 

(1,1,1),

(2,2,29),

(3,1,32),

(7,2,36),

(9,2,38),

(10,1,40);

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ROLE_NAME` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

insert  into `user_role`(`ID`,`ROLE_NAME`) values 

(1,'ROLE_ADMIN'),

(2,'ROLE_IP_ADD'),

(3,'ROLE_IP_DELETE'),

(4,'ROLE_IP_READ'),

(5,'WEB_USER');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(255) NOT NULL,
  `FIRST_NAME` varchar(255) NOT NULL,
  `LAST_NAME` varchar(255) NOT NULL,
  `EMAIL` varchar(255) NOT NULL,
  `PASSWORD` varchar(32) NOT NULL,
  `ENABLED` int(11) unsigned NOT NULL,
  `LAST_PASS_CHANGE_DATE` date NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `EMAIL` (`EMAIL`),
  UNIQUE KEY `USER_NAME` (`USER_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`ID`,`USER_NAME`,`FIRST_NAME`,`LAST_NAME`,`EMAIL`,`PASSWORD`,`ENABLED`,`LAST_PASS_CHANGE_DATE`) values 

(1,'admin','admina','admin','oktaycekmez@gmail.com','JJnhhf42',1,'2016-02-22'),

(29,'operator','turksatab','turksat','turksat@1234.com','Test1234',1,'2016-01-13'),

(30,'reader','reader','reader','reader@1234.com','reader',1,'2016-01-13'),

(31,'nogroup','nogroup','nogroup','nogroup@1234.com','nogroup',1,'2016-01-13'),

(32,'kodsis','kodsis','kodsis','oktaycekmezi@gmail.com','Kodsis1234',1,'2016-02-05'),

(36,'testaa','testaa','testaa','testaa@gmail.com','Test1234',1,'2016-02-22'),

(38,'testa','testaaa','testa','testa@gmail.com','Test1234',1,'2016-02-22'),

(39,'testaaab','testaaaab','testaa','testaab@gmail.com','Test1234',1,'2016-02-22'),

(40,'testadf','testa','testa','asdaad@gsdg.com','Test12345',1,'2016-02-22'),

(41,'yrdy','yrdy','yrdy','yrdy@sadas.com','Test12345',1,'2016-02-22'),

(42,'gfsdf','gfsdf','gfsdf','gfsdf@adsfa.com','1234Test2',1,'2016-02-22'),

(43,'fdghl','fdghl','fdghl','fdghl@gmail.com','1234Tasdt2',1,'2016-02-22'),

(44,'testabc','testabc','testabc','testabc@asdasd.com','Sifre1234',1,'2016-02-22'),

(45,'asdada','asagfd','asdada','asdada@fasf.com','Sifre1234',1,'2016-02-22'),

(46,'testafads','testafads','testafads','testafads@gmail.com','Test12321',1,'2016-02-22'),

(47,'adminabc','adminabc','adminabc','adminabc@fasf.com','Bhudusd213',1,'2016-02-23'),

(48,'testayt','testayt','testayt','testayt@adssadas.com','Admin1234',1,'2016-02-23');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
