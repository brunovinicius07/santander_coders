package org.example;

import java.util.Scanner;

public class TabelaSAC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor do empréstimo: ");
        double valorEmprestimo = scanner.nextDouble();

        System.out.print("Digite o tempo para pagamento em meses: ");
        int meses = scanner.nextInt();

        System.out.print("Digite a taxa de juros do empréstimo (em %): ");
        double juros = scanner.nextDouble();
               juros = juros / 100.0;

        double amortizacao = valorEmprestimo / meses;

        double saldoDevedor = valorEmprestimo;

        double totalJuros = 0;
        double totalAmortizado = 0;

        System.out.printf("Valor fixo da amortização R$ %.2f," +
                        " Saldo devedor total R$ %.2f com um juros de %.2f%% ao mês %n",
                amortizacao, valorEmprestimo, juros * 100);

        for (int i = 1; i <= meses; i++) {
            double jurosMensal = saldoDevedor * juros;

            double prestacao = jurosMensal + amortizacao;

            saldoDevedor -= amortizacao;
            totalJuros += jurosMensal;
            totalAmortizado += amortizacao;

            System.out.printf("Parcela %d | Juros: R$ %.2f | Prestação: R$ %.2f | Saldo devedor: R$ %.2f%n",
                    i, jurosMensal, prestacao, saldoDevedor);
        }

        System.out.printf("Total: Prestação R$ %.2f, Juros R$ %.2f, Amortização R$ %.2f%n",
                totalAmortizado + totalJuros, totalJuros, totalAmortizado);
    }
}