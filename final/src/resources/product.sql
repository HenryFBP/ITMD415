CREATE DATABASE IF NOT EXISTS itmd415;
USE itmd415;

-- DROP TABLE IF EXISTS product;
CREATE TABLE IF NOT EXISTS product (
    pid         INTEGER         NOT NULL UNIQUE AUTO_INCREMENT,
    ptid        INTEGER         NOT NULL,
    ownercid    INTEGER         NOT NULL,
    name        VARCHAR(64)     NOT NULL,
	carid       INTEGER         ,
	partid      INTEGER         ,
    
    PRIMARY KEY    (pid),
    FOREIGN KEY    (ownercid)   REFERENCES customer(cid),
    FOREIGN KEY    (ptid)       REFERENCES producttype(ptid),
    FOREIGN KEY    (carid)      REFERENCES car(carid),    
    FOREIGN KEY    (partid)     REFERENCES part(partid)    
);

DESCRIBE product;