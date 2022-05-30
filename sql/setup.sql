drop table if exists user;

create table user (
	user_id int primary key NOT NULL AUTO_INCREMENT,
	first_name varchar(25) NOT NULL,
	last_name varchar(25) NOT NULL,
	email varchar(35) NOT NULL,
	password varchar(15) NOT NULL,
	username varchar(20) unique NOT NULL
);

insert into user (first_name, last_name, email, password, username)
	values ('Francesca', 'Ventura', 'fraventura@icloud.com', 'ciao', 'fra7');
