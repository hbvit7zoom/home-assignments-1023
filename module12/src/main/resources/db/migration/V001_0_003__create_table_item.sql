create table item
(
    price_rub float(53),
    article   varchar(255),
    id        varchar(255) not null,
    name      varchar(255),
    order_id  varchar(255),
    primary key (id)
)