package proyectoCalculex;

import java.util.Scanner;

public class proyectoCalculexPRO {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----- BIENVENIDO A CALCULEX PRO -----");
        System.out.println();
        double n1 = pedirNumero(scanner, "Ingrese el primer número: ");
        double n2 = pedirNumero(scanner, "Ingrese el segundo número: ");
        
        int contador = 2;
        String respuestaSiNo;

        do {
            System.out.println("\n----- CALCULEX -----");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            System.out.println();
            
            int operacion = pedirEntero(scanner, "Introduce la operación (1-4): ");

            switch (operacion) {
                case 1:
                    n1 += n2;
                    break;
                case 2:
                    n1 -= n2;
                    break;
                case 3:
                    n1 *= n2;
                    break;
                case 4:
                    if (n2 == 0) {
                        System.out.println("Error: No se puede dividir entre cero. El valor no cambia.");
                    } else {
                        n1 /= n2;
                    }
                    break;
                default:
                    System.out.println("Opción no válida. No se realizó ninguna operación.");
                    break;
            }

            System.out.print("\n¿Quieres ingresar otro número? (si/no): ");
            respuestaSiNo = scanner.next().toLowerCase();

            if (respuestaSiNo.equals("si")) {
                n2 = pedirNumero(scanner, "Introduce el siguiente número: ");
                contador++;
            }

        } while (respuestaSiNo.equals("si"));

        System.out.println("\n=============================");
        System.out.println("Resultado final: " + n1);
        System.out.println("Total de números procesados: " + contador);
        System.out.println("=============================");

        scanner.close();
    }

    // Método auxiliar para validar entrada de números decimales
    private static double pedirNumero(Scanner scanner, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Error: Ingrese un número válido, carnal.");
                scanner.nextLine(); // Limpiar el buffer del scanner
            }
        }
    }

    // Método auxiliar para validar entrada de opciones (enteros)
    private static int pedirEntero(Scanner scanner, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Error: Selecciona una opción numérica válida.");
                scanner.nextLine(); // Limpiar el buffer del scanner
            }
        }
    }
}
