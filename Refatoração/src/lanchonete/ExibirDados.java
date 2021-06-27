package lanchonete;

import java.util.ArrayList;

public class ExibirDados {
	ArrayList<Funcionario> listaFuncionarios = BancoDados.listaFuncionarios;
	ArrayList<Pedido> historicoPedido= Historico.listaPedidoGeral;
	ArrayList<Cliente> listaCliente = BancoDados.listaClientes;
	static 	ArrayList<Comida> listaComidas= BancoDados.listaComidas;
	static	ArrayList<Bebida> listaBebidas= BancoDados.listaBebidas;
	
	//EXIBI��O DO CARD�PIO
	public static void exibirCardapio() {
		System.out.print("\n>>COMIDAS DISPON�VEIS:");
		if(!BancoDados.listaComidaIsEmpty()) {
			for(int i=0; i<listaComidas.size(); i++) 
				exibirDadosComidas(i);
			
		}
		System.out.print("\n\n>>BEBIDAS DISPON�VEIS:");
		if(!BancoDados.listaBebidasIsEmpty()) {
			for(int i=0; i<listaBebidas.size(); i++) 
				exibirDadosBebidas(i);
			System.out.println("");
		}
	}
	
	//M�TODOS DE EXIBI��O DE DADOS ESPEC�FICOS
	public static void exibirDadosFuncionarios(int indice) {
		Menu.cabecalho();
		Funcionario.exibirNome(indice);
		Funcionario.exibirEmail(indice);
		Funcionario.exibirNIT(indice);
		Funcionario.exibirCpf(indice);
		Funcionario.exibirCelular(indice);
		Funcionario.exibirSalario(indice);
	}
	
	public static void exibirDadosPedidos(int indice) {
		Menu.cabecalho();
		Pedido.exibirNomeCliente(indice);
		Pedido.exibirNomeComida(indice);
		Pedido.exibirNomeBebida(indice);
		Menu.rodape();
	}
	
	public static void exibirDadosComidas(int indice) {
		Menu.cabecalho();
		Comida.exibirNomeComida(indice);
		Comida.exibirValorComida(indice);
		Comida.exibirFrequenciaComida(indice);
	}
	
	public static void exibirDadosBebidas(int indice) {
		Menu.cabecalho();
		Bebida.exibirNomeBebida(indice);
		Bebida.exibirValorBebida(indice);
		Bebida.exibirFrequenciaBebida(indice);
	}
}
