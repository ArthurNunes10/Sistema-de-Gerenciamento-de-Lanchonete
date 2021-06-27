package lanchonete;

import java.util.ArrayList;

public class BancoDados {
	public static ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
	public static ArrayList<Comida> listaComidas = new ArrayList<Comida>();
	public static ArrayList<Bebida> listaBebidas = new ArrayList<Bebida>();
	public static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	public static ArrayList<Pedido> listaPedidosAbertos = new ArrayList<Pedido>();
	private static float saldo = 0f;
	
	public static float getSaldo() {
		return saldo;
	}
	public static void setSaldo(float saldo) {
		BancoDados.saldo = saldo;
	}
}
