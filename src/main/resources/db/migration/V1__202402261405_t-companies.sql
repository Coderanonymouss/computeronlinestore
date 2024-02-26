drop table if exists t_companies cascade;
create table t_companies
(
    id   bigserial not null,
    name varchar(255),
    primary key (id)
);