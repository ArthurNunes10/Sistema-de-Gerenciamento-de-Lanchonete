package lanchonete;
import java.util.Scanner;

public class AcoesAdm {
	Scanner input = new Scanner(System.in);
	Exception inputException = new Exception();
	Verificacao verificador = new Verificacao();

	public void addFuncionario() {
		
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
		
		Funcionario funcionario = new Funcionario(nome,cpf,celular,email,endereco,salario,nit);
		BancoDados.listaFuncionarios.add(funcionario);
		
		System.out.println("\n>>Funcionário cadastrado com sucesso!\n");
	}
	
	public void removeFuncionario() {
		if(BancoDados.listaFuncionarios.isEmpty()) {
			System.out.println("\n>>Não possui funcionários\n");
		} 
		 else{
			System.out.print("\nDigite o nome do funcionário que irá ser demitido:");
			String nome = input.nextLine();
			if((verificador.procurarFuncionario(BancoDados.listaFuncionarios, nome))!= -1) {
				System.out.println("Funcionário demitido com sucesso!");
				BancoDados.listaFuncionarios.remove(verificador.procurarFuncionario(BancoDados.listaFuncionarios, nome));
				System.out.println("Total de funcionários: " + BancoDados.listaFuncionarios.size() + "\n");
			}
		}
	}
	
	public void alterarDadosFuncionario() {
		if(BancoDados.listaFuncionarios.isEmpty()) {
			System.out.println("\n>>Não possui funcionários\n");
		}
		else{
			int opcao;
			System.out.println("\n(1) Alterar Salário");
			System.out.println("(2) Alterar E-mail");
			System.out.println("(3) Alterar Número de Contato");
			opcao = inputException.inputMenu(1,3);
			
			switch (opcao) {
			case 1:
				System.out.print("\nDigite o nome do funcionário:");
				String nome = input.nextLine();
				if((verificador.procurarFuncionario(BancoDados.listaFuncionarios, nome))!= -1) {
					System.out.print("Digite o novo salário: R$");
					BancoDados.listaFuncionarios.get(verificador.procurarFuncionario(BancoDados.listaFuncionarios, nome)).setSalario(inputException.exceptionFloat());
					System.out.print(">>Salário alterado com sucesso!\n");
				}
				break;
			case 2:
				System.out.print("\nDigite o nome do funcionário:");
				String nome2 = input.nextLine();
				if((verificador.procurarFuncionario(BancoDados.listaFuncionarios, nome2))!= -1) {
					System.out.print("Digite o novo E-mail: ");
					BancoDados.listaFuncionarios.get(verificador.procurarFuncionario(BancoDados.listaFuncionarios, nome2)).setEmail(input.nextLine());
					System.out.print(">>E-mail alterado com sucesso!\n");
				}
				break;
			case 3:
				System.out.print("\nDigite o nome do funcionário:");
				String nome3 = input.nextLine();
				if((verificador.procurarFuncionario(BancoDados.listaFuncionarios, nome3))!= -1) {
					System.out.print("Digite um número de contato: ");
					BancoDados.listaFuncionarios.get(verificador.procurarFuncionario(BancoDados.listaFuncionarios, nome3)).setCelular(input.nextLine());
					System.out.print(">>Número alterado com sucesso!\n");
				}
				break;
			}
				
		}	
	}
	
	public void addLanche() {
		System.out.println("\n(1) Adicionar Comida");
		System.out.println("(2) Adicionar Bebida");
		int opcao = inputException.inputMenu(1,2);
		
		switch(opcao) {
		case 1:
			System.out.print(">>Nome da comida: ");
			String nomeComida = input.nextLine();
			System.out.print(">>Valor: R$");
			float valor = inputException.exceptionFloat();
			Comida lanche = new Comida(nomeComida, valor);
			BancoDados.listaComidas.add(lanche);
			System.out.println("");
			break;
		case 2:
			System.out.print(">>Nome da bebida: ");
			String nomeBebida = input.nextLine();
			System.out.print(">>Valor: R$");
			float valorBebida = inputException.exceptionFloat();
			Bebida bebida = new Bebida(nomeBebida, valorBebida);
			BancoDados.listaBebidas.add(bebida);
			System.out.println("");
			break;
		}
	}
	
	public void removeLanche() {
		System.out.println("\n(1) Remover Comida");
		System.out.println("(2) Remover Bebida");
		int opcao = inputException.inputMenu(1,2);
			
		switch(opcao) {
		case 1:
			if(BancoDados.listaComidas.isEmpty()) {
				System.out.println("\n>>Não possui comidas cadastradas\n");
			}
			else{
				System.out.print("Digite o nome da comida que irá ser removida:");
				String nomeComida = input.nextLine();
				if((verificador.procurarComida(BancoDados.listaComidas, nomeComida))!= -1) {
					BancoDados.listaComidas.remove(verificador.procurarComida(BancoDados.listaComidas, nomeComida));
					System.out.println(">>Comida removida com sucesso!");
					System.out.println(">>Total de opções de comida: " + BancoDados.listaComidas.size() + "\n");
				}
			}
			break;
		case 2:
			if(BancoDados.listaBebidas.isEmpty()) {
				System.out.println("\n>>Não possui bebidas cadastradas\n");
			}
			else{
				System.out.print(">>Digite o nome da bebida que irá ser removida:");
				String nomeBebida = input.nextLine();
				if((verificador.procurarBebida(BancoDados.listaBebidas, nomeBebida))!= -1) {
					BancoDados.listaBebidas.remove(verificador.procurarBebida(BancoDados.listaBebidas, nomeBebida));
					System.out.println(">>Bebida removida com sucesso!");
					System.out.println(">>Total de opções de bebidas: " + BancoDados.listaBebidas.size() + "\n");
				}
			}
			break;
		}
	}
	
