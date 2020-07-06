package banco;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class Parametro {
	// Esta estrutura é uma filha da Comando (Aqui são adicionados os parâmetros do comando SQL)
	

	private String titulo;
	private String valor;
	private String tipo;
	
	public Parametro(String titulo, String valor, String tipo) {
		this.titulo = titulo;
		this.valor = valor;
		this.tipo = tipo;
	}
	
	public Parametro(String titulo, String tipo) {
		this.titulo = titulo;
		this.tipo = tipo;
	}
	
	// Mostra janela de diálogo para usuário inserir o valor do parâmetro
	public void showInput() {
		this.valor = JOptionPane.showInputDialog("Insira o paramêtro " + titulo + " (" + this.tipo + ") :");
	}
	
	// Retorna Valor em Formato String
	public String getValorString() { return this.valor; }
	
	// Retorna Valor em Formato Inteiro
	public int getValorInt() { try { return Integer.parseInt(this.valor); } catch (Exception e) { return 0; } }
	
	// Retorna Valor em Format Float
	public float getValorFloat() { try { return Float.parseFloat(this.valor); } catch (Exception e) { return 0; } }
	
	// Retorna Valor em formato Data
	public LocalDate getValorData() { try { return LocalDate.parse(this.valor, DateTimeFormatter.ofPattern("dd/MM/yyyy")); } catch (Exception e) { return LocalDate.now(); } }
	
	// Retorna Valor em formato Time
	public LocalTime getValorTime() { try { return LocalTime.parse(this.valor); } catch (Exception e) { return LocalTime.now(); } }
	
	// Retorna Valor em Boolean
	public boolean getValorBoolean() { try { return Boolean.parseBoolean(this.valor); } catch (Exception e) { return false; } }
	
	// Retorna Valor em String com Like
	public String getValorLike() { return "%" + this.valor + "%"; }
	
	public String toString() {
		String saida = "== Parâmetro ==\n= Titulo : " + this.titulo + "\n= Valor : " + this.valor + "\n= Tipo : " + this.tipo;
		return saida;
	}
	
	public String getTipo() {
		return this.tipo;
	}

	public String getTitulo() {
		return titulo;
	}
	
	
	
}
