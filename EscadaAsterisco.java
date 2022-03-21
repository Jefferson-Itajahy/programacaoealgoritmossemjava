package exercicios;

import java.util.Scanner;

// Escreva um algoritmo que mostre na tela uma escada de tamanho "n" utilizando o caractere "*" e espa�os.
// A base e altura da escada deve ser iguais ao valor de "n". A �ltima linha n�o deve conter nenhum espa�o. 

public class EscadaAsterisco {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Informe um numero inteiro positivo: ");
		int n = teclado.nextInt();
		teclado.close();
		
		String asterisco = "*";
		String formatacao = "%" + n + "s%n";

		for (int i = n; i >= 1; i--) {
			System.out.printf(formatacao, asterisco);
			asterisco += "*";
		}
	}
}
