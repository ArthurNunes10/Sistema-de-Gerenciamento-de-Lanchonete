package lanchonete;

public class Funcionario extends Pessoa {
	private float  salario;
	private String nit;
	
	public Funcionario(String nome, String cpf, String celular, String email, String endereco, float salario, String nit) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setCelular(celular);
		this.setEmail(email);
		this.setEndereco(endereco);
		this.setSalario(salario);
		this.setNit(nit);
	}

	//MÉTODOS GETTERS E SETTERS
	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}
}
