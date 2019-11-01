-- begin BLOG_ARTICLE
create table BLOG_ARTICLE (
    ID integer,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    VERSION integer not null,
    --
    TITLE varchar(255) not null,
    ABSTRACT_TEXT longtext,
    TAGS longtext,
    AUTHOR_ID varchar(32),
    CONTENT longtext,
    TO_TOP boolean,
    SEO_URL varchar(255),
    --
    primary key (ID)
)^
-- end BLOG_ARTICLE
-- begin BLOG_CATEGORY
create table BLOG_CATEGORY (
    ID integer,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    VERSION integer not null,
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    DESCRIPTION longtext,
    PARENT_CATEGORY_ID integer,
    --
    primary key (ID)
)^
-- end BLOG_CATEGORY
