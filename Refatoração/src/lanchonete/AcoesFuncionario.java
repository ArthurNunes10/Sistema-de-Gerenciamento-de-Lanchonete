package lanchonete;
import java.util.ArrayList;
import java.util.Scanner;

public class AcoesFuncionario {
	Scanner input = new Scanner(System.in);
	Exception inputException = new Exception();
	Verificacao verificador = new Verificacao();
	ArrayList<Funcionario> listaFuncionarios = BancoDados.listaFuncionarios;
	ArrayList<Pedido> historicoPedido= Historico.listaPedidoGeral;
	ArrayList<Cliente> listaCliente = BancoDados.listaClientes;
	ArrayList<Comida> listaComidas= BancoDados.listaComidas;
	ArrayList<Bebida> listaBebidas= BancoDados.listaBebidas;
	ArrayList<Pedido> listaPedidosAbertos= BancoDados.listaPedidosAbertos;
	Cadastro cadastro = new Cadastro();
	
	public void cadastrarPedido() {
		cadastro.cadastrarPedido();
	}
	
	public void cadastrarCliente() {
		Cliente cliente = cadastro.cadastrarCliente();
		BancoDados.adicionarCliente(cliente);
	}
	
	public void pedidosAbertos() {
		if(!BancoDados.listaPedidosAbertosIsEmpty()) {
			for(int i=0; i<listaPedidosAbertos.size(); i++) {
				ExibirDados.exibirDadosPedidos(i);
			}
		BancoDados.totalPedidosAbertos();
		}
	}
	
	public void concluirPedido() {
		if(!BancoDados.listaPedidosAbertosIsEmpty()) {
			int indice = Pedido.getIndice();
				BancoDados.removerPedido(indice);
		}
	}

	public void notaFiscal() {
		NotaFiscal nF = new NotaFiscal();
		nF.exibirNotaFiscal();
	}
	
	public void exibirCardapio() {
		ExibirDados.exibirCardapio();
	}
}
