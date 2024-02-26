drop table if exists t_coolers cascade;
create table t_coolers
(
    id    bigserial not null,
    name  varchar(255),
    price bigint,
    primary key (id)
);