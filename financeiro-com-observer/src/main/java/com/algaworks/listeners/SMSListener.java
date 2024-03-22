package com.algaworks.listeners;

import java.util.List;

import com.algaworks.model.Lancamento;
import com.algaworks.notificador.Notificador;

public class SMSListener implements Listener {
	private Notificador notificador;
	public SMSListener(Notificador notificador) {
		this.notificador = notificador;
		notificador.registrarListener(this);
	}

	@Override
	public void atualizar() {
		List<Lancamento> lancamentosVencidos = notificador.getLancamentosVencidos();
		for (Lancamento lancamento : lancamentosVencidos) {
			System.out.println("Enviando SMS para " + lancamento.getPessoa().getTelefone());
		}
	}
}
