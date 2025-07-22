INSERT INTO app_user ( email ,name, password, role) VALUES
 (  'admin@gmail.com', 'admin name','$2a$10$bs4N952Qn9pqQQg/TWqYW.1mfxMd8pTMtm56oqe33iTiub28zB/I2', 'ADMIN');

INSERT INTO app_user ( email ,name, password, role) VALUES
    (  'owner1@gmail.com', 'owner1 name','$2a$10$bs4N952Qn9pqQQg/TWqYW.1mfxMd8pTMtm56oqe33iTiub28zB/I2', 'OWNER'),
    (  'owner2@gmail.com', 'owner2 name','$2a$10$bs4N952Qn9pqQQg/TWqYW.1mfxMd8pTMtm56oqe33iTiub28zB/I2', 'OWNER');

INSERT INTO app_user ( email ,name, password, role) VALUES
    (  'customer1@gmail.com', 'customer1 name','$2a$10$bs4N952Qn9pqQQg/TWqYW.1mfxMd8pTMtm56oqe33iTiub28zB/I2', 'CUSTOMER'),
    (  'customer2@gmail.com', 'customer2 name','$2a$10$bs4N952Qn9pqQQg/TWqYW.1mfxMd8pTMtm56oqe33iTiub28zB/I2', 'CUSTOMER'),
    (  'customer3@gmail.com', 'customer3 name','$2a$10$bs4N952Qn9pqQQg/TWqYW.1mfxMd8pTMtm56oqe33iTiub28zB/I2', 'CUSTOMER'),
    (  'customer4@gmail.com', 'customer4 name','$2a$10$bs4N952Qn9pqQQg/TWqYW.1mfxMd8pTMtm56oqe33iTiub28zB/I2', 'CUSTOMER'),
    (  'customer5@gmail.com', 'customer5 name','$2a$10$bs4N952Qn9pqQQg/TWqYW.1mfxMd8pTMtm56oqe33iTiub28zB/I2', 'CUSTOMER'),
    (  'customer6@gmail.com', 'customer6 name','$2a$10$bs4N952Qn9pqQQg/TWqYW.1mfxMd8pTMtm56oqe33iTiub28zB/I2', 'CUSTOMER'),
    (  'customer7@gmail.com', 'customer7 name','$2a$10$bs4N952Qn9pqQQg/TWqYW.1mfxMd8pTMtm56oqe33iTiub28zB/I2', 'CUSTOMER'),
    (  'customer8@gmail.com', 'customer8 name','$2a$10$bs4N952Qn9pqQQg/TWqYW.1mfxMd8pTMtm56oqe33iTiub28zB/I2', 'CUSTOMER'),
    (  'customer9@gmail.com', 'customer9 name','$2a$10$bs4N952Qn9pqQQg/TWqYW.1mfxMd8pTMtm56oqe33iTiub28zB/I2', 'CUSTOMER'),
    (  'customer10@gmail.com', 'customer10 name','$2a$10$bs4N952Qn9pqQQg/TWqYW.1mfxMd8pTMtm56oqe33iTiub28zB/I2', 'CUSTOMER');

INSERT INTO house (address) VALUES
    ('address 1'),
    ('address 2'),
    ('address 3'),
    ('address 4'),
    ('address 5'),
    ('address 6'),
    ('address 7'),
    ('address 8'),
    ('address 9'),
    ('address 10');


-- Owner 2 owns houses 1 to 5
INSERT INTO owner_house (owner_id, house_id) VALUES
    (2, 1),
    (2, 2),
    (2, 3),
    (2, 4),
    (2, 5);


-- Owner 3 owns houses 6 to 10
INSERT INTO owner_house (owner_id, house_id) VALUES
    (3, 6),
    (3, 7),
    (3, 8),
    (3, 9),
    (3, 10);


INSERT INTO customer_house_rented (customer_id,house_id,rented_from,rented_to) VALUES
-- Customer 4 rents houses 1, 2, and 3
  (4, 1, '2025-01-01 10:00:00', '2025-12-31 10:00:00'),
  (4, 2, '2025-01-01 10:00:00', '2025-12-31 10:00:00'),
  (4, 3, '2025-01-01 10:00:00', '2025-12-31 10:00:00'),

-- Customer 5 rents houses 4 and 5
  (5, 4, '2025-02-01 10:00:00', '2025-12-31 10:00:00'),
  (5, 5, '2025-02-01 10:00:00', '2025-12-31 10:00:00'),

-- Customer 6 rents houses 6, 7, and 8
  (6, 6, '2025-03-01 10:00:00', '2025-12-31 10:00:00'),
  (6, 7, '2025-03-01 10:00:00', '2025-12-31 10:00:00'),
  (6, 8, '2025-03-01 10:00:00', '2025-12-31 10:00:00'),

-- Customer 7 rents houses 9 and 10
  (7, 9, '2025-04-01 10:00:00', '2025-12-31 10:00:00'),
  (7, 10, '2025-04-01 10:00:00', '2025-12-31 10:00:00'),

-- Customer 8 rents house 1
  (8, 1, '2025-05-01 10:00:00', '2025-12-31 10:00:00'),

-- Customer 9 rents houses 2, 4, and 6
  (9, 2, '2025-06-01 10:00:00', '2025-12-31 10:00:00'),
  (9, 4, '2025-06-01 10:00:00', '2025-12-31 10:00:00'),
  (9, 6, '2025-06-01 10:00:00', '2025-12-31 10:00:00'),

-- Customer 10 rents house 5
  (10, 5, '2025-07-01 10:00:00', '2025-12-31 10:00:00'),

-- Customer 11 rents houses 3 and 7
  (11, 3, '2025-08-01 10:00:00', '2025-12-31 10:00:00'),
  (11, 7, '2025-08-01 10:00:00', '2025-12-31 10:00:00'),

-- Customer 12 rents houses 6 and 10
  (12, 6, '2025-09-01 10:00:00', '2025-12-31 10:00:00'),
  (12, 10, '2025-09-01 10:00:00', '2025-12-31 10:00:00'),

-- Customer 13 rents houses 8 and 9
  (13, 8, '2025-10-01 10:00:00', '2025-12-31 10:00:00'),
  (13, 9, '2025-10-01 10:00:00', '2025-12-31 10:00:00');


