package com.buggy_cars_rating.utils;

public class WaitTime {

    /**
     * Pausa la ejecución del thread actual por la cantidad de segundos especificada
     * Maneja la excepción internamente
     * @param seconds Número de segundos a esperar
     */
    public static void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void waitFiveSeconds() {
        waitForSeconds(5);
    }
}
