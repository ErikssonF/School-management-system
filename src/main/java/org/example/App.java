package org.example;

import org.example.daos.Manager;

public class App {
    Manager m;

    public static void main(String[] args) {
        App app = new App();
    }

    App() {
        m = new Manager();
    }
}