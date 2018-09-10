create table author
(
code int primary key auto_increment,
name char(35) not null unique
)Engine=InnoDB;
create table book
(
code int primary key auto_increment,
title char(35) not null unique,
author_code int not null,
category char(35) not null,
price int not null,
foreign key (author_code) references author(code)
)Engine=InnoDB;
