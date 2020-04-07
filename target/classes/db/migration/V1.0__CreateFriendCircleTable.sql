CREATE TABLE `friend_circle` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `owner_ID` bigint(20) DEFAULT NULL COMMENT '用户id',
    `post_ID` bigint(20) DEFAULT NULL COMMENT '朋友圈信息id',
    `is_own` int(1) DEFAULT '0' COMMENT '是否是自己的',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;