-- DROP TABLE IF EXISTS forum;

CREATE TABLE IF NOT EXISTS forum (
	fid			INTEGER			NOT NULL UNIQUE,
	lid			INTEGER			NOT NULL,
	postercid	INTEGER			NOT NULL,
	date		INTEGER			NOT NULL,
	message		VARCHAR(512)	NOT NULL,
	
	PRIMARY KEY	(fid),
	FOREIGN KEY	(lid)			REFERENCES listing(lid),
	FOREIGN KEY	(postercid)		REFERENCES customer(cid)
);

DESCRIBE forum;