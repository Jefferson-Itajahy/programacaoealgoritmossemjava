package cursoLetsCode;
//Exemplo simples, mas poderoso, aborda algumas opera��es financeiras elementares de uma conta corrente em um Banco qualquer.  

import java.util.Scanner;

public class conta {

	public static void main(String[] args) {

		int opcao;
		double saldo = 0.0;
		double valor = 0.0;
		double investimento = 0.0;
		boolean encerrarPrograma = false;

		Scanner teclado = new Scanner(System.in);

		while (encerrarPrograma == false) {

			opcao = mostrarMenu(teclado);

			switch (opcao) {

			case 1:
				consultarSaldo(saldo, investimento);
				break;

			case 2:
				valor = efetuarDeposito(teclado, valor);
				saldo += valor;
				break;

			case 3:
				valor = efetuarSaque(teclado, valor, saldo);
				saldo -= valor;
				break;

			case 4:
				valor = efetuarInvestimento(teclado, valor, saldo, investimento);
				saldo -= valor;
				investimento += valor;
				break;

			case 5:
				valor = efeturarResgateInvestimento(teclado, valor, investimento);
				saldo += valor;
				investimento -= valor;
				break;
			case 6:
				encerrarPrograma = true;
				break;

			default:
				System.out.println("Op��o inv�lida, tente novamente!");
			}

		}
		teclado.close();
		System.out.println("Programa Encerrado");

	}

	private static int mostrarMenu(Scanner teclado) {

		int opcao;
		System.out.println();
		System.out.println("MENU DE OP��ES");
		System.out.println("[1] Mostrar Saldo");
		System.out.println("[2] Efetuar Dep�sito");
		System.out.println("[3] Efetuar Saque");
		System.out.println("[4] Efetuar Investimento");
		System.out.println("[5] Efetuar Resgate do Investimento");
		System.out.println("[6] Finalizar");
		System.out.print("Digite a op��o: ");
		opcao = teclado.nextInt();
		return opcao;

	}

	private static void consultarSaldo(double saldo, double investimento) {
		System.out.printf("Saldo da Conta %.2f: \n", saldo);
		if (investimento > 0.0) {
			System.out.printf("Saldo do Investimento %.2f: \n", investimento);
		}
	}

	private static double efetuarDeposito(Scanner teclado, double valor) {
		System.out.print("Informe o valor do dep�sito: ");
		valor = teclado.nextDouble();
		System.out.println("Dep�sito efetuado!");
		return valor;

	}

	private static double efetuarSaque(Scanner teclado, double valor, double saldo) {
		if (saldo <= 0.0) {
			System.out.println("Voc� n�o possui valor dispon�vel para saque!");
			return 0.0;
		}
		System.out.println("Informe o valor do saque: ");
		valor = teclado.nextDouble();
		if (valor > saldo) {
			System.out.println("Saque n�o realizado, saldo insuficiente!");
			return 0.0;
		}
		System.out.println("Saque efetuado!");
		return valor;
	}

	private static double efetuarInvestimento(Scanner teclado, double valor, double saldo, double investimento) {
		if (saldo > 0.0) {
			System.out.print("Informe o valor a ser investido: ");
			valor = teclado.nextDouble();
			if (valor > saldo) {
				System.out.println("Saldo insuficiente!");
				return 0.0;
			}
			System.out.println("Investimento efetuado!");
			return valor;
		}
		System.out.println("Voc� n�o possui valor dispon�vel para investimento!");
		return 0.0;
	}

	private static double efeturarResgateInvestimento(Scanner teclado, double valor, double investimento) {
		if (investimento <= 0.0) {
			System.out.println("Voc� n�o possui valor investido!");
			return 0.0;
		}
		System.out.println("Informe o valor do resgate: ");
		valor = teclado.nextDouble();

		if (valor > investimento) {
			System.out.println("Resgate n�o realizado, saldo insuficiente!");
			return 0.0;
		}
		System.out.println("Resgate efetuado!");
		return valor;

	}

}
