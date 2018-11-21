import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

 class Empregado{
	public String nome;
	public String endereco;
	public String tipo;
	public int numero;
	
}


public class Folha{
	
	public static void main(String args[]){
		
		Scanner scanner = new Scanner(System.in);

		java.util.ArrayList<Empregado> empregados = new java.util.ArrayList<Empregado>();

		int num = 1;
		
		System.out.println("Adicionar empregado: digite 1");

		int input = scanner.nextInt();

		if(input == 1){

			Empregado empregado;
			empregado = new Empregado();
			
			System.out.println("Nome:");
			empregado.nome = scanner.nextLine();

			System.out.println("Endereço:");
			empregado.endereco = scanner.nextLine();

			System.out.println("Tipo:");
			empregado.tipo = scanner.nextLine();

			empregado.numero = num;
			
			num++;
			
			empregados.add(empregado);	

		}
	
		scanner.close();
		
	}
}