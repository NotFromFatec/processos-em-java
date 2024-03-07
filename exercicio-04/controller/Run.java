package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Run implements ActionListener {
    private JTextField textField;
    private JFrame frame;

    public Run(JTextField textField, JFrame frame) {
        this.textField = textField;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = textField.getText();
        try {
            Runtime.getRuntime().exec(command);
            frame.dispose();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar o arquivo: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
