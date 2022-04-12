create database d_camel;
use d_camel;
create user u_camel identified by 'camel';
grant all privileges on d_camel.* to u_camel;

create table t_trx
(

)