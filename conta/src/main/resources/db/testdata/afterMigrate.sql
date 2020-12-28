set foreign_key_checks = 0;

delete from conta;
delete from banco;

insert into banco(id, code, descricao) values (1, '241', 'Bradesco');
insert into banco(id, code, descricao) values (2, '586', 'Santander');
insert into banco(id, code, descricao) values (3, '125', 'Brasil');