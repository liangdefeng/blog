create table BLOG_ARTICLE (
    ID integer,
    TITLE varchar(255) not null,
    ABSTRACT_TEXT longtext,
    TAGS longtext,
    AUTHOR_ID varchar(32),
    CONTENT longtext,
    TO_TOP boolean,
    SEO_URL varchar(255),
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    VERSION integer not null,
    primary key (ID)
);