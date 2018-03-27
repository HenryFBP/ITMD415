CREATE DATABASE IF NOT EXISTS itmd415;
USE itmd415;

-- DROP TABLE IF EXISTS car;
CREATE TABLE IF NOT EXISTS car (
    carid       INTEGER         NOT NULL UNIQUE AUTO_INCREMENT,
    make        VARCHAR(64)     NOT NULL,
    model       VARCHAR(64)     NOT NULL,
    miles       INTEGER         NOT NULL,
    year        INTEGER         NOT NULL,
    
    PRIMARY KEY (carid)
);

DESCRIBE car;