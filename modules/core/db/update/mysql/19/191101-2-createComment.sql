alter table BLOG_COMMENT add constraint FK_BLOG_COMMENT_ON_USER foreign key (USER_ID) references SEC_USER(ID);
create index IDX_BLOG_COMMENT_ON_USER on BLOG_COMMENT (USER_ID);
