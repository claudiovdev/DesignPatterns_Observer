package com.algaworks.listeners;

import com.algaworks.model.Lancamento;

import java.util.List;

public interface Listner {

    public void atualizar(List<Lancamento> lancamentosVencidos);
}
