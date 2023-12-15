package org.example;

import java.util.Scanner;

public class ConversorTemperatura {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe a temperatura: ");
        double temperatura = scanner.nextDouble();

        char unidadeOrigem;
        while (true) {
            System.out.print("Qual a unidade de origem dessa temperatura? [C, K, F] ");
            unidadeOrigem = scanner.next().toUpperCase().charAt(0);
            if (unidadeOrigem == 'C' || unidadeOrigem == 'K' || unidadeOrigem == 'F') {
                break;
            }
            System.out.println("Unidade origem inválida. Informe novamente.");
        }

        char unidadeDestino;
        while (true) {
            System.out.print("Qual a unidade de destino dessa temperatura? [C, K, F] ");
            unidadeDestino = scanner.next().toUpperCase().charAt(0);
            if (unidadeDestino == 'C' || unidadeDestino == 'K' || unidadeDestino == 'F') {
                break;
            }
            System.out.println("Unidade destino inválida. Informe novamente.");
        }

        double temperaturaConvertida;
        if (unidadeOrigem == 'C') {
            temperaturaConvertida = (unidadeDestino == 'K') ? temperatura + 273.15 :
                    (unidadeDestino == 'F') ? (temperatura * 9 / 5) + 32 : temperatura;
        } else if (unidadeOrigem == 'K') {
            temperaturaConvertida = (unidadeDestino == 'C') ? temperatura - 273.15 :
                    (unidadeDestino == 'F') ? (temperatura - 273.15) * 9 / 5 + 32 : temperatura;
        } else if (unidadeOrigem == 'F') {
            temperaturaConvertida = (unidadeDestino == 'C') ? (temperatura - 32) * 5 / 9 :
                    (unidadeDestino == 'K') ? (temperatura - 32) * 5 / 9 + 273.15 : temperatura;
        } else {
            temperaturaConvertida = temperatura;
        }

        System.out.printf("%.2f %s = %.2f %s%n", temperatura, unidadeOrigem, temperaturaConvertida, unidadeDestino);
    }
}