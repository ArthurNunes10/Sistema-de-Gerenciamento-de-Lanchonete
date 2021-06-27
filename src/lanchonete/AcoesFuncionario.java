package lanchonete;
import java.util.Scanner;

public class AcoesFuncionario {
	Scanner input = new Scanner(System.in);
	Exception inputException = new Exception();
	Verificacao verificador = new Verificacao();
	
	public void cadastrarPedido() {
		Comida comida;
		Bebida bebida;
		String nomeComida;
		String nomeBebida;
		String nomeOperador;
		float custo = 0f;
		
		if(BancoDados.listaComidas.isEmpty() || BancoDados.listaBebidas.isEmpty()) {
			System.out.println("\nImposs�vel cadastrar pedido, por favor, adicione pelo menos uma op��o de comida e bebida ao card�pio!\n");
		}
		else {
			System.out.print("\nDigite o CPF do cliente:");
			String cpf = input.nextLine();
			if(verificador.procurarCliente(BancoDados.listaClientes, cpf)!=-1) {
				exibirCardapio();
				
				System.out.print("\n>>Digite o nome da comida:");
				nomeComida = inputException.procuraComida(BancoDados.listaComidas,input.nextLine());
				
				System.out.print("\n>>Digite o nome da bebida:");
				nomeBebida = inputException.procuraBebida(BancoDados.listaBebidas,input.nextLine());
				
				System.out.print("\n>>Operador:");
				nomeOperador = inputException.procuraFuncionario(BancoDados.listaFuncionarios,input.nextLine());
				
				System.out.println("");
				comida = new Comida(nomeComida);
				bebida = new Bebida(nomeBebida);
				
				//ATUALIZA CUSTO E FREQU�NCIA DA COMIDA
				custo += BancoDados.listaComidas.get(verificador.procurarComida(BancoDados.listaComidas,nomeComida)).getValor();
				BancoDados.listaComidas.get(verificador.procurarComida(BancoDados.listaComidas,nomeComida)).setFrequencia(BancoDados.listaComidas.get(verificador.procurarComida(BancoDados.listaComidas,nomeComida)).getFrequencia()+1);
				
				//ATUALIZA CUSTO E FREQU�NCIA DA BEBIDA
				custo += BancoDados.listaBebidas.get(verificador.procurarBebida(BancoDados.listaBebidas,nomeBebida)).getValor();
				BancoDados.listaBebidas.get(verificador.procurarBebida(BancoDados.listaBebidas,nomeBebida)).setFrequencia(BancoDados.listaBebidas.get(verificador.procurarBebida(BancoDados.listaBebidas,nomeBebida)).getFrequencia()+1);
				
				//ADICIONA PEDIDO AOS PEDIDOS EM ABERTO
				Pedido pedido = new Pedido(BancoDados.listaClientes.get(verificador.procurarCliente(BancoDados.listaClientes, cpf)).getNome(), comida, bebida, custo, nomeOperador);
				BancoDados.listaPedidosAbertos.add(pedido);
				
				//ADICIONA PEDIDO NO HIST�RICO GERAL
				Historico.hPedidos(pedido); 
				
				//ADICIONA PEDIDO NO HIST�RICO PESSOAL DO CLIENTE
				BancoDados.listaClientes.get(verificador.procurarCliente(BancoDados.listaClientes, cpf)).historicoPedidos.hCliente(pedido);
				
				//ATUALIZA O SALDO DE CAIXA
				BancoDados.setSaldo(BancoDados.getSaldo()+custo);
			}
		}
	}
	
	public void cadastrarCliente() {
		System.out.print("\nNome:");
		String nome = input.nextLine();
		
		System.out.print("CPF:");
		String  cpf = input.nextLine();
		
		System.out.print("Celular:");
		String  celular = input.nextLine();
		
		System.out.print("E-mail:");
		String  email = input.nextLine();
		
		System.out.print("Endere�o:");
		String endereco = input.nextLine();
		
		Cliente cliente = new Cliente (nome, cpf, celular, email, endereco);
		BancoDados.listaClientes.add(cliente);
		
		System.out.println("\n>>Cliente cadastrado com sucesso!\n");
	}
	
