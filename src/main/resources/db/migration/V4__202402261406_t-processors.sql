drop table if exists t_processors cascade;
create table t_processors
(
    id    bigserial not null,
    name  varchar(255),
    price bigint,
    primary key (id)
);
