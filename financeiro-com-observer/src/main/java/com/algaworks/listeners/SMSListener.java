package com.algaworks.listeners;

import java.util.List;

import com.algaworks.model.Lancamento;

public class SMSListener implements Listner{
	@Override
	public void atualizar(List<Lancamento> lancamentosVencidos) {
		for (Lancamento lancamento : lancamentosVencidos) {
			System.out.println("Enviando SMS para " + lancamento.getPessoa().getTelefone());
		}
	}
}
