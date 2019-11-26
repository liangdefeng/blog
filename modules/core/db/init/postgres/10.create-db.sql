-- begin BLOG_CATEGORY
create table BLOG_CATEGORY (
    ID integer,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    VERSION integer not null,
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    DESCRIPTION text,
    PARENT_CATEGORY_ID integer,
    --
    primary key (ID)
)^
-- end BLOG_CATEGORY
-- begin BLOG_ARTICLE
create table BLOG_ARTICLE (
    ID integer,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    VERSION integer not null,
    --
    TITLE varchar(255) not null,
    ABSTRACT_TEXT text,
    TAGS text,
    AUTHOR_ID uuid,
    CONTENT text,
    TO_TOP boolean,
    SEO_URL varchar(255),
    --
    primary key (ID)
)^
-- end BLOG_ARTICLE
