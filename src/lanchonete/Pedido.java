package lanchonete;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class Pedido {
	private Comida comida;
	private Bebida bebida;
	private float custo = 0f;
	private String data;
	private String nomeCliente;
	private String nomeFuncionario;
	
	//CONSTRUTOR
	public Pedido(String nomeCliente,Comida comida, Bebida bebida, float custo, String nomeF) {
		this.setComida(comida);
		this.setNomeCliente(nomeCliente);
		this.setBebida(bebida);
		this.setCusto(custo);
		this.setData();
		this.setNomeFuncionario(nomeF);
	}

	//MÉTODOS GETTERS E SETTERS
	public Comida getComida() {
		return comida;
	}
	
	public void setComida(Comida comida) {
		this.comida = comida;
	}
	
	public Bebida getBebida() {
		return bebida;
	}
	
	public void setBebida(Bebida bebida) {
		this.bebida = bebida;
	}
	
	public float getCusto() {
		return custo;
	}
	
	public void setCusto(float custo) {
		this.custo = custo;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData() {
		Date data = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss a");
		String dataFormatada = formatar.format(data);
		this.data = dataFormatada;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
	
}
