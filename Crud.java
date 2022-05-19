package procedimentos.metodos;
// Algoritmo que realiza um CRUD de clientes
import java.util.ArrayList;
import java.util.Scanner;

public class Crud {
	public static void main(String[] args) {

		int opcao = 0;
		ArrayList<String> clientes = new ArrayList<>();

		Scanner teclado = new Scanner(System.in);

		do {
			opcao = menu(teclado);
			switch (opcao) {

			case 1:
				cadastrarCliente(clientes, teclado);
				break;

			case 2:
				pesquisarCliente(clientes, teclado);
				break;

			case 3:
				editarCliente(clientes, teclado);
				break;

			case 4:
				excluirCliente(clientes, teclado);
				break;

			default:
				if (opcao != 5) {
					System.out.println("Op��o inv�lida!");
				}
			}
		} while (opcao != 5);
		System.out.println("Aplica��o Encerrada");
		teclado.close();
	}

	private static int menu(Scanner teclado) {
		System.out.println("MENU DE OP��ES");
		System.out.println("[1] - Cadastrar Cliente");
		System.out.println("[2] - Pesquisar Cliente");
		System.out.println("[3] - Editar Cliente");
		System.out.println("[4] - Excluir Cliente");
		System.out.println("[5] - Sair");
		System.out.print("Escolha a op��o: ");
		int opcao = teclado.nextInt();
		return opcao;
	}

	private static void cadastrarCliente(ArrayList<String> clientes, Scanner teclado) {
		String continuar = "S";
		do {
			System.out.print("Digite o nome a ser cadastrado: ");
			String nome = teclado.next();
			clientes.add(nome.toLowerCase());
			System.out.print("Continuar? \"S\" Sim | \"N\" N�o ");
			continuar = teclado.next();
		} while (continuar.equalsIgnoreCase("S"));
	}

	private static void pesquisarCliente(ArrayList<String> clientes, Scanner teclado) {
		String continuar = "S";

		System.out.print("Digite \"E\" para exibir a lista de cliente ou qualquer tecla para pesquisar um nome: ");
		continuar = teclado.next();

		if (continuar.equalsIgnoreCase("E")) {
			exibirListaClientes(clientes);
			return;
		}		

		do {
			System.out.print("Digite o nome a ser pesquisado: ");
			String nome = teclado.next().toLowerCase();
			System.out.println(clientes.contains(nome) ? nome + " est� na lista." : nome + " n�o est� na lista.");
			System.out.print("Nova pesquisa? \"S\" Sim | \"N\" N�o ");
			continuar = teclado.next();
		} while (continuar.equalsIgnoreCase("S"));
	}

	private static void exibirListaClientes(ArrayList<String> clientes) {

		if (clientes.isEmpty()) {
			System.out.println("A lista est� vazia");
			return;
		}
		// Exibir a lista
		// localiza o primeiro caracter e o coloca em mai�sculo, depois concatena com o
		// nome a partir
		// do segundo caracter
		for (String nome : clientes) {
			System.out.println(nome.substring(0, 1).toUpperCase() + nome.substring(1));
		}

	}

	private static void editarCliente(ArrayList<String> clientes, Scanner teclado) {
		String continuar = "S";

		do {
			System.out.print("Qual nome deseja editar?: ");
			String nomeErrado = teclado.next().toLowerCase();
			if (clientes.contains(nomeErrado)) {
				System.out.print("Digite a corre��o: ");
				String nomeCerto = teclado.next().toLowerCase();
				clientes.add(clientes.indexOf(nomeErrado), nomeCerto); // substitui o nome errado pelo nome certo na
																		// posi��o do �ndice
				clientes.remove(nomeErrado);
				System.out.println("Nome corrigido");
				System.out.print("Outra edi��o? \"S\" Sim | \"N\" N�o ");
				continuar = teclado.next();
			} else {
				System.out.println("Nome n�o localizado");
				System.out.print("Tentar novamente? \"S\" Sim | \"N\" N�o ");
				continuar = teclado.next();
			}
		} while (continuar.equalsIgnoreCase("S"));
	}

	private static void excluirCliente(ArrayList<String> clientes, Scanner teclado) {
		String continuar = "S";

		System.out.print(
				"Digite \"E\" para excluir todos nomes da lista de clientes ou outra tecla para excluir apenas um nome: ");
		continuar = teclado.next();
		if (continuar.equalsIgnoreCase("E")) {
			excluirListaClientes(clientes, teclado);
			return;
		}
		do {
			System.out.print("Digite o nome a ser exclu�do: ");
			String nome = teclado.next().toLowerCase();
			System.out.println(clientes.contains(nome) ? nome + " foi exclu�do." : nome + " n�o est� na lista.");
			clientes.remove(nome);
			System.out.print("Excluir outro nome? \"S\" Sim | \"N\" N�o ");
			continuar = teclado.next();
		} while (continuar.equalsIgnoreCase("S"));
	}

	private static void excluirListaClientes(ArrayList<String> clientes, Scanner teclado) {

		if (clientes.isEmpty()) {
			System.out.println("A lista est� vazia");
			return;
		}
		System.out.print("Tem certeza que deseja excluir todos os nomes da lista? \"S\" Sim | \"N\" N�o \" ");
		String confirmacao = teclado.next();
		if (confirmacao.equalsIgnoreCase("S")) {
			clientes.clear();
			System.out.println("Nomes exclu�dos");
			return;
		}
	}

}
