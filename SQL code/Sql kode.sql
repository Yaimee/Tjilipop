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
  imgURL varchar(2000) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXIST `vin` (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  price varchar(45) NOT NULL,
  procent varchar(45) NOT NULL,
  origin varchar(45) NOT NULL,
  description varchar(45) NOT NULL,
  imgURL varchar(2000) NOT NULL,
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
  imgURL varchar(2000) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXIST `spiritus` (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  price varchar(45) NOT NULL,
  procent varchar(45) NOT NULL,
  origin varchar(45) NOT NULL,
  description varchar(200) NOT NULL,
  imgURL varchar(2000) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXIST `mad` (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  price varchar(45) NOT NULL,
  procent varchar(45) NOT NULL,
  origin varchar(45) NOT NULL,
  description varchar(200) NOT NULL,
  imgURL varchar(2000) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXIST `events` (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  date date NOT NULL,
  time varchar(45) NOT NULL,
  info varchar(200) NOT NULL,
  imgURL varchar(2000) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;