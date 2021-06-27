package lanchonete;

public class SistemaPrincipal {
	public static void main(String[] args) {
		
			Exception input = new Exception();
			int opcao;
			Menu exibir = new Menu();
			SeletorMenu abrir = new SeletorMenu();
			
			while(true) {
				//EXIBE O MENU PRINCIPAL
				exibir.menuPrincipal(); 
				//LER A OPCAO E CHECA ELA
				opcao = input.inputMenu(0,2);
				
				//ENCERRA O PROGRAMA
				if(opcao==0){
					break;
				}
				//DIRECIONAMENTO PARA O NOVO MENU OU ENCERRA O PROGRAMA
				abrir.seletorMenuPrincipal(opcao);
				
				//MODO ADM
				 if(opcao==1) {
					while(true) {
						opcao = input.inputMenu(0,11);
						if(opcao==0) {
							break;
						}
						abrir.seletorMenuAdm(opcao);
						exibir.menuAdm(1);
					}
				}
				//MODO FUNCIONARIO
				else if(opcao==2) {
					if(!(BancoDados.listaFuncionarios.isEmpty())){
						while(true) {
							opcao = input.inputMenu(0,6);
							if(opcao==0) {
								break;
							}
							abrir.seletorMenuFuncionario(opcao);
							exibir.menuFuncionario();
						}
					}
				}
			}
			System.out.println("Programa Encerrado....");
	}
}