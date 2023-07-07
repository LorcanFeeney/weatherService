# weatherService
Weather Service API

I chose to use a Postgres database.

**Run these database scripts **

-- Create the "weather" database
CREATE DATABASE weather;

-- Create a "sensors" table to store sensor information
CREATE TABLE sensors (
    id       SERIAL PRIMARY KEY,
    name     VARCHAR(100) NOT NULL,
    location VARCHAR(100) NOT NULL,
    type     VARCHAR(100) NOT NULL
);

-- Create the "measurements" table
CREATE TABLE measurements (
    time         TIMESTAMPTZ       NOT NULL,
    sensor_id    INTEGER           NOT NULL,
    location     VARCHAR(100)      NOT NULL,
    temperature  DOUBLE PRECISION  NULL,
    humidity     DOUBLE PRECISION  NULL,
    wind_speed   DOUBLE PRECISION  NULL,
    rainfall     DOUBLE PRECISION  NULL,
    -- Add more columns as needed for other weather data

    -- Primary key
    CONSTRAINT measurements_pkey PRIMARY KEY (time, sensor_id),

    -- Foreign key for sensor_id referencing a "sensors" table
    CONSTRAINT fk_sensor_id FOREIGN KEY (sensor_id) REFERENCES sensors (id)
);

-- Insert sample sensor data
INSERT INTO sensors (name, location, type)
VALUES 
  ('Rainfall Sensor 1 Limerick', 'Limerick', 'Rainfall'),
  ('Temperature Sensor 1 Limerick', 'Limerick', 'Temperature'),
  ('Wind Sensor 1 Limerick', 'Limerick', 'Wind'),

  ('Rainfall Sensor 2 Galway', 'Galway', 'Rainfall'),
  ('Temperature Sensor 2 Galway', 'Galway', 'Temperature'),
  ('Wind Sensor 2 Galway', 'Galway', 'Wind'),

  ('Rainfall Sensor 3 Dublin', 'Dublin', 'Rainfall'),
  ('Temperature Sensor 3 Dublin', 'Dublin', 'Temperature'),
  ('Wind Sensor 3 Dublin', 'Dublin', 'Wind'),

  ('Rainfall Sensor 4 Cork', 'Cork', 'Rainfall'),
  ('Temperature Sensor 4 Cork', 'Cork', 'Temperature'),
  ('Wind Sensor 4 Cork', 'Cork', 'Wind');

-- Insert a sample weather measurement from Rainfall Sensor 1 Limerick
INSERT INTO measurements (time, sensor_id, location, rainfall)
VALUES ('2023-07-06 10:00:00', 1, 'Limerick', 12.5);

-- Insert a sample weather measurement from Temperature Sensor 1 Limerick
INSERT INTO measurements (time, sensor_id, location, temperature)
VALUES ('2023-07-06 10:00:00', 2, 'Limerick', 25.5);

-- Insert a sample weather measurement from Wind Sensor 1 Limerick
INSERT INTO measurements (time, sensor_id, location, wind_speed)
VALUES ('2023-07-06 10:00:00', 3, 'Limerick', 10.2);

-- Insert a sample weather measurement from Rainfall Sensor 2 Galway
INSERT INTO measurements (time, sensor_id, location, rainfall)
VALUES ('2023-07-06 10:00:00', 4, 'Galway', 8.2);

-- Insert a sample weather measurement from Temperature Sensor 2 Galway
INSERT INTO measurements (time, sensor_id, location, temperature)
VALUES ('2023-07-06 10:00:00', 5, 'Galway', 24.8);

-- Insert a sample weather measurement from Wind Sensor 2 Galway
INSERT INTO measurements (time, sensor_id, location, wind_speed)
VALUES ('2023-07-06 10:00:00', 6, 'Galway', 9.5);

-- Insert a sample weather measurement from Rainfall Sensor 3 Dublin
INSERT INTO measurements (time, sensor_id, location, rainfall)
VALUES ('2023-07-06 10:00:00', 7, 'Dublin', 10.2);

-- Insert a sample weather measurement from Temperature Sensor 3 Dublin
INSERT INTO measurements (time, sensor_id, location, temperature)
VALUES ('2023-07-06 10:00:00', 8, 'Dublin', 25.5);

-- Insert a sample weather measurement from Wind Sensor 3 Dublin
INSERT INTO measurements (time, sensor_id, location, wind_speed)
VALUES ('2023-07-06 10:00:00', 9, 'Dublin', 10.2);

-- Insert a sample weather measurement from Rainfall Sensor 4 Cork
INSERT INTO measurements (time, sensor_id, location, rainfall)
VALUES ('2023-07-06 10:00:00', 10, 'Cork', 8.2);

-- Insert a sample weather measurement from Temperature Sensor 4 Cork
INSERT INTO measurements (time, sensor_id, location, temperature)
VALUES ('2023-07-06 10:00:00', 11, 'Cork', 24.8);

-- Insert a sample weather measurement from Wind Sensor 4 Cork
INSERT INTO measurements (time, sensor_id, location, wind_speed)
VALUES ('2023-07-06 10:00:00', 12, 'Cork', 9.5);


NOTE: make sure to change the data source credentials in the application properties file to the details you have set in your database.

Once the application is connected to the data source and running, you can try to run the following in Insomnia or Postman:


GET REQUEST - http://localhost:8080/api/sensors
This should retrieve all sensors

POST REQUEST - http://localhost:8080/api/sensors
Body: {
  "name": "Noise Sensor",
  "location": "Living Room",
  "type": "Noise level"
}
This should add a new sensor to the database

GET REQUEST - http://localhost:8080/api/weatherData/{location}
This will retrieve weather data in the database for the particular location

