

import java.util.Scanner;

public class CalculadoraSimple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa el primer número: ");
        double a = sc.nextDouble();

        System.out.print("Ingresa la operación (+, -, *, /): ");
        char operacion = sc.next().charAt(0);

        System.out.print("Ingresa el segundo número: ");
        double b = sc.nextDouble();

        if (operacion == '+') {
            System.out.println("Resultado: " + (a + b));
        } else if (operacion == '-') {
            System.out.println("Resultado: " + (a - b));
        } else if (operacion == '*') {
            System.out.println("Resultado: " + (a * b));
        } else if (operacion == '/') {
            System.out.println("Resultado: " + (a / b));
        } else {
            System.out.println("Operación no válida.");
        }
    }
}
