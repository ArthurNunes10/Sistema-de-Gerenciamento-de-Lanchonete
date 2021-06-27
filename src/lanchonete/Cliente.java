package lanchonete;

public final class Cliente extends Pessoa{
	Historico historicoPedidos = new Historico();
	
	public Cliente(String nome, String cpf, String celular, String email, String endereco) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setCelular(celular);
		this.setEmail(email);
		this.setEndereco(endereco);	
	}	
}
