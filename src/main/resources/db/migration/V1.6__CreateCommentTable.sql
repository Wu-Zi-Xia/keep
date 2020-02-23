DROP TABLE IF EXISTS keep_comment;
CREATE TABLE `keep_comment` (
  `comment_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `owner_ID` bigint(20) NOT NULL COMMENT '拥有者ID',
  `content`  varchar(200) COMMENT '评论的具体内容',
  `type`  int COMMENT '评论类型',
  `create_date`  varchar(20) NOT  null COMMENT '评论创建时间',
  PRIMARY KEY (`comment_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;