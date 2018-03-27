CREATE DATABASE IF NOT EXISTS itmd415;
USE itmd415;

INSERT INTO producttype VALUES (1, "car");
INSERT INTO producttype VALUES (2, "part");

INSERT INTO customer VALUES (1, "HenryFBP", "HenryFBP@gmail.com", "pbkdf2sha1:64000:18:24:n:h1l08Agjw5onzudezyMDAu/dVN94We3b:sq3Y/F0CsaeHpK7pw49BAd+I"); -- youwillneverguess
INSERT INTO customer VALUES (2, "dchase", "dchase3@hawk.iit.edu", "pbkdf2sha1:64000:18:24:n:hh82TcSHudimd8whGG3DdJ7wegN6PcqH:CkoMEIu82FjAm35I1zmWG0q7"); -- youmayguess
INSERT INTO customer VALUES (3, "AdmiralAckbar", "Ackbar@gmail.com", "pbkdf2sha1:64000:18:24:n:Hy4GIW3CjqvlL3yW35aeQ3BbTZgvL6ZE:pe8rQHdVr43DiXNWzhP1Lkbw"); -- itsatrap
INSERT INTO customer VALUES (4, "God", "BigG@heaven.gov", "pbkdf2sha1:64000:18:24:n:jb5TMaeqwhLi7J66jBDvs3DuWQ2Wd1+T:HDA6gyEwFDJGo+8G6lKI97je"); -- trueadmin
INSERT INTO customer VALUES (5, "vader", "vader@death.star", "pbkdf2sha1:64000:18:24:n:8/4CUieFhpGhZBKGl7CIYH5pcw5AnoY1:K4rTownyEoyHtUq2/q2Y0DYt"); -- vaderrules
INSERT INTO customer VALUES (6, "a", "a@a.a", "pbkdf2sha1:64000:18:24:n:edRQbyWWL/fvt2f3Rq3kQSKFlbv+nqqn:tksEGPJN0jNnSNCYvCmlPL7Q"); -- a

INSERT INTO car VALUES (1, "Ford", "Fiesta", 10000, 1997); -- henry's ford fiesta
INSERT INTO car VALUES (2, "Lexus", "CT", 20000, 1994); -- dennis' lexus CT
INSERT INTO car VALUES (3, "Godco", "Godmobile", 90000, 0); -- god's car
INSERT INTO car VALUES (4, "Resistance", "Tie Fighter", 900000, 2020); -- ackbar's tie fighter
INSERT INTO car VALUES (5, "Generico", "Genericar", 100, 2000); -- a's generic car

INSERT INTO part VALUES (1, "Ford", "Fiesta", "Tire", "New"); -- henry's ford fiesta tire
INSERT INTO part VALUES (2, "Ford", "Fiesta", "Engine", "Good"); -- henry's ford fiesta engine
INSERT INTO part VALUES (3, "Godco", "Godmobile", "Jesus Juice", "Holy"); -- god's jesus juice
INSERT INTO part VALUES (4, "Resistance", "Tie Fighter", "Blaster", "Ok"); -- ackbar's blaster

--                          pk | type | owner | car  |  part | product name     |
INSERT INTO product VALUES (1,    1,      1,      1  ,  NULL,  "New Ford Fiesta");
INSERT INTO product VALUES (2,    1,      2,      2  ,  NULL,  "Good Lexus CT");
INSERT INTO product VALUES (3,    1,      4,      3  ,  NULL,  "God's Car");
INSERT INTO product VALUES (4,    1,      3,      4  ,  NULL,  "Tie Fighter");
INSERT INTO product VALUES (5,    1,      6,      5  ,  NULL,  "Genericar v1.0");
INSERT INTO product VALUES (6,    2,      1,     NULL,   1  ,  "New Ford Fiesta Tire");
INSERT INTO product VALUES (7,    2,      1,     NULL,   2  ,  "Good Ford Fiesta Engine");
INSERT INTO product VALUES (8,    2,      4,     NULL,   3  ,  "Fresh Jesus Juice");
INSERT INTO product VALUES (9,    2,      3,     NULL,   4  ,  "OK Tie Blaster");

--                          pk | product id | buyer | price |
INSERT INTO listing VALUES (1,       1,       NULL,   20000);
INSERT INTO listing VALUES (2,       2,       NULL,   10000);

-- INSERT INTO forum VALUES (1, 3, 3, 2018, "Help me out bro! I didn't know it was a trap!");
-- INSERT INTO forum VALUES (2, 5, 2, 2018, "I gotcha a Death Star?!?!");

SELECT * FROM customer;
SELECT * FROM car;
SELECT * FROM part;
SELECT * FROM producttype;
SELECT * FROM product;
SELECT * FROM listing;
SELECT * FROM forum;