drop table if exists member CASCADE;
create table member
(
 id varchar(255),
 pwd varchar(255),
 primary key (id)
);


create table board
(
 title varchar(255),
 cover varchar(255),
 author varchar(255),
 publisher varchar(255),

 primary key (title)
);

create table review
(
 num bigint generated by default as identity,
 title varchar(255),
 id varchar(255),
 name varchar(255),
 content varchar(1500),

 primary key (title)
);

