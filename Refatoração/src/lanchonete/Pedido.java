package lanchonete;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public final class Pedido {
	private Comida comida;
	private Bebida bebida;
	private float custo = 0f;
	private String data;
	private String nomeCliente;
	private String nomeFuncionario;
	static ArrayList <Pedido>  listaPedidosAbertos = BancoDados. listaPedidosAbertos;
	static Scanner input = new Scanner(System.in);
	
	//CONSTRUTOR
	public Pedido(String nomeCliente,Comida comida, Bebida bebida, float custo, String nomeF) {
		this.setComida(comida);
		this.setNomeCliente(nomeCliente);
		this.setBebida(bebida);
		this.setCusto(custo);
		this.setData();
		this.setNomeFuncionario(nomeF);
	}
	
	public Comida getComida() {
		return comida;
	}
	
	public static void exibirNomeCliente(int i) {
		System.out.println("Nome: "+ listaPedidosAbertos.get(i).getNomeCliente());
	}
	
	public static void exibirNomeComida(int indice) {
		System.out.println("Comida:"+ listaPedidosAbertos.get(indice).getComida().getNome());
	}
	
	public static void exibirNomeBebida(int indice) {
		System.out.println("Bebida:"+ listaPedidosAbertos.get(indice).getBebida().getNome());
	}
	
	public static int getIndice() {
		System.out.print("\n>>Digite o nome do cliente:");
		return Verificacao.procurarPedido(listaPedidosAbertos, input.nextLine());
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
