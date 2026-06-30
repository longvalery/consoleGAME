package com.rva.desktop;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import sun.misc.Signal;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // Устанавливаем кодировку вывода в UTF-8
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
        // Регистрируем обработчик для сигнала SIG-1INT (Ctrl+C)
        Signal.handle(new Signal("INT"), signal -> {
            System.out.println("\nЖалко... но, может быть в следующий раз...");
            System.exit(20);   // Завершаем JVM с кодом 20
        });
        Gameboard game = new Gameboard(5, 5, 3);
        game.help();
        if (game.start()) {
            int level = game.inputLevel();
            game.setLevel(level);
            game.loop();
        }
    }

}