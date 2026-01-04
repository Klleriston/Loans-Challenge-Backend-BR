# Loans Challenge - Backend

Desafio backend desenvolvido em **Spring Boot** para gerenciar empréstimos baseado em regras de negócio pre definidas.
([Back-End Brasil](https://github.com/backend-br) - 
[Desafio](https://github.com/backend-br/desafios/blob/master/loans/PROBLEM.md) )


## Descrição do Projeto

Este projeto implementa uma API REST que determina quais tipos de empréstimo estão disponíveis para um cliente com base em suas características (salário, CPF, idade e localizacao). O sistema utiliza regras de negócio configuráveis para validar a elegibilidade do usuário.

## Tecnologias

- **Java 17**
- **Spring Boot 4.0.1**
- **Lombok** 
- **Maven**

## Estrutura do Projeto

```
credChallenge/
├── src/main/java/com/klleriston/credChallenge/
│   ├── controllers/
│   │   └── LoanController.java          # Endpoints REST
│   ├── domain/
│   │   ├── LoanType.java                # Enum dos tipos de empréstimo
│   │   ├── LoanRule.java                # Regra base para empréstimos
│   │   ├── LoanRulesProvider.java       # Provedor de regras
│   │   └── User.java                    # Entidade de usuário
│   ├── dtos/
│   │   ├── AvailableLoansDTO.java       # DTO com empréstimos disponíveis
│   │   └── LoanDTO.java                 # DTO de empréstimo individual
│   ├── services/
│   │   ├── LoanService.java             # Interface do serviço
│   │   └── impl/
│   │       └── LoanServiceImpl.java      # Implementação do serviço
│   └── CredChallengeApplication.java    # Classe principal
├── src/test/java/                       # Testes unitários
├── src/main/resources/
│   └── application.properties            # Configurações da aplicação
└── pom.xml                               # Dependências Maven

```

## Tipos de Empréstimo

O sistema oferece 3 tipos de empréstimo com taxas de juros específicas:

| Tipo | Taxa de Juros |
|------|---------------|
| **PERSONAL** | 4% |
| **CONSIGNMENT** | 2% |
| **GUARANTEED** | 3% |

## Endpoints da API

### Obter Empréstimos Disponíveis

```http
POST /customer-loans
Content-Type: application/json

{
  "age": 26,
  "cpf": "275.484.389-23",
  "name": "Vuxaywua Zukiagou",
  "income": 7000.00,
  "location": "SP"
}
```

**Resposta:**
```json
{
    "userName": "Vuxaywua Zukiagou",
    "availableLoans": [
        {
            "type": "CONSIGNMENT",
            "interestRate": 2
        }
    ]
}
```

## Como Executar

### Pré-requisitos
- Java 17 ou superior
- Maven 3.6+

### Executar a Aplicação

```bash
./mvnw spring-boot:run
```

A aplicação iniciará em `http://localhost:8081`

## Arquitetura

### Padrões Utilizados

1. **MVC Pattern** - Separação entre Controllers, Services e Domain
2. **DTO Pattern** - Transfer Objects para comunicação entre camadas
3. **Strategy Pattern** - LoanRulesProvider e LoanRule para validações
4. **Dependency Injection** - Utilizado pelo Spring Framework

### Fluxo de Requisição

```
LoanController 
    ↓
LoanService (interface)
    ↓
LoanServiceImpl
    ↓
LoanRulesProvider
    ↓
LoanRule[] (validações)
    ↓
AvailableLoansDTO (resposta)
```
## Classes Principais

### LoanService
Interface que define o contrato para obter empréstimos disponíveis.

### LoanServiceImpl
Implementação que processa as regras de negócio:
- Filtra regras aplicáveis ao usuário
- Mapeia os empréstimos permitidos
- Retorna DTOs com as informações formatadas

### LoanRulesProvider
Provedor de regras que determina quais empréstimos são elegíveis baseado nas características do usuário.

## Licença

Este projeto é um desafio de backend e está disponível como código de aprendizado.

## Autor

Desenvolvido por **Klleriston Andrade**

---
