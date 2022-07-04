DROP SCHEMA IF EXISTS ESHOP;
CREATE SCHEMA IF NOT EXISTS ESHOP;

DROP TABLE IF EXISTS ESHOP.USERS;

CREATE TABLE IF NOT EXISTS ESHOP.USERS
(
    ID           SERIAL UNIQUE,
    LOGIN        VARCHAR(20) NOT NULL UNIQUE,
    NAME         VARCHAR(20) NOT NULL,
    SURNAME      VARCHAR(20) NOT NULL,
    BIRTHDAY     VARCHAR(10),
    EMAIL        VARCHAR(30) NOT NULL UNIQUE,
    PHONE_NUMBER VARCHAR(13) UNIQUE,
    PASSWORD     VARCHAR(20) NOT NULL,
    PRIMARY KEY (ID)
);

INSERT INTO ESHOP.USERS (LOGIN, NAME, SURNAME, BIRTHDAY, EMAIL, PHONE_NUMBER,
                         PASSWORD) VALUE ('Max',
                                          'Maximilian',
                                          'Poltorzhickiy',
                                          '1990.01.01',
                                          'max@gmail.com',
                                          '+375259457864',
                                          '1234');
INSERT INTO ESHOP.USERS (LOGIN, NAME, SURNAME, BIRTHDAY, EMAIL, PHONE_NUMBER,
                         PASSWORD) VALUE ('Anna',
                                          'Anna',
                                          'Kovrizhnih',
                                          '1992.07.14',
                                          'anna@gmail.com',
                                          '+375252542354',
                                          '12345');
INSERT INTO ESHOP.USERS (LOGIN, NAME, SURNAME, BIRTHDAY, EMAIL, PHONE_NUMBER,
                         PASSWORD) VALUE ('Alia',
                                          'Alina',
                                          'Poltorzhickaya',
                                          '1988.10.15',
                                          'alina.box@gmail.com',
                                          '+375293569784',
                                          '4321');
INSERT INTO ESHOP.USERS (LOGIN, NAME, SURNAME, BIRTHDAY, EMAIL, PHONE_NUMBER,
                         PASSWORD) VALUE ('Vas',
                                          'Vasya',
                                          'Ivanov',
                                          '1986.02.21',
                                          'vasya.boss@gmail.com',
                                          '+375337854312',
                                          '54321');

DROP TABLE IF EXISTS ESHOP.CATEGORY;

CREATE TABLE IF NOT EXISTS ESHOP.CATEGORY
(
    ID   SERIAL UNIQUE,
    NAME VARCHAR(20) NOT NULL UNIQUE,
    PRIMARY KEY (ID)
);

INSERT INTO ESHOP.CATEGORY (NAME) VALUE ('Mobile phones');
INSERT INTO ESHOP.CATEGORY (NAME) VALUE ('Laptops');
INSERT INTO ESHOP.CATEGORY (NAME) VALUE ('GPS Navigators');
INSERT INTO ESHOP.CATEGORY (NAME) VALUE ('Fridges');
INSERT INTO ESHOP.CATEGORY (NAME) VALUE ('Cars');
INSERT INTO ESHOP.CATEGORY (NAME) VALUE ('Cameras');
INSERT INTO ESHOP.CATEGORY (NAME) VALUE ('TV-BOX');

DROP TABLE IF EXISTS ESHOP.PRODUCT;

