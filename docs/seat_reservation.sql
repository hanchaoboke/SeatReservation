CREATE DATABASE `seat_reservation`;

USE `seat_reservation`;

-- user
-- seat
-- order(user_id,seat_id)

CREATE TABLE `user` (
                        `id`         INT(10)   NOT NULL AUTO_INCREMENT,
                        `username`   VARCHAR(64)        DEFAULT '' UNIQUE COMMENT '用户名',
                        `password`   VARCHAR(64)        DEFAULT '' COMMENT '密码',
                        `phone`      VARCHAR(20)  NULL  DEFAULT ''  COMMENT '手机号',
                        `email`      VARCHAR(50)  NULL  DEFAULT ''  COMMENT '电子邮箱',
                        `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                        `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                        `actived`    TINYINT(1) NOT NULL DEFAULT 0 COMMENT '激活状态',
                        `flag`       TINYINT(1) NOT NULL DEFAULT 0 COMMENT '用户身份',
                        PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = `utf8mb4` AUTO_INCREMENT = 1000 COMMENT ='用户表';

INSERT INTO user (`username`,`password`,`actived`) VALUES ('abc',123456,1);

CREATE TABLE `seat` (
                        `id`         INT(10)   NOT NULL AUTO_INCREMENT,
                        `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                        `actived`     TINYINT(2) NOT NULL DEFAULT 0 COMMENT '预定状态',
                        `repair`    TINYINT(1) NOT NULL DEFAULT 0 COMMENT '是否维修',
                        PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = `utf8mb4` AUTO_INCREMENT = 1 COMMENT ='座位表';

CREATE TABLE `orders` (
                        `id`         INT(10)   NOT NULL AUTO_INCREMENT,
                        `user_id`    INT(10)   NULL DEFAULT 0 COMMENT '用户ID',
                        `seat_id`    INT(10)   NULL DEFAULT 0 COMMENT '座位ID',
                        `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                        `duration_at` TIMESTAMP NOT NULL COMMENT '座位锁定开始时间',
                        `duration`   TINYINT(2) NOT NULL DEFAULT 1 COMMENT '座位预定时长',
                        `actived`    TINYINT(1) NOT NULL DEFAULT 1 COMMENT '订单状态',
                        PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = `utf8mb4` COMMENT ='订单表';






