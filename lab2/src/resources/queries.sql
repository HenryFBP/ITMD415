--USING testdb;

CREATE DATABASE IF NOT EXISTS testdb;


DROP TABLE comment;

CREATE TABLE IF NOT EXISTS comment (
   comment_id 		INT 		NOT NULL AUTO_INCREMENT,
   name 			VARCHAR(64) NOT NULL,
   content			TEXT 		NOT NULL,
   date     		BIGINT 		NOT NULL,
   PRIMARY KEY (comment_id)
);

DESCRIBE comment;
SELECT * FROM comment;