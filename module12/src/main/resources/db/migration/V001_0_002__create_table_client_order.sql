create table client_order
(
    created_date_time timestamp(6),
    client_id         varchar(255),
    id                varchar(255) not null,
    primary key (id)
)