package lanchonete;

public class SeletorMenu {
	AcoesAdm adm = new AcoesAdm();
	AcoesFuncionario acaoFuncionario = new AcoesFuncionario();
	Menu exibir = new Menu();
	
	public void seletorMenuPrincipal(int opcao) {
		if(opcao == 1) exibir.menuAdm();
		else if (opcao == 2) {
			exibir.menuFuncionario();
		}
		else System.out.printf("O programa foi encerrado!");
	}
	
	public void seletorMenuAdm(int opcao) {
		if(opcao == 1) this.adm.addFuncionario();
		else if(opcao == 2) this.adm.removeFuncionario();
		else if(opcao == 3) this.adm.alterarDadosFuncionario();
		else if(opcao == 4) this.adm.addLanche();
		else if(opcao == 5) this.adm.removeLanche();
		else if(opcao == 6) this.adm.valorLanche();
		else if(opcao == 7) this.adm.historicoGeral();
		else if(opcao == 8) this.adm.historicoCliente();
		else if(opcao == 9) this.adm.listarFuncionarios();
		else if(opcao == 10) this.adm.exibirCardapio();
		else if(opcao == 11) this.adm.caixaCorrente();
		else if(opcao == 0) this.exibir.menuPrincipal();
	}

	public void seletorMenuFuncionario(int opcao) {
		if(opcao == 1) this.acaoFuncionario.cadastrarPedido();
		else if(opcao == 2) this.acaoFuncionario.pedidosAbertos();
		else if(opcao == 3) this.acaoFuncionario.concluirPedido();
		else if(opcao == 4) this.acaoFuncionario.notaFiscal();
		else if(opcao == 5) this.acaoFuncionario.exibirCardapio();
		else if(opcao == 6) this.acaoFuncionario.cadastrarCliente();
		else if(opcao == 0) this.exibir.menuPrincipal();
	}
}
