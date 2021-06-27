package lanchonete;
import java.util.ArrayList;
import java.util.Scanner;

public class Funcionario extends Pessoa {
	static Scanner input = new Scanner(System.in);
	private float  salario;
	private String nit;
	static Exception inputException = new Exception();
	static  ArrayList<Funcionario> listaFuncionarios = BancoDados.listaFuncionarios;
	
	//CONSTRUTORES
	public Funcionario(String nome, String cpf, String celular, String email, String endereco, float salario, String nit) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setCelular(celular);
		this.setEmail(email);
		this.setEndereco(endereco);
		this.setSalario(salario);
		this.setNit(nit);
	}
	public Funcionario() {}
	
	
	public static String lerNomeFuncionario() {
		System.out.print("\nDigite o nome do funcionário:");
		return input .nextLine();
		}
	
	public static String lerNomeFuncionario(ArrayList <Funcionario> listaFuncionario) {
		 return inputException.procuraFuncionario(listaFuncionario);
	}
	
	//MÉTODOS DE ALTERAÇÃO DE DADOS
	private void alterarSalario(int indiceFuncionario) {
		System.out.print("Digite o novo salário: R$");
		float salario = inputException.exceptionFloat();
		listaFuncionarios.get(indiceFuncionario).setSalario(salario);
		System.out.print(">>Salário alterado com sucesso!\n");
	}
	
	private  void alterarEmail(int indiceFuncionario) {
		System.out.print("Digite o novo E-mail: ");
		String email = input.nextLine();
		listaFuncionarios.get(indiceFuncionario).setEmail(email);
		System.out.print(">>E-mail alterado com sucesso!\n");
	}
	
	private  void alterarCelular(int indiceFuncionario) {
		System.out.print("Digite um número de contato: ");
		String celular = input.nextLine()	;
		listaFuncionarios.get(indiceFuncionario).setCelular(celular);
		System.out.print(">>Número alterado com sucesso!\n");
	}
	
	public  void alterarDados(int opcao) {
		int indiceFuncionario = getIndice();
		if(indiceFuncionario!= -1) {
			switch(opcao) {
			case 1:  
				alterarSalario(indiceFuncionario);
				break;
			case 2:
				alterarEmail(indiceFuncionario);
				break;
			case 3:
				alterarCelular(indiceFuncionario);
				break;
			}
		}	
	}

	//MÉTODOS DE EXIBIÇÃO DE DADOS
	public static void exibirNome(int indice) {
		System.out.println("Nome:"+ listaFuncionarios.get(indice).getNome());
	}
	
	public static void exibirEmail(int indice) {
		System.out.println("E-mail: " + listaFuncionarios.get(indice).getEmail());
	}
	
	public static void exibirNIT(int indice) {
		System.out.println("NIT: " + listaFuncionarios.get(indice).getNit());
	}

	public static void exibirCpf(int indice) {
		System.out.println("CPF: " + listaFuncionarios.get(indice).getCpf());
	}

	public static void exibirCelular(int indice) {
		System.out.println("Celular: " + listaFuncionarios.get(indice).getCelular());
	}

	public static void exibirSalario(int indice) {
		System.out.println("Salário:R$ " + listaFuncionarios.get(indice).getSalario());
	}
	
	//MÉTODOS GET E SETTERS
	public static int getIndice() {
		return Verificacao.procurarFuncionario(listaFuncionarios, lerNomeFuncionario()); 
	}
	
	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}
}
