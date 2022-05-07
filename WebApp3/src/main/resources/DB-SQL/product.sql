-- DDL for schema online_shop_pc

DROP SCHEMA IF EXISTS online_shop_product;
CREATE SCHEMA IF NOT EXISTS online_shop_product;

DROP TABLE IF EXISTS online_shop_product.product_db, online_shop_product.product_image_db;
CREATE TABLE IF NOT EXISTS online_shop_product.product_db
(
    id          INT           NOT NULL AUTO_INCREMENT UNIQUE,
    brand       VARCHAR(100)  NOT NULL,
    model       VARCHAR(100)  NOT NULL,
    type        VARCHAR(50)   NOT NULL,
    description VARCHAR(1000) NOT NULL,
    price       INT           NOT NULL,
    quantity    INT           NOT NULL,
    PRIMARY KEY (id)
);

-- DML for Table product_db

INSERT INTO online_shop_product.product_db(brand, model, type, description, price, quantity) value ('Asus',
                                                                                                    'N75SF',
                                                                                                    'Laptop',
                                                                                                    '17.3" 1920 x 1080 TN+Film, несенсорный, 2310M 2100 МГц, 4 ГБ DDR3, HDD 750 ГБ, Windows 7 Home Premium, DVD, цвет крышки черный',
                                                                                                    1500,
                                                                                                    5);
INSERT INTO online_shop_product.product_db(brand, model, type, description, price, quantity) value ('Asus',
                                                                                                    'TUF Gaming A17',
                                                                                                    'Laptop',
                                                                                                    '17.3" 1920 x 1080 IPS, 120 Гц, несенсорный, AMD Ryzen 7 4800H 2900 МГц, 16 ГБ DDR4, SSD 512 ГБ, видеокарта NVIDIA GeForce GTX 1660 Ti 6 ГБ, без ОС, цвет крышки серый',
                                                                                                    1500,
                                                                                                    3);
INSERT INTO online_shop_product.product_db(brand, model, type, description, price, quantity) value ('Xiaomi',
                                                                                                    'Redmi Note 8',
                                                                                                    'Smartphone',
                                                                                                    'Android, экран 6.3" IPS (1080x2340), Qualcomm Snapdragon 665, ОЗУ 4 ГБ, флэш-память 64 ГБ, карты памяти, камера 48 Мп, аккумулятор 4000 мАч, 2 SIM',
                                                                                                    300,
                                                                                                    6);
INSERT INTO online_shop_product.product_db(brand, model, type, description, price, quantity) value ('Xiaomi',
                                                                                                    'Mi box 4s',
                                                                                                    'TV-box',
                                                                                                    'USB, Smart TV, Wi-Fi, 4K, поддержка HDR',
                                                                                                    90,
                                                                                                    1);
INSERT INTO online_shop_product.product_db(brand, model, type, description, price, quantity) value ('Xiaomi',
                                                                                                    'Poco F1',
                                                                                                    'Smartphone',
                                                                                                    'Android, экран 6.18" IPS (1080x2246), Qualcomm Snapdragon 845, ОЗУ 6 ГБ, флэш-память 128 ГБ, карты памяти, камера 12 Мп, аккумулятор 4000 мАч, 2 SIM',
                                                                                                    400,
                                                                                                    1);
INSERT INTO online_shop_product.product_db(brand, model, type, description, price, quantity) value ('HONOR',
                                                                                                    'MagicBook X15',
                                                                                                    'Laptop',
                                                                                                    '15.6" 1920 x 1080 IPS, 60 Гц, несенсорный, Intel Core i3 10110U 2100 МГц, 8 ГБ DDR4, SSD 256 ГБ, видеокарта встроенная, Windows 10, цвет крышки серый',
                                                                                                    700,
                                                                                                    2);

CREATE TABLE IF NOT EXISTS online_shop_product.product_image_db
(
    id         INT         NOT NULL AUTO_INCREMENT UNIQUE,
    product_id INT         NOT NULL,
    name_image VARCHAR(50) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (product_id) REFERENCES online_shop_product.product_db (id) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO online_shop_product.product_image_db(product_id, name_image) value (1, 'asus_n75sf.jpg');
INSERT INTO online_shop_product.product_image_db(product_id, name_image) value (2, 'asus_tufgaminga17.jpg');
INSERT INTO online_shop_product.product_image_db(product_id, name_image) value (3, 'xiaomi_rn8.jpg');
INSERT INTO online_shop_product.product_image_db(product_id, name_image) value (4, 'xiaomi_mibox4s.jpg');
INSERT INTO online_shop_product.product_image_db(product_id, name_image) value (5, 'xiaomi_pocof1.jpg');
INSERT INTO online_shop_product.product_image_db(product_id, name_image) value (6, 'honor_mbx15.jpg');