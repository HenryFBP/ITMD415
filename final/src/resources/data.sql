-- data input

INSERT INTO customer VALUES (1, "HenryFBP", "HenryFBP@gmail.com", "pbkdf2sha1:64000:18:24:n:h1l08Agjw5onzudezyMDAu/dVN94We3b:sq3Y/F0CsaeHpK7pw49BAd+I"); -- youwillneverguess
INSERT INTO customer VALUES (2, "dchase", "dchase3@hawk.iit.edu", "pbkdf2sha1:64000:18:24:n:hh82TcSHudimd8whGG3DdJ7wegN6PcqH:CkoMEIu82FjAm35I1zmWG0q7"); -- youmayguess
INSERT INTO customer VALUES (3, "AdmiralAckbar", "Ackbar@gmail.com", "pbkdf2sha1:64000:18:24:n:Hy4GIW3CjqvlL3yW35aeQ3BbTZgvL6ZE:pe8rQHdVr43DiXNWzhP1Lkbw"); -- itsatrap
INSERT INTO customer VALUES (4, "God", "BigG@heaven.gov", "pbkdf2sha1:64000:18:24:n:jb5TMaeqwhLi7J66jBDvs3DuWQ2Wd1+T:HDA6gyEwFDJGo+8G6lKI97je"); -- trueadmin
SELECT * FROM customer;

INSERT INTO product VALUES (1, 2, 1, "Engine", 150);
INSERT INTO product VALUES (2, 1, 2, "Lexus", 50000);
INSERT INTO product VALUES (3, 2, 3, "Get out of jail free card", 50);
INSERT INTO product VALUES (4, 1, 4, "Cloud Car", 999999);
INSERT INTO product VALUES (5, 1, 2, "Death Star", 999999999);

INSERT INTO listing VALUES (1, 1, 1, null, null);
INSERT INTO listing VALUES (2, 2, 2, 4, null);
INSERT INTO listing VALUES (3, 3, 3, null, null);
INSERT INTO listing VALUES (4, 4, 4, 1, null);
INSERT INTO listing VALUES (5, 5, 2, 3, null);

INSERT INTO forum VALUES (1, 3, 3, 2018, "Help me out bro! I didn't know it was a trap!");
INSERT INTO forum VALUES (2, 5, 2, 2018, "I gotcha a Death Star?!?!");

SELECT * FROM customer;
SELECT * FROM producttype;
SELECT * FROM product;
SELECT * FROM listing;
SELECT * FROM forum;