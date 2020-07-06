package classes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Agendamento {
	private int id;
	private LocalDate data;
	private LocalTime horario;
	private float duracao;
	private String cpf;
	private String nomePaciente;
	private String telefone;
	private LocalDate dataNascimento;
	private String nomeProfissional; // Nome do profissional
	private String tipo; // [ Clínico Geral, Dentista, Fisioterapeuta, Cardiologista, Dermatologista ]
	private float valorConsulta; // Padrão 200,00
	private int porcDesconto; // De 0 até 100
	private int convenio; // [ 0 - Não / 1 - Sim ]
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public LocalTime getHorario() {
		return horario;
	}
	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
	public float getDuracao() {
		return duracao;
	}
	public void setDuracao(float duracao) {
		this.duracao = duracao;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNomePaciente() {
		return nomePaciente;
	}
	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getNomeProfissional() {
		return nomeProfissional;
	}
	public void setNomeProfissional(String nomeProfissional) {
		this.nomeProfissional = nomeProfissional;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public float getValorConsulta() {
		return valorConsulta;
	}
	public void setValorConsulta(float valorConsulta) {
		this.valorConsulta = valorConsulta;
	}
	public int getPorcDesconto() {
		return porcDesconto;
	}
	public void setPorcDesconto(int porcDesconto) {
		this.porcDesconto = porcDesconto;
	}
	public int getConvenio() {
		return convenio;
	}
	public void setConvenio(int convenio) {
		this.convenio = convenio;
	}
	
	// Retorna em formato Array
	public String[] getVetor() {
		String[] vetor = new String[13];
		vetor[0] = String.valueOf(this.getId());
		vetor[1] = String.valueOf(this.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		vetor[2] = String.valueOf(this.getHorario().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
		vetor[3] = String.valueOf(this.getDuracao());
		vetor[4] = this.getCpf();
		vetor[5] = this.getNomePaciente();
		vetor[6] = this.getTelefone();
		vetor[7] = String.valueOf(this.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		vetor[8] = this.getNomeProfissional();
		vetor[9] = this.getTipo();
		vetor[10] = String.valueOf(this.getValorConsulta());
		vetor[11] = String.valueOf(this.getPorcDesconto());
		vetor[12] = String.valueOf(this.getConvenio());
		return vetor;
	}
	
	
}
