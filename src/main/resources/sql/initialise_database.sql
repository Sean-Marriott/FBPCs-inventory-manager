DROP TABLE IF EXISTS parts;
--SPLIT
CREATE TABLE IF NOT EXISTS parts (
    partID INTEGER PRIMARY KEY AUTOINCREMENT,
    name VARCHAR(50),
    type VARCHAR(20),
    condition VARCHAR(15),
    price FLOAT,
    purchaseDate VARCHAR(15),
    warrantyDate VARCHAR(15),
    store VARCHAR(50),
    received INTEGER);
--SPLIT
