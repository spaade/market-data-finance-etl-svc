CREATE TABLE stock
(
    id            SERIAL PRIMARY KEY,
    symbol        VARCHAR(10)  NOT NULL,
    name          VARCHAR(100) NOT NULL,
    currency      VARCHAR(10)  NOT NULL,
    stockexchange VARCHAR(50)  NOT NULL,
    quote         VARCHAR(100) NOT NULL,
    stats         VARCHAR(100) NOT NULL,
    dividend      VARCHAR(200) NOT NULL
);

INSERT INTO stock (symbol, name, currency, stockexchange, quote, stats, dividend)
VALUES ('INTC', 'Intel Corporation', 'USD', 'NasdaqNM', 'Ask: 32.25, Bid: 32.24, Price: 32.2485, Prev close: 33.62',
        'EPS: 2.019, PE: 16.65, PEG: 1.74',
        'Pay date: Mon Dec 01 06:00:00 CET 2014, Ex date: Tue Aug 05 06:00:00 CEST 2014, Annual yield: 2.68%');
