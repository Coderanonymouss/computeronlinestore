drop table if exists t_rams cascade;
create table t_users
(
    id          bigserial not null,
    email       varchar(255),
    full_name   varchar(255),
    password    varchar(255),
    primary key (id)
);