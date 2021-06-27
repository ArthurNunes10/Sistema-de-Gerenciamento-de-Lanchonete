package lanchonete;

import java.util.ArrayList;

public class Historico {
	ArrayList<Pedido> listaPedidoCliente = new ArrayList<Pedido>();
	static ArrayList<Pedido> listaPedidoGeral = new ArrayList<Pedido>();

	// adiciona pedido no historico pessoal do cliente
	public void adicionarPedidoHistoricoCliente(Pedido pedido) {
		this.listaPedidoCliente.add(pedido);
	}

	// adiciona pedido no histórico geral
	public static void adicionarPedidoHistoricoGeral(Pedido pedido) {
		listaPedidoGeral.add(pedido);
	}

	// listar historico 
	public static void listarHistorico(ArrayList<Pedido> historico) {
		for (int i = historico.size() - 1; i >= 0; i--) {
			System.out.println("\n-------\nCliente:  " + historico.get(i).getNomeCliente() + "\nData: "
					+ historico.get(i).getData() + "\nComida: " + historico.get(i).getComida().getNome() + "\nBebida: "
					+ historico.get(i).getBebida().getNome() + "\nValor: R$" + historico.get(i).getCusto()
					+ "\n-------\n");
		}
	}
	
	public void exibirHistoricoCliente(String cpf) {
		ArrayList<Cliente> listaCliente = BancoDados.listaClientes;
		int indiceCliente = Verificacao.procurarCliente(listaCliente, cpf);
		System.out.println("\n>>Histórico de Compras de "+listaCliente.get(indiceCliente).getNome()+":");
		listaCliente.get(indiceCliente).listarPedidos();
	}
}
