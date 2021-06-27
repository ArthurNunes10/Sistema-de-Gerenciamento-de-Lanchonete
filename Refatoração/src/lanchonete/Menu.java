package lanchonete;

public final class Menu {
	Verificacao verificar = new Verificacao();
	Exception inputException = new Exception();
	
	public void menuPrincipal() {
		System.out.println("\n>>Bem vindos ao sistema de gerenciamento");
		System.out.println("Escolha uma das op��es abaixo:");
		System.out.println("(1) Sistema Administrador");
		System.out.println("(2) Sistema Funcion�rio");
		System.out.println("(0) Sair");
	}
	
	
	public void menuAdm() {
		verificar.menuAcessoAdm();
		System.out.println("\n## Modo Administrador ##");
		System.out.println("Selecione uma op��o abaixo:");
		System.out.println("(1) Adicionar Funcion�rio");
		System.out.println("(2) Remover Funcion�rio");
		System.out.println("(3) Alterar dados do funcion�rio");
		System.out.println("(4) Adicionar lanche ao card�pio");
		System.out.println("(5) Remover lanche do card�pio");
		System.out.println("(6) Alterar valor do lanche");
		System.out.println("(7) Hist�rico Geral");
		System.out.println("(8) Hist�rico do Cliente");
		System.out.println("(9) Listar Funcion�rios");
		System.out.println("(10) Exibir Card�pio");
		System.out.println("(11) Saldo de Caixa");
		System.out.println("(0) Voltar");
	}
	
	public void menuAdm(int a) {
		System.out.println("\n## Modo Administrador ##");
		System.out.println("Selecione uma op��o abaixo:");
		System.out.println("(1) Adicionar Funcion�rio");
		System.out.println("(2) Remover Funcion�rio");
		System.out.println("(3) Alterar dados do funcion�rio");
		System.out.println("(4) Adicionar lanche ao card�pio");
		System.out.println("(5) Remover lanche do card�pio");
		System.out.println("(6) Alterar valor do lanche");
		System.out.println("(7) Hist�rico Geral");
		System.out.println("(8) Hist�rico do Cliente");
		System.out.println("(9) Listar Funcion�rios");
		System.out.println("(10) Exibir Card�pio");
		System.out.println("(11) Saldo de Caixa");
		System.out.println("(0) Voltar");
	}

	public void menuFuncionario() {
		if(!(BancoDados.listaFuncionarios.isEmpty())){
			System.out.println("\n## Modo Funcion�rio ##");
			System.out.println("Selecione uma op��o abaixo:");
			System.out.println("(1) Cadastrar Pedido");
			System.out.println("(2) Exibir pedidos em aberto");
			System.out.println("(3) Concluir pedido");
			System.out.println("(4) Emitir Nota Fiscal");
			System.out.println("(5) Exibir Card�pio");
			System.out.println("(6) Cadastrar Cliente");
			System.out.println("(0) Voltar");
		}
		else {
			System.out.println("\n>>Nenhum funcion�rio cadastrado no sistema!\n");
		}
	}
	
	public  int menuAlteracaoDadosFuncionario() {
		System.out.println("\n(1) Alterar Sal�rio");
		System.out.println("(2) Alterar E-mail");
		System.out.println("(3) Alterar N�mero de Contato");
		int opcao = inputException.inputMenu(1,3);
		return opcao;
	}
	
	public  int menuAlteracaoValorLanche() {
		System.out.println("\n(1) Alterar valor da Comida");
		System.out.println("(2) Alterar valor da Bebida");
		int opcao = inputException.inputMenu(1,2);
		return opcao;
	}
	
	
	public int menuCadastroLanche(String tipo) {
		switch(tipo) {
		case "Adicionar":
			System.out.println("\n(1) Adicionar Comida");
			System.out.println("(2) Adicionar Bebida");
			break;
		case "Remover":
			System.out.println("\n(1) Remover Comida");
			System.out.println("(2) Remover Bebida");
			break;
		}
		int opcao = inputException.inputMenu(1,2);
		return opcao;
	}
	
	public static void cabecalho() {
		System.out.println("\n-------");
	}
	
	public static void rodape() {
		System.out.println("------\n");
	}
}
