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
