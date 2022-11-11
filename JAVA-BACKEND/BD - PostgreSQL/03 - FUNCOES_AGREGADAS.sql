SELECT * FROM information_schema.columns WHERE table_name = 'banco';
SELECT column_name, data_type FROM information_schema.columns WHERE table_name = 'banco';

-- AVG
-- COUNT
-- SUM
-- MIN
-- MAX

-- Media dos valores
SELECT AVG (valor) 
FROM cliente_transacoes;

-- Contar os valores em uma tabela
SELECT COUNT(numero)
FROM cliente;

-- Contando e agrupando
SELECT COUNT(numero), email
FROM cliente
WHERE email ILIKE '%gmail.com'
GROUP BY email;

-- Maior numero da tabela
SELECT MAX(numero)
FROM cliente;

SELECT MAX(valor)
FROM cliente_transacoes;

SELECT MAX(valor), tipo_transacao_id
FROM cliente_transacoes
GROUP BY tipo_transacao_id;

-- Menor numero da tabela
SELECT MIN(numero)
FROM cliente;

SELECT MIN(valor)
FROM cliente_transacoes;

SELECT MIN(valor), tipo_transacao_id
FROM cliente_transacoes
GROUP BY tipo_transacao_id;

-- Usando o Having

SELECT COUNT(id), tipo_transacao_id
FROM cliente_transacoes
GROUP BY tipo_transacao_id
HAVING COUNT(id) > 150;

-- SUM 
SELECT SUM (valor)
FROM cliente_transacoes;

-- SUM com ORDER BY
SELECT SUM(valor), tipo_transacao_id
FROM cliente_transacoes
GROUP BY tipo_transacao_id
ORDER BY tipo_transacao_id DESC;