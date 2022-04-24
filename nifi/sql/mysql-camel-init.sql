create database db_camel;
create user u_camel identified by 'camel';
grant all privileges on db_camel.* to u_camel;

use db_camel;

create table t_trx
(
    c_card   varchar(255),
    n_amount integer
)