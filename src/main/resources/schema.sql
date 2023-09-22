CREATE TABLE members (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) not null,
    password VARCHAR(50) not null,
    role VARCHAR(50) not null,
    provider VARCHAR(50) not null
)