package com.snake8bit;

import java.time.LocalDateTime;

public class Logger {
    public static void log(String message) {
        System.out.println("[" + LocalDateTime.now() + "] " + message);
    }
}