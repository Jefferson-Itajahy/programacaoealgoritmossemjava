package cap6_metodos;
//A classe simula o jogo de dados craps.

/* Voc� lan�a dois dados de seis faces (1 a 6). A soma dos pontos nas faces viradas para cima � calculada.
Se a soma for 7 ou 11 no primeiro lance, voc� ganha. Se a soma for 2, 3 ou 12 no primeiro lance (chamado
�craps�), voc� perde (isto �, a �casa� ganha). Se a soma for 4, 5, 6, 8, 9 ou 10 no primeiro lance, essa soma torna-
-se sua �pontua��o�. Para ganhar, voc� deve continuar a rolar os dados at� �fazer sua pontua��o� (isto �, obter
um valor igual � sua pontua��o). Voc� perde se obtiver um 7 antes de fazer sua pontua��o. */

import java.security.SecureRandom;
import java.util.Scanner;

public class JogoDadosCraps {

	// lan�a os dados, calcula a soma e exibe os resultados
	public static int rolarDados() {

		// Seleciona valores aleat�rios do dado (gera 6 valores de 0 a 5). O dado vai de 1 a 6 
		// por isso soma 1 no inicio
		int dado1 = 1 + numerosAleatorios.nextInt(6); 
		int dado2 = 1 + numerosAleatorios.nextInt(6); 

		int soma = dado1 + dado2;

		System.out.printf("Resultado do lan�amento: %d + %d = %d%n", dado1, dado2, soma);
		return soma;
	}

	// constantes que representam lan�amentos comuns dos dados para ganho ou perda no primeiro lan�amento
	private static final int DOIS = 2;
	private static final int TRES = 3;
	private static final int SETE = 7;
	private static final int ONZE = 11;
	private static final int DOZE = 12;

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		int meusPontos = 0; 

		STATUS statusJogo; // pode ser CONTINUE, GANHOU ou PERDEU
		System.out.println("Primeiro lan�amento dos dados!");
		int somaDados = rolarDados();
		
		
		// determina o estado do jogo e a pontua��o com base no primeiro lan�amento
		switch (somaDados) {	
		
		// situa��o que voc� ganha na primeira rodada
		case SETE:
		case ONZE:
			statusJogo = STATUS.GANHOU;
			System.out.println("Voc� ganhou!");
			break;
		// situa��o que a casa ganha na primeira rodada
		case DOIS:
		case TRES:
		case DOZE:
			statusJogo = STATUS.PERDEU;
			System.out.println("Voc� Perdeu");
			break;

		default:
			statusJogo = STATUS.CONTINUE;
			meusPontos = somaDados;
			System.out.printf("Seus Pontos: %d%n", meusPontos);
		}

		while (statusJogo == STATUS.CONTINUE) {			
			System.out.println("Tecle Enter para lan�ar os dados novamente!");
			String tecla = teclado.nextLine();
			somaDados = rolarDados();

			if (somaDados == meusPontos) {
				statusJogo = STATUS.GANHOU;
				System.out.println("Voc� ganhou!");
			} else if (somaDados == SETE) {
				statusJogo = STATUS.PERDEU;
				System.out.println("Voc� Perdeu");
			}			
		}
		teclado.close();
	}

	// cria um gerador seguro de n�meros aleat�rios para uso no m�todo rolarDados
	private static final SecureRandom numerosAleatorios = new SecureRandom();

	// tipo enum com constantes que representam o estado do jogo
	private enum STATUS {
		CONTINUE, GANHOU, PERDEU
	}

}
