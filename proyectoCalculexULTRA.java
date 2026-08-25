package proyectoCalculex;


import java.util.Scanner;

public class proyectoCalculexULTRA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----- BIENVENIDO A CALCULEX PRO -----");
        System.out.println();
        double n1 = pedirNumero(scanner, "Ingrese el primer número base/operando: ");
        
        int contador = 1;
        String respuestaSiNo;

        do {
            System.out.println("\n----- Menú de Operaciones -----");
            System.out.println("1. Suma (n1 + n2)");
            System.out.println("2. Resta (n1 - n2)");
            System.out.println("3. Multiplicación (n1 * n2)");
            System.out.println("4. División (n1 / n2)");
            System.out.println("5. Potencia (n1 ^ n2)");
            System.out.println("6. Raíz (Raíz n2-ésima de n1)");
            System.out.println("7. Coseno (cos(n1) en radianes)");
            System.out.println("8. Arcoseno (arcsin(n1))");
            System.out.println("9. Logaritmo (log10(n1))");
            System.out.println("10. Tangente (tan(n1) en radianes)");
            System.out.println("11. Representación en Fracción (n1 / n2)");
            System.out.println("12. Integral definida de f(x) = x^2 en [n1, n2]");
            System.out.println();
            
            int operacion = pedirEntero(scanner, "Introduce la opción deseada (1-12): ");
            double n2 = 0;

            // Se solicita n2 únicamente si la operación requiere dos valores
            if (requiereSegundoNumero(operacion)) {
                n2 = pedirNumero(scanner, "Ingrese el segundo número: ");
                contador++;
            }

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
                        System.out.println("Error: No se puede dividir entre cero.");
                    } else {
                        n1 /= n2;
                    }
                    break;
                case 5:
                    n1 = Math.pow(n1, n2);
                    break;
                case 6:
                    if (n1 < 0 && n2 % 2 == 0) {
                        System.out.println("Error: Raíz par de un número negativo.");
                    } else {
                        n1 = Math.pow(n1, 1.0 / n2);
                    }
                    break;
                case 7:
                    n1 = Math.cos(n1);
                    break;
                case 8:
                    if (n1 < -1 || n1 > 1) {
                        System.out.println("Error: El dominio de arcsin está entre -1 y 1.");
                    } else {
                        n1 = Math.asin(n1);
                    }
                    break;
                case 9:
                    if (n1 <= 0) {
                        System.out.println("Error: El logaritmo requiere un valor mayor a cero.");
                    } else {
                        n1 = Math.log10(n1);
                    }
                    break;
                case 10:
                    n1 = Math.tan(n1);
                    break;
                case 11:
                    if (n2 == 0) {
                        System.out.println("Error: El denominador no puede ser cero.");
                    } else {
                        System.out.println("Resultado como fracción: " + (int) n1 + "/" + (int) n2);
                        n1 = n1 / n2;
                    }
                    break;
                case 12:
                    n1 = calcularIntegralTrapecio(n1, n2, 1000);
                    break;
                default:
                    System.out.println("Opción no válida. No se realizó ninguna operación.");
                    break;
            }

            System.out.println("Valor acumulado actual: " + n1);
            System.out.print("\n¿Quieres realizar otra operación sobre el resultado? (si/no): ");
            respuestaSiNo = scanner.next().toLowerCase();

        } while (respuestaSiNo.equals("si"));

        System.out.println("\n=============================");
        System.out.println("Resultado final: " + n1);
        System.out.println("Total de datos/operandos procesados: " + contador);
        System.out.println("=============================");

        scanner.close();
    }

    // Identifica si la función es binaria (requiere n2) o unaria (opera solo sobre n1)
    private static boolean requiereSegundoNumero(int op) {
        return op == 1 || op == 2 || op == 3 || op == 4 || op == 5 || op == 6 || op == 11 || op == 12;
    }

    // Aproximación de la integral definida \int_{a}^{b} x^2 dx usando la Regla del Trapecio
    private static double calcularIntegralTrapecio(double a, double b, int n) {
        double h = (b - a) / n;
        double suma = 0.5 * (evaluarFuncion(a) + evaluarFuncion(b));
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            suma += evaluarFuncion(x);
        }
        return suma * h;
    }

    // Función polinomial base f(x) = x^2 para demostración de cálculo integral
    private static double evaluarFuncion(double x) {
        return Math.pow(x, 2);
    }

    private static double pedirNumero(Scanner scanner, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.nextLine();
            }
        }
    }

    private static int pedirEntero(Scanner scanner, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Error: Selecciona una opción numérica válida.");
                scanner.nextLine();
            }
        }
    }
}
