package view;

import controller.Redes;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Redes Redes = new Redes();
        String opcao = JOptionPane.showInputDialog(null, "Escolha uma opção:\n1. IP\n2. Ping\n3. Sair");
        loop: while (opcao != null) {
            switch (opcao) {
                case "1":
                    Redes.ip();
                    break;
                case "2":
                    Redes.ping();
                    break;
                case "3":
                    break loop; 
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
            opcao = JOptionPane.showInputDialog(null, "Escolha uma opção:\n1. IP\n2. Ping\n3. Sair");
        }
    }
}
