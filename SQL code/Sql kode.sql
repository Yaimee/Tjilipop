create database if not exists tjili-pop;

use tjili-pop;
drop table if exists`beer`;
drop table if exists`vin`;
drop table if exists`login`;
drop table if exists`uden_alkohol`;
drop table if exists`spiritus`;
drop table if exists`mad`;
drop table if exists`events`;

CREATE TABLE IF NOT EXIST `beer` (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  price int NOT NULL,
  procent double NOT NULL,
  origin varchar(45) NOT NULL,
  description varchar(200) NOT NULL,
  image_URL varchar(2000) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXIST `vin` (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  price varchar(45) NOT NULL,
  procent varchar(45) NOT NULL,
  origin varchar(45) NOT NULL,
  description varchar(45) NOT NULL,
  image_URL varchar(2000) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXIST `login` (
  username varchar(30) NOT NULL,
  password varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXIST `uden_alkohol` (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  price varchar(45) NOT NULL,
  procent varchar(45) NOT NULL,
  origin varchar(45) NOT NULL,
  description varchar(200) NOT NULL,
  image_URL varchar(2000) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXIST `spiritus` (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  price varchar(45) NOT NULL,
  procent varchar(45) NOT NULL,
  origin varchar(45) NOT NULL,
  description varchar(200) NOT NULL,
  image_URL varchar(2000) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXIST `mad` (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  price varchar(45) NOT NULL,
  procent varchar(45) NOT NULL,
  origin varchar(45) NOT NULL,
  description varchar(200) NOT NULL,
  image_URL varchar(2000) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXIST `events` (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  date date NOT NULL,
  time varchar(45) NOT NULL,
  info varchar(200) NOT NULL,
  image_URL varchar(2000) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `tjili-pop`.`beer` (`id`,`name`,`price`,`procent`,`origin`,`description`,`image_URL`) VALUES (2,'Stout',NULL,8,'England','A fine brew','https://i.imgur.com/wpFtGjP.jpg');
INSERT INTO `tjili-pop`.`beer` (`id`,`name`,`price`,`procent`,`origin`,`description`,`image_URL`) VALUES (5,'Guiness',NULL,8,'England','A fine brew','https://i.imgur.com/qg0BRdt.jpg');
INSERT INTO `tjili-pop`.`beer` (`id`,`name`,`price`,`procent`,`origin`,`description`,`image_URL`) VALUES (9,'Tuborg',NULL,4.5,'Denmark','A good brew','https://i.imgur.com/tnrI7Cz.jpg');

INSERT INTO `tjili-pop`.`events` (`id`,`name`,`date`,`time`,`info`,`image_URL`) VALUES (1,'Metallica','2022-05-11','18:00','Det bliver kanon','https://i.imgur.com/QC58WTX.jpg');
INSERT INTO `tjili-pop`.`events` (`id`,`name`,`date`,`time`,`info`,`image_URL`) VALUES (2,'Kiss','2022-05-10','18:16','De spiller godt','https://i.imgur.com/AEGG8kA.jpg');
INSERT INTO `tjili-pop`.`events` (`id`,`name`,`date`,`time`,`info`,`image_URL`) VALUES (3,'Led Zeppelin','2022-05-12','12:30','De er bare så gode','https://i.imgur.com/Azts2Ro.jpg');
INSERT INTO `tjili-pop`.`events` (`id`,`name`,`date`,`time`,`info`,`image_URL`) VALUES (4,'The Wailers','2022-07-12','15:40','Hold da op vi glæder os','https://i.imgur.com/KQSRFWA.jpg');
INSERT INTO `tjili-pop`.`events` (`id`,`name`,`date`,`time`,`info`,`image_URL`) VALUES (5,'Die Antwort','2022-05-12','14:30','Det bliver fjong','https://i.imgur.com/fBzfEkA.jpg');
