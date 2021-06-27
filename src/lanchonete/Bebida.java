package lanchonete;

public  class Bebida {
	private String nome;
	private float valor;
	private int frequencia;
	
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
	
	//METODOS GETTERS E SETTERS
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
