package fsm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	enum Estados implements Estado {
		
		Q0 {
			@Override
			public Estado next(char symbol) {
				return symbol == '0' ? Q0 : Q1;
			}
		},
		Q1 {
			@Override
			public Estado next(char symbol) {
				return symbol == '0' ? Q0 : Q2;
			}
		},
		Q2 {
			@Override
			public Estado next(char symbol) {
				return symbol == '0' ? Q4 : Q3;
			}
		},
		Q3 {
			@Override
			public Estado next(char symbol) {
				return symbol == '0' ? Q4 : Q0;
			}
		},
		Q4 {
			@Override
			public Estado next(char symbol) {
				return symbol == '0' ? Q4 : Q4;
			}
		};
	};

	public static void main(String[] args) throws IOException {
		FiniteStateMachine finiteStateMachine;
		String cadeiaEntrada = "";
		
		System.out.println("|-------------------------------------------------------------------------------------------------|");
		System.out.println("|>>>>>>>>>>>>>>>>>>>>>>> Maquina de Estados Finitos para o Jogo X. <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<|");
		System.out.println("|- Utilize cadeias de entrada com 0s e 1s para testar a sequência de ações do g-player.           |");
		System.out.println("|                                                                                                 |");
		System.out.println("|-> Defender = 0                                                                                  |");
		System.out.println("|-> Atirar = 1                                                                                    |");
		System.out.println("|                                                                                                 |");
		System.out.println("|* Para sair, digite \"sair\" quando for pedida a entrada.                                          |");
		System.out.println("|-------------------------------------------------------------------------------------------------|\n");
		
		while (true) {
			System.out.print("> Cadeia de Entrada: ");
			cadeiaEntrada = tryReadInput();
			
			if (cadeiaEntrada.equals("")) {
				System.out.println("** Entrada não pode ser vazia!\n");
			} else if (cadeiaEntrada.equals("sair")) {
				System.out.println("> Tchau!");
				System.exit(0);
			} else if (entradaInvalida(cadeiaEntrada)) {
				System.out.println("** Entrada invalida, digite apenas 0s e 1s!\n");
			} else {
				finiteStateMachine = new FiniteStateMachine(cadeiaEntrada);
				System.out.println(finiteStateMachine.aceitou() ? "> Sequência Invalida!\n" : "> Sequência Valida!\n");
			}
			
		}
	}

	private static boolean entradaInvalida(String cadeiaEntrada) {
		for (char c : cadeiaEntrada.toCharArray()) {
			if (c != '0' && c != '1') {
				return true;
			}
		}
		return false;
	}

	private static String tryReadInput() throws IOException {
		String cadeiaEntrada;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			cadeiaEntrada = br.readLine();
		} catch (IOException e) {
			throw new IOException("Erro na leitura da entrada", e);
		}
		return cadeiaEntrada;
	}

}
