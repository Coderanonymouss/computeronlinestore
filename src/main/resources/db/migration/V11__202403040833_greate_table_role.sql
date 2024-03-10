drop table if exists role cascade;

create table role
(
    id   bigserial not null,
    role varchar(255),
    primary key (id)
);