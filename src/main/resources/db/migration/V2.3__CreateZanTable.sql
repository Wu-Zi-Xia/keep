CREATE TABLE `zan` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`owner_ID` bigint(20) DEFAULT NULL COMMENT '拥有者的id',
`zan_id` varchar(500) DEFAULT NULL COMMENT '点赞的人的id',
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;