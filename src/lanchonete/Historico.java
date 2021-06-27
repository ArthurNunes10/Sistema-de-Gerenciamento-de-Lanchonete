package lanchonete;

import java.util.ArrayList;

public  class  Historico {
	ArrayList<Pedido> listaPedidoCliente = new ArrayList<Pedido>();
	static ArrayList<Pedido> listaPedidoGeral = new ArrayList<Pedido>();
	
	public void hCliente(Pedido pedido) {
		this.listaPedidoCliente.add(pedido);
	}
	
	public static void hPedidos(Pedido pedido) {
		listaPedidoGeral.add(pedido);
	}
	
	public static void listarHistoricoGeral() {
		for(int i=listaPedidoGeral.size()-1; i>=0; i--) {
			System.out.println("\n-------\nCliente:  " + listaPedidoGeral.get(i).getNomeCliente() +
								"\nData: " +listaPedidoGeral.get(i).getData() +
							   "\nComida: " +listaPedidoGeral.get(i).getComida().getNome()+
							   "\nBebida: " +listaPedidoGeral.get(i).getBebida().getNome()+
							   "\nValor: R$" +listaPedidoGeral.get(i).getCusto() + "\n-------\n");
		}
	}
	
	public void listarHistoricoCliente() {
		for(int i=listaPedidoCliente.size()-1; i>=0; i--) {
			System.out.println("\n-------\nCliente:  " + this.listaPedidoCliente.get(i).getNomeCliente() +
								"\nData: " +this.listaPedidoCliente.get(i).getData() +
							   "\nComida: " +this.listaPedidoCliente.get(i).getComida().getNome()+
							   "\nBebida: " + this.listaPedidoCliente.get(i).getBebida().getNome()+
							   "\nValor: R$" +this.listaPedidoCliente.get(i).getCusto()+ "\n-------\n");
		}
	}
}
