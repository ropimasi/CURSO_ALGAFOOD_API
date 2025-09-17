insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');
insert into cozinha (id, nome) values (3, 'Argentina');
insert into cozinha (id, nome) values (4, 'Brasileira');

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

insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_cep, endereco_bairro, endereco_logradouro, endereco_numero, endereco_complemento) values (1, 'Thai Delivery', 5.00, 1, utc_timestamp(), utc_timestamp(), 2, '74823-060', 'Setor Central', 'Av. Goiás', '1000', 'Sala 10');
insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (2, 'Taifudi', 10.00, 1, utc_timestamp(), utc_timestamp());
insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (3, 'Tuktuk Delivery', 6.00, 2, utc_timestamp(), utc_timestamp());
insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (4, 'Tikfudi', 11.00, 2, utc_timestamp(), utc_timestamp());
insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (5, 'Java Steakhouse', 12, 3, utc_timestamp, utc_timestamp);
insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (6, 'Lanchonete do Tio Zé', 11, 4, utc_timestamp, utc_timestamp);
insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (7, 'Bar da Maria', 6, 4, utc_timestamp, utc_timestamp);

insert into permissao (id, nome, descricao) values (1, 'Admin', 'Permissão de administrador');
insert into permissao (id, nome, descricao) values (2, 'Gestão', 'Permissão de gerenciamento');
insert into permissao (id, nome, descricao) values (3, 'Usuário', 'Permissão de usuário');
insert into permissao (id, nome, descricao) values (4, 'Visita', 'Permissão de visitante');

insert into forma_pagamento (id, descricao) values (1, 'DIN');
insert into forma_pagamento (id, descricao) values (2, 'CHQ');
insert into forma_pagamento (id, descricao) values (3, 'PIX');
insert into forma_pagamento (id, descricao) values (4, 'DEB');
insert into forma_pagamento (id, descricao) values (5, 'CRE');

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 1), (1, 2), (1, 3), (2, 3), (3, 2), (3, 3), (4, 1), (4, 2), (5, 1), (5, 2), (6, 3);

insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Porco com molho agridoce', 'Deliciosa carne suína ao molho especial', 78.90, 1, 1);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Camarão tailandês', '16 camarões grandes ao molho picante', 110, 1, 1);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Salada picante com carne grelhada', 'Salada de folhas com cortes finos de carne bovina grelhada e nosso molho especial de pimenta vermelha', 87.20, 1, 2);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Garlic Naan', 'Pão tradicional indiano com cobertura de alho', 21, 1, 3);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Murg Curry', 'Cubos de frango preparados com molho curry e especiarias', 43, 1, 3);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Bife Ancho', 'Corte macio e suculento, com dois dedos de espessura, retirado da parte dianteira do contrafilé', 79, 1, 4);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('T-Bone', 'Corte muito saboroso, com um osso em formato de T, sendo de um lado o contrafilé e do outro o filé mignon', 89, 1, 4);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Sanduíche X-Tudo', 'Sandubão com muito queijo, hamburger bovino, bacon, ovo, salada e maionese', 19, 1, 5);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Espetinho de Cupim', 'Acompanha farinha, mandioca e vinagrete', 8, 1, 6);




