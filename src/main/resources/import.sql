insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');

insert into restaurante (nome, id, taxa_frete, cozinha_id) values ('Thai Delivery', 1, 5.00, 1);
insert into restaurante (nome, id, taxa_frete, cozinha_id) values ('Taifudi', 2, 10.00, 1);
insert into restaurante (nome, id, taxa_frete, cozinha_id) values ('Tuktuk Delivery', 3, 6.00, 2);
insert into restaurante (nome, id, taxa_frete, cozinha_id) values ('Tikfudi', 4, 11.00, 2);

insert into estado (id, nome) values (1, 'DF');
insert into estado (id, nome) values (2, 'GO');
insert into estado (id, nome) values (3, 'SP');
insert into estado (id, nome) values (4, 'MG');
insert into estado (id, nome) values (5, 'RJ');
insert into estado (id, nome) values (6, 'PR');
insert into estado (id, nome) values (7, 'BA');

insert into cidade (id, nome, estado_id) values (1, 'Brasília', 1);
insert into cidade (id, nome, estado_id) values (2, 'Goiania', 2);
insert into cidade (id, nome, estado_id) values (3, 'Rio Verde', 2);
insert into cidade (id, nome, estado_id) values (4, 'São Paulo', 3);
insert into cidade (id, nome, estado_id) values (5, 'São José do Rio Preto', 3);
insert into cidade (id, nome, estado_id) values (6, 'Belo Horizonte', 4);
insert into cidade (id, nome, estado_id) values (7, 'Uberlândia', 4);
insert into cidade (id, nome, estado_id) values (8, 'Rio de Janeiro', 5);
insert into cidade (id, nome, estado_id) values (9, 'Curitiba', 6);
insert into cidade (id, nome, estado_id) values (10, 'Salvador', 7);

insert into permissao (id, nome, descricao) values (1, 'Admin', 'Permissão de administrador');
insert into permissao (id, nome, descricao) values (2, 'Gestão', 'Permissão de gerenciamento');
insert into permissao (id, nome, descricao) values (3, 'Usuário', 'Permissão de usuário');
insert into permissao (id, nome, descricao) values (4, 'Visita', 'Permissão de visitante');

insert into forma_pagamento (id, descricao) values (1, 'DIN');
insert into forma_pagamento (id, descricao) values (2, 'CHQ');
insert into forma_pagamento (id, descricao) values (3, 'PIX');
insert into forma_pagamento (id, descricao) values (4, 'DEB');
insert into forma_pagamento (id, descricao) values (5, 'CRE');

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 3), (1, 2), (1, 3), (2, 3), (3, 2), (3, 3); 