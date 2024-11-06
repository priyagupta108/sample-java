package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) {
        System.out.println("Maven JDK version:");
        System.out.println(System.getProperty("java.version"));

        System.out.println("Subprocess JDK version:");
        runSubprocess();
    }

    private static void runSubprocess() {
        try {
            Process process = new ProcessBuilder("java", "-version").start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}