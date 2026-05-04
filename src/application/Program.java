package application;

import entities.BankAccount;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("======== CRIE SUA CONTA ========");
        System.out.print("Informe seu nome: ");
        String nome = sc.nextLine();
        System.out.print("Informe o valor do seu primeiro deposito: R$ ");
        double deposito = sc.nextDouble();

        BankAccount account = new BankAccount(nome, deposito);
        System.out.printf("%nSeja bem-vindo(a), %s!%n", account.getNome());

        int opc;
        do {
            System.out.println("\n===========  BANCO  ===========");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Consultar cheque especial");
            System.out.println("3. Depositar dinheiro");
            System.out.println("4. Sacar dinheiro");
            System.out.println("5. Pagar boleto");
            System.out.println("6. Verificar cheque especial");
            System.out.println("7. Exibir extratos");
            System.out.println("0. Sair");
            System.out.println("================================");
            System.out.print("Escolha uma opção: ");
            opc = sc.nextInt();


            switch (opc) {
                case 1 -> account.consultarSaldo();
                case 2 -> account.consultarChequeEspecial();
                case 3 -> {
                    System.out.print("Informe o valor do deposito: ");
                    deposito = sc.nextDouble();
                    account.depositarDinheiro(deposito);
                }
                case 4 -> {
                    System.out.print("Informe o valor do saque: ");
                    double saque = sc.nextDouble();
                    account.sacarDinheiro(saque);
                }
                case 5 -> {
                    System.out.print("Informe o valor do boleto a ser pago: ");
                    double valor = sc.nextDouble();
                    account.pagarBoleto(valor);
                }
                case 6 -> account.verificarChequeEspecial();

                case 7 -> account.exibirExtrato();

                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");

            }

        } while (opc != 0);


    }
}
