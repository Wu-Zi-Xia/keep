DROP TABLE IF EXISTS keep_friend;
CREATE TABLE `keep_friend` (
  `friend_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `friend_friendID` bigint(20) NOT NULL COMMENT '朋友ID',
  `friend_userID` bigint(20) NOT NULL COMMENT '我的ID',
  PRIMARY KEY (`friend_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



