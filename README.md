# 🏦 Sistema Bancário - Java

Simulação de uma conta bancária desenvolvida em Java com orientação a objetos, implementando operações bancárias reais com regras de negócio para cheque especial e cobrança de taxas.

---

## 📋 Funcionalidades

- ✅ Criar conta com depósito inicial
- ✅ Consultar saldo
- ✅ Consultar limite do cheque especial
- ✅ Depositar dinheiro
- ✅ Sacar dinheiro
- ✅ Pagar boleto
- ✅ Verificar uso do cheque especial
- ✅ Exibir extrato de transações

---

## 📐 Regras de Negócio

### Cheque Especial
O limite do cheque especial é definido automaticamente no momento da criação da conta com base no depósito inicial:

| Depósito Inicial | Cheque Especial |
|---|---|
| Até R$ 500,00 | R$ 50,00 |
| Acima de R$ 500,00 | 50% do depósito inicial |

**Exemplo:**
- Depósito inicial de R$ 300,00 → cheque especial de R$ 50,00
- Depósito inicial de R$ 1.000,00 → cheque especial de R$ 500,00

### Uso do Cheque Especial
Quando o saldo da conta não é suficiente para cobrir um saque ou pagamento de boleto, o sistema utiliza automaticamente o cheque especial para cobrir a diferença.

**Exemplo:**
- Saldo: R$ 100,00 | Cheque especial: R$ 200,00
- Saque de R$ 250,00 → saldo vai para R$ 0,00 e R$ 150,00 são retirados do cheque especial

### Taxa de 20%
Ao utilizar o cheque especial, uma taxa de **20% sobre o valor usado** fica pendente e é cobrada automaticamente no próximo depósito, antes de creditar o valor na conta.

**Exemplo:**
- Usou R$ 150,00 do cheque especial → taxa pendente = R$ 30,00
- No próximo depósito de R$ 500,00 → desconta R$ 30,00 → saldo final = R$ 470,00

---

## 🗂️ Estrutura do Projeto

```
src/
├── application/
│   └── Program.java       # Classe principal com menu interativo
└── entities/
    └── BankAccount.java   # Classe da conta bancária com toda a lógica
```

### `BankAccount.java`
Classe que representa a conta bancária. Aplica o conceito de **encapsulamento** — todos os atributos são `private` e acessados via getters e setters. Contém:

- Atributos: `nome`, `saldo`, `chequeEspecial`, `valorUsadoCheque`, `extrato`
- Construtor que define o limite do cheque especial automaticamente
- Métodos de operação bancária com lógica de negócio embutida
- `List<String> extrato` para registrar todas as movimentações

### `Program.java`
Classe principal com o método `main`. Responsável por:
- Capturar os dados do usuário via `Scanner`
- Instanciar a `BankAccount`
- Exibir o menu em loop com `do/while`
- Direcionar cada opção para o método correspondente via `switch`

---

## 💡 Conceitos de Java Aplicados

- **Orientação a Objetos** — encapsulamento com atributos `private`, getters e setters
- **Construtores** — inicialização dos atributos com lógica de negócio
- **ArrayList / List** — armazenamento do histórico de transações
- **For-each** — iteração do extrato para exibição
- **Scanner** — leitura de dados do usuário no terminal
- **do/while + switch** — controle do fluxo do menu interativo
- **String.format / printf** — formatação de valores monetários com 2 casas decimais

---

## ▶️ Como Executar

### Pré-requisitos
- Java 17 ou superior instalado
- IntelliJ IDEA ou qualquer IDE Java

### Passos
```bash
# Clone o repositório
git clone https://github.com/RayDavyd/sistema-bancario-java.git

# Abra na sua IDE e execute a classe
src/application/Program.java
```

---

## 🖥️ Exemplo de Uso

```
======== CRIE SUA CONTA ========
Informe seu nome: Ray
Informe o valor do seu primeiro deposito: R$ 1000.00

Seja bem-vindo(a), Ray!

===========  BANCO  ===========
1. Consultar saldo
2. Consultar cheque especial
3. Depositar dinheiro
4. Sacar dinheiro
5. Pagar boleto
6. Verificar cheque especial
7. Exibir extrato
0. Sair
================================
```

---

## 👨‍💻 Autor

Feito por [RayDavyd](https://github.com/RayDavyd)
