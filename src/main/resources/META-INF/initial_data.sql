-- insert into lazyloading_eagerloading_categoria (id, nome) value (10, 'bebidas')
-- insert into lazyloading_eagerloading_categoria (id, nome) value (20, 'electrodomesticos')
-- insert into lazyloading_eagerloading_categoria (id, nome) value (30, 'moveis')
--
-- insert into lazyloading_eagerloading_produto (id, categoria_id, nome) values (1, 10, 'Gin')
-- insert into lazyloading_eagerloading_produto (id, categoria_id, nome) values (2, 10, '2M')
-- insert into lazyloading_eagerloading_produto (id, categoria_id, nome) values (3, 10, 'Txilar')
-- insert into lazyloading_eagerloading_produto (id, categoria_id, nome) values (5, 10, 'Coca-Cola')
-- insert into lazyloading_eagerloading_produto (id, categoria_id, nome) values (4, 20, 'Frigorifico')
-- insert into lazyloading_eagerloading_produto (id, categoria_id, nome) values (6, 20, 'Fogao')
-- insert into lazyloading_eagerloading_produto (id, categoria_id, nome) values (8, 30, 'DVD')
-- insert into lazyloading_eagerloading_produto (id, categoria_id, nome) values (9, 30, 'Cama')
-- insert into lazyloading_eagerloading_produto (id, categoria_id, nome) values (21 , 30, 'Guarda fato')
-- insert into lazyloading_eagerloading_produto (id, categoria_id, nome) values (56, 30, 'Sofa')
--
-- insert into exclusao_em_cascata_categoria (id, nome) value (10, 'bebidas')
-- insert into exclusao_em_cascata_categoria (id, nome) value (20, 'electrodomesticos')
-- insert into exclusao_em_cascata_categoria (id, nome) value (30, 'moveis')
--
-- insert into exclusao_em_cascata_produto (id, categoria_id, nome) values (1, 10, 'Gin')
-- insert into exclusao_em_cascata_produto (id, categoria_id, nome) values (2, 10, '2M')
-- insert into exclusao_em_cascata_produto (id, categoria_id, nome) values (3, 10, 'Txilar')
-- insert into exclusao_em_cascata_produto (id, categoria_id, nome) values (5, 10, 'Coca-Cola')
-- insert into exclusao_em_cascata_produto (id, categoria_id, nome) values (4, 20, 'Frigorifico')
-- insert into exclusao_em_cascata_produto (id, categoria_id, nome) values (6, 20, 'Fogao')
-- insert into exclusao_em_cascata_produto (id, categoria_id, nome) values (8, 30, 'DVD')
-- insert into exclusao_em_cascata_produto (id, categoria_id, nome) values (9, 30, 'Cama')
-- insert into exclusao_em_cascata_produto (id, categoria_id, nome) values (21 , 30, 'Guarda fato')
-- insert into exclusao_em_cascata_produto (id, categoria_id, nome) values (56, 30, 'Sofa')
--
-- insert into operacoes_em_lote_usuario(id, email, estado) values (1, 'a@gmail.com', true)
-- insert into operacoes_em_lote_usuario(id, email, estado) values (2, 'b@gmail.com', true)
-- insert into operacoes_em_lote_usuario(id, email, estado) values (3, 'c@gmail.com', true)
-- insert into operacoes_em_lote_usuario(id, email, estado) values (4, 'd@gmail.com', true)
-- insert into operacoes_em_lote_usuario(id, email, estado) values (5, 'e@gmail.com', true)
-- insert into operacoes_em_lote_usuario(id, email, estado) values (6, 'f@gmail.com', true)
-- insert into operacoes_em_lote_usuario(id, email, estado) values (7, 'g@gmail.com', true)
-- insert into operacoes_em_lote_usuario(id, email, estado) values (8, 'h@gmail.com', true)
-- insert into operacoes_em_lote_usuario(id, email, estado) values (9, 'i@gmail.com', true)
-- insert into operacoes_em_lote_usuario(id, email, estado) values (10, 'a@gmail.com', false)
-- insert into operacoes_em_lote_usuario(id, email, estado) values (11, 'a@gmail.com', false)
-- insert into operacoes_em_lote_usuario(id, email, estado) values (12, 'a@gmail.com', false)

-- insert into lock_otimista_produto(id, nome, preco, version) values (1, 'Agua 1L', 30.0, 0)
-- insert into lock_otimista_produto(id, nome, preco, version) values (2, 'Agua 2L', 60.0, 0)
-- insert into lock_otimista_produto(id, nome, preco, version) values (3, 'Agua 5L', 200.0, 0)

insert into cache_de_segundo_nivel_centro_custo (id, designacao) values (1, 'Tech');
insert into cache_de_segundo_nivel_centro_custo (id, designacao) values (1, 'Hibrido');
insert into cache_de_segundo_nivel_centro_custo (id, designacao) values (1, 'HyLurio');
insert into cache_de_segundo_nivel_centro_custo (id, designacao) values (1, 'Royal');


