-- run it on MySQL as root
-- creates user and schema yellow

drop user if exists yellow;
drop schema if exists yellow;

-- !!! change password !!!
create user yellow identified by 'password';
create schema yellow;

grant all privileges on yellow.* to yellow;
