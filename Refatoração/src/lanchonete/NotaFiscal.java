package lanchonete;

import java.util.ArrayList;
import java.util.Scanner;

public class NotaFiscal {
	static ArrayList <Pedido>  listaPedidosAbertos = BancoDados. listaPedidosAbertos;
	Scanner input = new Scanner(System.in);
	
	public void exibirNotaFiscal() {
		if(!BancoDados.listaPedidosAbertosIsEmpty()) {
			int indicePedido = Pedido.getIndice();
			if(indicePedido!=-1) {
				exibirCabecalho();
				exibirProdutos(indicePedido);
				exibirData(indicePedido);
				exibirCusto(indicePedido);
				exibirOperador(indicePedido);
				exibirRodape();
			}
		}
	}
	
	private void exibirCabecalho(){
		System.out.println("---------------------");
		System.out.println("COMPROVANTE DE VENDA");
		System.out.println("---------------------");
	}
	
	private void exibirRodape(){
		System.out.println("---------------------\n");
	}
	
	private void exibirProdutos(int indice){
		System.out.println("Comida: "+ listaPedidosAbertos.get(indice).getComida().getNome());
		System.out.println("Bebida: "+ listaPedidosAbertos.get(indice).getBebida().getNome());
	}
	
	private void exibirData(int indice){
		System.out.println("(Data/Horário) de pagamento: "+listaPedidosAbertos.get(indice).getData());
	}
	
	private void exibirCusto(int indice){
		System.out.println("Custo: R$"+listaPedidosAbertos.get(indice).getCusto());
	}
	
	private void exibirOperador(int indice){
		System.out.println("Operador: "+listaPedidosAbertos.get(indice).getNomeFuncionario());
	}
}
