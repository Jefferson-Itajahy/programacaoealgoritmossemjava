package exercicios;

import java.util.Scanner;

public class NumeroPrimo {
	
	public static void main(String[] args) {
		
			/* N�meros primos s�o os n�meros naturais, ou seja, n�meros inteiros
			 * n�o negativos, que s�o divis�veis somente por dois divisores: 
			 * o n�mero 1 e ele mesmo.  
			 */
					
			System.out.println("Receber um n�mero e informar se � primo"); 
			
			System.out.print("Informe um numero inteiro positivo: ");
			Scanner teclado = new Scanner(System.in);
			int numero = teclado.nextInt();
			teclado.close();
			
			int contDivisores = 0;
						
			for (int i = 2; i < numero; i++ ) { // A formula checa se o numero � divis�vel por ele mesmo
				if (numero % i == 0 ) {         // e por outros cujo resto da divis�o d� zero, se verdadeiro resulta
					contDivisores++;          	// em n�mero que n�o � primo e acrescenta 1 ao contador
				}
			}	
				if (contDivisores == 0) {
				System.out.println("O n�mero " + numero + " � primo.");
				return;
			 }

			System.out.println("O n�mero " + numero + " n�o � primo.");			 

	}
}
