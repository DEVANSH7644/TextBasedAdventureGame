CREATE DATABASE adventure_game_db;
USE adventure_game_db;

CREATE TABLE players (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    health INT DEFAULT 100,
    location VARCHAR(50) DEFAULT 'Starting Room',
    inventory TEXT
);

