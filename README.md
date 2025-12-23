# 📌 Sistema Kanban – Backend

Backend de um sistema Kanban desenvolvido com **Spring Boot**, focado no gerenciamento de tarefas e organização de atividades em colunas (ex: *A Fazer*, *Em Progresso*, *Concluído*).

O projeto segue boas práticas de desenvolvimento backend, arquitetura em camadas e princípios REST, servindo como base para integração com aplicações frontend.

---

## 🚀 Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **Spring Security + JWT**
- **Hibernate**
- **PostgreSQL**
- **Swagger / OpenAPI**
- **Maven**

---

## 🧩 Funcionalidades

- Cadastro e autenticação de usuários
- Geração e validação de token JWT
- CRUD de atividades/tarefas
- Organização das tarefas no modelo **Kanban**
- Controle de acesso por autenticação
- Documentação automática da API com Swagger

---

## 🏗️ Arquitetura

O projeto foi estruturado seguindo o padrão **MVC** e arquitetura em camadas:

- **Controller** – Camada de entrada (API REST)
- **Service** – Regras de negócio
- **Repository** – Acesso ao banco de dados
- **Model / Entity** – Entidades do sistema
- **Security** – Autenticação e autorização com JWT
- **DTOs** – Transferência de dados

---

## 🔐 Segurança

- Autenticação baseada em **JWT (JSON Web Token)**
- Proteção de endpoints com **Spring Security**
- Tokens assinados e com tempo de expiração
- Controle de acesso a rotas protegidas

---

## 📄 Documentação da API

Após rodar o projeto, a documentação estará disponível em:

http://localhost:8080/swagger-ui/index.html


---

## ⚙️ Como Executar o Projeto

### Pré-requisitos
- Java 17+
- Maven
- PostgreSQL

### Passos

```bash
# Clonar o repositório
git clone https://github.com/seu-usuario/seu-repositorio.git

# Entrar no projeto
cd seu-repositorio

# Executar a aplicação
mvn spring-boot:run


````

---
## Configure o banco PostgreSQL no arquivo application.properties

spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
spring.datasource.username=usuario
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update

---

## 🎯 Objetivo do Projeto

Este projeto foi desenvolvido com o objetivo de:

- Praticar desenvolvimento backend com Spring Boot
- Aplicar autenticação e autorização com JWT
- Construir uma API REST organizada e segura
- Servir como projeto de portfólio profissional

---

## 👨‍💻 Autor

Ícaro Lins Gomes

Desenvolvedor Backend Java | Spring Boot

GitHub: https://github.com/icaroLins
LinkedIn: https://www.linkedin.com/in/icaro-lins-gomes-16324422b/
