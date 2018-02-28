-- DROP TABLE IF EXISTS producttype;

CREATE TABLE IF NOT EXISTS producttype (
	ptype		INTEGER			NOT NULL UNIQUE,
	name		VARCHAR(64)		NOT NULL,

	PRIMARY KEY	(ptype)
);

DESCRIBE producttype;

INSERT INTO producttype VALUES (1, 'car');
INSERT INTO producttype VALUES (2, 'part');

SELECT * FROM producttype;