package exercicios;

import java.util.Scanner;

public class MediaDuasNotas {
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
			System.out.println("Informe duas notas para obter a m�dia do aluno.");
			
			System.out.print("Digite a 1� nota : ");
			double nota1 = teclado.nextDouble();
			System.out.print("Digite a 2� nota : ");
			double nota2 = teclado.nextDouble();
			
			teclado.close();
			
			double media = (nota1 + nota2)/2;
			
			if (media >=7) {											
				System.out.println("M�dia: " + media + " Aprovado"); 
				return;
			} else if (media > 4) { 									
				System.out.println("M�dia: " + media + " Recupera��o");
				return;
			} 														
				System.out.println("M�dia: " + media + " Reprovado");		
	}
}
