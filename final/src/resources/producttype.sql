-- DROP TABLE IF EXISTS producttype;

CREATE TABLE IF NOT EXISTS producttype (
	ptid		INTEGER			NOT NULL UNIQUE,
	name		VARCHAR(64)		NOT NULL,

	PRIMARY KEY	(ptid)
);

DESCRIBE producttype;

INSERT INTO producttype VALUES (1, 'car');
INSERT INTO producttype VALUES (2, 'part');

SELECT * FROM producttype;