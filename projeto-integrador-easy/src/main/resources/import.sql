-- Inserindo usuários
INSERT INTO usuario (id, nome, email, senha) VALUES
(1, 'Arthur Auersvald', 'arthur@email.com', '123456'),
(2, 'Sara Mendes', 'sara@email.com', '654321'),
(3, 'João Silva', 'joao@email.com', 'abc123'),
(4, 'Maria Oliveira', 'maria@email.com', 'maria321'),
(5, 'Pedro Santos', 'pedro@email.com', 'senha123');

-- Inserindo categorias
INSERT INTO categoria (id, nome, tipo) VALUES
(1, 'Alimentação', 'DESPESA'),
(2, 'Transporte', 'DESPESA'),
(3, 'Salário', 'RECEITA'),
(4, 'Lazer', 'DESPESA'),
(5, 'Investimentos', 'RECEITA');

-- Inserindo transações
INSERT INTO transacao (id, tipo, valor, data, descricao, categoria_id, usuario_id) VALUES
(1, 'DESPESA', 50.00, '2025-09-01', 'Almoço no restaurante', 1, 1),
(2, 'DESPESA', 120.00, '2025-09-02', 'Gasolina', 2, 1),
(3, 'RECEITA', 3000.00, '2025-09-05', 'Pagamento salário', 3, 2),
(4, 'DESPESA', 80.00, '2025-09-07', 'Cinema e pipoca', 4, 3),
(5, 'RECEITA', 500.00, '2025-09-08', 'Dividendos', 5, 4);

-- Inserindo investimentos
INSERT INTO investimento (id, valorAplicado, dataAplicacao, tipoInvestimento, usuario_id) VALUES
(1, 1000.00, '2025-08-15', 'RENDA_FIXA', 1),
(2, 2000.00, '2025-08-20', 'RENDA_VARIAVEL', 2),
(3, 1500.00, '2025-08-25', 'CRIPTO', 3),
(4, 500.00, '2025-08-28', 'RENDA_FIXA', 4),
(5, 3000.00, '2025-08-30', 'RENDA_VARIAVEL', 5);
