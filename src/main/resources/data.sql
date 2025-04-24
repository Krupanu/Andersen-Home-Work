INSERT INTO SpaceRental.user
VALUES (1,'admin@test.com','Admin','Test','$2a$10$5TBQSyLUhDmepe1Li7M3/uIUg40dUsPqoRU01ENRlcU93.BEo0gCu','ADMIN'),
       (2,'customer@test.com','Customer','Test','$2a$10$5TBQSyLUhDmepe1Li7M3/uIUg40dUsPqoRU01ENRlcU93.BEo0gCu','CUSTOMER');

INSERT INTO SpaceRental.spaces
VALUES (1,false,  'Conference Room for 10 people',100, 'UNAVAILABLE', 'Conference Room'),
       (2, false,  'Meeting Room for 5 people',50, 'UNAVAILABLE', 'Meeting Room'),
       (3, false,  'Office Space for 1 person', 20, 'AVAILABLE', 'Office Space');

INSERT INTO SpaceRental.user_reservations
VALUES (1,1),
       (2,2);