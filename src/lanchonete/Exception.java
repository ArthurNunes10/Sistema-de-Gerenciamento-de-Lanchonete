package lanchonete;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.NumberFormatException;

public class Exception  {
	Scanner input = new Scanner(System.in);
	Verificacao verificador = new Verificacao();
	int z;
	float b;

//VERIFICACAO DE TIPO PARA INTEIROS (OPCAO)
	public int exceptionInteiroOp() {
		boolean continueLoop = true;
	
		do {
			try {
				System.out.print(">>Opção:");
				 z = Integer.parseInt(input.next());
				continueLoop = false;
			}catch(NumberFormatException e) {
				System.out.println(">>Formato de entrada inválida, por favor, digite apenas números inteiros:");
			}
		}while(continueLoop);
		continueLoop = true;
		return z;
	}
	
//VERIFICACAO DE TIPO PARA INTEIROS
	public int exceptionInteiro() {
		boolean continueLoop = true;
		do {
			try {
				 z = Integer.parseInt(input.next());
				continueLoop = false;
			}catch(NumberFormatException e) {
				System.out.println(">>Formato de entrada inválida, por favor, digite apenas números inteiros:");
			}
		}while(continueLoop);
		continueLoop = true;
		return z;
	}
	
//POLIMORFISMO DE SOBREPOSIÇÃO COM A CLASSE VERIRICAO
	public String procuraComida(ArrayList<Comida> lista, String nomeComida) {
	
		int flag=0;
		do {
			if(flag==1) {
				System.out.print(">>Digite novamente: ");
				nomeComida = input.nextLine();}
			flag=1;
		}while(verificador.procurarComida(lista, nomeComida)==-1);
		return nomeComida;
	}
	
//POLIMORFISMO DE SOBREPOSIÇÃO COM A CLASSE VERIRICAO
	public String procuraBebida(ArrayList<Bebida> lista, String nomeBebida) {
		
		int flag=0;
		do {
			if(flag==1) {
				System.out.print(">>Digite novamente: ");
				nomeBebida = input.nextLine();}
			flag=1;
		}while(verificador.procurarBebida(lista, nomeBebida)==-1);
		return nomeBebida;
	}
	
//POLIMORFISMO DE SOBREPOSIÇÃO COM A CLASSE VERIFIRICAO
		public String procuraFuncionario(ArrayList<Funcionario> lista, String nomeF) {
			
			int flag=0;
			do {
				if(flag==1) {
					System.out.print(">>Digite novamente: ");
					nomeF = input.nextLine();}
				flag=1;
			}while(verificador.procurarFuncionario(lista, nomeF)==-1);
			return nomeF;
		}
		
//VERIFICACAO DE TIPO PARA FLOAT
	public float exceptionFloat() {
		boolean continueLoop = true;
		do {
			try {
				 b = Float.parseFloat(input.next());
				continueLoop = false;
			}catch(NumberFormatException e) {
				System.out.println(">>Formato de entrada inválida, por favor, digite apenas números reais:");
			}
		}while(continueLoop);
		continueLoop = true;
		return b;	
	}
	
//VERIFICAÇÃO DO INTERVALO DAS OPÇÕES

	public boolean inputMenu(int opcao, int a, int b) {
		if((opcao>=a)&&(opcao<=b)) {
			return true;
		}
		System.out.println(">>Opção inválida, por favor, digite novamente:");
		return false;
	}
	
// VERIFICAÇÃO CONJUNTA USADA PARA OPCOES
	public int inputMenu(int a, int b) {
		int opcao;
		boolean continueLoop = true;
		opcao = this.exceptionInteiroOp();
		continueLoop = this.inputMenu(opcao, a, b);
		while(!continueLoop) {
			opcao = this.exceptionInteiroOp();
			continueLoop = this.inputMenu(opcao, a, b);
		}
		return opcao;
	}
}
