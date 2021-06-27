package lanchonete;
import java.util.Scanner;
import java.util.ArrayList;

public class Comida {
	private String nome;
	private float valor;
	private int frequencia;
	static ArrayList<Comida> listaComida = BancoDados.listaComidas;
	static Scanner input = new Scanner(System.in);
	static Exception inputException = new Exception();
	
	/*POLIMORFISMO ESTÁTICO 
	 CONSTRUTOR USADO NO CADASTRO DE COMIDAS AO CARDÁPIO*/
	public Comida(String nome, float valor) {
		this.setNome(nome);
		this.setValor(valor);
		this.setFrequencia(0);
	}
	
	public static void alterarValorComida() {
		if(!BancoDados.listaComidaIsEmpty()) {
			int indiceComida = getIndice();
			if(indiceComida!= -1) {
				System.out.print(">>Digite o novo valor: R$");
				listaComida.get(indiceComida).setValor(inputException.exceptionFloat());
				System.out.println(">>Valor alterado com sucesso!\n");
			}
		}
	}
	
	/*POLIMORFISMO ESTÁTICO 
	CONSTRUTOR USADO PARA PEDIDOS*/
	public Comida(String nome) {
		this.setNome(nome);
	}
	
	public static String lerNomeComida() {
		System.out.print("Digite o nome da comida:");
		return  input.nextLine();
	}
	
	public static String lerNomeComida(ArrayList <Comida>listaComida) {
		 return inputException.procuraComida(listaComida);
	}
	
	//MÉTODOS DE EXIBIÇÃO DE DADOS DA COMIDA
	public static void exibirNomeComida(int indice) {
		System.out.println("Nome:"+ listaComida.get(indice).getNome());
	}
	
	public static void exibirValorComida(int indice) {
		System.out.println("Valor:R$"+ listaComida.get(indice).getValor());
	}
	
	public static void exibirFrequenciaComida(int indice) {
		System.out.print("Frequência:"+ listaComida.get(indice).getFrequencia());
	}
	
	
	//METODOS GETTERS E SETTERS
	public static int getIndice() {
		return Verificacao.procurarComida(listaComida, lerNomeComida()); 
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public int getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}
	
}
