Instruções

mvn -N wrapper:wrapper

ao clonar o projeto, executar mvn wrapper:wrapper para baixar as dependencias e organizar o ambiente.

./mvnw spring-boot:run

#Sql

CREATE TABLE `categoria` (
 id int(11) NOT NULL AUTO_INCREMENT,
 nome varchar(255) NOT NULL,
 descricao text DEFAULT NULL,
 categoria_pai_id int(11) DEFAULT NULL,
 PRIMARY KEY (id),
 KEY categoria_pai_id (categoria_pai_id),
 CONSTRAINT categoria_ibfk_1 FOREIGN KEY (categoria_pai_id) REFERENCES categoria (id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci



CREATE TABLE produto (
 id int(11) NOT NULL AUTO_INCREMENT,
 nome varchar(255) NOT NULL,
 descricao text DEFAULT NULL,
 valor decimal(10,2) NOT NULL,
 quantidade_estoque int(11) NOT NULL,
 categoria_id int(11) DEFAULT NULL,
 PRIMARY KEY (id),
 KEY categoria_id (categoria_id),
 CONSTRAINT produto_ibfk_1 FOREIGN KEY (categoria_id) REFERENCES categoria (id) ON DELETE CASCADE
);
