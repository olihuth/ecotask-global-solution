# EcoTask - Plataforma de Micro-Trabalho Verde
### Global Solution 2025/2 - Engenharia de Software - FIAP

---

## 📝 Descrição do Projeto
O EcoTask é uma solução full stack que conecta empresas com demandas de sustentabilidade a trabalhadores (EcoTaskers). O projeto utiliza **Java (Spring Boot)** no backend com arquitetura segura e escalável, e **Kotlin (Jetpack Compose)** no frontend mobile nativo.

---

## 🚀 Tecnologias Utilizadas
* **Backend:** Java 21, Spring Boot 3, Spring Data JPA, Spring Security (BCrypt).
* **Banco de Dados:** SQLite (Arquivo local `ecotask.db`).
* **Mobile:** Android Nativo com Kotlin e Jetpack Compose.
* **Comunicação:** API RESTful (Retrofit no mobile).

---

## ⚙️ Instruções de Execução

### 1. Backend (API)
**Pré-requisitos:** JDK 21 instalado, Maven ou IntelliJ IDEA.

1.  Abra a pasta `Backend` no IntelliJ IDEA.
2.  Aguarde o Maven baixar as dependências.
3.  Execute a classe principal: `br.com.fiap.ecotask.EcotaskApplication`.
4.  O servidor iniciará na porta `8080`.
    * **Nota:** O banco de dados `ecotask.db` será criado automaticamente na raiz do projeto.

### 2. Mobile (App Android)
**Pré-requisitos:** Android Studio (Koala ou superior), Emulador Android.

1.  Abra a pasta `Mobile` no Android Studio.
2.  Aguarde o Gradle sincronizar (`Sync Project`).
3.  **Configuração de IP:** O projeto está configurado para `10.0.2.2` (localhost do Emulador padrão).
    * Se usar dispositivo físico, altere o IP em `service/RetrofitClient.kt`.
4.  Execute o app (`Run 'app'`) em um emulador.

---

## 🧪 Testando a Aplicação (Roteiro de Teste)

### Passo 1: Popular o Banco (Via Postman)
Como o banco é criado do zero, use o Postman para criar os usuários iniciais:

**A. Criar Empresa**
* **POST** `http://localhost:8080/api/usuarios` -> JSON: `{"email": "empresa@fiap.com", "senhaHash": "123", "perfil": "EMPRESA"}`
* **POST** `http://localhost:8080/api/empresas` -> JSON: `{"razaoSocial": "TechCare", "cnpj": "1234", "usuario": {"id": 1}}`

**B. Criar Tarefa**
* **POST** `http://localhost:8080/api/tarefas` -> JSON: `{"titulo": "Limpar Praça", "valorPagamento": 50.0, "empresa": {"id": 1}}`

**C. Criar Trabalhador (Para aceitar tarefas)**
* **POST** `http://localhost:8080/api/usuarios` -> JSON: `{"email": "joao@eco.com", "senhaHash": "123", "perfil": "ECOTASKER"}`
* **POST** `http://localhost:8080/api/ecotaskers` -> JSON: `{"nomeCompleto": "João", "cpf": "111", "usuario": {"id": 2}}`

### Passo 2: Simulação de IoT
Para simular um sensor inteligente criando uma tarefa automaticamente:
* Faça uma requisição **POST** (sem corpo) para: `http://localhost:8080/api/tarefas/iot/alertar-lixeira-cheia`
* Verifique no App Mobile: Uma nova tarefa "ALERTA IOT" aparecerá na lista.

### Passo 3: App Mobile
* Abra o App.
* Visualize a lista de tarefas.
* Clique em **"ACEITAR"**.
* A submissão será enviada para o backend e salva no banco.

---

## 🔒 Segurança Implementada
* **Criptografia:** Todas as senhas são salvas com hash **BCrypt**.
* **Validação:** Uso de `@NotBlank` e `@Email` para garantir integridade dos dados.
* **Proteção:** Uso de JPA Repository para prevenir SQL Injection.

---
