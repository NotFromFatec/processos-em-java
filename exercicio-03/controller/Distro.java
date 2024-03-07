package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Distro {

    private String os() {
        return System.getProperty("os.name");
    }

    public void exibeDistro() {
        String so = os();

        if (so.contains("Linux")) {
            try {
                Process process = Runtime.getRuntime().exec(new String[]{"cat", "/etc/os-release"});

                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

                String line;

                while ((line = reader.readLine()) != null) {
                    if (line.startsWith("NAME=") || line.startsWith("VERSION=")) {
                        System.out.println(line);
                    }
                }

                reader.close();
            } catch (Exception error) {
                System.out.println("Algo deu errado!");
                error.printStackTrace();
            }
        } else {
            System.out.println("O seu sistema operacional é " + so + " e não Linux. Mas ...");

            try {
                BufferedReader reader = new BufferedReader(new FileReader("os-release.txt"));

                String line;

                while ((line = reader.readLine()) != null) {
                    if (line.startsWith("NAME=") || line.startsWith("VERSION=")) {
                        System.out.println(line);
                    }
                }

                reader.close();
            } catch (IOException error) {
                System.out.println("Algo deu errado!");
                error.printStackTrace();
            }
        }
    }
}
