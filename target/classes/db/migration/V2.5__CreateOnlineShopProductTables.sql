CREATE TABLE IF NOT EXISTS `sports_equipment` (
  `equipment_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `equipment_name` char(15) NOT NULL COMMENT '装备名称',
  `image_url` varchar(200) NOT NULL COMMENT '图片资源',
  `equipment_tag` varchar(200)  NOT NULL COMMENT '装备标志',
  `brand` varchar(50) NOT NULL COMMENT '商标',
  `price` int(10) NOT NULL COMMENT '价格',
  `description` varchar(400) NOT NULL COMMENT '装备信息',
  PRIMARY KEY (`equipment_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE IF NOT EXISTS `substitute_food` (
  `food_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `food_name` char(15) NOT NULL COMMENT '食物名称',
  `image_url` varchar(200) NOT NULL COMMENT '图片资源',
  `calorie` int (10) NOT NULL COMMENT '卡路里',
  `brand` varchar(50) NOT NULL COMMENT '商标',
  `price` int(10) NOT NULL COMMENT '价格',
  `description` varchar(400) NOT NULL COMMENT '食物信息',
  PRIMARY KEY (`food_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE IF NOT EXISTS `sports_wear` (
  `wear_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `wear_name` char(15) NOT NULL COMMENT '服饰名称',
  `image_url` varchar(200) NOT NULL COMMENT '图片资源',
  `sex` varchar(1) NOT NULL COMMENT '性别',
  `brand` varchar(50) NOT NULL COMMENT '商标',
  `price` int(10) NOT NULL COMMENT '价格',
  `description` varchar(400) NOT NULL COMMENT '服饰信息',
  PRIMARY KEY (`wear_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE IF NOT EXISTS `sports_life` (
  `product_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_name` char(15) NOT NULL COMMENT '商品名称',
  `image_url` varchar(200) NOT NULL COMMENT '图片资源',
  `brand` varchar(50) NOT NULL COMMENT '商标',
  `price` int(10) NOT NULL COMMENT '价格',
  `description` varchar(400) NOT NULL COMMENT '商品信息',
  PRIMARY KEY (`product_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;