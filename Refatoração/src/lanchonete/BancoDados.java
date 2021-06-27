package lanchonete;

import java.util.ArrayList;

public class BancoDados {
	public static ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
	public static ArrayList<Comida> listaComidas = new ArrayList<Comida>();
	public static ArrayList<Bebida> listaBebidas = new ArrayList<Bebida>();
	public static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	public static ArrayList<Pedido> listaPedidosAbertos = new ArrayList<Pedido>();
	private static float saldo = 0f;
	
	//MÉTODOS DE ADICIONAR
	public static void adicionarFuncionarios(Funcionario funcionario) {
		listaFuncionarios.add(funcionario);
		System.out.println("\n>>Funcionário cadastrado com sucesso!\n");
	}
	
	public static void adicionarCliente(Cliente cliente) {
		listaClientes.add(cliente);
		System.out.println("\n>>Cliente cadastrado com sucesso!\n");
	}
	
	public static void adicionarPedidoHistoricoCliente(Pedido pedido, int indiceCliente) {
	listaClientes.get(indiceCliente).historicoPedidos.adicionarPedidoHistoricoCliente(pedido);
	}
	
	public static void adicionarPedido(Pedido pedido) {
		listaPedidosAbertos.add(pedido);
	}
	
	public static void addComida(Comida comida) {
		listaComidas.add(comida);
		System.out.println("");
	}
	
	public static void addBebida(Bebida bebida) {
		listaBebidas.add(bebida);
		System.out.println("");
	}
	
	//VERIFICA SE UMA LISTA ESTÁ VAZIA
	public static boolean listaFuncionarioIsEmpty() {
		if(listaFuncionarios.isEmpty()) {
			System.out.println("\n>>Não possui funcionários\n");
			return true;
		}
			return false;
	}
	
	public static boolean listaClienteIsEmpty() {
		if(listaClientes.isEmpty()) {
			System.out.println("\n>>Nenhum cliente cadastrado no momento.\n");
			return true;
		}
			return false;
	}
	
	public static boolean listaComidaIsEmpty() {
		if(listaComidas.isEmpty()) {
			System.out.println("\n>>Não possui comidas cadastradas\n");
			return true;
		}
			return false;
	}
	
	public static boolean listaBebidasIsEmpty() {
		if(listaBebidas.isEmpty()) {
			System.out.println("\n>>Não possui bebidas cadastradas\n");
			return true;
		}
			return false;
	}
	
	public static boolean listaPedidosAbertosIsEmpty() {
		if(listaPedidosAbertos.isEmpty()) {
			System.out.println("\n>>Não temos nenhum pedido em aberto no momento\n");
			return true;
		}
			return false;
	}
	
	public static boolean lanchesIsEmpty() {
		if(listaComidas.isEmpty() || listaBebidas.isEmpty()) {
			System.out.println("\nImpossível cadastrar pedido, por favor, adicione pelo menos uma opção de comida e bebida ao cardápio!\n");
			return true;
		}
		return false;
	}
	
	//MÉTODOS QUE EXIBEM O TOTAL DE ITENS DE UMA LISTA
	public static void totalFuncionarios() {
		System.out.println("Total de funcionários: " + listaFuncionarios.size() + "\n");
	}
	
	public static void totalComidas() {
		System.out.println(">>Total de opções de comida: " + listaComidas.size() + "\n");
	}
	
	public static void totalBebidas() {
		System.out.println(">>Total de opções de bebida: " + listaBebidas.size() + "\n");
	}
	
	public static void totalPedidosAbertos() {
		System.out.println(">>Total de pedidos em aberto: " + listaPedidosAbertos.size() + "\n");
	}
	
	//MÉTODOS DE REMOÇÃO
	public static void removerPedido(int indice) {
		if(indice!=-1) {
			listaPedidosAbertos.remove(indice);
			System.out.println(">>Pedido concluido com sucesso!\n");
		}
	}
	
	public static void removerFuncionarios() {
		int indiceFuncionario = Funcionario. getIndice();
		if(indiceFuncionario!=-1) {
			listaFuncionarios.remove(indiceFuncionario);
			System.out.println("Funcionário demitido com sucesso!");
		}
	}
	
	private static void removerComida() {
		int indiceComida = Comida. getIndice();
		if(indiceComida!= -1) {
			listaComidas.remove(indiceComida);
			System.out.println(">>Comida removida com sucesso!");
			totalComidas();
		}
	}
	
	private static void removerBebida() {
		int indiceBebida = Bebida. getIndice();
		if(indiceBebida!= -1) {
			listaBebidas.remove(indiceBebida);
			System.out.println(">>Bebida removida com sucesso!");
			totalBebidas();
		}
	}
	
	public static void removerLanche(int tipo) {
		switch(tipo) {
		case 1:
			if(!listaComidaIsEmpty()) {
				removerComida();
			}
			break;
		case 2:
			if(!listaBebidasIsEmpty()) {
				removerBebida();
			}
			break;
		}
	}
	
	//MÉTODOS DE ATUALIZAÇÃO DE FREQUÊNCIA DAS COMIDAS
	public static void atualizarFrequenciaComida(int indiceComida) {
		listaComidas.get(indiceComida).setFrequencia(listaComidas.get(indiceComida).getFrequencia()+1);
	}
	
	public static void atualizarFrequenciaBebida(int indiceBebida) {
		listaBebidas.get(indiceBebida).setFrequencia(listaBebidas.get(indiceBebida).getFrequencia()+1);
	}
	
	//MÉTODOS DE SALDO
	public static Float atualizarSaldo(int indiceComida, int indiceBebida) {
		float custo = 0f;
		custo = listaComidas.get(indiceComida).getValor();
		custo += listaBebidas.get(indiceBebida).getValor();
		setSaldo(getSaldo()+custo);
		return custo;
	}
	
	public static float getSaldo() {
		return saldo;
	}
	
	private static void setSaldo(float saldo) {
		BancoDados.saldo = saldo;
	}
}
