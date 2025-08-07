DROP DATABASE IF EXISTS OOPProject;
CREATE DATABASE OOPProject;
use OOPProject;

-- Drop tables if they exist (in case you're not dropping the whole DB)
DROP TABLE IF EXISTS Fuel_Log;
DROP TABLE IF EXISTS GPS_Log;
DROP TABLE IF EXISTS Vehicle;

-- Create Vehicle table
CREATE TABLE Vehicle (
    vehicle_id INT PRIMARY KEY,
    type VARCHAR(50) NOT NULL,
    fuel_type VARCHAR(30) NOT NULL,
    max_passengers INT,
    route_id VARCHAR(20)
);

-- Create GPS_Log table
CREATE TABLE GPS_Log (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    vehicle_id INT,
    latitude DECIMAL(9,6) NOT NULL,
    longitude DECIMAL(9,6) NOT NULL,
    timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (vehicle_id) REFERENCES Vehicle(vehicle_id)
);

-- Create Fuel_Log table
CREATE TABLE Fuel_Log (
    id INT AUTO_INCREMENT PRIMARY KEY,
    vehicle_id INT,
    fuel_used DOUBLE NOT NULL,
    distance DOUBLE NOT NULL,
    timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (vehicle_id) REFERENCES Vehicle(vehicle_id)
);