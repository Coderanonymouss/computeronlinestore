drop table if exists t_rams cascade;
create table t_rams
(
    id    bigserial not null,
    name  varchar(255),
    price bigint,
    primary key (id)
);