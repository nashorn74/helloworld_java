create user 'spring4'@'localhost' 
	identified by 'spring4';
    
create database spring4fs character set=utf8;

grant all privileges on spring4fs.* to
	'spring4'@'localhost';
    
create table spring4fs.MEMBER(
	ID int auto_increment primary key,
    EMAIL varchar(255),
    PASSWORD varchar(100),
    NAME varchar(100),
    REGDATE datetime,
    unique key (EMAIL)
) engine=InnoDB char set=utf8;

insert into spring4fs.MEMBER
(EMAIL,PASSWORD,NAME,REGDATE)
values ('test@test.net','1234','hong',now());
