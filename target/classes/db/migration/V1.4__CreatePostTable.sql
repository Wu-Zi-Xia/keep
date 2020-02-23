DROP TABLE IF EXISTS keep_post;
CREATE TABLE `keep_post` (
  `post_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `owner_ID` bigint(20) NOT NULL COMMENT '拥有者ID',
  `image_url`  varchar(200) COMMENT '图片url',
  `video_url`  varchar(200) COMMENT '短视频url',
  `create_date`  varchar(20) NOT  null COMMENT '动态创建时间',
  PRIMARY KEY (`post_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;