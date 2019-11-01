create table BLOG_COMMENT (
    ID integer,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    VERSION integer not null,
    --
    CONTENT varchar(65535) not null,
    USER_ID varchar(32),
    --
    primary key (ID)
);