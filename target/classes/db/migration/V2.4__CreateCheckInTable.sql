CREATE TABLE `check_in` (
  `check_inID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `owner_ID` bigint(20)NOT NULL COMMENT '签到表的拥有者',
  `month` varchar(20) NOT NULL COMMENT '签到表当前月份',
  `results` text  COMMENT '每月的签到信息',
  `continue_sign` int(5) NOT NULL COMMENT '连续签到天数',
  PRIMARY KEY (`check_inID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;