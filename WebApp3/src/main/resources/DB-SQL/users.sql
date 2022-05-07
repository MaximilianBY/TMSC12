DROP SCHEMA IF EXISTS online_shop_users;
CREATE SCHEMA IF NOT EXISTS online_shop_users;

DROP TABLE IF EXISTS online_shop_users.users_data, online_shop_users.users_purchases;
CREATE TABLE IF NOT EXISTS online_shop_users.users_data
(
    id           INT          NOT NULL AUTO_INCREMENT UNIQUE,
    user_name    VARCHAR(50)  NOT NULL UNIQUE,
    password     VARCHAR(100) NOT NULL,
    email        VARCHAR(50) UNIQUE,
    phone_number VARCHAR(20) UNIQUE,
    PRIMARY KEY (id)
);

-- DML for Table product_db

INSERT INTO online_shop_users.users_data(user_name, password, email, phone_number) value ('Maximus', '1234', NULL, NULL);
INSERT INTO online_shop_users.users_data(user_name, password, email, phone_number) value ('Max', '1234', NULL, NULL);

CREATE TABLE IF NOT EXISTS online_shop_users.users_purchases
(
    id           INT         NOT NULL AUTO_INCREMENT UNIQUE,
    user_id      VARCHAR(50) NOT NULL,
    purchase_id  INT,
    brand        VARCHAR(100),
    model        VARCHAR(100),
    type         VARCHAR(50),
    description  VARCHAR(1000),
    price        INT,
    image_name   VARCHAR(50),
    status_order BIT,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES online_shop_users.users_data (user_name) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO online_shop_users.users_purchases(user_id, purchase_id, brand, model, type, description,
                                              price, image_name,
                                              status_order) value ('Maximus', null, null, null, null, null, null, null, null);
INSERT INTO online_shop_users.users_purchases(user_id, purchase_id, brand, model, type, description,
                                              price, image_name,
                                              status_order) value ('Max', null, null, null, null, null, null, null, null);