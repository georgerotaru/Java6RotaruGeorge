--create table to store eBook information
CREATE TABLE EBOOKS (ISBN VARCHAR(50) PRIMARY KEY, TITLE VARCHAR(50) NOT NULL, DESCRIPTION VARCHAR(1000), TYPE VARCHAR(25), PAGES INTEGER, GENRE VARCHAR(25), PRICE DOUBLE NOT NULL);

--create table to store available eBook format types
CREATE TABLE EBOOK_FORMAT(TYPE VARCHAR(25) PRIMARY KEY );
--insert two format types into EBOOK_FORMAT table
INSERT INTO EBOOK_FORMAT VALUES ('ePub');
INSERT INTO EBOOK_FORMAT VALUES ('pdf');

--create table to store available book genres
CREATE TABLE BOOK_GENRES(GENRE VARCHAR(25) PRIMARY KEY );
--insert genres into BOOK_GENRES table
INSERT INTO BOOK_GENRES VALUES ('Comedy');
INSERT INTO BOOK_GENRES VALUES ('Drama');
INSERT INTO BOOK_GENRES VALUES ('Horror');
INSERT INTO BOOK_GENRES VALUES ('Mystery');
INSERT INTO BOOK_GENRES VALUES ('Romance');
INSERT INTO BOOK_GENRES VALUES ('Satire');
INSERT INTO BOOK_GENRES VALUES ('Tragedy');
INSERT INTO BOOK_GENRES VALUES ('Tragicomedy');
INSERT INTO BOOK_GENRES VALUES ('Fantasy');
INSERT INTO BOOK_GENRES VALUES ('Mythology');
INSERT INTO BOOK_GENRES VALUES ('Adventure');
INSERT INTO BOOK_GENRES VALUES ('SF');
INSERT INTO BOOK_GENRES VALUES ('Crime');
INSERT INTO BOOK_GENRES VALUES ('Short story');

--create table to store which authors wrote a book, with primary key that autoincrements by 1 with every new entry
CREATE TABLE EBOOK_AUTHORS (ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY, ISBN VARCHAR(50), CNP VARCHAR(13));

--create table with list of book authors
CREATE TABLE AUTHORS (CNP VARCHAR(13) PRIMARY KEY, FIRST_NAME VARCHAR(30), LAST_NAME VARCHAR(30) NOT NULL);

--create table with rating values given by a user to a certain book, with primary key that autoincrements by 1 with every new entry
CREATE TABLE EBOOK_RATINGS (ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY, RATING VARCHAR(5), CNP VARCHAR(13), ISBN VARCHAR (50));

--create table with predefined book ratings
CREATE TABLE RATINGS (RATING VARCHAR(5) PRIMARY KEY);
INSERT INTO RATINGS VALUES ('*');
INSERT INTO RATINGS VALUES ('**');
INSERT INTO RATINGS VALUES ('***');
INSERT INTO RATINGS VALUES ('****');
INSERT INTO RATINGS VALUES ('*****');

--create table to store usernames, passwords and if the user has administrator rights on the website (with every username unique)
CREATE TABLE USERS (CNP VARCHAR (13) PRIMARY KEY, USERNAME VARCHAR(50), PASSWORD VARCHAR(50), IS_ADMIN BOOLEAN);

--create table to store order status for eBooks, with primary key that autoincrements by 1 with every new entry
CREATE TABLE ORDERS (ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY, ISBN VARCHAR(50), CNP VARCHAR(13), PRICE DOUBLE, STATUS VARCHAR(25));

--create table to store eBooks' order status
CREATE TABLE ORDER_STATUS (STATUS VARCHAR(25));
--insert three types of order statuses into ORDER_STATUS table
INSERT INTO ORDER_STATUS VALUES ('PENDING');
INSERT INTO ORDER_STATUS VALUES ('SOLD');
INSERT INTO ORDER_STATUS VALUES ('FAILED');