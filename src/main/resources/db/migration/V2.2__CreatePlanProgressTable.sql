CREATE TABLE `plan_progress` (
  `plan_ProgressID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `owner_ID` bigint(20)NOT NULL COMMENT '计划进程的拥有者',
  `start_planID` varchar (200)NOT NULL COMMENT '此个计划开始的数据库的ID',
  `current_state` int(10) NOT NULL COMMENT '当前被执行的计划的ID',
   `end_planID` int(10) NOT NULL COMMENT '此个计划结束的数据库的ID',
  PRIMARY KEY (`plan_progressID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;