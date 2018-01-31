INSERT INTO AUTHORS VALUES ('5061756612048', 'Paula', 'Hawkins');

INSERT INTO EBOOKS VALUES ('978-606-719-419-7', 'Fata din tren', '#1 New York Times Bestseller\nBestseller absolut in Marea Britanie
Tu nu o cunosti.
Dar ea te cunoaste.
Peste 1,8 milioane de exemplare vandute in doar patru luni, in Statele Unite.', 'ePub', 408, 'Fantasy', 20.99);
INSERT INTO EBOOKS VALUES ('978-606-719-418-0', 'Fata din tren', '#1 New York Times Bestseller
Bestseller absolut in Marea Britanie
Tu nu o cunosti.
Dar ea te cunoaste.
Peste 1,8 milioane de exemplare vandute in doar patru luni, in Statele Unite.', 'pdf', 408, 'Fantasy', 19);

INSERT INTO EBOOK_AUTHORS(ISBN, CNP) VALUES ('978-606-719-419-7', '5061756612048');
INSERT INTO EBOOK_AUTHORS(ISBN, CNP) VALUES ('978-606-719-418-0', '5061756612048');

INSERT INTO USERS VALUES ('6164669669737', 'admin', '1234', true);
INSERT INTO USERS VALUES ('6765672676572', 'georger', '1234', false);

INSERT INTO EBOOK_RATINGS(RATING, CNP, ISBN) VALUES ('*****', '6164669669737', '978-606-719-418-0');
INSERT INTO EBOOK_RATINGS(RATING, CNP, ISBN) VALUES ('****', '6765672676572', '978-606-719-418-0');