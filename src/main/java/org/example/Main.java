package org.example;

import main.java.org.example.persistencia.DemoLibroDB;

public class Main {
    public static void main(String[] args) {
        DemoLibroDB demo  = new DemoLibroDB();
        demo.insertarStatement();
        System.out.println("-----");
        demo.insertarPreparedStatement();
    }
}