package proyectoCalculex;

import java.util.Scanner;


public class proyectoCalculex {
	
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        double suma;
        double resta;
        double multiplicacion;
        double division;
        double resultado = 0;
        double valor = 0;
        String respuestaSiNo;
        double n1 = 0;
        double n2 = 0;
        int respuesOperacion = 0;
        int contador = 2;
        

        try {
        System.out.println("-----CALCULEX-----");
        System.out.println();
        System.out.print("Ingrese el primer número: ");
        n1 = scanner.nextDouble();

        System.out.print("Ingrese el segundo número: ");
        n2 = scanner.nextDouble();
        scanner.nextLine();
        
        }catch (Exception e) {
        	
        	System.out.println("Hubo un error, pon numeros carnal");
        	
        }
       

        do {
        
        try {	
        System.out.println("¿Que operacion quieres hacer? ");
        System.out.println();
        System.out.println("Suma--------------------------> 1");
        System.out.println("Resta-------------------------> 2");
        System.out.println("Multiplicacion----------------> 3");
        System.out.println("Division----------------------> 4");
        System.out.println();
        
        System.out.println("Introduce la operacion: ");
        respuesOperacion = scanner.nextInt();
        System.out.println();
        
        }catch (Exception e) {
        	System.out.println("Pon las opciones que dice ahi");
        }
        
        if (respuesOperacion == 1) {
        	
        	suma = n1 + n2;
        	resultado = suma;
        	n1 = resultado;
        	valor = suma;
        	
        
        }else if (respuesOperacion == 2) {
        	
        	resta = n1 - n2;
        	resultado = resta;
        	n1 = resultado;
        	valor = resta;
        
        }else if (respuesOperacion == 3) {
           
        	multiplicacion = n1 * n2;
        	resultado = multiplicacion;
        	n1 = resultado;
        	valor = multiplicacion;
        
        }else if (respuesOperacion == 4) {
            
        	division = n1 / n2;
        	resultado = division;
        	n1 = resultado;
        	valor = division;
        }
        
        
        System.out.println();
        System.out.println("¿Quires ingresar otro numero?");
        System.out.println("Pon Si o no");
         respuestaSiNo = scanner.next();
        
       
         try {
         if (respuestaSiNo.equals("si")) {
        System.out.println("Introduce el numero: ");
        n2 = scanner.nextDouble();
        contador++;
         }
        	 
         }catch (Exception e) {
        	 System.out.println("Pon numeros carnal");
         }
       
         
         
        }while (respuestaSiNo.equals("si"));
        
        
        
        System.out.println("Tu resultado fue: " + valor);
        System.out.println("Con " + contador + " valores");
        

        scanner.close();
        
  
    }
}
