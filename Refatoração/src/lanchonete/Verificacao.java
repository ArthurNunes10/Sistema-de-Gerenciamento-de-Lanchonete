package lanchonete;

import java.util.ArrayList;
import java.util.Scanner;

public class Verificacao {
	Scanner input = new Scanner(System.in);

	public void menuAcessoAdm() {
		String login, senha;
		do {
			System.out.print("------------\n>>Login: ");
			login = input.nextLine();
			System.out.print(">>Senha: ");
			senha = input.nextLine();
			System.out.println("------------");
			if(!(login.equals("admin")&&senha.equals("admin"))) System.out.println("Usuário e senha incorretos, por favor, digite novamente!");
		}while(!(login.equals("admin")&&senha.equals("admin")));
	}

	public static  int procurarFuncionario(ArrayList<Funcionario> lista, String nome) {
		int indice = -1;
		
		for(int i=0; i<lista.size(); i++) {
			if(lista.get(i).getNome().equals(nome)) {
				indice = i;
				break;
			}	
			else if(i==lista.size()-1) 
				System.out.println("\n>>Funcionário não encontrado ou inexistente!\n");	
		}
		return indice;
	}
	
	public static int procurarCliente(ArrayList<Cliente> lista, String cpf) {
		int indice = -1;
		
		if(lista.isEmpty())
			System.out.println("\n>>Cliente não encontrado ou inexistente!\n");
		else {
			for(int i=0; i<lista.size(); i++) {
				if(lista.get(i).getCpf().equals(cpf)) {
					indice = i;
					break;
				}
					
				else if(i==lista.size()-1) 
					System.out.println("\n>>Cliente não encontrado ou inexistente!\n");	
			}
		}
		return indice;
	}
	
	public static int procurarComida(ArrayList<Comida> lista, String nome) {
		int indice = -1;
		
		for(int i=0; i<lista.size(); i++) {
			if(lista.get(i).getNome().equals(nome)) {
				indice = i;
				break;
			}
				
			else if(i==lista.size()-1) 
				System.out.println("\n>>Comida não encontrada ou inexistente!\n");	
		}
		return indice;
	}
	
	public static int procurarBebida(ArrayList<Bebida> lista, String nome) {
		int indice = -1;
		
		for(int i=0; i<lista.size(); i++) {
			if(lista.get(i).getNome().equals(nome)) {
				indice = i;
				break;
			}
			else if(i==lista.size()-1) 
				System.out.println("\n>>Bebida não encontrada ou inexistente!\n");	
		}
		return indice;
	}
	
	public static int procurarPedido(ArrayList<Pedido> lista, String nome) {
		int indice = -1;
		
		for(int i=0; i<lista.size(); i++) {
			if(lista.get(i).getNomeCliente().equals(nome)) {
				indice = i;
				break;
			}
				
			else if(i==lista.size()-1) 
				System.out.println("\n>>Pedido não encontrado ou inexistente!\n");	
		}
		return indice;
	}
	
	public void verificarListaCliente(String cpf) {
		ArrayList<Cliente> listaCliente = BancoDados.listaClientes;
		int indiceCliente = procurarCliente(listaCliente, cpf);
		
		if(listaCliente.get(indiceCliente).listaPedido.isEmpty()) {
			System.out.println("\n>>Histórico vazio\n");
		}
	}
	
}
