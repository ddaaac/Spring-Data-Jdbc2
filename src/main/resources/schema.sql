create table if not exists person
(
    person_id   bigint primary key auto_increment not null,
    person_name varchar(20),
    age         int
);
