CREATE TABLE `keep_plan` (
  `plan_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `owner_ID` bigint(20)NOT NULL COMMENT '计划拥有者',
  `sports` varchar (200)NOT NULL COMMENT '运动内容',
  `state` int(10) NOT NULL COMMENT '计划是否完成',
  PRIMARY KEY (`plan_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;