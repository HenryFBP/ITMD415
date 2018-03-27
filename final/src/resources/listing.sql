CREATE DATABASE IF NOT EXISTS itmd415;
USE itmd415;

-- DROP TABLE IF EXISTS listing;
CREATE TABLE IF NOT EXISTS listing (
    lid         INTEGER         NOT NULL UNIQUE AUTO_INCREMENT,
    pid         INTEGER         NOT NULL,
    buyercid    INTEGER         ,
    price       INTEGER         NOT NULL,
    
    PRIMARY KEY (lid),
    FOREIGN KEY (pid)           REFERENCES product(pid),
    FOREIGN KEY (buyercid)      REFERENCES customer(cid)
    
);

DESCRIBE listing;