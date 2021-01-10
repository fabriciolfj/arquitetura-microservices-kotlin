create table banco(
id bigint not null auto_increment,
code varchar(10) not null,
descricao varchar(50) not null,
primary key (id),
UNIQUE(code)
)engine=InnoDB default charset=utf8;

create table conta(
id bigint not null auto_increment,
numero varchar(10) not null,
banco_id bigint not null,
cliente varchar(14),
unique key unique_numero (numero),
primary key (id),
foreign key (banco_id) references banco (id)
)engine=InnoDB default charset=utf8;

create table extrato (
id bigint not null auto_increment,
conta_id bigint not null,
data datetime,
saldo numeric(15,4),
operacao varchar(10) not null,
foreign key (conta_id) references conta(id),
primary key (id)
)engine=InnoDB default charset=utf8;