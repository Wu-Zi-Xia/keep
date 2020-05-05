create table `sports_data`(
id bigint(20) NOT NULL AUTO_INCREMENT comment '主键',
owner_id bigint(20)  not NULL COMMENT '运动计划的拥有者的id',
time int(10)   NULL COMMENT '运动总时间',
calorie bigint(20)   NULL COMMENT '消耗的卡路里',
PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;