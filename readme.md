# Smart Library Api

API REST desenvolvida com **Spring Boot** para gerenciamento de uma biblioteca, oferecendo autenticação baseada em **JWT** e funcionalidades para gerenciamento de livros e empréstimos.

---

## Tecnologias

- Java 21
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Spring Data JPA
- MySQL
- Maven

---

## Pré-requisitos

Antes de executar o projeto, certifique-se de possuir instalado:

- Java 21 ou superior
- Maven 3.9+
- MySQL

---

## Configuração

### Banco de Dados

Configure as credenciais de acesso ao banco de dados no arquivo:

```properties
src/main/resources/application.properties
```

### Configuração do CORS

Para que o frontend consiga consumir a API, configure a origem permitida através da propriedade:

```properties
# Informe a URL onde o frontend estará sendo executado
app.cors.allowed-origin=http://localhost:5173
```

Caso o frontend utilize outra porta ou domínio, basta alterar o valor dessa propriedade.

**Exemplos:**

```properties
app.cors.allowed-origin=http://localhost:3000
```

```properties
app.cors.allowed-origin=http://localhost:5173
```

```properties
app.cors.allowed-origin=https://meu-frontend.com
```

> **Importante:** A aplicação aceita requisições apenas da origem configurada nessa propriedade.

---

## Executando a aplicação

Clone o repositório:

```bash
git clone <url-do-repositorio>
```

Acesse a pasta do projeto:

```bash
cd <nome-do-projeto>
```

Execute a aplicação:

```bash
./mvnw spring-boot:run
```

Ou execute diretamente pela sua IDE.

Após iniciar, a API estará disponível em:

```text
http://localhost:8080
```

---

## Autenticação

A autenticação da API é realizada utilizando **JWT**.

Após realizar o login, envie o token no cabeçalho das requisições protegidas:

```http
Authorization: Bearer <seu_token>
```

---

## Funcionalidades

- Autenticação de usuários
- Cadastro e gerenciamento de livros
- Controle de empréstimos

---

## Estrutura do Projeto

```
src
├── main
│   ├── java
│   └── resources
│       └── application.properties
└── test
```

---

## Licença

Este projeto foi desenvolvido para fins acadêmicos e de aprendizado.
