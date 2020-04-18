CREATE TABLE `keep_lesson` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  lesson_name varchar (50) not null comment '课程名字',
  image_url varchar (100)  not null comment '课程图片资源的url',
  `sports` varchar (200)NOT NULL COMMENT '运动内容',
  `hot` int(10) NOT NULL COMMENT '课程热度',
  `type` varchar(20) not null comment '课程的类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `choose_lesson` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
 `owner_id` bigint(20) NOT NULL COMMENT '课程拥有者的id',
 `lesson_id` bigint(20) NOT NULL COMMENT '课程的id',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `sports_history` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
`owner_id` bigint(20) NOT NULL COMMENT '拥有者的id',
`sports_id` bigint(20) NOT NULL COMMENT '运动的id',
 finish_date bigint(20) not null comment '运动完成时间',
 type varchar(20) not null comment '判断是哪种类型',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

