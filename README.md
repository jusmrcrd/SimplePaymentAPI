# SimplePaymentAPI

Uma API para confirmação dos dados de pagamento de cartão.

## Funcionalidades

- **Criar Agendamento:** Adicionar e confirmar pagamentos;

## Instalação

### Requisitos

- Java 21
- Maven
- Banco de dados (configuração padrão para H2)

### Configuração
1. **Clone o Repositório:**

```bash
git clone https://github.com/jusmrcrd/SimplePaymentAPI.git
cd SimplePaymentAPI
```
2. **Instale as Dependências:**

```bash
mvn install
```
3. **Execute a Aplicação:**

```bash
mvn spring-boot:run
```
## Uso

### Endpoints

#### Confirmar pagamento
- **Método:** `POST`
- **URL:** `/`
- **Descrição:** manda um Requisito com as informações do pagamento.
- **Corpo da Requisição:**
```json 
  {
    "method":"debit",
    "flag":"visa", 
    "amount": 75.32
  }
   ```
