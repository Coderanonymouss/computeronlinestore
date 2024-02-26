drop table if exists t_matrices cascade;

create table t_matrices
(
    id    bigserial not null,
    name  varchar(255),
    price bigint,
    primary key (id)
);