	public void pedidosAbertos() {
		if(BancoDados.listaPedidosAbertos.isEmpty()) {
			System.out.println("\n>>N�o temos nenhum pedido em aberto no momento\n");
		}
		else {
			for(int i=0; i<BancoDados.listaPedidosAbertos.size(); i++) {
				System.out.println("-------\nNome: " + BancoDados.listaPedidosAbertos.get(i).getNomeCliente() +
						   "\nComida: " + BancoDados.listaPedidosAbertos.get(i).getComida().getNome()+
						   "\nBebida: " + BancoDados.listaPedidosAbertos.get(i).getBebida().getNome());
			}
			System.out.println("------");
			System.out.println(">>Total de pedidos em aberto: " + BancoDados.listaPedidosAbertos.size() + "\n");
		}
	}
	
	public void concluirPedido() {
		if(BancoDados.listaPedidosAbertos.isEmpty()) {
			System.out.println("\n>>N�o temos nenhum pedido em aberto no momento\n");
		}
		
		else {
			System.out.print("\n>>Digite o nome do cliente:");
			String nome = input.nextLine();
			if(verificador.procurarPedido(BancoDados.listaPedidosAbertos,nome)!=-1) {
				BancoDados.listaPedidosAbertos.remove(verificador.procurarPedido(BancoDados.listaPedidosAbertos,nome));
				System.out.println(">>Pedido concluido com sucesso!\n");
			}
		}
	}

	public void notaFiscal() {
		if(BancoDados.listaPedidosAbertos.isEmpty()) {
			System.out.println("\n>>N�o temos nenhum pedido em aberto no momento\n");
		}
		else {
			System.out.print("\n>>Digite o nome do cliente:");
			String nome = input.nextLine();
			if(verificador.procurarPedido(BancoDados.listaPedidosAbertos,nome)!=-1) {
				System.out.println("---------------------");
				System.out.println("COMPROVANTE DE VENDA");
				System.out.println("---------------------");
				System.out.println(">>Produtos:");
				System.out.println("Comida: "+BancoDados.listaPedidosAbertos.get(verificador.procurarPedido(BancoDados.listaPedidosAbertos,nome)).getComida().getNome());
				System.out.println("Bebida: "+BancoDados.listaPedidosAbertos.get(verificador.procurarPedido(BancoDados.listaPedidosAbertos,nome)).getBebida().getNome());
				System.out.println("(Data/Hor�rio) de pagamento: "+BancoDados.listaPedidosAbertos.get(verificador.procurarPedido(BancoDados.listaPedidosAbertos,nome)).getData());
				System.out.println("Custo: R$"+BancoDados.listaPedidosAbertos.get(verificador.procurarPedido(BancoDados.listaPedidosAbertos,nome)).getCusto());
				System.out.println("Operador: "+BancoDados.listaPedidosAbertos.get(verificador.procurarPedido(BancoDados.listaPedidosAbertos,nome)).getNomeFuncionario());
				System.out.println("---------------------\n");
			}
		}
	}
	
	public void exibirCardapio() {
		System.out.println("\n>>COMIDAS DISPON�VEIS:");
		
		if(BancoDados.listaComidas.isEmpty())
			System.out.println(">>Nenhuma comida cadastrada no momento!");
		else {
			for(int i=0; i<BancoDados.listaComidas.size(); i++) {
				System.out.println("-------\nNome: " + BancoDados.listaComidas.get(i).getNome() +
						   "\nValor: R$ " + BancoDados.listaComidas.get(i).getValor()+
						   "\nFrequ�ncia: " + BancoDados.listaComidas.get(i).getFrequencia());
			}
		}
		
		System.out.println("\n>>BEBIDAS DISPON�VEIS:");
		
		if(BancoDados.listaBebidas.isEmpty())
			System.out.println(">>Nenhuma bebida cadastrada no momento!");
		else {
			for(int i=0; i<BancoDados.listaBebidas.size(); i++) {
				System.out.println("-------\nNome: " + BancoDados.listaBebidas.get(i).getNome() +
						   "\nValor: R$ " + BancoDados.listaBebidas.get(i).getValor() +
						   "\nFrequ�ncia: " + BancoDados.listaBebidas.get(i).getFrequencia() );
			}
		}
	}
}
