# Sistema de Autenticação e Autorização

Esta API permite que você controle acessos a diferentes partes do sistema com base nas ROLES dos usuários.

## Sumário
- Endpoints
- Autenticação
- Erros Comuns
- Estrutura do Projeto
- Componentes Principais
- Uso
- Exemplos de Requisições

## Endpoints

- **POST /login**: Autentica um usuário e retorna um token JWT.
- **GET /username/{token}**: Extrai o nome de usuário de um token JWT fornecido.
- **GET /user**: Retorna as informações do usuário autenticado.
- **GET /admin**: Restrito a usuários com o papel "ADMIN".
- **GET /moderado**: Restrito a usuários com o papel "MODERADO".
- **GET /comum**: Restrito a usuários com o papel "COMUM".

## Autenticação

Esta API utiliza JSON Web Token (JWT) como método de autenticação. Após um usuário ser autenticado via `/login`, um token JWT é gerado e deve ser usado para acessar endpoints protegidos.

## Erros Comuns

- **401 Unauthorized**: Indica que o usuário ou a senha estão incorretos.
- **403 Forbidden**: Indica que o usuário autenticado não possui a role necessária para acessar o endpoint.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

- **config**: Configurações de segurança e beans do Spring.
- **controller**: Controladores REST que lidam com as requisições HTTP.
- **model**: Modelos de dados para requisições e respostas.
- **security**: Classes utilitárias para operações relacionadas ao JWT.
- **service**: Serviços que contêm a lógica de negócios.

## Componentes Principais

### Pontos de entrada da aplicação
- `AuenticacaoAutorizacaoApplication`: Classe principal que inicializa a aplicação Spring Boot.

### Configuração de segurança
- `SecurityConfig`: Configura as definições de segurança HTTP, detalhes dos usuários e codificação de senhas. Define quais endpoints requerem autenticação e quais são acessíveis publicamente.

### Controller
- `AuthController`: Manipula requisições relacionadas à autenticação e fornece os endpoints de login e acesso aos recursos protegidos.

### Model
- `UserEntity`: Representa os dados do usuário para as requisições de login.

### Security
- `JwtUtil`: Contém métodos para gerar e extrair informações de tokens JWT.

### Service
- `AuthService`: Fornece métodos para gerar tokens JWT e extrair nomes de usuário dos tokens.

## Uso

### Executar a aplicação
Use sua IDE ou linha de comando para executar a classe `AuenticacaoAutorizacaoApplication`.

### Autenticar usuário
Envie uma requisição POST para /login com um JSON contendo username e password.

## Exemplos de requisição

### Requisição de Login
```sh
curl -X POST http://localhost:8080/login -H "Content-Type: application/json" -d '{"username": "giovanna", "password": "0311"}'
```
### Extrair nome de usuário
```sh
curl -X GET http://localhost:8080/username/{token}
```
### Acessar endpoint do administrador
```sh
curl -X GET http://localhost:8080/admin -H "Authorization: Bearer {token}"
```


## Prints do Insomnia

![Captura de tela 2024-06-16 171659](https://github.com/giovanna252gabriela/SistemaDeAutenticacaoAutorizacao/assets/125416536/249457d7-6e5f-45d7-b6ac-d2f51b5f2738)
![Captura de tela 2024-06-16 171751](https://github.com/giovanna252gabriela/SistemaDeAutenticacaoAutorizacao/assets/125416536/40894d3c-5415-4813-b8af-8a8f7970e1fe)
![Captura de tela 2024-06-16 171902](https://github.com/giovanna252gabriela/SistemaDeAutenticacaoAutorizacao/assets/125416536/bd96c7e3-418c-4c5e-8029-6ad8365d329c)
![Captura de tela![Captura de tela 2024-06-16 172123](https://github.com/giovanna252gabriela/SistemaDeAutenticacaoAutorizacao/assets/125416536/604365dd-3e34-4250-8074-ecd516908fe3)
 2024-06-16 172002](https://github.com/giovanna252gabriela/SistemaDeAutenticacaoAutorizacao/assets/125416536/78f203e6-f66d-4cfe-8527-db79f1d9f606)
![Captura de tela 2024-06-16 172153](https://github.com/giovanna252gabriela/SistemaDeAutenticacaoAutorizacao/assets/125416536/e9f82179-9e92-4de9-9bd0-77c9c37f9cd8)

## Diagrama

![Captura de tela 2024-06-15 181848](https://github.com/giovanna252gabriela/SistemaDeAutenticacaoAutorizacao/assets/125416536/17ca7adb-5e95-44e9-9623-3cb23af76986)
