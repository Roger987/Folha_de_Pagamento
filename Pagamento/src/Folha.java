import java.util.Scanner;

public class Folha{
	
	public static void main(String args[]){
		
		Scanner scanner = new Scanner(System.in);
		
		int input = -1, num = 0;
		
		String aux;
		
		System.out.println("Digite a opera��o desejada:\n\n1: Adi��o de empregado\n2:Remo��o de empregado\n3:Lan�ar um cart�o de ponto\n4: Lan�ar um resultado Venda\n5: Lan�ar uma taxa de servi�o\n6: Alterar detalhes de um emprego\n7: Rodar a folha de pagamento para hoje\n8: Undo/redo\n9: Agenda de pagamento\n10: Cria��o de novas agendas de pagamento:\n0: Encerrar o programa\n");

		
		java.util.ArrayList<Empregado> empregados = new java.util.ArrayList<Empregado>();
		
		
		while(input != 0) {
			
			input = scanner.nextInt();
			
			aux = scanner.nextLine();
			
			if(input == 0) {
				System.out.println("Programa encerrado");
				break;
			}
			
			switch(input)
			{
				case 1:
				    	Empregado empregado;
						empregado = new Empregado();
						
						System.out.println("\nNome:");
						empregado.nome = scanner.nextLine();
	
						System.out.println("Endere�o:");
						empregado.endereco = scanner.nextLine();
	
						System.out.println("Tipo:");
						empregado.tipo = scanner.nextLine();
	
						empregado.numero = num;
				
						empregados.add(empregado);
						
						System.out.println(empregado.nome + " adicionado! N�mero: " + num);
						num++;
				        
						break;
				    
				case 2:
			    		
						 System.out.println("\nDigite o n�mero do usu�rio que deseja remover:\n");
						 
						 int index = scanner.nextInt();
						 
						 String funcionario = empregados.get(index).nome;
						 empregados.remove(index);
						 System.out.println("\n" + funcionario + " removido do sistema.\n");
				         
						 break;
			    
			    case 3:
			    		 
			    		 System.out.println("\nDigite o n�mero do funcion�rio:\n");
			    		 
			    		 int index2;
			    		 float entrada, saida;
			    		 
			    		 index2 = scanner.nextInt();
			    		 String aux2 = scanner.nextLine();
			    		 
			    		 System.out.println("Ol� " + empregados.get(index2).nome + ", digite o hor�rio de entrada:\n");
			    		 entrada = scanner.nextFloat();
			    		 
			    		 System.out.println("\nDigite o hor�rio de sa�da:\n");
			    		 saida = scanner.nextFloat();
			    		 
			    		 empregados.get(index2).horas = saida - entrada;
			    		 
			          	 break;
			          	 
			    case 4:
				    	 System.out.println("\nDigite o n�mero do funcion�rio:\n");
				    	
				    	 int index3 = scanner.nextInt();
				    	
				    	 System.out.println("Informe o Resultado de venda:");
				    	
				    	 float venda = scanner.nextFloat();
				    	 empregados.get(index3).vendas = venda;
				    	
				    	 break;
			    	
			    case 5:
			    	
				    	 System.out.println("\nDigite o n�mero do funcion�rio:\n");
				    	
				    	 int index4 = scanner.nextInt();
				    	
				       	 System.out.println("Informe o valor da taxa:");
				    	
				    	 float taxa = scanner.nextFloat();
				    	 empregados.get(index4).taxas = taxa;
				    	
				    	 break;
			    	
			    case 6:
			    		 System.out.println("\nDigite o n�mero do funcion�rio:\n");
			    	
			    		 int index5 = scanner.nextInt();
			    	
			    
			    default:
			    	 	 System.out.println("D�gito inv�lido\n");
			            
			}
			System.out.println("\nDigite a opera��o desejada:\n\n1: Adi��o de empregado\n2:Remo��o de empregado\n3:Lan�ar um cart�o de ponto\n4: Lan�ar um resultado Venda\n5: Lan�ar uma taxa de servi�o\n6: Alterar detalhes de um emprego\n7: Rodar a folha de pagamento para hoje\n8: Undo/redo\n9: Agenda de pagamento\n10: Cria��o de novas agendas de pagamento:\n0: Encerrar o programa\n");
			
		}
		
		scanner.close();
		
	}
	
}