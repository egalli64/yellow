drop table if exists comment;
drop table if exists user_book;
drop table if exists user;
drop table if exists book;

create table user (
	user_id int primary key AUTO_INCREMENT,
	first_name varchar(25) NOT NULL,
	last_name varchar(25) NOT NULL,
	email varchar(35) NOT NULL,
	password varchar(15) NOT NULL,
	username varchar(20) unique NOT NULL
);

insert into user (first_name, last_name, email, password, username)
	values ('Francesca', 'Ventura', 'fraventura@icloud.com', 'ciao', 'fra7');
insert into user (first_name, last_name, email, password, username) 
	values ('Mario', 'Rossi', 'mariorossi@gmail.com', 'cane', 'mariorossi88');
insert into user (first_name, last_name, email, password, username)
	values ('Lorena', 'Carbone', 'lorenacarbone@gmail.com','hgud', 'lorenac');
insert into user (first_name, last_name, email, password, username)
	values ('Giovanni', 'Roma', 'gioroma@libero.it', 'roma123', 'giovanniroma');
insert into user (first_name, last_name, email, password, username)
	values ('Valentina', 'Ranieri', 'vale.ran1@gmail.com', 'fuffy', 'valeranieri84');
insert into user (first_name, last_name, email, password, username)
	values ('Luca', 'Martini', 'martinil98@hotmail.it', 'jnfgjsd', 'lucamartini98');
insert into user (first_name, last_name, email, password, username)
	values ('Sara', 'Di Stefano', 'saradistef@gmail.com', 'pizza', 'sarads');
insert into user (first_name, last_name, email, password, username)
	values ('Lorenzo', 'Clemente', 'loreclemente1@libero.it', 'abcde', 'lorenzo1');
insert into user (first_name, last_name, email, password, username)
	values ('Giulia', 'Mazzini', 'giulimazzi@gmail.it', 'gatto', 'giulietta92');

create table book (
	book_id int primary key AUTO_INCREMENT,
	title varchar(40) not null,
	author varchar(40) not null, 
	genre varchar(20) not null
);
insert into book (title, author, genre)
	values ('Divina Commedia', 'Dante Alighieri', 'Italian Literature');
insert into book (title, author, genre)
	values ('1984', 'George Orwell', 'Science fiction');
insert into book (title, author, genre)
	values ('Dottor Watson', 'Arthur Conan Doyle', 'thriller');
insert into book (title, author, genre)
	values ('Il piccolo principe', 'Antoine de Saint-Exupéry', 'novel');
insert into book (title, author, genre)
	values ('Alla ricerca del tempo perduto', 'Marcell Proust', 'novel');
insert into book (title, author, genre)
	values ('Via col vento', ' Margaret Mitchell', 'novel');
insert into book (title, author, genre)
	values ('Piccole donne', 'Louisa May Alcott', 'novel');
insert into book (title, author, genre)
	values ('Harry Potter','J.K. Rowling', 'Science fiction');
insert into book (title, author, genre)
	values ('Orlando furioso', 'Ludovico Ariosto', 'Italian literature');
insert into book (title, author, genre)
	values ('Eragon', 'Christopher Paolini', 'Science fiction');

create table user_book (
	user_book_id int primary key AUTO_INCREMENT,
	book_id int not null,
	user_id int not null,
	vote int not null,
	review varchar(250),
	foreign key (user_id) references user (user_id),
	foreign key (book_id) references book (book_id)
);

create table comment (
	comment_id int primary key AUTO_INCREMENT,
	live_comment varchar(250) NOT NULL,
	user_book_id int NOT NULL,
	foreign key (user_book_id) references user_book (user_book_id)
);