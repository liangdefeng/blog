alter table BLOG_ARTICLE add constraint FK_BLOG_ARTICLE_ON_AUTHOR foreign key (AUTHOR_ID) references SEC_USER(ID);
create index IDX_BLOG_ARTICLE_ON_AUTHOR on BLOG_ARTICLE (AUTHOR_ID);
