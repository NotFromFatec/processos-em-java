package view;

import controller.Kill;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Kill Kill = new Kill();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:\n1. Listar processos\n2. Matar processo por PID\n3. Matar processo por nome\n4. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer do scanner

            switch (opcao) {
                case 1:
                    Kill.listaProcessos();
                    break;
                case 2:
                    System.out.println("Digite o PID do processo:");
                    String pid = scanner.nextLine();
                    Kill.mataPid(pid);
                    break;
                case 3:
                    System.out.println("Digite o nome do processo:");
                    String nome = scanner.nextLine();
                    Kill.mataNome(nome);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
