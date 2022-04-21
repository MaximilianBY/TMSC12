-- DDL for schema online_shop_pc

DROP SCHEMA IF EXISTS online_shop_pc;
CREATE SCHEMA IF NOT EXISTS online_shop_pc;

DROP TABLE IF EXISTS online_shop_pc.product_db, online_shop_pc.product_image_db;
CREATE TABLE IF NOT EXISTS online_shop_pc.product_db
(
    id          INT          NOT NULL AUTO_INCREMENT UNIQUE,
    brand       VARCHAR(100) NOT NULL,
    model       VARCHAR(100) NOT NULL,
    description VARCHAR(200) NOT NULL,
    price       INT          NOT NULL,
    quantity    INT          NOT NULL,
    PRIMARY KEY (id)
);

-- DML for Table product_db

INSERT INTO online_shop_pc.product_db(brand, model, description, price, quantity) value ('Asus', 'N75SF', 'laptop', 1500, 5);
INSERT INTO online_shop_pc.product_db(brand, model, description, price, quantity) value ('Asus', 'TUF Gaming A17', 'laptop', 1500, 3);
INSERT INTO online_shop_pc.product_db(brand, model, description, price, quantity) value ('Xiaomi', 'Redmi Note 8', 'smartphone', 300, 6);
INSERT INTO online_shop_pc.product_db(brand, model, description, price, quantity) value ('Xiaomi', 'Mi box 4s', 'TV-box', 90, 1);
INSERT INTO online_shop_pc.product_db(brand, model, description, price, quantity) value ('Xiaomi', 'Poco F1', 'smartphone', 400, 1);
INSERT INTO online_shop_pc.product_db(brand, model, description, price, quantity) value ('HONOR', 'MagicBook X15', 'laptop', 700, 2);

CREATE TABLE IF NOT EXISTS online_shop_pc.product_image_db
(
    id         INT         NOT NULL AUTO_INCREMENT UNIQUE,
    product_id INT         NOT NULL,
    name_image VARCHAR(50) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (product_id) REFERENCES online_shop_pc.product_db (id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO online_shop_pc.product_image_db(product_id, name_image) value (1, 'asus_n75sf.jpg');
INSERT INTO online_shop_pc.product_image_db(product_id, name_image) value (2, 'asus_tufgaminga17.jpg');
INSERT INTO online_shop_pc.product_image_db(product_id, name_image) value (3, 'xiaomi_rn8.jpg');
INSERT INTO online_shop_pc.product_image_db(product_id, name_image) value (4, 'xiaomi_mibox4s.jpg');
INSERT INTO online_shop_pc.product_image_db(product_id, name_image) value (5, 'xiaomi_pocof1.jpg');
INSERT INTO online_shop_pc.product_image_db(product_id, name_image) value (6, 'honor_mbx15.jpg');