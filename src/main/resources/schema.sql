CREATE TABLE stadium (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
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

CREATE TABLE members (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) not null,
    password VARCHAR(50) not null,
    role VARCHAR(50) not null,
    provider VARCHAR(50) not null
);

CREATE TABLE reservations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    member_id BIGINT not null,
    stadium_id BIGINT not null,
    reservation_date DATE not null,
    start_time TIME not null,
    reservation_time INT not null,
    FOREIGN KEY (member_id) REFERENCES members (id),
    FOREIGN KEY (stadium_id) REFERENCES stadium (id)
);
