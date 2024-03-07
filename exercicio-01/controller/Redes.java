package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Redes {

    private String os() {
        return System.getProperty("os.name");
    }

    public void ip() {
        String so = os();

        System.out.println("IPv4(s):");

        try {
            Process process;

            if (so.contains("Windows")) {
                process = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "ipconfig"});
            } else {
                process = Runtime.getRuntime().exec(new String[]{"ifconfig"});
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;

            while ((line = reader.readLine()) != null) {                
                if (so.contains("Windows") && line.contains("IPv4")) {
                    System.out.println("\t" + line.split(": ")[1]);
                } else if (line.contains("inet") && !line.contains("127.0.0.1")) {
                    System.out.println(line.split(" ")[1]);
                }
            }

            reader.close();
        } catch (Exception error) {
            System.out.println("Algo deu errado!");
            error.printStackTrace();
        }
    }

    public void ping() {
        String so = os();

        System.out.println("Pingando...");

        try {
            Process process;

            if (so.contains("Windows")) {
                process = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "ping -4 -n 10 www.google.com.br"});
            } else {
                process = Runtime.getRuntime().exec(new String[]{"ping", "-4", "-c", "10", "www.google.com.br"});
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line = "";
            String lastLine = "";
            while ((line = reader.readLine()) != null) {
                lastLine = line;
            }

            String ms = lastLine.split(" ")[lastLine.split(" ").length - 1];

            System.out.println("Tempo médio do ping: " + ms);

            reader.close();
        } catch (Exception error) {
            System.out.println("Algo deu errado!");
            error.printStackTrace();
        }
    }
}
