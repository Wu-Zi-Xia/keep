CREATE TABLE `product_category` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`parent_id` bigint(20) DEFAULT NULL COMMENT '所属类型的id',
`name` varchar(50) DEFAULT NULL COMMENT '类别的名字',
`create_date` bigint(20) COMMENT '创建时间',
`modify_date` bigint(20) COMMENT '修改时间',
state int not null comment '',
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `product` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`category_id` bigint(20) DEFAULT NULL COMMENT '所属类型的id',
public_attribute varchar(200) DEFAULT NULL COMMENT '主要属性',
`attribute_list` varchar(200) DEFAULT NULL COMMENT '销售属性',
`create_date` bigint(20) COMMENT '创建时间',
`modify_date` bigint(20) COMMENT '修改时间',
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table product_specs(
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`product_id` bigint(20)  not NULL COMMENT '商品的id',
product_specs varchar(50) not null comment '具体属性，可以定义价格',
product_stock int not null comment '库存',
product_price double not null comment '价格',
status int not null comment '是否还有',
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;