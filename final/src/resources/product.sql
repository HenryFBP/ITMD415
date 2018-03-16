CREATE DATABASE IF NOT EXISTS itmd415;
USE itmd415;

-- DROP TABLE IF EXISTS product;
CREATE TABLE IF NOT EXISTS product (
    pid         INTEGER         NOT NULL UNIQUE AUTO_INCREMENT,
    ptid        INTEGER         NOT NULL,
    ownercid    INTEGER         NOT NULL,
    name        VARCHAR(64)     NOT NULL,
    price       INTEGER         NOT NULL,
    
    PRIMARY KEY    (pid),
    FOREIGN KEY    (ptid)       REFERENCES producttype(ptid),
    FOREIGN KEY    (ownercid)   REFERENCES customer(cid)
    
);

DESCRIBE product;