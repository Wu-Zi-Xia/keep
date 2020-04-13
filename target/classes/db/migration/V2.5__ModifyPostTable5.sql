alter table  keep_post modify column like_count int not null COMMENT '动态点赞数';
alter table  keep_post modify column comment_count int not null COMMENT '动态评论数';