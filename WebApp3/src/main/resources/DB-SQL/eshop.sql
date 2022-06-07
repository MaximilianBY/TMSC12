DROP SCHEMA IF EXISTS eshop;
CREATE SCHEMA IF NOT EXISTS eshop;

DROP TABLE IF EXISTS eshop.user;

CREATE TABLE IF NOT EXISTS eshop.user
(
    id           SERIAL UNIQUE,
    login        VARCHAR(20) NOT NULL UNIQUE,
    user_name    VARCHAR(20) NOT NULL,
    surname      VARCHAR(20) NOT NULL,
    birthday     VARCHAR(10),
    email        VARCHAR(30) NOT NULL UNIQUE,
    phone_number VARCHAR(13) UNIQUE,
    password     VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO eshop.user (login, user_name, surname, birthday, email, phone_number,
                        password) VALUE ('Max',
                                         'Maximilian',
                                         'Poltorzhickiy',
                                         '1990.01.01',
                                         'max@gmail.com',
                                         '+375259457864',
                                         '1234');
INSERT INTO eshop.user (login, user_name, surname, birthday, email, phone_number,
                        password) VALUE ('Anna',
                                         'Anna',
                                         'Kovrizhnih',
                                         '1992.07.14',
                                         'anna@gmail.com',
                                         '+375252542354',
                                         '12345');
INSERT INTO eshop.user (login, user_name, surname, birthday, email, phone_number,
                        password) VALUE ('Alia',
                                         'Alina',
                                         'Poltorzhickaya',
                                         '1988.10.15',
                                         'alina.box@gmail.com',
                                         '+375293569784',
                                         '4321');
INSERT INTO eshop.user (login, user_name, surname, birthday, email, phone_number,
                        password) VALUE ('Vas',
                                         'Vasya',
                                         'Ivanov',
                                         '1986.02.21',
                                         'vasya.boss@gmail.com',
                                         '+375337854312',
                                         '54321');

DROP TABLE IF EXISTS eshop.category;

CREATE TABLE IF NOT EXISTS eshop.category
(
    id   SERIAL UNIQUE,
    name VARCHAR(20) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

INSERT INTO eshop.category (name) VALUE ('Mobile phones');
INSERT INTO eshop.category (name) VALUE ('Laptops');
INSERT INTO eshop.category (name) VALUE ('GPS Navigators');
INSERT INTO eshop.category (name) VALUE ('Fridges');
INSERT INTO eshop.category (name) VALUE ('Cars');
INSERT INTO eshop.category (name) VALUE ('Cameras');
INSERT INTO eshop.category (name) VALUE ('TV-BOX');

DROP TABLE IF EXISTS eshop.product;

CREATE TABLE IF NOT EXISTS eshop.product
(
    id          SERIAL UNIQUE,
    brand       VARCHAR(20)     NOT NULL,
    model       VARCHAR(20)     NOT NULL UNIQUE,
    description VARCHAR(1000)   NOT NULL,
    price       BIGINT UNSIGNED NOT NULL,
    quantity    BIGINT UNSIGNED NOT NULL,
    category_id BIGINT UNSIGNED NOT NULL,
    primary key (id),
    CONSTRAINT FK_PRODUCT_CATEGORY_ID_CATEGORY_ID
        FOREIGN KEY (category_id) REFERENCES category (id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO eshop.product (brand, model, description, price, quantity, category_id) VALUE ('Asus',
                                                                                           'N75SF',
                                                                                           '17.3" 1920 x 1080 TN+Film, несенсорный, 2310M 2100 МГц, 4 ГБ DDR3, HDD 750 ГБ, Windows 7 Home Premium, DVD, цвет крышки черный',
                                                                                           1500,
                                                                                           6,
                                                                                           2);
INSERT INTO eshop.product (brand, model, description, price, quantity, category_id) VALUE ('Asus',
                                                                                           'TUF Gaming A17',
                                                                                           '17.3" 1920 x 1080 IPS, 120 Гц, несенсорный, AMD Ryzen 7 4800H 2900 МГц, 16 ГБ DDR4, SSD 512 ГБ, видеокарта NVIDIA GeForce GTX 1660 Ti 6 ГБ, без ОС, цвет крышки серый',
                                                                                           1500,
                                                                                           8,
                                                                                           2);
INSERT INTO eshop.product (brand, model, description, price, quantity, category_id) VALUE ('Xiaomi',
                                                                                           'Redmi Note 8',
                                                                                           'Android, экран 6.3" IPS (1080x2340), Qualcomm Snapdragon 665, ОЗУ 4 ГБ, флэш-память 64 ГБ, карты памяти, камера 48 Мп, аккумулятор 4000 мАч, 2 SIM',
                                                                                           300,
                                                                                           5,
                                                                                           1);
INSERT INTO eshop.product (brand, model, description, price, quantity, category_id) VALUE ('Xiaomi',
                                                                                           'Mi box 4s',
                                                                                           'USB, Smart TV, Wi-Fi, 4K, поддержка HDR',
                                                                                           90,
                                                                                           9,
                                                                                           7);
INSERT INTO eshop.product (brand, model, description, price, quantity, category_id) VALUE ('Xiaomi',
                                                                                           'Poco F1',
                                                                                           'Android, экран 6.18" IPS (1080x2246), Qualcomm Snapdragon 845, ОЗУ 6 ГБ, флэш-память 128 ГБ, карты памяти, камера 12 Мп, аккумулятор 4000 мАч, 2 SIM',
                                                                                           400,
                                                                                           8,
                                                                                           1);
INSERT INTO eshop.product (brand, model, description, price, quantity, category_id) VALUE ('HONOR',
                                                                                           'MagicBook X15',
                                                                                           '15.6" 1920 x 1080 IPS, 60 Гц, несенсорный, Intel Core i3 10110U 2100 МГц, 8 ГБ DDR4, SSD 256 ГБ, видеокарта встроенная, Windows 10, цвет крышки серый',
                                                                                           700,
                                                                                           12,
                                                                                           2);

DROP TABLE IF EXISTS eshop.images;

CREATE TABLE IF NOT EXISTS eshop.images
(
    category_id BIGINT UNSIGNED,
    product_id  BIGINT UNSIGNED,
    image_path  VARCHAR(100) NOT NULL,
    CONSTRAINT FK_IMAGES_CATEGORY_ID_CATEGORY_ID
        FOREIGN KEY (category_id) REFERENCES category (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_IMAGES_PRODUCT_ID_PRODUCT_ID
        FOREIGN KEY (product_id) REFERENCES product (id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO eshop.images (category_id, product_id, image_path) VALUE (1,
                                                                      NULL,
                                                                      'mobile.jpg');
INSERT INTO eshop.images (category_id, product_id, image_path) VALUE (2,
                                                                      NULL,
                                                                      'laptop.jpg');
INSERT INTO eshop.images (category_id, product_id, image_path) VALUE (3,
                                                                      NULL,
                                                                      'jps_nav.jpg');
INSERT INTO eshop.images (category_id, product_id, image_path) VALUE (4,
                                                                      NULL,
                                                                      'fridge.jpg');
INSERT INTO eshop.images (category_id, product_id, image_path) VALUE (5,
                                                                      NULL,
                                                                      'car.jpg');
INSERT INTO eshop.images (category_id, product_id, image_path) VALUE (6,
                                                                      NULL,
                                                                      'camera.jpg');
INSERT INTO eshop.images (category_id, product_id, image_path) VALUE (7,
                                                                      NULL,
                                                                      'tv-box.jpg');
INSERT INTO eshop.images (category_id, product_id, image_path) VALUE (NULL,
                                                                      1,
                                                                      'asus_n75sf.jpg');
INSERT INTO eshop.images (category_id, product_id, image_path) VALUE (NULL,
                                                                      2,
                                                                      'asus_tufgaminga17.jpg');
INSERT INTO eshop.images (category_id, product_id, image_path) VALUE (NULL,
                                                                      3,
                                                                      'xiaomi_rn8.jpg');
INSERT INTO eshop.images (category_id, product_id, image_path) VALUE (NULL,
                                                                      4,
                                                                      'xiaomi_mibox4s.jpg');
INSERT INTO eshop.images (category_id, product_id, image_path) VALUE (NULL,
                                                                      5,
                                                                      'xiaomi_pocof1.jpg');
INSERT INTO eshop.images (category_id, product_id, image_path) VALUE (NULL,
                                                                      6,
                                                                      'honor_mbx15.jpg');

DROP TABLE IF EXISTS eshop.orders;

CREATE TABLE IF NOT EXISTS eshop.orders
(
    id          SERIAL UNIQUE,
    user_id     BIGINT UNSIGNED NOT NULL,
    order_date  date            NOT NULL,
    order_price BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_USER_ID_ORDERS_USER_ID
        FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS eshop.order_product;

CREATE TABLE IF NOT EXISTS eshop.order_product
(
    order_id         BIGINT UNSIGNED NOT NULL,
    product_id       BIGINT UNSIGNED NOT NULL,
    product_quantity BIGINT UNSIGNED NOT NULL,
    CONSTRAINT FK_ORDER_PRODUCT_PRODUCT_ID_PRODUCT_ID
        FOREIGN KEY (product_id) REFERENCES eshop.product (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_ORDER_PRODUCT_ORDER_ID_ORDERS_ID
        FOREIGN KEY (order_id) REFERENCES eshop.orders (id) ON DELETE CASCADE ON UPDATE CASCADE
);