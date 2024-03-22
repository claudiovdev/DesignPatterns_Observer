package com.algaworks.notificador;

import com.algaworks.listeners.Listener;
import com.algaworks.model.Lancamento;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NotificadorLancamentosVencidos implements Notificador{
    public Set<Listener> listners;
    List<Lancamento> lancamentosVencidos;

    public NotificadorLancamentosVencidos() {
        this.listners = new HashSet<>();
    }

    @Override
    public void registrarListener(Listener listner) {
        this.listners.add(listner);
    }

    @Override
    public void removerListener(Listener listner) {
        this.listners.remove(listner);
    }

    @Override
    public void notificarListener() {
        for (Listener listner: listners){
            listner.atualizar();
        }
    }

    @Override
    public void novosLancamentosVencidos(List<Lancamento> lancamentosVencidos) {
        this.lancamentosVencidos = lancamentosVencidos;
        this.notificarListener();
    }

    @Override
    public List<Lancamento> getLancamentosVencidos() {
        List<Lancamento> lancamentos = this.lancamentosVencidos;
        return lancamentos;
    }
}
