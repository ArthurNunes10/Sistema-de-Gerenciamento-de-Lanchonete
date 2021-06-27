package lanchonete;
import java.util.ArrayList;
import java.util.Scanner;

public final class Cliente extends Pessoa{
	static Scanner input = new Scanner(System.in);
	Historico historicoPedidos = new Historico();
	ArrayList<Pedido> listaPedido = this.historicoPedidos.listaPedidoCliente;
	static ArrayList<Cliente> listaClientes = BancoDados.listaClientes;
	
	public Cliente(String nome, String cpf, String celular, String email, String endereco) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setCelular(celular);
		this.setEmail(email);
		this.setEndereco(endereco);	
	}	
	
	public void listarPedidos() {
		Historico.listarHistorico(listaPedido);
	}
	
	public static String lerCpf() {
		System.out.print("\nDigite o CPF do cliente:");
		return input.nextLine();
	}
	
	public static int getIndice(String cpf) {
		return Verificacao.procurarCliente(listaClientes, cpf); 
	}
}
