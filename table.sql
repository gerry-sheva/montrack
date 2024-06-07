create table users (
    id bigserial primary key,
    created_at timestamp default now(),
    updated_at timestamp default now(),
    deleted_at timestamp,
    active_wallet bigint
);

create table user_auth (
    user_id bigint primary key,
    username varchar(127) not null,
    email varchar(127) not null ,
    password varchar(255) not null,
    salt varchar(255) not null,
    google boolean,
    apple boolean
);
