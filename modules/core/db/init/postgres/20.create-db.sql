-- begin BLOG_CATEGORY
alter table BLOG_CATEGORY add constraint FK_BLOG_CATEGORY_ON_PARENT_CATEGORY foreign key (PARENT_CATEGORY_ID) references BLOG_CATEGORY(ID)^
create index IDX_BLOG_CATEGORY_ON_PARENT_CATEGORY on BLOG_CATEGORY (PARENT_CATEGORY_ID)^
-- end BLOG_CATEGORY
-- begin BLOG_ARTICLE
alter table BLOG_ARTICLE add constraint FK_BLOG_ARTICLE_ON_AUTHOR foreign key (AUTHOR_ID) references SEC_USER(ID)^
create unique index IDX_BLOG_ARTICLE_UK_SEO_URL on BLOG_ARTICLE (SEO_URL) ^
create index IDX_BLOG_ARTICLE_ON_AUTHOR on BLOG_ARTICLE (AUTHOR_ID)^
-- end BLOG_ARTICLE
