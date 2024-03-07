// package view;

import javax.swing.*;

import controller.Cancel;
import controller.Run;
import controller.Search;

public class RunSimulator extends JFrame {
    private JTextField textField;
    private JButton okButton, cancelButton, searchButton;
    private JLabel text, openText, image;

    public RunSimulator() {
        ImageIcon icon = new ImageIcon("./exec.png");

        setTitle("Executar Simulador");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(icon.getImage());

        image = new JLabel(icon);
        image.setBounds(14, 10, 50, 50);

        text = new JLabel("<html>Digite o nome de um programa, pasta, documento ou recurso da internet e o Windows o abrira para voce.</html>");
        text.setBounds(70, 10, 320, 50);

        openText = new JLabel("<html>Abrir: </html>");
        openText.setBounds(20, 56, 350, 50);

        textField = new JTextField();
        textField.setBounds(70, 70, 300, 25);

        okButton = new JButton("OK");
        okButton.setBounds(110, 120, 80, 30);
        cancelButton = new JButton("Cancelar");
        cancelButton.setBounds(200, 120, 80, 30);
        searchButton = new JButton("Procurar");
        searchButton.setBounds(290, 120, 80, 30);

        add(image);
        add(text);
        add(openText);
        add(textField);
        add(okButton);
        add(cancelButton);
        add(searchButton);

        setLayout(null);
        setVisible(true);

        Search Search = new Search(textField);
        Run Run = new Run(textField, this);
        Cancel Cancel = new Cancel(this);

        textField.addActionListener(Run);
        searchButton.addActionListener(Search);
        okButton.addActionListener(Run);
        cancelButton.addActionListener(Cancel);
    }

    public static void main(String[] args) {
        new RunSimulator();
    }
}
