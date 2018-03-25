CREATE DATABASE IF NOT EXISTS itmd415;
USE itmd415;

-- DROP TABLE IF EXISTS part;
CREATE TABLE IF NOT EXISTS part (
    partid      INTEGER         NOT NULL UNIQUE AUTO_INCREMENT,
    make        VARCHAR(64)     ,
    model       VARCHAR(64)     ,
    condition   VARCHAR(64)     ,
    
    PRIMARY KEY (partid)
);

DESCRIBE part;