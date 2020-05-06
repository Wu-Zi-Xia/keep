create table `user_record`(
id bigint(20) NOT NULL AUTO_INCREMENT comment '主键',
owner_id bigint(20)  not NULL COMMENT '记录的拥有者的id',
product_id bigint(20) not null comment '没有具体到每一个规格的商品的id',
PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;