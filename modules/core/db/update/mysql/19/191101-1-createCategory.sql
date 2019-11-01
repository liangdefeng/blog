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
);