create schema cinema;
create table movie
(
    id int,
    name varchar(64) not null,
    length int not null
);

create table session
(
    id int auto_increment,
    movie_id int not null,
    start_time datetime not null,
    cost decimal not null,
    constraint session_pk
        primary key (id),
    constraint session_movie_id_fk
        foreign key (movie_id) references movie (id)
);

create table ticket
(
    id int auto_increment,
    session_id int not null,
    constraint ticket_pk
        primary key (id),
    constraint ticket_session_id_fk
        foreign key (session_id) references session (id)
);

use cinema;

insert into movie (name, length)
values ('Movie1', 60), ('Movie2', 90), ('Movie3', 120);

insert into session (movie_id, start_time, cost)
values (1, '2022-01-05 09:00:00', 15),
       (2, '2022-01-05 10:00:00', 20),
       (3, '2022-01-05 11:00:00', 25),
       (1, '2022-01-05 12:00:00', 20);

insert into ticket (session_id)
values (1),(2),(3),(4),(1),(1),(1),(1),(1),(2),(3),(4),
       (1),(1),(2),(2),(3),(1),(4),(4),(1),(2),(3),(4),
       (1),(1),(1),(1),(1),(2),(3),(4),
       (1),(1),(2),(2),(3),(1),(4),(4);
