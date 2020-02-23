DROP TABLE IF EXISTS keep_user;
CREATE TABLE `keep_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_number` int(12) NOT NULL COMMENT '电话号码',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;