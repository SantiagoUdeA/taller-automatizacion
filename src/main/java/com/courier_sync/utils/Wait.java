package com.courier_sync.utils;

public class Wait {

    /**
     * Pausa la ejecución del thread actual por la cantidad de segundos especificada
     * Maneja la excepción internamente
     * @param seconds Número de segundos a esperar
     */
    public static void forSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void forMilliseconds(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void fiveSeconds() {
        forSeconds(5);
    }

    public static void twoSeconds() {
        forSeconds(2);
    }
}
