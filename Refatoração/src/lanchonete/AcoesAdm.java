package lanchonete;
import java.util.Scanner;
import java.util.ArrayList;

public class AcoesAdm {
	Scanner input = new Scanner(System.in);
	Exception inputException = new Exception();
	Verificacao verificador = new Verificacao();
	Cadastro cadastro = new Cadastro();
	ArrayList<Funcionario> listaFuncionarios = BancoDados.listaFuncionarios;
	ArrayList<Pedido> historicoPedido= Historico.listaPedidoGeral;
	ArrayList<Cliente> listaCliente = BancoDados.listaClientes;
	static 	ArrayList<Comida> listaComidas= BancoDados.listaComidas;
	static	ArrayList<Bebida> listaBebidas= BancoDados.listaBebidas;
	
	Menu exibir = new Menu();
	Funcionario funcionario = new Funcionario();
	
	public void addFuncionario() {
		Funcionario funcionario = cadastro.cadastrarFuncionario();
		BancoDados.adicionarFuncionarios(funcionario);
	}
	
	public void removeFuncionario() {
		if(!BancoDados.listaFuncionarioIsEmpty()) {
			BancoDados.removerFuncionarios();
			BancoDados.totalFuncionarios();
		}
	}
	
	public void alterarDadosFuncionario() {
		if(!BancoDados.listaFuncionarioIsEmpty()) {
			int opcao = exibir.menuAlteracaoDadosFuncionario();
			funcionario.alterarDados(opcao);
		}
	}
	
	public void addLanche() {
		int opcao = exibir.menuCadastroLanche("Adicionar");
		cadastro.cadastrarLanche(opcao);
	}
	
	public void removeLanche() {
		int opcao = exibir.menuCadastroLanche("Remover");
		BancoDados.removerLanche(opcao);
	}
	
	public void alterarValorLanche() {
		int opcao = exibir.menuAlteracaoValorLanche();
		cadastro.alterarValorLanche(opcao);
	}
	
	public void historicoGeral() {
		if(Historico.listaPedidoGeral.isEmpty())
			System.out.println("\n>>Nenhum pedido realizado!\n");
		Historico.listarHistorico(historicoPedido);
	}
	
	public void historicoCliente() {
		if(listaCliente.isEmpty()) {
			System.out.println("\n>>Nenhum cliente cadastrado no momento.\n");
		}
		else {
			String cpf = Cliente.lerCpf();
			int indiceCliente = Verificacao.procurarCliente(listaCliente, cpf);
			if(indiceCliente != -1) {
				listaCliente.get(indiceCliente).historicoPedidos.exibirHistoricoCliente(cpf);
				verificador.verificarListaCliente(cpf);
			}
		}
	}
	
	public void listarFuncionarios() {
		if(!BancoDados.listaFuncionarioIsEmpty()) {
			for(int i=0; i<listaFuncionarios.size(); i++) {
				ExibirDados.exibirDadosFuncionarios(i);
			}	
			BancoDados.totalFuncionarios();
		}
	}
	
	public void caixaCorrente() {
		System.out.println("\n>>O caixa atual possui um saldo de R$"+BancoDados.getSaldo()+"\n");	
	}
	
	public void exibirCardapio() {
		ExibirDados.exibirCardapio();
	}
}
