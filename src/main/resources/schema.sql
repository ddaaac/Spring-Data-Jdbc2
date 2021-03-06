create table if not exists person
(
    person_id   bigint primary key auto_increment not null,
    person_name varchar(20),
    age         int
);

create table if not exists article
(
    id       bigint primary key auto_increment,
    author   varchar(50),
    contents varchar(255)
);

create table if not exists comment
(
    content     varchar(255),
    article     bigint,
    article_key bigint
);

create table if not exists chess
(
    id bigint primary key auto_increment
);

create table if not exists piece
(
    name     varchar(30),
    chess_id bigint,
    position varchar(20)
);

create table if not exists embedded_entity
(
    id            bigint primary key auto_increment,
    name          varchar(255),
    child1_name1x varchar(255),
    child1_name2x varchar(255),
    child2_name1x varchar(255),
    child2_name2x varchar(255)
);

create table if not exists user
(
    id   bigint primary key,
    name varchar(50)
);

create table if not exists orders
(
    id    varchar(255) primary key,
    title varchar(50)
);

create table if not exists product
(
    id      bigint primary key,
    name    varchar(255),
    version bigint
);

create table if not exists member
(
    id         bigint primary key,
    name       varchar(50),
    password   varchar(255),
    created_at datetime
);

create table if not exists subway
(
    id         bigint primary key auto_increment,
    name       varchar(255) not null,
    created_at datetime     not null,
    updated_at datetime     not null
);

create table if not exists favorite
(
    id         bigint primary key auto_increment,
    source_id  bigint       not null,
    target_id  bigint       not null,
    name       varchar(255) not null,
    created_at datetime     not null,
    updated_at datetime     not null
);

create table if not exists time_entity_base
(
    id         bigint primary key auto_increment,
    name       varchar(255) not null,
    created_at datetime,
    updated_at datetime
);

create table if not exists time_child
(
    name       varchar(255) not null,
    parent_key bigint       not null,
    parent_id  bigint       not null,
    created_at datetime,
    updated_at datetime
);

create table if not exists validation_entity
(
    id              bigint primary key auto_increment,
    long_than_three varchar(255),
    not_blank       varchar(255),
    past            datetime,
    positive        int,
    embedded_name   varchar(255)
);

create table if not exists validation_child_entity
(
    email             varchar(255),
    validation_entity bigint
);

create table if not exists issue
(
    id         bigint primary key auto_increment,
    member_id  bigint,
    title      varchar(255),
    created_at datetime,
    updated_at datetime
)
