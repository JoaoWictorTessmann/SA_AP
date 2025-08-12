CREATE DATABASE IF NOT EXISTS db_autopaint;
USE db_autopaint;

-- Tabela de usuários
CREATE TABLE usuarios (
  id_usuario INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL UNIQUE,
  senha VARCHAR(255) NOT NULL,
  tipo_usuario VARCHAR(20) NOT NULL, -- Substitui ENUM, controlar na aplicação
  data_criacao DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- Tabela de serviços (pedidos)
CREATE TABLE servicos (
  id_servico INT AUTO_INCREMENT PRIMARY KEY,
  nome_cliente VARCHAR(100) NOT NULL,
  descricao VARCHAR(255),
  modelo_carro VARCHAR(100),
  placa VARCHAR(10),
  valor VARCHAR(100),
  tempo_estimado VARCHAR(100),
  status_servico VARCHAR(20) NOT NULL DEFAULT 'Pendente', -- Substitui ENUM
  data_pedido DATETIME DEFAULT CURRENT_TIMESTAMP,
  data_finalizacao DATETIME
);