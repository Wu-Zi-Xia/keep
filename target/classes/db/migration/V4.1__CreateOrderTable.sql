create table `order`(
id bigint(20) NOT NULL AUTO_INCREMENT comment '主键',
payment double  NULL COMMENT '实际支付的金额',
payment_type int(2) null comment '支付方式',
post_fee double null comment '邮费',
status int(10) null comment '订单状态',
create_date bigint(20)  null comment '创建时间',
modify_date bigint(20)  null comment '修改时间',
payment_date bigint(20) null comment '付款时间',
consign_date bigint(20) null comment '发货时间',
end_date bigint(20) null comment '交易完成时间',
close_date bigint(20) null comment '交易关闭时间',
shipping_name varchar(20) null comment '物流名称',
shipping_code varchar(20) null comment '物流单号',
user_id bigint(20) null comment '用户id',
buyer_message varchar(100) null comment '买家留言',
buyer_nick varchar(50) null comment '买家昵称',
buyer_rate int(2) null comment '买家是否已经评价',
PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table `order_item`(
id bigint(20) NOT NULL AUTO_INCREMENT comment '主键',
product_id bigint(20)  not NULL COMMENT '商品的id',
order_id bigint(20) not null comment '订单id',
num int(10) not null comment '商品购买数量',
name varchar(200) null comment '商品标题',
total_fee double null  comment '总金额',
product_price double not null comment '价格',
resource_url varchar(200) null comment '商品图片地址',
PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table `order_shipping`(
id bigint(20) NOT NULL AUTO_INCREMENT comment '主键',
order_id bigint(20) not null comment '订单id',
receiver_name varchar(20)  null comment '收货人全名',
receiver_phone varchar(20) null comment '固定电话',
receiver_mobile varchar(20) null comment '移动电话',
receiver_state varchar(20) null comment '省份',
receiver_city varchar(20) null comment '城市',
receiver_district varchar(40) null comment '区/县',
receiver_address varchar(30) null comment '收货地址',
receiver_zip varchar(6) null comment '邮政编码',
create_date bigint(20) null comment '新建时间',
modify_date bigint(20) null comment '修改时间',
PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;