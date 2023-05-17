DROP TABLE IF EXISTS `tda_TODO`;
CREATE TABLE `tda_TODO`
(
    `id`        bigint      NOT NULL,
    `titleTODO` varchar(45) NOT NULL,
    `typeTODO`  varchar(45) DEFAULT NULL,
    `checkTODO` tinyint     NOT NULL,
    PRIMARY KEY (`id`)
);

INSERT INTO `tda_TODO`
VALUES (5208732809027387395, 'fezafzef', 'EASY', 0),
       (5208732809027387396, 'repas', 'HARD', 1),
       (5218163430061506560, 'repas', 'MEDIUM', 0),
       (5231441887992217600, 'repas', 'MEDIUM', 0);