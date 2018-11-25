import java.util.Scanner;

public class Folha{
	
	public static void main(String args[]){
		
		Scanner scanner = new Scanner(System.in);
		
		int input = -1, num = 0, numsindicato = 0;
		
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
	
						System.out.println("Tipo:\n   1 - Horista\n   2 - Assalariado\n   3 - Comissionado");
						empregado.tipo = scanner.nextInt();
						
						if(empregado.tipo == 1) {
							System.out.println("Informe o salário por hora trabalhada:");
							empregado.salariofixo = scanner.nextFloat();
						}
						
						else if(empregado.tipo == 2) {
							System.out.println("Informe o salário mensal:");
							empregado.salariofixo = scanner.nextFloat();
						}
						
						else if(empregado.tipo == 3) {
							System.out.println("Informe o salário bi-semanal:");
							empregado.salariofixo = scanner.nextFloat();
							System.out.println("Informe o percentual da comissão:");
							empregado.comissao = scanner.nextFloat();
						}
	
						empregado.numero = num;
						
						System.out.println("Método de Pagamento:\n   1 - Cheque pelo correio\n   2 - Cheque em mãos\n   3 - Depósito em conta");
						empregado.metodopagamento = scanner.nextInt();
						
						System.out.println("Pertence ao sindicato?\n   0 - Não   1 - Sim");
						empregado.sindicato = scanner.nextInt();
						
						if(empregado.sindicato == 1) {
							empregado.numerosindicato = numsindicato;
							numsindicato++;
							System.out.println("Informe a taxa sindical:");
							empregado.taxasindical = scanner.nextFloat();
						}
				
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
			    		 float entrada, saida, diferencahoras;
			    		 
			    		 index2 = scanner.nextInt();
			    		 aux = scanner.nextLine();
			    		 
			    		 if(empregados.get(index2).tipo == 1) {
			    			 System.out.println("Digite o horário de entrada:\n");
				    		 entrada = scanner.nextFloat();
				    		 
				    		 System.out.println("\nDigite o horário de saída:\n");
				    		 saida = scanner.nextFloat();
				    		 
				    		 diferencahoras = saida - entrada;
				    		 
				    		 if(diferencahoras <= 8) {
				    			 empregados.get(index2).horas += diferencahoras;
				    		 }
				    		 else {
				    			 empregados.get(index2).horas += 8;
				    			 empregados.get(index2).horaextra += (diferencahoras - 8);
				    		 }
				    		 
	 
			    		 }
			    		 else {
			    			 System.out.println("O funcionário não é horista.");
			    		 }
			    		 
			          	 break;
			          	 
			    case 4:
				    	 System.out.println("\nDigite o número do funcionário:\n");
				    	
				    	 int index3 = scanner.nextInt();
				    	 
				    	 if(empregados.get(index3).tipo == 3) {
					    	 System.out.println("Informe o Resultado de venda:");
						    	
					    	 float venda = scanner.nextFloat();
					    	 empregados.get(index3).vendas += venda;
				    		 
				    	 }
				    	 
				    	 else {
				    		 System.out.println("O funcionário não é comissionado.");
				    	 }
				    	
				    	 break;
			    	
			    case 5:
			    	
				    	 System.out.println("\nDigite o número do funcionário:\n");
				    	
				    	 int index4 = scanner.nextInt();
				    	
				    	 if(empregados.get(index4).sindicato == 1) {
				    		 
				    		 System.out.println("Informe o valor da taxa de serviço:");
						    	
					    	 float taxa = scanner.nextFloat();
					    	 empregados.get(index4).taxaservico = taxa;
				    	 }
				    	 else {
				    		 System.out.println("O funcionário não faz parte do sindicato.");
				    	 }
				    	
				    	 break;
			    	
			    case 6:
			    		 System.out.println("\nDigite o número do funcionário:\n");
			    	
			    		 int index5 = scanner.nextInt();
			    		 
			    		 System.out.println("\nDigite a informação que deseja alterar:\n\n1: Nome\n2: Endereço\n3: Tipo\n4: Método de pagamento\n5: Pertencimento ao sindicato\n6: Identificação no sindicato\n7: Taxa sindical\n");
			    		 
			    		 int choice = scanner.nextInt();
			    		 aux = scanner.nextLine();
			    		 
			    		 if(choice == 1){
			    			 System.out.println("\nDigite o nome do funcionário:\n");
			    			 
			    			 String novonome = scanner.nextLine();
			    			 empregados.get(index5).nome = novonome;
			    			 
			    			 System.out.println("\nNome alterado com sucesso.\n");
			    		 }
			    		 
			    		 else if(choice == 2){
			    			 System.out.println("\nDigite o endereço do funcionário:\n");
			    			 
			    			 String novoend = scanner.nextLine();
			    			 empregados.get(index5).endereco = novoend;
			    			 
			    			 System.out.println("\nEndereço alterado com sucesso.\n");
			    		 }
			    		 
			    		 else if(choice == 3) {
			    			 System.out.println("\nDigite o tipo do funcionário:\n   1 - Horista\n   2 - Assalariado\n   3 - Comissionado");
			    			 
			    			 int novotipo = scanner.nextInt();
			    			 empregados.get(index5).tipo = novotipo;
			    			 
			    			 System.out.println("\nTipo alterado com sucesso.\n");
			    		 }
			    		 else if(choice == 4) {
			    			 System.out.println("Selecione o método de pagamento:\n   1 - Cheque pelo correio\n   2 - Cheque em mãos\n   3 - Depósito em conta");
			    			 
			    			 int novometodo = scanner.nextInt();
			    			 empregados.get(index5).metodopagamento = novometodo;
			    			 
			    			 System.out.println("\nMétodo de pagamento alterado com sucesso.\n");
			    		 }
			    		 else if(choice == 5) {
			    			 System.out.println("Pertence ao sindicato?\n   0 - Não\n   1 - Sim");
			    			 
			    			 int novosind = scanner.nextInt();
			    			 empregados.get(index5).sindicato = novosind;
			    			 
			    			 System.out.println("\nPertinência ao sindicato alterada com sucesso.\n");
			    		 }
			    		 else if(choice == 6) {
			    			 System.out.println("Digite sua nova identificação no sindicato:\n");
			    			 
			    			 int novoid = scanner.nextInt();
			    			 empregados.get(index5).numerosindicato = novoid;
			    			 
			    			 System.out.println("\nIdentificação no sindicato alterada com sucesso.\n");
			    		 }
			    		 else if(choice == 7) {
			    			 System.out.println("Digite a taxa sindical:\n");
			    			 
			    			 float novataxa = scanner.nextFloat();
			    			 empregados.get(index5).taxasindical = novataxa;
			    			 
			    			 System.out.println("Taxa sindical alterada com sucesso.\n");
			    		 }
			    		 else {
			    			 System.out.println("Operação inválida");
			    		 }
			    case 7:
			    		 System.out.println("Informe o dia, o mês e o ano, separados por uma quebra de linha:");
			    		 
			    		 int i;
			    		 int dia = scanner.nextInt();
			    		 int mes = scanner.nextInt();
			    		 int ano = scanner.nextInt();
			    		 aux = scanner.nextLine();
			    		 
			    		 System.out.println("Informe o dia da semana:");
			    		 
			    		 String diasemana = scanner.nextLine();
			    		 
			    		 System.out.println("Data:" + dia + "/" + mes + "/" + ano + ", " + diasemana);
			    		 System.out.println("-------------------------------------------------------------------------------\n");
			    		 
			    		 for(i = 0; i < num; i++) {
			    			 
			    			 if((empregados.get(i).tipo == 1)&&(diasemana.charAt(2) == 'x')) {
			    				 System.out.println("Nome: " + empregados.get(i).nome + "          Endereço:" + empregados.get(i).endereco);
			    				 System.out.println("Tipo: Horista          Método de pagamento: " + empregados.get(i).metodopagamento);
			    				 if(empregados.get(i).sindicato == 1) {
			    					 System.out.println("Identificação no sindicato: " + empregados.get(i).numerosindicato + "          Total de taxas do sindicato: " + (empregados.get(i).taxasindical + empregados.get(i).taxaservico) + "%");
			    				 }
			    				 double salario = (empregados.get(i).horas * empregados.get(i).salariofixo) + (empregados.get(i).horaextra * 1.5 * empregados.get(i).salariofixo);
			    				 salario = salario - (salario * ((empregados.get(i).taxasindical + empregados.get(i).taxaservico)/100));
			    				 System.out.println("Valor do salário: " + salario);
			    				 System.out.println("\n-------------------------------------------------------------------------------\n");
			    			 }
			    			 
			    			 else if((empregados.get(i).tipo == 2)) {
			    				 System.out.println("Nome: " + empregados.get(i).nome + "          Endereço:" + empregados.get(i).endereco);
			    				 System.out.println("Tipo: Assalariado          Método de pagamento: " + empregados.get(i).metodopagamento);
			    				 if(empregados.get(i).sindicato == 1) {
			    					 System.out.println("Identificação no sindicato: " + empregados.get(i).numerosindicato + "          Total de taxas do sindicato: " + (empregados.get(i).taxasindical + empregados.get(i).taxaservico) + "%");
			    				 }
			    				 double salario = empregados.get(i).salariofixo;
			    				 salario = salario - (salario * ((empregados.get(i).taxasindical + empregados.get(i).taxaservico)/100));
			    				 System.out.println("Valor do salário: " + salario);
			    				 System.out.println("\n-------------------------------------------------------------------------------\n");
			    			 }
			    			 
			    			 else if((empregados.get(i).tipo == 3)) {
			    				 System.out.println("Nome: " + empregados.get(i).nome + "          Endereço:" + empregados.get(i).endereco);
			    				 System.out.println("Tipo: Assalariado          Método de pagamento: " + empregados.get(i).metodopagamento);
			    				 if(empregados.get(i).sindicato == 1) {
			    					 System.out.println("Identificação no sindicato: " + empregados.get(i).numerosindicato + "          Total de taxas do sindicato: " + (empregados.get(i).taxasindical + empregados.get(i).taxaservico) + "%");
			    				 }
			    				 double salario = empregados.get(i).salariofixo + (empregados.get(i).vendas * (empregados.get(i).comissao)/100);
			    				 salario = salario - (salario * ((empregados.get(i).taxasindical + empregados.get(i).taxaservico)/100));
			    				 System.out.println("Valor do salário: " + salario);
			    				 System.out.println("\n-------------------------------------------------------------------------------\n");
			    			 }
			    			 
			    			 
			    		 }
			    
			    	
			            
			}
			System.out.println("\nDigite a operação desejada:\n\n1: Adição de empregado\n2:Remoção de empregado\n3:Lançar um cartão de ponto\n4: Lançar um resultado Venda\n5: Lançar uma taxa de serviço\n6: Alterar detalhes de um emprego\n7: Rodar a folha de pagamento para hoje\n8: Undo/redo\n9: Agenda de pagamento\n10: Criação de novas agendas de pagamento:\n0: Encerrar o programa\n");
			
		}
		
		scanner.close();
		
	}
	
}