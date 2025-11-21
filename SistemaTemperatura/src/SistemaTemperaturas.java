// Nome do Aluno: David William Britis Lima
// Trabalho: Sistema de Gerenciamento de Temperaturas Semanais
// Disciplina: Lógica de Programação e Algoritmos
// Data: 21/11/2025
//
// Este programa cria um sistema que registra temperaturas de 7 dias da semana,
// permite exibir todas as temperaturas, calcular a média semanal
// e mostrar o(s) dia(s) mais quente(s) e frio(s).

import java.util.Scanner;

public class SistemaTemperaturas {

    // Vetor que armazena as temperaturas dos 7 dias da semana
    static double[] temperaturas = new double[7];

    // Vetor com o nome dos dias da semana (para exibição mais organizada)
    static String[] diasSemana = {
        "Domingo", "Segunda-feira", "Terça-feira",
        "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado"
    };

    // Objeto Scanner para ler entradas do teclado
    static Scanner entrada = new Scanner(System.in);

    // -----------------------------------------------------------
    // FUNÇÃO: calcularMedia()
    // Retorna a média das temperaturas registradas na semana.
    // -----------------------------------------------------------
    public static double calcularMedia() {
        double soma = 0;

        // Soma todas as temperaturas armazenadas no vetor
        for (int i = 0; i < temperaturas.length; i++) {
            soma += temperaturas[i];
        }

        // Retorna a média
        return soma / temperaturas.length;
    }

    // -----------------------------------------------------------
    // PROCEDIMENTO: mostrarExtremos()
    // Exibe os dias mais quentes e mais frios da semana.
    // -----------------------------------------------------------
    public static void mostrarExtremos() {

        // Inicializa maior e menor como o primeiro valor do vetor
        double maior = temperaturas[0];
        double menor = temperaturas[0];

        // Percorre o vetor procurando valores maiores e menores
        for (int i = 1; i < temperaturas.length; i++) {
            if (temperaturas[i] > maior) {
                maior = temperaturas[i];
            }
            if (temperaturas[i] < menor) {
                menor = temperaturas[i];
            }
        }

        // Exibe os dias de maior temperatura
        System.out.println("\n===== DIAS MAIS QUENTES =====");
        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i] == maior) {
                System.out.println(diasSemana[i] + " → " + temperaturas[i] + "°C");
            }
        }

        // Exibe os dias de menor temperatura
        System.out.println("\n===== DIAS MAIS FRIOS =====");
        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i] == menor) {
                System.out.println(diasSemana[i] + " → " + temperaturas[i] + "°C");
            }
        }
    }

    // -----------------------------------------------------------
    // PROCEDIMENTO: inserirTemperaturas()
    // Lê e armazena as temperaturas da semana com validação.
    // -----------------------------------------------------------
    public static void inserirTemperaturas() {

        // Loop para cadastrar os 7 dias da semana
        for (int i = 0; i < temperaturas.length; i++) {

            double temp;

            // Validação da faixa da temperatura
            do {
                System.out.print("Digite a temperatura de " + diasSemana[i] + " (-20 a 50°C): ");
                temp = entrada.nextDouble();

                if (temp < -20 || temp > 50) {
                    System.out.println("❌ ERRO: Temperatura inválida! Digite entre -20°C e 50°C.");
                }

            } while (temp < -20 || temp > 50); // Repete até o valor ser válido

            // Armazena no vetor
            temperaturas[i] = temp;
        }

        System.out.println("\n✔ Temperaturas cadastradas com sucesso!\n");
    }

    // -----------------------------------------------------------
    // PROCEDIMENTO: mostrarTodas()
    // Exibe todas as temperaturas armazenadas.
    // -----------------------------------------------------------
    public static void mostrarTodas() {

        System.out.println("\n===== TEMPERATURAS REGISTRADAS =====");

        // Mostra cada dia da semana com sua temperatura
        for (int i = 0; i < temperaturas.length; i++) {
            System.out.println(diasSemana[i] + ": " + temperaturas[i] + "°C");
        }

        System.out.println();
    }

    // -----------------------------------------------------------
    // MÉTODO PRINCIPAL (main)
    // Mostra o menu e controla a escolha do usuário.
    // -----------------------------------------------------------
    public static void main(String[] args) {

        int opcao; // guarda a escolha do menu

        do {
            // Exibe o menu na tela
            System.out.println("==============================");
            System.out.println("   SISTEMA DE TEMPERATURAS   ");
            System.out.println("==============================");
            System.out.println("1. Inserir temperaturas");
            System.out.println("2. Mostrar todas as temperaturas");
            System.out.println("3. Calcular média semanal");
            System.out.println("4. Indicar dia mais quente e mais frio");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = entrada.nextInt(); // Lê a opção digitada

            // Validação da opção do menu
            if (opcao < 1 || opcao > 5) {
                System.out.println("❌ Opção inválida! Tente novamente.\n");
                continue; // volta ao menu
            }

            // Escolha da ação baseada no menu
            switch (opcao) {
                case 1:
                    inserirTemperaturas();
                    break;

                case 2:
                    mostrarTodas();
                    break;

                case 3:
                    double media = calcularMedia();
                    System.out.println("\n🌡 Média semanal das temperaturas: " + media + "°C\n");
                    break;

                case 4:
                    mostrarExtremos();
                    break;

                case 5:
                    System.out.println("\nEncerrando o sistema... Até mais!");
                    break;
            }

        } while (opcao != 5); // o menu continua até o usuário escolher sair
    }
}
