DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS books_users;
DROP TABLE IF EXISTS trade;


CREATE TABLE users (
    user_id INT NOT NULL,
    bond_holder VARCHAR(100) NOT NULL,
    type VARCHAR(50) NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE books (
    book_id INT NOT NULL,
    book_name VARCHAR(100) NOT NULL,
    status VARCHAR(50) NOT NULL,
    bond_maturity_date DATE,
    issuer_name VARCHAR(200) NOT NULL,
    isin VARCHAR(100) NOT NULL,
    face_value INT NOT NULL,
    cusip VARCHAR(100),
    bond_currency VARCHAR(100) NOT NULL,
    coupon_percent DOUBLE NOT NULL,
    unit_price DOUBLE NOT NULL,
    PRIMARY KEY (book_id)
);

CREATE TABLE books_users (
    bond_holder VARCHAR(250) NOT NULL,
    book_name VARCHAR(250) NOT NULL,
    PRIMARY KEY (bond_holder, book_name)
);


CREATE TABLE trade (
    trade_id int NOT NULL,
    trade_type VARCHAR(250) NOT NULL,
    book_name VARCHAR(100) NOT NULL,
    isin VARCHAR(100) NOT NULL,
    trade_currency VARCHAR(250) NOT NULL,
    trade_date DATE NOT NULL,
    trade_status VARCHAR(50) NOT NULL,
    trade_settlement_date DATE NOT NULL,
    quantity INT NOT NULL,
    trade_currency VARCHAR(50) NOT NULL,
    PRIMARY KEY (trade_id)
);


