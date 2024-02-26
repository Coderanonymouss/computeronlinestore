drop table if exists t_categories cascade;

create table t_categories
(
    id                       bigserial not null,
    name                     varchar,
    company_id               bigint,
    cooler_categories_id     bigint,
    matrix_categories_id     bigint,
    processor_categories_id  bigint,
    ram_categories_id        bigint,
    video_card_categories_id bigint,
    price bigint,
    primary key (id)
);
