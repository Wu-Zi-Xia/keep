
CREATE TABLE `arm_sports` (
  `sports_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sports_name` varchar (30)NOT NULL COMMENT '运动名称',
  `weight` int (1)NOT NULL COMMENT '运动权重',
  `resource_URL` varchar (200)NOT NULL COMMENT '运动资源的路径',
  `calorie` int(10) NOT NULL COMMENT '消耗的卡路里',
  PRIMARY KEY (`sports_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `forearm_sports` (
  `sports_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sports_name` varchar (30)NOT NULL COMMENT '运动名称',
  `weight` int (1)NOT NULL COMMENT '运动权重',
  `resource_URL` varchar (200)NOT NULL COMMENT '运动资源的路径',
  `calorie` int(10) NOT NULL COMMENT '消耗的卡路里',
  PRIMARY KEY (`sports_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `chest_sports` (
  `sports_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sports_name` varchar (30)NOT NULL COMMENT '运动名称',
  `weight` int (1)NOT NULL COMMENT '运动权重',
  `resource_URL` varchar (200)NOT NULL COMMENT '运动资源的路径',
  `calorie` int(10) NOT NULL COMMENT '消耗的卡路里',
  PRIMARY KEY (`sports_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `back_sports` (
  `sports_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sports_name` varchar (30)NOT NULL COMMENT '运动名称',
  `weight` int (1)NOT NULL COMMENT '运动权重',
  `resource_URL` varchar (200)NOT NULL COMMENT '运动资源的路径',
  `calorie` int(10) NOT NULL COMMENT '消耗的卡路里',
  PRIMARY KEY (`sports_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `belly_sports` (
  `sports_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sports_name` varchar (30)NOT NULL COMMENT '运动名称',
  `weight` int (1)NOT NULL COMMENT '运动权重',
  `resource_URL` varchar (200)NOT NULL COMMENT '运动资源的路径',
  `calorie` int(10) NOT NULL COMMENT '消耗的卡路里',
  PRIMARY KEY (`sports_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `thigh_sports` (
  `sports_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sports_name` varchar (30)NOT NULL COMMENT '运动名称',
  `weight` int (1)NOT NULL COMMENT '运动权重',
  `resource_URL` varchar (200)NOT NULL COMMENT '运动资源的路径',
  `calorie` int(10) NOT NULL COMMENT '消耗的卡路里',
  PRIMARY KEY (`sports_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `shank_sports` (
  `sports_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sports_name` varchar (30)NOT NULL COMMENT '运动名称',
  `weight` int (1)NOT NULL COMMENT '运动权重',
  `resource_URL` varchar (200)NOT NULL COMMENT '运动资源的路径',
  `calorie` int(10) NOT NULL COMMENT '消耗的卡路里',
  PRIMARY KEY (`sports_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;