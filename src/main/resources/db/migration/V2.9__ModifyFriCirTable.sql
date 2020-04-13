
ALTER TABLE friend_circle DROP COLUMN user_userId;
ALTER TABLE friend_circle add COLUMN post_OwnerId bigint(20) not null comment '动态拥有者的id';
