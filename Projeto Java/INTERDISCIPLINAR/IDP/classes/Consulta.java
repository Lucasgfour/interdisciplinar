package classes;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import banco.AgendamentoDao;

public class Consulta {
	// Foi utilizado uma hashTable conforme solicitação do Trabalho e para ajudar no armazenamento/exibição da Tela Inicial (Onde lista-se todos os agendamentos por Profissional).
	private Hashtable<String, LinkedList<Agendamento>> consultas = new Hashtable<String, LinkedList<Agendamento>>();
	
	public Consulta() {
		Atualizar();
	}
	
	public Consulta(List<Agendamento> agendamentos) {
		setDados(agendamentos);
	}
	
	// Atualizar Lista
	public void Atualizar() {
		AgendamentoDao Agend = new AgendamentoDao();
		setDados(Agend.listar());
	}
	
	// Receber Dados do Banco e distribuir os Agendamentos por Profissional
	public void setDados(List<Agendamento> agendamentos) {
		try {
			for (int i = 0; i < agendamentos.size(); i++) {
				Agendamento tempAgend = agendamentos.get(i);
				if(consultas.containsKey(tempAgend.getNomeProfissional())) {
					consultas.get(tempAgend.getNomeProfissional()).add(tempAgend);
				} else {
					consultas.put(tempAgend.getNomeProfissional(), new LinkedList<Agendamento>());
					consultas.get(tempAgend.getNomeProfissional()).add(tempAgend);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Retorna os Agendamentos de Determinado Profissional já ordenado por Data/Horario
	public LinkedList<Agendamento> getPacientes(String profissional) {
		LinkedList<Agendamento> listPaciente = new LinkedList<Agendamento>();
		try {
			listPaciente = consultas.get(profissional);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listPaciente;
	}
}
