DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS books_users;
DROP TABLE IF EXISTS trade;

CREATE TABLE users (
    userId INT NOT NULL AUTO_INCREMENT,
    bondHolder VARCHAR(100) NOT NULL,
    type VARCHAR(50) NOT NULL,
    PRIMARY KEY (userId)
);

CREATE TABLE books (
    bookId INT NOT NULL AUTO_INCREMENT,
    bookName VARCHAR(100) NOT NULL,
    status VARCHAR(50) NOT NULL,
    bondMaturityDate DATE,
    issuerName VARCHAR(200) NOT NULL,
    isin VARCHAR(100) NOT NULL,
    faceValue INT NOT NULL,
    cusip VARCHAR(100),
    bondCurrency VARCHAR(100) NOT NULL,
    couponPercent DOUBLE NOT NULL,
    unitPrice DOUBLE NOT NULL,
    PRIMARY KEY (bookId)
);

CREATE TABLE books_users (
    bondHolder VARCHAR(250) NOT NULL,
    bookName VARCHAR(250) NOT NULL,
    PRIMARY KEY (bondHolder, bookName)
);


CREATE TABLE trade (
    tradeId int NOT NULL AUTO_INCREMENT,
    tradeType VARCHAR(250) NOT NULL,
    bookName VARCHAR(100) NOT NULL,
    isin VARCHAR(100) NOT NULL,
    tradeCurrency VARCHAR(250) NOT NULL,
    tradeDate DATE NOT NULL,
    tradeStatus VARCHAR(50) NOT NULL,
    tradeSettlementDate DATE NOT NULL,
    quantity INT NOT NULL,
    PRIMARY KEY (tradeId)
);


