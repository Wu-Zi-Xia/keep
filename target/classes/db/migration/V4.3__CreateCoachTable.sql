create table `coach`(
id bigint(20) NOT NULL AUTO_INCREMENT comment '主键',
coach_number varchar(20)  not NULL COMMENT '教练的number',
avatar_url varchar(100)   NULL COMMENT '教练头像',
nick_name varchar(100)   NULL COMMENT '教练的昵称',
height int(10) null comment'身高',
weight int(10) null comment'体重',
sex char(1) null comment '性别',
PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;