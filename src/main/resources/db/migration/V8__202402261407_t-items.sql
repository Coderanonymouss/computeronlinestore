drop table if exists t_items cascade;

create table t_items
(
    id                       bigserial not null,
    amount                   integer,
    name                     varchar(200),
    price                    integer,
    company_id               bigint,
    cooler_categories_id     bigint,
    matrix_categories_id     bigint,
    processor_categories_id  bigint,
    ram_categories_id        bigint,
    video_card_categories_id bigint,
    primary key (id)
);

