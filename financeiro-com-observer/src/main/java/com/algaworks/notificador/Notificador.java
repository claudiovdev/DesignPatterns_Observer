package com.algaworks.notificador;

import com.algaworks.listeners.Listener;
import com.algaworks.model.Lancamento;

import java.util.List;

public interface Notificador {
    public void registrarListener(Listener listner);
    public void removerListener(Listener listner);
    public void notificarListener();

    public void novosLancamentosVencidos(List<Lancamento> lancamentosVencidos);

    public List<Lancamento> getLancamentosVencidos();
}
