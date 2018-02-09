CREATE DATABASE IF NOT EXISTS testdb;

USE testdb;

--DROP TABLE IF EXISTS comment;
CREATE TABLE IF NOT EXISTS comment (
   comment_id 		INT 		NOT NULL AUTO_INCREMENT,
   name 			VARCHAR(64) NOT NULL,
   content			TEXT 		NOT NULL,
   date     		BIGINT 		NOT NULL,

   PRIMARY KEY (comment_id)
);

DESCRIBE comment;
SELECT * FROM comment;

--DROP TABLE IF EXISTS user;
CREATE TABLE IF NOT EXISTS user (
	user_id			INT			NOT NULL AUTO_INCREMENT,
	name			VARCHAR(64) NOT NULL,
	email			VARCHAR(64) NOT NULL,
	password		VARCHAR(64) NOT NULL,
	dob				BIGINT		NOT NULL,
	
	PRIMARY KEY (user_id)
);

DESCRIBE user
SELECT * FROM user;