	public void valorLanche() {
		System.out.println("\n(1) Alterar valor da Comida");
		System.out.println("(2) Alterar valor da Bebida");
		int opcao = inputException.inputMenu(1,2);
		
		switch(opcao) {
		case 1:
			if(BancoDados.listaComidas.isEmpty()) {
				System.out.println("\n>>Não possui comidas cadastradas\n");
			}
			else{
				System.out.print(">>Digite o nome da comida:");
				String nomeComida = input.nextLine();
				if((verificador.procurarComida(BancoDados.listaComidas, nomeComida))!= -1) {
					System.out.print(">>Digite o novo valor: R$");
					BancoDados.listaComidas.get(verificador.procurarComida(BancoDados.listaComidas, nomeComida)).setValor(inputException.exceptionFloat());
					System.out.println(">>Valor alterado com sucesso!\n");
				}
			}
			break;
		case 2:
			if(BancoDados.listaBebidas.isEmpty()) {
				System.out.println(">>Não possui bebidas cadastradas\n");
			}
			else{
				System.out.print("Digite o nome da bebida:");
				String nomeBebida = input.nextLine();
				if((verificador.procurarBebida(BancoDados.listaBebidas, nomeBebida))!= -1) {
					System.out.print("Digite o novo valor: R$");
					BancoDados.listaBebidas.get(verificador.procurarBebida(BancoDados.listaBebidas, nomeBebida)).setValor(inputException.exceptionFloat());
					System.out.println("Valor alterado com sucesso!\n");
				}
			}
			break;
		}
	}
	
	public void historicoGeral() {
		if(Historico.listaPedidoGeral.isEmpty())
			System.out.println("\n>>Nenhum pedido realizado!\n");
		Historico.listarHistoricoGeral();
	}
	
	public void historicoCliente() {
		if(BancoDados.listaClientes.isEmpty()) {
			System.out.println("\n>>Nenhum cliente cadastrado no momento.\n");
		}
		else {
			System.out.print("\nDigite o CPF do cliente:");
			String cpf = input.nextLine();
			if((verificador.procurarCliente(BancoDados.listaClientes, cpf))!= -1) {
				System.out.println(">>Histórico de Compras de "+ BancoDados.listaClientes.get(verificador.procurarCliente(BancoDados.listaClientes, cpf)).getNome()+":");
				BancoDados.listaClientes.get(verificador.procurarCliente(BancoDados.listaClientes, cpf)).historicoPedidos.listarHistoricoCliente();
				if(BancoDados.listaClientes.get(verificador.procurarCliente(BancoDados.listaClientes, cpf)).historicoPedidos.listaPedidoCliente.isEmpty()) {
					System.out.println("\n>>Histórico vazio\n");
				}
			}
		}
	}
	
	public void listarFuncionarios() {
		if(BancoDados.listaFuncionarios.isEmpty()) System.out.println("\n>>Não possui funcionários cadastrados no momento!\n");
		else {
			for(int i=0; i<BancoDados.listaFuncionarios.size(); i++) {
				System.out.println("-------\nNome: " + BancoDados.listaFuncionarios.get(i).getNome() +
								   "\nE-mail: " + BancoDados.listaFuncionarios.get(i).getEmail()+
								   "\nNIT: " + BancoDados.listaFuncionarios.get(i).getNit()+
								   "\nCpf: " + BancoDados.listaFuncionarios.get(i).getCpf()+
								   "\nCelular: " + BancoDados.listaFuncionarios.get(i).getCelular()+
								   "\nSalário:R$ " + BancoDados.listaFuncionarios.get(i).getSalario());
			}
			System.out.println("------");
			System.out.println(">>Total de funcionários: " + BancoDados.listaFuncionarios.size() + "\n");
		}	
	}
	
	public void caixaCorrente() {
		System.out.println("\n>>O caixa atual possui um saldo de R$"+BancoDados.getSaldo()+"\n");	
	}
	
	public void exibirCardapio() {
		System.out.println("\n>>COMIDAS DISPONÍVEIS:");
		
		if(BancoDados.listaComidas.isEmpty())
			System.out.println(">>Nenhuma comida cadastrada no momento!");
		else {
			for(int i=0; i<BancoDados.listaComidas.size(); i++) {
				System.out.println("-------\nNome: " + BancoDados.listaComidas.get(i).getNome() +
						   "\nValor: R$ " + BancoDados.listaComidas.get(i).getValor()+
						   "\nFrequência: " + BancoDados.listaComidas.get(i).getFrequencia());
			}
		}
		
		System.out.println("\n>>BEBIDAS DISPONÍVEIS:");
		
		if(BancoDados.listaBebidas.isEmpty())
			System.out.println(">>Nenhuma bebida cadastrada no momento!");
		else {
			for(int i=0; i<BancoDados.listaBebidas.size(); i++) {
				System.out.println("-------\nNome: " + BancoDados.listaBebidas.get(i).getNome() +
						   "\nValor: R$ " + BancoDados.listaBebidas.get(i).getValor() +
						   "\nFrequência: " + BancoDados.listaBebidas.get(i).getFrequencia() );
			}
		}
	}
}
