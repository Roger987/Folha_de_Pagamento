import java.util.Scanner;

public class Folha{
	
	public static void main(String args[]){
		
		Scanner scanner = new Scanner(System.in);
		
		int input = -1, num = 0;
		
		String aux;
		
		System.out.println("Digite a operação desejada:\n\n1: Adição de empregado\n2:Remoção de empregado\n3:Lançar um cartão de ponto\n4: Lançar um resultado Venda\n5: Lançar uma taxa de serviço\n6: Alterar detalhes de um emprego\n7: Rodar a folha de pagamento para hoje\n8: Undo/redo\n9: Agenda de pagamento\n10: Criação de novas agendas de pagamento:\n0: Encerrar o programa\n");

		
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
	
						System.out.println("Endereço:");
						empregado.endereco = scanner.nextLine();
	
						System.out.println("Tipo:");
						empregado.tipo = scanner.nextLine();
	
						empregado.numero = num;
				
						empregados.add(empregado);
						
						System.out.println(empregado.nome + " adicionado! Número: " + num);
						num++;
				        
						break;
				    
				case 2:
			    		
						 System.out.println("\nDigite o número do usuário que deseja remover:\n");
						 
						 int index = scanner.nextInt();
						 
						 String funcionario = empregados.get(index).nome;
						 empregados.remove(index);
						 System.out.println("\n" + funcionario + " removido do sistema.\n");
				         
						 break;
			    
			    case 3:
			    		 
			    		 System.out.println("\nDigite o número do funcionário:\n");
			    		 
			    		 int index2;
			    		 float entrada, saida;
			    		 
			    		 index2 = scanner.nextInt();
			    		 String aux2 = scanner.nextLine();
			    		 
			    		 System.out.println("Olá " + empregados.get(index2).nome + ", digite o horário de entrada:\n");
			    		 entrada = scanner.nextFloat();
			    		 
			    		 System.out.println("\nDigite o horário de saída:\n");
			    		 saida = scanner.nextFloat();
			    		 
			    		 empregados.get(index2).horas = saida - entrada;
			    		 
			          	 break;
			          	 
			    case 4:
				    	 System.out.println("\nDigite o número do funcionário:\n");
				    	
				    	 int index3 = scanner.nextInt();
				    	
				    	 System.out.println("Informe o Resultado de venda:");
				    	
				    	 float venda = scanner.nextFloat();
				    	 empregados.get(index3).vendas = venda;
				    	
				    	 break;
			    	
			    case 5:
			    	
				    	 System.out.println("\nDigite o número do funcionário:\n");
				    	
				    	 int index4 = scanner.nextInt();
				    	
				       	 System.out.println("Informe o valor da taxa:");
				    	
				    	 float taxa = scanner.nextFloat();
				    	 empregados.get(index4).taxas = taxa;
				    	
				    	 break;
			    	
			    case 6:
			    		 System.out.println("\nDigite o número do funcionário:\n");
			    	
			    		 int index5 = scanner.nextInt();
			    	
			    
			    default:
			    	 	 System.out.println("Dígito inválido\n");
			            
			}
			System.out.println("\nDigite a operação desejada:\n\n1: Adição de empregado\n2:Remoção de empregado\n3:Lançar um cartão de ponto\n4: Lançar um resultado Venda\n5: Lançar uma taxa de serviço\n6: Alterar detalhes de um emprego\n7: Rodar a folha de pagamento para hoje\n8: Undo/redo\n9: Agenda de pagamento\n10: Criação de novas agendas de pagamento:\n0: Encerrar o programa\n");
			
		}
		
		scanner.close();
		
	}
	
}