CREATE DATABASE IF NOT EXISTS test;

USE test;

DROP TABLE IF EXISTS Reviewer;
CREATE TABLE IF NOT EXISTS Reviewer (
	ReviewerID		INT			NOT NULL AUTO_INCREMENT,
    Name			VARCHAR(30)	NOT NULL,
    Address			VARCHAR(40)	NOT NULL,
    Affiliation		VARCHAR(30)	NOT NULL,
    
    PRIMARY KEY (ReviewerID),
    FOREIGN KEY (Address) REFERENCES AddressTable(AddressKey)
);
DESCRIBE Reviewer;


/*CREATE TABLE Movie(

);*/