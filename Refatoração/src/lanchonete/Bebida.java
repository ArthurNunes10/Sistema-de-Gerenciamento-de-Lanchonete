package lanchonete;
import java.util.ArrayList;
import java.util.Scanner;

public  class Bebida {
	private String nome;
	private float valor;
	private int frequencia;
	static Scanner input = new Scanner(System.in);
	static ArrayList<Bebida> listaBebidas = BancoDados.listaBebidas;
	static Exception inputException = new Exception();
	
	/*POLIMORFISMO ESTÁTICO 
	 CONSTRUTOR USADO NO CADASTRO DE BEBIDAS AO CARDÁPIO*/
	public Bebida(String nome, float valor) {
		this.setNome(nome);
		this.setValor(valor);
		this.setFrequencia(0);
	}
	
	/*POLIMORFISMO ESTÁTICO 
	CONSTRUTOR USADO PARA PEDIDOS*/
	public Bebida(String nome) {
		this.setNome(nome);
	}
	
	public static void alterarValorBebida() {
		if(!BancoDados.listaBebidasIsEmpty()) {
			int indiceBebida = getIndice();
			if(indiceBebida!= -1) {
				System.out.print(">>Digite o novo valor: R$");
				listaBebidas.get(indiceBebida).setValor(inputException.exceptionFloat());
				System.out.println(">>Valor alterado com sucesso!\n");
			}
		}
	}
	
	public static String lerNomeBebida() {
		System.out.print("Digite o nome da bebida:");
		return  input.nextLine();
	}
	
	public static String lerNomeBebida(ArrayList <Bebida>listaBebida) {
		 return inputException.procuraBebida(listaBebida);
	}
	
	//MÉTODOS DE EXIBIÇÃO DE DADOS DA BEBIDA
		public static void exibirNomeBebida(int indice) {
			System.out.println("Nome:"+ listaBebidas.get(indice).getNome());
		}
		
		public static void exibirValorBebida(int indice) {
			System.out.println("Valor:R$"+ listaBebidas.get(indice).getValor());
		}
		
		public static void exibirFrequenciaBebida(int indice) {
			System.out.print("Frequência:"+ listaBebidas.get(indice).getFrequencia());
		}
	
	//METODOS GETTERS E SETTERS
	public static int getIndice() {
		return Verificacao.procurarBebida(listaBebidas, lerNomeBebida()); 
	}
	
	public int getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
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

}
