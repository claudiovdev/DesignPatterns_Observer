package com.algaworks.job;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.algaworks.model.Lancamento;
import com.algaworks.repository.Lancamentos;
import com.algaworks.listeners.EmailListener;
import com.algaworks.listeners.SMSListener;

public class LancamentosVencidosJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		
		Lancamentos lancamentos = (Lancamentos) jobDataMap.get("lancamentos");
		List<Lancamento> lancamentosVencidos = lancamentos.todosVencidos();
		
		EmailListener enviadorEmail = (EmailListener) jobDataMap.get("enviadorEmail");
		SMSListener enviadorSms = (SMSListener) jobDataMap.get("enviadorSms");
		enviadorEmail.enviar(lancamentosVencidos);
		enviadorSms.enviar(lancamentosVencidos);
	}

}
