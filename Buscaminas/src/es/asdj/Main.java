package es.asdj;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int lado;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Bienvenido al buscaminas");
        lado = pedirNumeroEnRango(entrada, 5, 20,"¿Qué tan largo quieres el tablero? [De 5 a 20] ");
    }


    private static int pedirNumeroEnRango(Scanner entrada, int min ,int max,String mensaje) {
        int numero;
        do {
            System.out.print(mensaje);
            numero = entrada.nextInt();
        } while (numero < min || numero > max);

        return numero;
    }
}
    private static int construirTablero() {

    }