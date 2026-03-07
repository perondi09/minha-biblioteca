# 📚 API minha biblioteca

Uma API REST simples desenvolvida para registrar, organizar e ter o controle total sobre os livros que já li. O projeto conta com autenticação segura de usuários e persistência de dados em banco de dados relacional.

## 🚀 Tecnologias Utilizadas

Este projeto foi desenvolvido utilizando as seguintes tecnologias:

* **Java**
* **Spring Boot**
* **Spring Data JPA**
* **PostgreSQL**
* **JWT (JSON Web Token)** para autenticação e autorização
* **Maven** para gerenciamento de dependências

## ⚙️ Pré-requisitos

Antes de começar, você vai precisar ter as seguintes ferramentas instaladas na sua máquina:
* [JDK 21+](https://www.oracle.com/java/technologies/javase-downloads.html)
* [PostgreSQL](https://www.postgresql.org/)

## 🛠️ Configuração e Execução

1. Clone o repositório:
```bash
git clone https://github.com/perondi09/minha-biblioteca.git
```

2. Acesse a pasta do projeto:

```bash
cd minha-biblioteca
```

3. Configure o banco de dados PostgreSQL. Crie um banco com o nome apropriado e atualize as credenciais (usuário e senha) no arquivo `src/main/resources/application.properties` (ou `.yml`):

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/sua_base_de_dados
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update

# Configuração da chave JWT
api.security.token.secret=sua_chave_secreta_aqui

```

4. Execute a aplicação:

```bash
mvn spring-boot:run

```

O servidor iniciará localmente na porta `8080` (por padrão).

## 📍 Endpoints da Aplicação

Como a aplicação possui autenticação via **JWT**, é necessário primeiro registrar um usuário, fazer o login para obter o token e, em seguida, passar o token no Header (`Authorization: Bearer <seu_token>`) das requisições privadas.

### Autenticação (Público)

| Método | Rota | Descrição |
| --- | --- | --- |
| `POST` | `/auth/register` | Cria um novo usuário no sistema |
| `POST` | `/auth/login` | Autentica o usuário e retorna o Token JWT |

### Livros (Requer Autenticação)

| Método | Rota | Descrição |
| --- | --- | --- |
| `GET` | `/api/livros` | Lista todos os livros registrados |
| `GET` | `/api/livros/{id}` | Retorna um livro especifico |
| `POST` | `/api/livros` | Adiciona um novo livro à biblioteca |
| `DELETE` | `/api/livros/{id}` | Remove um livro do registro |

*Observação: As rotas iniciadas com `/api/livros` exigem o token JWT válido no cabeçalho da requisição.*

## 📝 Exemplo de Requisição (JSON)

**Criar Livro (`POST /api/livros`)**

```json
{
  "titulo": "O Senhor dos Anéis: A Sociedade do Anel",
  "autor": "J.R.R. Tolkien"  
}

```

## 👨‍💻 Autor

Desenvolvido por **Guilherme Perondi** - [Linkedin](https://www.linkedin.com/in/guilherme-perondi/)
