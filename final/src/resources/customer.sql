-- DROP TABLE IF EXISTS customer;

CREATE TABLE IF NOT EXISTS customer (
	cid			INTEGER			NOT NULL UNIQUE,
	username	VARCHAR(64)		NOT NULL UNIQUE,
	email		VARCHAR(64)		NOT NULL UNIQUE,
	passhash	BINARY(64)		NOT NULL,			-- this is 64 because 512 bits is 64 bytes. SHA-512 hashes to 64 bytes.
	
	PRIMARY KEY (cid)
);

DESCRIBE customer;