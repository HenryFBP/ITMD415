CREATE SCHEMA IF NOT EXISTS ITMD415;
USE ITMD415;

CREATE TABLE IF NOT EXISTS users (
	userID int NOT NULL AUTO_INCREMENT,
    userName varchar(45) NOT NULL,
    userPassword varchar(45) NOT NULL,
    userDoB date,
    PRIMARY KEY (userID)
);

CREATE TABLE IF NOT EXISTS buyers (
	buyerID int NOT NULL,
    creditCard varchar(45) NOT NULL,
    PRIMARY KEY (buyerID, creditCard),
    FOREIGN KEY (buyerID)
		REFERENCES users(userID)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS sellers (
	sellerID int NOT NULL,
    bankAccount varchar(45) NOT NULL,
    PRIMARY KEY (sellerID, bankAccount),
    FOREIGN KEY (sellerID)
		REFERENCES users(userID)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS cars (
	carID int NOT NULL AUTO_INCREMENT,
    carModel varchar(45),
    carCost double NOT NULL,
    sellersID int,
    PRIMARY KEY (carID),
    FOREIGN KEY (sellersID)
		REFERENCES sellers(sellerID)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS parts (
	partID int NOT NULL AUTO_INCREMENT,
    partName varchar(65),
    partCost double NOT NULL,
    sellersID int,
    PRIMARY KEY (partID),
    FOREIGN KEY (sellersID)
		REFERENCES sellers(sellerID)
        ON DELETE CASCADE
);