create table `coach_qualification`(
id bigint(20) NOT NULL AUTO_INCREMENT comment '主键',
user_id bigint(20) not null comment '用户id',
certification_id bigint(20) not NULL COMMENT '资质证书的id',
PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table `certification`(
id bigint(20) NOT NULL AUTO_INCREMENT comment '主键',
qualification_type varchar(20)  not NULL COMMENT '资质证书的具体信息',
PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
rename table `order` to product_order;

