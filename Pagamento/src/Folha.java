import java.util.Scanner;
import java.util.Calendar;
import java.util.*; 

public class Folha{
	
	public static void main(String args[]){
		
		Scanner scanner = new Scanner(System.in);
		
		int input = -1, num = 0, numsindicato = 0, flag = 0, dia = Calendar.getInstance().get(Calendar.DAY_OF_MONTH), mes = Calendar.getInstance().get(Calendar.MONTH) + 1, ano = Calendar.getInstance().get(Calendar.YEAR);
		int diasemana = Calendar.getInstance().get(Calendar.DAY_OF_WEEK), op = 0;
		
		String aux;
		
		System.out.println("Digite a opera��o desejada:\n\n1: Adi��o de empregado\n2: Remo��o de empregado\n3: Lan�ar um cart�o de ponto\n4: Lan�ar um resultado Venda\n5: Lan�ar uma taxa de servi�o\n6: Alterar detalhes de um emprego\n7: Rodar a folha de pagamento para hoje\n8: Undo/redo\n9: Agenda de pagamento\n10: Cria��o de novas agendas de pagamento:\n0: Encerrar o programa\n");

		
		java.util.ArrayList<Empregado> empregados = new java.util.ArrayList<Empregado>();
		java.util.ArrayList<Empregado> empregadoscopia = new java.util.ArrayList<Empregado>();
		Stack<ArrayList<Empregado>> undo = new Stack<ArrayList<Empregado>>();
		Stack<ArrayList<Empregado>> redo = new Stack<ArrayList<Empregado>>();
		
		
		while(input != 0) {
			
			
			input = scanner.nextInt();
			
			aux = scanner.nextLine();
			
			if(input < 8 && input > 0) {
				int j;
				Empregado empregadocopia;
				empregadocopia = new Empregado();
				if(op > 0) {
					for(j = 0; j < num; j++) {
						empregadocopia.nome = empregados.get(j).nome;
						empregadocopia.endereco = empregados.get(j).endereco;
						empregadocopia.tipo = empregados.get(j).tipo;
						empregadocopia.metodopagamento = empregados.get(j).metodopagamento;
						empregadocopia.sindicato = empregados.get(j).sindicato;
						empregadocopia.numerosindicato = empregados.get(j).numerosindicato;
						empregadocopia.numero = empregados.get(j).numero;
						empregadocopia.salariofixo = empregados.get(j).salariofixo;
						empregadocopia.comissao = empregados.get(j).comissao;
						empregadocopia.horas = empregados.get(j).horas;
						empregadocopia.horaextra = empregados.get(j).horaextra;
						empregadocopia.vendas = empregados.get(j).vendas;
						empregadocopia.taxaservico = empregados.get(j).taxaservico;
						empregadocopia.taxasindical = empregados.get(j).taxasindical;
						empregadocopia.agendanovatipo = empregados.get(j).agendanovatipo;
						
						empregadoscopia.add(empregadocopia);
					}
					undo.push(empregadoscopia);
				}
				op++;
			}
			
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
	
						System.out.println("Tipo:\n   1 - Horista\n   2 - Assalariado\n   3 - Comissionado");
						empregado.tipo = scanner.nextInt();
						
						if(empregado.tipo == 1) {
							System.out.println("Informe o sal�rio por hora trabalhada:");
							empregado.salariofixo = scanner.nextFloat();
						}
						
						else if(empregado.tipo == 2) {
							System.out.println("Informe o sal�rio mensal:");
							empregado.salariofixo = scanner.nextFloat();
						}
						
						else if(empregado.tipo == 3) {
							System.out.println("Informe o sal�rio bi-semanal:");
							empregado.salariofixo = scanner.nextFloat();
							System.out.println("Informe o percentual da comiss�o:");
							empregado.comissao = scanner.nextFloat();
						}
	
						empregado.numero = num;
						
						System.out.println("M�todo de Pagamento:\n   1 - Cheque pelo correio\n   2 - Cheque em m�os\n   3 - Dep�sito em conta");
						empregado.metodopagamento = scanner.nextInt();
						
						System.out.println("Pertence ao sindicato?\n   0 - N�o   1 - Sim");
						empregado.sindicato = scanner.nextInt();
						
						if(empregado.sindicato == 1) {
							empregado.numerosindicato = numsindicato;
							numsindicato++;
							System.out.println("Informe a taxa sindical:");
							empregado.taxasindical = scanner.nextFloat();
						}
				
						empregados.add(empregado);
						
						System.out.println(empregado.nome + " adicionado! N�mero: " + num);
						num++;
				        
						break;
				    
				case 2:
			    		
						 System.out.println("\nDigite o n�mero do usu�rio que deseja remover:\n");
						 
						 int index = scanner.nextInt();
						 
						 String funcionario = empregados.get(index).nome;
						 empregados.remove(index);
						 num--;
						 System.out.println("\n" + funcionario + " removido do sistema.\n");
				         
						 break;
			    
			    case 3:
			    		 
			    		 System.out.println("\nDigite o n�mero do funcion�rio:\n");
			    		 
			    		 int index2;
			    		 float entradahora, entradamin, saidahora, saidamin, diferencahoras;
			    		 
			    		 index2 = scanner.nextInt();
			    		 aux = scanner.nextLine();
			    		 
			    		 if(empregados.get(index2).tipo == 1) {
			    			 System.out.println("Digite a hora e os minutos de entrada separados por uma quebra de linha:\n");
				    		 entradahora = scanner.nextFloat();
				    		 entradamin = scanner.nextFloat();
				    		 
				    		 System.out.println("\nDigite a hora e os minutos de sa�da separados por uma quebra de linha:\n");
				    		 saidahora = scanner.nextFloat();
				    		 saidamin = scanner.nextFloat();
				    		 
				    		 if(saidahora > entradahora) {
				    			 diferencahoras = ((saidahora - entradahora) + ((1/60)*saidamin - (1/60)*entradamin));
					    		 
					    		 if(diferencahoras <= 8) {
					    			 empregados.get(index2).horas += diferencahoras;
					    		 }
					    		 else {
					    			 empregados.get(index2).horas += 8;
					    			 empregados.get(index2).horaextra += (diferencahoras - 8);
					    		 }
					    		 System.out.println("CART�O DE PONTO\n-------------------------------------------\n");
					    		 System.out.println(empregados.get(index2).nome + "\nEntrada: " + (int) entradahora + ":" + (int) entradamin + "\nSa�da: " + (int) saidahora + ":" + (int) saidamin + "\nTotal de horas: " + diferencahoras + "h");
					    		 
				    			 
				    		 }
				    		 else {
				    			 System.out.println("Hor�rios inv�lidos.");
				    		 }
	 
			    		 }
			    		 else {
			    			 System.out.println("O funcion�rio n�o � horista.");
			    		 }
			    		 
			          	 break;
			          	 
			    case 4:
				    	 System.out.println("\nDigite o n�mero do funcion�rio:\n");
				    	
				    	 int index3 = scanner.nextInt();
				    	 
				    	 if(empregados.get(index3).tipo == 3) {
					    	 System.out.println("Informe o Resultado de venda:");
						    	
					    	 float venda = scanner.nextFloat();
					    	 empregados.get(index3).vendas += venda;
					    	 
					    	 System.out.println("RESULTADO DE VENDA:\n----------------------------------------\nFuncion�rio: " + empregados.get(index3).nome + "\nResultado: $" + venda);
				    		 
				    	 }
				    	 
				    	 else {
				    		 System.out.println("O funcion�rio n�o � comissionado.");
				    	 }
				    	
				    	 break;
			    	
			    case 5:
			    	
				    	 System.out.println("\nDigite o n�mero do funcion�rio:\n");
				    	
				    	 int index4 = scanner.nextInt();
				    	
				    	 if(empregados.get(index4).sindicato == 1) {
				    		 
				    		 System.out.println("Informe o valor da taxa de servi�o:");
						    	
					    	 float taxa = scanner.nextFloat();
					    	 empregados.get(index4).taxaservico = taxa;
					    	 
					    	 System.out.println("Taxa de servi�o adicionada.");
				    	 }
				    	 else {
				    		 System.out.println("O funcion�rio n�o faz parte do sindicato.");
				    	 }
				    	
				    	 break;
			    	
			    case 6:
			    		 System.out.println("\nDigite o n�mero do funcion�rio:\n");
			    	
			    		 int index5 = scanner.nextInt();
			    		 
			    		 System.out.println("\nDigite a informa��o que deseja alterar:\n\n1: Nome\n2: Endere�o\n3: Tipo\n4: M�todo de pagamento\n5: Pertencimento ao sindicato\n6: Identifica��o no sindicato\n7: Taxa sindical\n");
			    		 
			    		 int choice = scanner.nextInt();
			    		 aux = scanner.nextLine();
			    		 
			    		 if(choice == 1){
			    			 System.out.println("\nDigite o nome do funcion�rio:\n");
			    			 
			    			 String novonome = scanner.nextLine();
			    			 empregados.get(index5).nome = novonome;
			    			 
			    			 System.out.println("\nNome alterado com sucesso.\n");
			    		 }
			    		 
			    		 else if(choice == 2){
			    			 System.out.println("\nDigite o endere�o do funcion�rio:\n");
			    			 
			    			 String novoend = scanner.nextLine();
			    			 empregados.get(index5).endereco = novoend;
			    			 
			    			 System.out.println("\nEndere�o alterado com sucesso.\n");
			    		 }
			    		 
			    		 else if(choice == 3) {
			    			 System.out.println("\nDigite o tipo do funcion�rio:\n   1 - Horista\n   2 - Assalariado\n   3 - Comissionado");
			    			 
			    			 int novotipo = scanner.nextInt();
			    			 empregados.get(index5).tipo = novotipo;
			    			 
			    			 if(novotipo == 1) {
									System.out.println("Informe o sal�rio por hora trabalhada:");
									empregados.get(index5).salariofixo = scanner.nextFloat();
							 }
								
							 else if(novotipo == 2) {
									System.out.println("Informe o sal�rio mensal:");
									empregados.get(index5).salariofixo = scanner.nextFloat();
							 }
								
							 else if(novotipo == 3) {
									System.out.println("Informe o sal�rio bi-semanal:");
									empregados.get(index5).salariofixo = scanner.nextFloat();
									System.out.println("Informe o percentual da comiss�o:");
									empregados.get(index5).comissao = scanner.nextFloat();
							 }			    			 
			    			 System.out.println("\nTipo alterado com sucesso.\n");
			    		 }
			    		 else if(choice == 4) {
			    			 System.out.println("Selecione o m�todo de pagamento:\n   1 - Cheque pelo correio\n   2 - Cheque em m�os\n   3 - Dep�sito em conta");
			    			 
			    			 int novometodo = scanner.nextInt();
			    			 empregados.get(index5).metodopagamento = novometodo;
			    			 
			    			 System.out.println("\nM�todo de pagamento alterado com sucesso.\n");
			    		 }
			    		 else if(choice == 5) {
			    			 System.out.println("Pertence ao sindicato?\n   0 - N�o\n   1 - Sim");
			    			 
			    			 int novosind = scanner.nextInt();
			    			 empregados.get(index5).sindicato = novosind;
			    			 
			    			 System.out.println("\nPertin�ncia ao sindicato alterada com sucesso.\n");
			    		 }
			    		 else if(choice == 6) {
			    			 System.out.println("Digite sua nova identifica��o no sindicato:\n");
			    			 
			    			 int novoid = scanner.nextInt();
			    			 if(novoid <= num) {
			    				 System.out.println("N�mero inv�lido.\nTente novamente.");
			    			 }
			    			 else {
			    				 empregados.get(index5).numerosindicato = novoid;
				    			 
				    			 System.out.println("\nIdentifica��o no sindicato alterada com sucesso.\n");
			    			 }
			    			
			    		 }
			    		 else if(choice == 7) {
			    			 System.out.println("Digite a taxa sindical:\n");
			    			 
			    			 float novataxa = scanner.nextFloat();
			    			 empregados.get(index5).taxasindical = novataxa;
			    			 
			    			 System.out.println("Taxa sindical alterada com sucesso.\n");
			    		 }
			    		 else {
			    			 System.out.println("Opera��o inv�lida");
			    		 }
			    		 
			    		 break;
			    case 7:
			    		 
			    		 int i;
			    		 
			    		 System.out.println("Data: " + dia + "/" + mes + "/" + ano);
			    		 System.out.println("-------------------------------------------------------------------------------\n");
			    		 
			    		 for(i = 0; i < num; i++) {
			    			 
			    			 if((empregados.get(i).tipo == 1)&&(diasemana == 6)) {
			    				 System.out.println("Nome: " + empregados.get(i).nome + "          Endere�o: " + empregados.get(i).endereco);
			    				 System.out.print("Tipo: Horista          M�todo de pagamento: ");
			    				 if(empregados.get(i).metodopagamento == 1) {
			    					 System.out.println("Cheque pelo correio.");
			    				 }
			    				 else if(empregados.get(i).metodopagamento == 2) {
			    					 System.out.println("Cheque em m�os.");
			    				 }
			    				 else if(empregados.get(i).metodopagamento == 3) {
			    					 System.out.println("D�bito em conta.");
			    				 }
			    				 if(empregados.get(i).sindicato == 1) {
			    					 System.out.println("Identifica��o no sindicato: " + empregados.get(i).numerosindicato + "          Total de taxas do sindicato: " + (empregados.get(i).taxasindical + empregados.get(i).taxaservico) + "%");
			    				 }
			    				 double salario = (empregados.get(i).horas * empregados.get(i).salariofixo) + (empregados.get(i).horaextra * 1.5 * empregados.get(i).salariofixo);
			    				 salario = salario - (salario * ((empregados.get(i).taxasindical + empregados.get(i).taxaservico)/100));
			    				 System.out.println("Valor do sal�rio: " + salario);
			    				 System.out.println("\n-------------------------------------------------------------------------------\n");
			    			 }
			    			 
			    			 else if((empregados.get(i).tipo == 2)&&(dia == 30)&&(diasemana != 1)&&(diasemana != 7)) {
			    				 System.out.println("Nome: " + empregados.get(i).nome + "          Endere�o: " + empregados.get(i).endereco);
			    				 System.out.print("Tipo: Assalariado          M�todo de pagamento: ");
			    				 if(empregados.get(i).metodopagamento == 1) {
			    					 System.out.println("Cheque pelo correio.");
			    				 }
			    				 else if(empregados.get(i).metodopagamento == 2) {
			    					 System.out.println("Cheque em m�os.");
			    				 }
			    				 else if(empregados.get(i).metodopagamento == 3) {
			    					 System.out.println("D�bito em conta.");
			    				 }
			    				 if(empregados.get(i).sindicato == 1) {
			    					 System.out.println("Identifica��o no sindicato: " + empregados.get(i).numerosindicato + "          Total de taxas do sindicato: " + (empregados.get(i).taxasindical + empregados.get(i).taxaservico) + "%");
			    				 }
			    				 double salario = empregados.get(i).salariofixo;
			    				 salario = salario - (salario * ((empregados.get(i).taxasindical + empregados.get(i).taxaservico)/100));
			    				 System.out.println("Valor do sal�rio: " + salario);
			    				 System.out.println("\n-------------------------------------------------------------------------------\n");
			    			 }
			    			 
			    			 else if((empregados.get(i).tipo == 3)&&(diasemana == 6)&&((flag%2 == 0)||(flag == 0))) {
			    				 System.out.println("Nome: " + empregados.get(i).nome + "          Endere�o: " + empregados.get(i).endereco);
			    				 System.out.print("Tipo: Comissionado          M�todo de pagamento: ");
			    				 if(empregados.get(i).metodopagamento == 1) {
			    					 System.out.println("Cheque pelo correio.");
			    				 }
			    				 else if(empregados.get(i).metodopagamento == 2) {
			    					 System.out.println("Cheque em m�os.");
			    				 }
			    				 else if(empregados.get(i).metodopagamento == 3) {
			    					 System.out.println("D�bito em conta.");
			    				 }			    				 if(empregados.get(i).sindicato == 1) {
			    					 System.out.println("Identifica��o no sindicato: " + empregados.get(i).numerosindicato + "          Total de taxas do sindicato: " + (empregados.get(i).taxasindical + empregados.get(i).taxaservico) + "%");
			    				 }
			    				 double salario = empregados.get(i).salariofixo + (empregados.get(i).vendas * (empregados.get(i).comissao)/100);
			    				 salario = salario - (salario * ((empregados.get(i).taxasindical + empregados.get(i).taxaservico)/100));
			    				 System.out.println("Valor do sal�rio: " + salario);
			    				 System.out.println("\n-------------------------------------------------------------------------------\n");
			    			 }
			    				 
			    		 }
		    			 dia++;
		    			 diasemana++;
		    			 if((dia == 31)&&(mes == 12)) {
		    				 ano++;
		    				 mes = 1;
		    				 dia = 1;
		    			 }
		    			 if(dia == 31 && mes != 12) {
		    				 dia = 1;
		    				 mes++;
		    			 }
		    			 if(diasemana == 8) {
		    				 diasemana = 1;
		    			 }
		    			 else if(diasemana == 6) {
		    				 flag++;
		    			 }
		    			 break;
			    
			    case 8:
			    	System.out.println("Digite a opera��o desejada:\n 1 - undo\n 2 - redo\n");
			    	int y = scanner.nextInt();
			    	if(op > 0) {
				    	if(y == 1) {
				    		redo.push(empregados);
				    		empregados = undo.pop();
				    		System.out.println("Sucesso!");
				    	}
				    	else if(y == 2) {
				    		undo.push(empregados);
				    		empregados = redo.pop();
				    		System.out.println("Sucesso!");
				    	}
			    	}
			    	break;
					
			    	
			    case 9:
			    	System.out.println("AGENDA DE PAGAMENTO:");
			    	System.out.println("\n-------------------------------------------------------------------------------\n");
			    	System.out.println("Empregados pagos semanalmente:\n");
			    	for(i = 0; i < num; i++){
			    		if((empregados.get(i).tipo == 1)||(empregados.get(i).tipo == 4 && empregados.get(i).agendanovatipo == 2)) {
			    			System.out.println("   - " + empregados.get(i).nome);
			    		}
			    		
			    	}
			    	System.out.println("\n-------------------------------------------------------------------------------\n");
			    	System.out.println("Empregados pagos bi-semanalmente:\n");
			    	for(i = 0; i < num; i++){
			    		if(empregados.get(i).tipo == 3) {
			    			System.out.println("   - " + empregados.get(i).nome);
			    		}
			    		
			    	}
			    	System.out.println("\n-------------------------------------------------------------------------------\n");
			    	System.out.println("Empregados pagos mensalmente:\n");
			    	for(i = 0; i < num; i++){
			    		if(empregados.get(i).tipo == 2||(empregados.get(i).tipo == 4 && empregados.get(i).agendanovatipo == 1)) {
			    			System.out.println("   - " + empregados.get(i).nome);
			    		}
			    		
			    	}
			    	break;
			    case 10:
			    	System.out.println("Informe o n�mero do funcion�rio:");
			    	int input10 = scanner.nextInt();
			    	aux = scanner.nextLine();
			    	
			    	System.out.println("Digite a frequ�ncia de pagamento, Mensal ou Semanal, caso seja mensal, digite o dia no qual deseja ser pago, caso seja semanal, informe o intervalo de semanas no qual deseja ser pago e o dia da semana no qual deseja ser pago.\nConsidere o �ltimo dia �til do m�s como $.");
			    	String agendanova = scanner.nextLine();
			    	
			    	if(agendanova.charAt(2) == 'n') {
			    		
			    		empregados.get(input10).agendanovatipo = 1;
			    		empregados.get(input10).tipo = 4;
			    		
			    		
			    		System.out.println("Nova agenda: " + agendanova);
			    	}
			    	else if(agendanova.charAt(2) == 'm') {
			    		empregados.get(input10).agendanovatipo = 2;
			    		empregados.get(input10).tipo = 4;
			    		
			    		System.out.println("Nova agenda: " + agendanova);
			    	}
			    	break;
			    	
			}
			System.out.println("\nDigite a opera��o desejada:\n\n1: Adi��o de empregado\n2: Remo��o de empregado\n3: Lan�ar um cart�o de ponto\n4: Lan�ar um resultado Venda\n5: Lan�ar uma taxa de servi�o\n6: Alterar detalhes de um emprego\n7: Rodar a folha de pagamento para hoje\n8: Undo/redo\n9: Agenda de pagamento\n10: Cria��o de novas agendas de pagamento:\n0: Encerrar o programa\n");
			
		}
		
		scanner.close();
		
	}
	
}
