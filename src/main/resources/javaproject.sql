CREATE TABLE vehicles (
    vehicle_id VARCHAR(50) PRIMARY KEY,
    fuel_type VARCHAR(20),
    fuel_level DECIMAL(5,2)
);

INSERT INTO vehicles VALUES
('BUS001', 'Diesel', 75.0),
('TRAIN003', 'Electric', 15.0),
('LR002', 'Electric', 45.5),
('BUS002', 'Diesel', 10.0);