package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Kill {

    private String os() {
        return System.getProperty("os.name");
    }

    public void listaProcessos() {
        String so = os();

        System.out.println("Processos:");

        try {
            Process process;

            if (so.contains("Windows")) {
                process = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "TASKLIST /FO TABLE"});
            } else {
                process = Runtime.getRuntime().exec(new String[]{"ps", "-ef"});
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (Exception error) {
            System.out.println("Algo deu errado!");
            error.printStackTrace();
        }
    }

    public void mataPid(String pid) {
        String so = os();
        
        try {
            Process process;

            if (so.contains("Windows")) {
                process = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "TASKKILL /PID " + pid});
            } else {
                process = Runtime.getRuntime().exec(new String[]{"kill", "-9", pid});
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (Exception error) {
            System.out.println("Algo deu errado!");
            error.printStackTrace();
        }
    }

    public void mataNome(String nome) {
        String so = os();

        try {
            Process process;

            if (so.contains("Windows")) {
                process = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "TASKKILL /IM " + nome});
            } else {
                process = Runtime.getRuntime().exec(new String[]{"pkill", "-f", nome});
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (Exception error) {
            System.out.println("Algo deu errado!");
            error.printStackTrace();
        }
    }
}