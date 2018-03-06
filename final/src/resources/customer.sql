-- DROP TABLE IF EXISTS customer;

CREATE TABLE IF NOT EXISTS customer (
    cid         INTEGER         NOT NULL UNIQUE,
    username    VARCHAR(64)     NOT NULL UNIQUE,
    email       VARCHAR(64)     NOT NULL UNIQUE,
    passhash    VARCHAR(64)     NOT NULL,
    
    PRIMARY KEY (cid)
);

DESCRIBE customer;