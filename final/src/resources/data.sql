-- data input

INSERT INTO customer VALUES (1, "Henry Post", "HenryFBP@gmail.com", "youwillneverguess");
INSERT INTO customer VALUES (2, "Dennis Chase", "dchase3@hawk.iit.edu", "youmayguess");
INSERT INTO customer VALUES (3, "Admiral Ackbar", "Ackbar@gmail.com", "itsatrap");
INSERT INTO customer VALUES (4, "God", "BigG@heaven.gov", "trueadmin");

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