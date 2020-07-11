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
    id bigint primary key auto_increment,
    name varchar(255),
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
    id       bigint primary key,
    name     varchar(50),
    password varchar(255)
);
