create table banco(
id bigint not null auto_increment,
code varchar(10) not null,
descricao varchar(50) not null,
primary key (id),
UNIQUE(code)
)engine=InnoDB default charset=utf8;

create table conta(
id bigint not null auto_increment,
numero int not null,
digito int not null,
banco_id bigint not null,
cliente varchar(14),
primary key (id),
foreign key (banco_id) references banco (id)
)engine=InnoDB default charset=utf8;