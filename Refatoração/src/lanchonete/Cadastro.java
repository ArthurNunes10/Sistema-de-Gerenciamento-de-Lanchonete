package lanchonete;

import java.util.ArrayList;
import java.util.Scanner;

public  class Cadastro {
	Scanner input = new Scanner(System.in);
	Exception inputException = new Exception();
	ArrayList<Comida> listaComidas= BancoDados.listaComidas;
	ArrayList<Bebida> listaBebidas= BancoDados.listaBebidas;
	ArrayList<Funcionario> listaFuncionarios= BancoDados.listaFuncionarios;
	ArrayList<Cliente> listaClientes = BancoDados.listaClientes;
	
	public  Funcionario cadastrarFuncionario(){
		
		System.out.print("\nNome:");
		String nome = input.nextLine();
		
		System.out.print("CPF:");
		String  cpf = input.nextLine();
		
		System.out.print("NIT: ");
		String  nit = input.nextLine();
		
		System.out.print("Celular:");
		String  celular = input.nextLine();
		
		System.out.print("E-mail:");
		String  email = input.nextLine();
		
		System.out.print("Endereço:");
		String endereco = input.nextLine();
		
		System.out.print("Salário: R$");
		float salario = inputException.exceptionFloat();
		
		return new Funcionario(nome,cpf,celular,email,endereco,salario,nit);
	}
	
	public Cliente cadastrarCliente() {
		System.out.print("\nNome:");
		String nome = input.nextLine();
		
		System.out.print("CPF:");
		String  cpf = input.nextLine();
		
		System.out.print("Celular:");
		String  celular = input.nextLine();
		
		System.out.print("E-mail:");
		String  email = input.nextLine();
		
		System.out.print("Endereço:");
		String endereco = input.nextLine();
		return new Cliente (nome, cpf, celular, email, endereco);
	}
	
	private void cadastrarComida() {
		System.out.print(">>Nome da comida: ");
		String nomeComida = input.nextLine();
		
		System.out.print(">>Valor: R$");
		float valor = inputException.exceptionFloat();
		BancoDados.addComida(new Comida(nomeComida, valor));
	}
	
	private void cadastrarBebida() {
		System.out.print(">>Nome da bebida: ");
		String nomeBebida = input.nextLine();
		
		System.out.print(">>Valor: R$");
		float valorBebida = inputException.exceptionFloat();
		BancoDados.addBebida(new Bebida(nomeBebida, valorBebida));
	}
	
	public void cadastrarLanche(int opcao) {
		switch(opcao) {
		case 1:
			 cadastrarComida();
			break;
		case 2:
			 cadastrarBebida();
			break;
		}
	}
	
	public void alterarValorLanche(int opcao) {
		switch(opcao) {
		case 1:
			Comida.alterarValorComida();
			break;
		case 2:
			Bebida.alterarValorBebida();
			break;
		}
	}
	
	public void cadastrarPedido() {
	
		if(!BancoDados.lanchesIsEmpty()) {
			String cpf = Cliente.lerCpf();
			int indiceCliente = Cliente.getIndice(cpf);
			if(indiceCliente!=-1) {
				ExibirDados.exibirCardapio(); 
				String nomeComida =  Comida.lerNomeComida(listaComidas);
				int indiceComida = Verificacao.procurarComida(listaComidas,nomeComida);
				String nomeBebida = Bebida.lerNomeBebida(listaBebidas);
				int indiceBebida = Verificacao.procurarBebida(listaBebidas,nomeBebida);
				String nomeOperador = Funcionario.lerNomeFuncionario(listaFuncionarios);
				Comida comida = new Comida(nomeComida);
				Bebida	bebida = new Bebida(nomeBebida);
				System.out.println("");
				BancoDados.atualizarFrequenciaComida(indiceComida);
				BancoDados.atualizarFrequenciaBebida(indiceBebida);
				float custo = BancoDados.atualizarSaldo(indiceComida, indiceBebida);
				Pedido pedido = new Pedido(listaClientes.get(indiceCliente).getNome(), comida, bebida, custo, nomeOperador);
				BancoDados.adicionarPedido(pedido);
				Historico.adicionarPedidoHistoricoGeral(pedido); 
				BancoDados.adicionarPedidoHistoricoCliente(pedido,indiceCliente);
			}
		}
	}
}