CREATE TABLE IF NOT EXISTS ESHOP.PRODUCT
(
    ID          SERIAL UNIQUE,
    BRAND       VARCHAR(20)     NOT NULL,
    MODEL       VARCHAR(20)     NOT NULL UNIQUE,
    DESCRIPTION VARCHAR(1000)   NOT NULL,
    PRICE       BIGINT UNSIGNED NOT NULL,
    QUANTITY    BIGINT UNSIGNED NOT NULL,
    CATEGORY_ID BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY (ID),
    CONSTRAINT FK_PRODUCT_CATEGORY_ID_CATEGORY_ID
        FOREIGN KEY (CATEGORY_ID) REFERENCES CATEGORY (ID) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO ESHOP.PRODUCT (BRAND, MODEL, DESCRIPTION, PRICE, QUANTITY, CATEGORY_ID) VALUE ('Asus',
                                                                                           'N75SF',
                                                                                           '17.3" 1920 x 1080 TN+Film, несенсорный, 2310M 2100 МГц, 4 ГБ DDR3, HDD 750 ГБ, Windows 7 Home Premium, DVD, цвет крышки черный',
                                                                                           1500,
                                                                                           6,
                                                                                           2);
INSERT INTO ESHOP.PRODUCT (BRAND, MODEL, DESCRIPTION, PRICE, QUANTITY, CATEGORY_ID) VALUE ('Asus',
                                                                                           'TUF Gaming A17',
                                                                                           '17.3" 1920 x 1080 IPS, 120 Гц, несенсорный, AMD Ryzen 7 4800H 2900 МГц, 16 ГБ DDR4, SSD 512 ГБ, видеокарта NVIDIA GeForce GTX 1660 Ti 6 ГБ, без ОС, цвет крышки серый',
                                                                                           1500,
                                                                                           8,
                                                                                           2);
INSERT INTO ESHOP.PRODUCT (BRAND, MODEL, DESCRIPTION, PRICE, QUANTITY, CATEGORY_ID) VALUE ('Xiaomi',
                                                                                           'Redmi Note 8',
                                                                                           'Android, экран 6.3" IPS (1080x2340), Qualcomm Snapdragon 665, ОЗУ 4 ГБ, флэш-память 64 ГБ, карты памяти, камера 48 Мп, аккумулятор 4000 мАч, 2 SIM',
                                                                                           300,
                                                                                           5,
                                                                                           1);
INSERT INTO ESHOP.PRODUCT (BRAND, MODEL, DESCRIPTION, PRICE, QUANTITY, CATEGORY_ID) VALUE ('Xiaomi',
                                                                                           'Mi box 4s',
                                                                                           'USB, Smart TV, Wi-Fi, 4K, поддержка HDR',
                                                                                           90,
                                                                                           9,
                                                                                           7);
INSERT INTO ESHOP.PRODUCT (BRAND, MODEL, DESCRIPTION, PRICE, QUANTITY, CATEGORY_ID) VALUE ('Xiaomi',
                                                                                           'Poco F1',
                                                                                           'Android, экран 6.18" IPS (1080x2246), Qualcomm Snapdragon 845, ОЗУ 6 ГБ, флэш-память 128 ГБ, карты памяти, камера 12 Мп, аккумулятор 4000 мАч, 2 SIM',
                                                                                           400,
                                                                                           8,
                                                                                           1);
INSERT INTO ESHOP.PRODUCT (BRAND, MODEL, DESCRIPTION, PRICE, QUANTITY, CATEGORY_ID) VALUE ('HONOR',
                                                                                           'MagicBook X15',
                                                                                           '15.6" 1920 x 1080 IPS, 60 Гц, несенсорный, Intel Core i3 10110U 2100 МГц, 8 ГБ DDR4, SSD 256 ГБ, видеокарта встроенная, Windows 10, цвет крышки серый',
                                                                                           700,
                                                                                           12,
                                                                                           2);

DROP TABLE IF EXISTS eshop.images;

CREATE TABLE IF NOT EXISTS eshop.images
(
    CATEGORY_ID BIGINT UNSIGNED,
    PRODUCT_ID  BIGINT UNSIGNED,
    IMAGE_PATH  VARCHAR(100) NOT NULL,
    CONSTRAINT FK_IMAGES_CATEGORY_ID_CATEGORY_ID
        FOREIGN KEY (CATEGORY_ID) REFERENCES CATEGORY (ID) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_IMAGES_PRODUCT_ID_PRODUCT_ID
        FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT (ID) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO ESHOP.IMAGES (CATEGORY_ID, PRODUCT_ID, IMAGE_PATH) VALUE (1,
                                                                      NULL,
                                                                      'mobile.jpg');
INSERT INTO ESHOP.IMAGES (CATEGORY_ID, PRODUCT_ID, IMAGE_PATH) VALUE (2,
                                                                      NULL,
                                                                      'laptop.jpg');
INSERT INTO ESHOP.IMAGES (CATEGORY_ID, PRODUCT_ID, IMAGE_PATH) VALUE (3,
                                                                      NULL,
                                                                      'jps_nav.jpg');
INSERT INTO ESHOP.IMAGES (CATEGORY_ID, PRODUCT_ID, IMAGE_PATH) VALUE (4,
                                                                      NULL,
                                                                      'fridge.jpg');
INSERT INTO ESHOP.IMAGES (CATEGORY_ID, PRODUCT_ID, IMAGE_PATH) VALUE (5,
                                                                      NULL,
                                                                      'car.jpg');
INSERT INTO ESHOP.IMAGES (CATEGORY_ID, PRODUCT_ID, IMAGE_PATH) VALUE (6,
                                                                      NULL,
                                                                      'camera.jpg');
INSERT INTO ESHOP.IMAGES (CATEGORY_ID, PRODUCT_ID, IMAGE_PATH) VALUE (7,
                                                                      NULL,
                                                                      'tv-box.jpg');
INSERT INTO ESHOP.IMAGES (CATEGORY_ID, PRODUCT_ID, IMAGE_PATH) VALUE (NULL,
                                                                      1,
                                                                      'asus_n75sf.jpg');
INSERT INTO ESHOP.IMAGES (CATEGORY_ID, PRODUCT_ID, IMAGE_PATH) VALUE (NULL,
                                                                      2,
                                                                      'asus_tufgaminga17.jpg');
INSERT INTO ESHOP.IMAGES (CATEGORY_ID, PRODUCT_ID, IMAGE_PATH) VALUE (NULL,
                                                                      3,
                                                                      'xiaomi_rn8.jpg');
INSERT INTO ESHOP.IMAGES (CATEGORY_ID, PRODUCT_ID, IMAGE_PATH) VALUE (NULL,
                                                                      4,
                                                                      'xiaomi_mibox4s.jpg');
INSERT INTO ESHOP.IMAGES (CATEGORY_ID, PRODUCT_ID, IMAGE_PATH) VALUE (NULL,
                                                                      5,
                                                                      'xiaomi_pocof1.jpg');
INSERT INTO ESHOP.IMAGES (CATEGORY_ID, PRODUCT_ID, IMAGE_PATH) VALUE (NULL,
                                                                      6,
                                                                      'honor_mbx15.jpg');

DROP TABLE IF EXISTS eshop.orders;

CREATE TABLE IF NOT EXISTS eshop.orders
(
    ID          SERIAL UNIQUE,
    USER_ID     BIGINT UNSIGNED NOT NULL,
    ORDER_DATE  DATE            NOT NULL,
    ORDER_PRICE BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY (ID),
    CONSTRAINT FK_USER_ID_ORDERS_USER_ID
        FOREIGN KEY (USER_ID) REFERENCES USERS (ID) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS eshop.order_product;

CREATE TABLE IF NOT EXISTS eshop.order_product
(
    ORDER_ID         BIGINT UNSIGNED NOT NULL,
    PRODUCT_ID       BIGINT UNSIGNED NOT NULL,
    PRODUCT_QUANTITY BIGINT UNSIGNED NOT NULL,
    CONSTRAINT FK_ORDER_PRODUCT_PRODUCT_ID_PRODUCT_ID
        FOREIGN KEY (PRODUCT_ID) REFERENCES ESHOP.PRODUCT (ID) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_ORDER_PRODUCT_ORDER_ID_ORDERS_ID
        FOREIGN KEY (ORDER_ID) REFERENCES ESHOP.ORDERS (ID) ON DELETE CASCADE ON UPDATE CASCADE
);