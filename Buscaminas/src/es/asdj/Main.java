package es.asdj;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int longitud;
        char[] tablero;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Bienvenido al buscaminas");
        longitud = pedirNumeroEnRango(entrada, 5, 20,"¿Qué tan largo quieres el tablero? [De 5 a 20] ");
        tablero = contruirTablero(longitud);
        mostrarTablero(tablero);
    }


    private static int pedirNumeroEnRango(Scanner entrada, int min ,int max,String mensaje) {
        int numero;
        do {
            System.out.print(mensaje);
            numero = entrada.nextInt();
        } while (numero < min || numero > max);

        return numero;
    }

    private static char[] contruirTablero(int tamanyo) {
        char[] tablero = new char[tamanyo];
        int minaoNumero;

        for (int i = 0; i < tamanyo; i++) {
            minaoNumero = (int) (Math.random() * 2);
            if (minaoNumero == 0) {
               tablero[i] = '*';
            } else if (minaoNumero == 1){
                tablero[i] = '0';
            }
        }

        for (int i = 0; i < tamanyo; i++) {
            if (i != 0 && i != tablero.length - 1 && tablero[i] == '0') {
                if (tablero[i - 1] == '*' && tablero[i + 1] != '*' || tablero[i + 1] == '*' && tablero[i - 1] != '*') {
                    tablero[i] = '1';
                } else if (tablero[i - 1] == '*' && tablero[i + 1] == '*') {
                    tablero[i] = '2';
                }
            } else if (i == 0 && tablero[i] == '0') {
                if (tablero[i + 1] == '*'){
                    tablero[i] = '1';
                }
            } else if (i == tablero.length - 1) {
                if (tablero[i - 1] == '*' && tablero[i] == '0'){
                    tablero[i] = '1';
                }
            }
        }

        return tablero;
    }

    private static void mostrarTablero(char[] tablero) {
        for (int i = 0; i < tablero.length; i++){
            if (i < 9) {
                System.out.print("  " + (i + 1) + " ");
            } else {
                System.out.print(" " + (i + 1) + " ");
            }
        }
        System.out.println();

        for (int i = 0; i < tablero.length; i++) {
            System.out.print("+---");
        }
        System.out.println("+");

        for (int i = 0; i < tablero.length; i++) {
            System.out.print("| " + tablero[i] + " ");
        }
        System.out.println("|");

        for (int i = 0; i < tablero.length; i++) {
            System.out.print("+---");
        }
        System.out.println("+");
    }
}
