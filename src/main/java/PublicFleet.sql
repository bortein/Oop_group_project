/**
 * Author:  Patricia Sunday
 */

DROP DATABASE IF EXISTS PublicFleet;
CREATE DATABASE PublicFleet;

USE PublicFleet;

CREATE TABLE Users(
    ID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    FullName VARCHAR(250) NOT NULL,
    Email VARCHAR(254) UNIQUE NOT NULL,
    Password VARCHAR(65) NOT NULL,
    UserType ENUM('MANAGER', 'OPERATOR') NOT NULL
);

CREATE TABLE Vehicles(
    ID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    IDNumber VARCHAR(45) UNIQUE NOT NULL,
    VehicleType ENUM('DIESEL_BUS','ELECTRIC_LIGHT_RAIL','DIESEL_ELECTRIC_TRAIN') NOT NULL,
    FuelType VARCHAR(45) NOT NULL,
    ConsumptionRate DECIMAL(4,2) NOT NULL,
    MaxPassengers INT NOT NULL,
    Route VARCHAR(60) NOT NULL
);

/*test records*/
INSERT INTO Users(FullName, Email, Password, UserType)
    VALUES('Patricia Sunday', 'sund0058@algonquinlive.com', 'password', 'MANAGER');

INSERT INTO Users(FullName, Email, Password, UserType)
    VALUES('Pat Sund', 'patriciasnsunday@outlook.com', 'password', 'OPERATOR');

INSERT INTO Vehicles(IDNumber, VehicleType, FuelType, ConsumptionRate, MaxPassengers, Route)
    VALUES('Bus589', 'DIESEL_BUS', 'Diesel', 18.4, '50', 'Baseline to Bayshore');