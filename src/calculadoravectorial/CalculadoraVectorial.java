package calculadoravectorial;

import java.util.Scanner;

public class CalculadoraVectorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------Escuela Tecnológica Instituto Técnico Central-----------");
        System.out.println("----------Bienvenidos al programa de la Calculadora Vectorial----------");
        System.out.println("-----------------Realizado por: Nicolas Moreno Jiménez----------------------");
        System.out.println("\nA continuación encontrarán un menú por favor, elegir bien la opción correcta.");
        int[] vector1 = new int[5];
        int[] vector2 = new int[5];
        int[] resultado = new int[5];
        char[] operaciones = new char[5];
        boolean operacionesLlenas = false;

        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Llenar vector 1");
            System.out.println("2. Llenar vector 2");
            System.out.println("3. Llenar vector de operaciones");
            System.out.println("4. Operaciones");
            System.out.println("5. Listar vectores");
            System.out.println("0. Terminar");
            System.out.print("\nIngrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\nIngrese 5 números enteros para llenar el vector 1:");
                    for (int i = 0; i < 5; i++) {
                        vector1[i] = scanner.nextInt();
                    }
                    break;
                case 2:
                    System.out.println("\nIngrese 5 números enteros para llenar el vector 2:");
                    for (int i = 0; i < 5; i++) {
                        vector2[i] = scanner.nextInt();
                    }
                    break;
                case 3:
                    System.out.println("\nIngrese 5 operaciones (+, -, *, /) para llenar el vector de operaciones:");
                    for (int i = 0; i < 5; i++) {
                        char operacion;
                        do {
                            operacion = scanner.next().charAt(0);
                            if (operacion == '+' || operacion == '-' || operacion == '*' || operacion == '/') {
                                operaciones[i] = operacion;
                                break;
                            } else {
                                System.out.println("Operación no válida. Intente de nuevo.");
                            }
                        } while (true);
                    }
                    operacionesLlenas = true;
                    break;
                case 4:
                    if (!operacionesLlenas) {
                        System.out.println("\nPrimero debe llenar el vector de operaciones.");
                    } else {
                        for (int i = 0; i < 5; i++) {
                            switch (operaciones[i]) {
                                case '+':
                                    resultado[i] = vector1[i] + vector2[i];
                                    break;
                                case '-':
                                    resultado[i] = vector1[i] - vector2[i];
                                    break;
                                case '*':
                                    resultado[i] = vector1[i] * vector2[i];
                                    break;
                                case '/':
                                    resultado[i] = vector1[i] / vector2[i];
                                    break;
                            }
                        }
                        System.out.println("\nOperaciones realizadas y almacenadas en el vector resultado.");
                    }
                    break;
                case 5:
                    System.out.println("Vector 1: " + arrayToString(vector1));
                    System.out.println("Vector 2: " + arrayToString(vector2));
                    System.out.println("Vector de Operaciones: " + new String(operaciones));
                    System.out.println("Vector de Resultado: " + arrayToString(resultado));
                    break;
                case 0:
                    System.out.println("\nPrograma terminado con éxito :).");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 0);
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

