CREATE TABLE `product` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
);
INSERT INTO product VALUES ('1', 'APPLE');
INSERT INTO product VALUES ('2', 'BANANA');
INSERT INTO product VALUES ('3', 'MANGO');