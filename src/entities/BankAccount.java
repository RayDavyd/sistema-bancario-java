package entities;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String nome;
    private double saldo;
    private double chequeEspecial;
    private double valorUsadoCheque;
    private final List<String> extrato;

    public BankAccount(String nome, double saldo) {
        this.nome = nome;
        this.saldo = saldo;
        this.extrato = new ArrayList<>();
        if (saldo <= 500.00) {
            this.chequeEspecial = 50.0;
        } else {
            this.chequeEspecial = saldo * 0.5;
        }
        extrato.add(String.format("Conta criada com deposito inicial: +R$ %.2f", saldo));
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public void consultarSaldo() {
        System.out.printf("Saldo: R$ %.2f%n", saldo);
    }

    public void consultarChequeEspecial() {
        System.out.printf("Limite do cheque especial: R$ %.2f%n", chequeEspecial);
    }

    public void depositarDinheiro(double valor) {
        if (valorUsadoCheque > 0) {
            double taxa = valorUsadoCheque * 0.20;
            System.out.printf("Taxa de cheque especial cobrada: R$ %.2f%n", taxa);
            valor -= taxa;
            valorUsadoCheque = 0;
        }
        saldo += valor;
        System.out.printf("Depósito realizado! Saldo atual: R$ %.2f%n", saldo);
        extrato.add(String.format("Deposito: +R$ %.2f | Saldo: R$ %.2f", valor, saldo));
    }

    public void sacarDinheiro(double valor) {
        double limiteTotal = saldo + chequeEspecial;
        if (valor <= saldo) {
            saldo -= valor;
            System.out.printf("Saque realizado! Saldo atual: R$ %.2f%n", saldo);
            extrato.add(String.format("Saque: -R$ %.2f | Saldo: R$ %.2f", valor, saldo));
        } else if (valor <= limiteTotal) {
            double diferenca = valor - saldo;
            saldo = 0;
            valorUsadoCheque += diferenca;
            System.out.printf("Saque realizado usando R$ %.2f do cheque especial.%n", diferenca);
            extrato.add(String.format("Saque c/ cheque especial: -R$ %.2f | Saldo: R$ %.2f", valor, saldo));
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void pagarBoleto(double valor) {
        double limiteTotal = saldo + chequeEspecial;
        if (valor <= saldo) {
            saldo -= valor;
            System.out.printf("Boleto pago! Saldo atual: R$ %.2f%n", saldo);
            extrato.add(String.format("Boleto pago: -R$ %.2f | Saldo: R$ %.2f", valor, saldo));
        } else if (valor <= limiteTotal) {
            double diferenca = valor - saldo;
            saldo = 0;
            valorUsadoCheque += diferenca;
            System.out.printf("Boleto pago usando R$ %.2f do cheque especial.%n", diferenca);
            extrato.add(String.format("Boleto pago: -R$ %.2f | Saldo: R$ %.2f", valor, saldo));

        } else {
            System.out.println("Saldo insuficiente para pagar o boleto.");
        }
    }

    public void verificarChequeEspecial() {
        if (valorUsadoCheque > 0) {
            System.out.printf("Você está usando R$ %.2f do cheque especial.%n", valorUsadoCheque);
            System.out.printf("Taxa pendente no próximo depósito: R$ %.2f%n", valorUsadoCheque * 0.20);
        } else {
            System.out.println("Cheque especial não está sendo usado.");
        }
    }

    public void exibirExtrato() {
        System.out.println("=== EXTRATO BANCÁRIO ===");
        if (extrato.isEmpty()) {
            System.out.println("Nenhuma movimentação realizada.");
        } else {
            for (String registro : extrato) {
                System.out.println(registro);
            }
        }
        System.out.println("Saldo final: R$ " + saldo);
    }

}