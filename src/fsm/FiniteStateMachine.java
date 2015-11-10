package fsm;

import fsm.Main.Estados;

public class FiniteStateMachine {
	
	private static final Estados ESTADO_INICIAL = Estados.Q0;
	private static final Estados ESTADO_FINAL = Estados.Q4;
	
	private final String cadeiaEntrada;
	
	public FiniteStateMachine(String cadeiaEntrada) {
		this.cadeiaEntrada = cadeiaEntrada;
	}
	
	public String getCadeiaEntrada() {
		return this.cadeiaEntrada;
	}
	
	public boolean aceitou() {
		Estado atual = ESTADO_INICIAL;
		
		for (char simbolo : cadeiaEntrada.toCharArray()) {
			atual = atual.next(simbolo);
		}
		
		return atual == ESTADO_FINAL;
	}
}