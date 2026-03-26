JWT Authentication Template - Spring Security

Template de autenticação com JWT utilizando Spring Boot e Spring Security, projetado para ser reutilizável em diferentes projetos backend.

Problema

Ao iniciar novos projetos, é comum:

Repetir a configuração de segurança do zero
Copiar código sem entender completamente
Criar implementações inconsistentes entre projetos

Este template foi criado para resolver isso, oferecendo uma base padronizada, segura e reutilizável.

Solução

Uma estrutura genérica de autenticação baseada em JWT com:

Autenticação stateless
Filtro customizado integrado ao Spring Security
Controle de acesso por roles (USER / ADMIN)
Senhas criptografadas com BCrypt
Arquitetura desacoplada e reutilizável
Estrutura do Projeto
security/
├── config/
│   └── SecurityConfig.java
├── controller/
│   └── AuthController.java
├── dto/
│   ├── LoginRequest.java
│   └── LoginResponse.java
├── jwt/
│   └── JwtAuthenticationFilter.java
├── service/
│   ├── AuthService.java
│   └── JwtService.java
├── repository/
│   └── UserRepository.java
├── model/
│   └── User.java

Fluxo de Autenticação
Usuário faz login (/auth/login)
API valida credenciais
Token JWT é gerado
Cliente envia o token no header:
Authorization: Bearer {token}
O filtro intercepta a requisição
Usuário é autenticado no contexto do Spring
Acesso é liberado conforme a role
Regras de Acesso (exemplo)
Endpoint	Acesso
/auth/**	Público
/public/**	Público
/user/**	USER, ADMIN
/admin/**	ADMIN

Como usar
Clone o repositório
git clone https://github.com/seu-usuario/seu-repo.git
Configure seu banco de dados
Crie um usuário com senha criptografada:
passwordEncoder.encode("sua_senha");
Inicie a aplicação

Tecnologias
Java
Spring Boot
Spring Security
JWT
BCrypt
