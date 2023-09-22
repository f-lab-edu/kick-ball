CREATE TABLE stadium (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) not null,
    address VARCHAR(100) not null,
    size VARCHAR(50) not null,
    guidelines CLOB,
    parking BOOLEAN not null,
    airConditioning BOOLEAN not null,
    showers BOOLEAN not null,
    ballRental BOOLEAN not null,
    vestRental BOOLEAN not null,
    shoesRental BOOLEAN not null
);
