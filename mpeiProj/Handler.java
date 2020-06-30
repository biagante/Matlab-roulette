package mpeiProj;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Handler {
	database bank;
	Scanner in = new Scanner(System.in);
	private static final String filepath="src\\mpeiProj\\save.txt";
	
	public Handler() throws IOException {
		bank = new database();
		lerFich();
				
	}
	
	public void lerFich() throws IOException {
		File in = new File(filepath);
		Scanner input = new Scanner(in);
		
		while(input.hasNextLine()) {
			String[] dados = input.nextLine().split("\t");
			String[] data = dados[2].split("-");
			Criminal c = new Criminal(dados[0],
					         Integer.parseInt(dados[1]), 
					         new Data(Integer.parseInt(data[0].trim()),Integer.parseInt(data[1].trim()),Integer.parseInt(data[2].trim())),
					         Integer.parseInt(dados[3]), 
					         Integer.parseInt(dados[4]), 
					         Boolean.parseBoolean(dados[5]),
					         Boolean.parseBoolean(dados[6]));
			for(int i = 7; i < dados.length;i++) {
				String[] d = dados[i].split(":");
				String[] dC = d[1].split("-");
				c.addCrime(new Crime(d[0], 
						   new Data(Integer.parseInt(dC[0].trim()),Integer.parseInt(dC[1].trim()),Integer.parseInt(dC[2].trim()))));
			}
			
			bank.addCriminal(c);
			
			
		}
		input.close();
		
	
	}
	
	public void save() throws IOException{
		File out = new File(filepath);
		PrintWriter output = new PrintWriter(out);
        for(Criminal c : bank.db()) {
        	StringBuilder s = new StringBuilder();
        	for(Crime e: c.record()) {
        		s.append(String.format("\t%s:%s",e.type(),e.dC().toString()));
        	}
        	
        	output.print(String.format("%s\t%d\t%s\t%d\t%d\t%b\t%b%s\n",
        			                   c.name(),c.age(),c.birthday().toString(),c.weight(),c.height(),!(c.dead()),!(c.encarcerated()), s.toString()));
        }
        output.close();
	
	}
	
	public void encontrarCriminosoAtr(int n) {
		System.out.print( String.format("\n\nCriminosos com Atributos Semelhates a %s %d\n"
				                      + "%s",bank.db().get(n-1).name(),bank.db().get(n-1).id(),list2String(bank.findSimilarAtr(bank.db().get(n-1))) ));
	}
	
	private String  list2String(List<Criminal> c) {
		StringBuilder s = new StringBuilder();
		for(Criminal e : c) {
			s.append(String.format("||Nome: %s | ID:%d\n", e.name(), e.id()));
		}
		
		return s.toString();
		
	}

	public void encontrarCriminosoCr(int n) {
		System.out.print( String.format("\n\nCriminosos com Crimes Semelhantes a %s %d\n"
                + "%s",bank.db().get(n-1).name(),bank.db().get(n-1).id(),list2String(bank.findSimilarCr(bank.db().get(n-1))) ));
	}
	
	public void searchByName(String s) {
		String[] tmp = s.split("\\s+");
		ArrayList<String> temp = new ArrayList<String>();
		for(String x : tmp) {
			temp.add(x);
		}
		StringBuilder n = new StringBuilder();
		int i = 1;
		for(Criminal c : bank.db()){
			String[] nTmp = c.name().split("\\s+");
			ArrayList<String> nTemp = new ArrayList<String>();
			for(String x : nTmp) {
				nTemp.add(x);
			}
			if(bank.sig().jaccard(bank.sig().minhash(temp), bank.sig().minhash(nTemp), 0.7)) {
				n.append(String.format("%s |%d \n", c.name(), c.id()));
				i++;
			}
		}
		
		if(i != 1) {
			System.out.println(String.format("\n\nResultados da Pesquisa:\n%s", n.toString()));
		}
		else {
			System.out.println("Nenhum resultado encontrado.");
		}
		
	}
	

	public void adicionarCriminosos() throws IOException {
		
		while(true) {
			save();
			System.out.println("\n\nInscrição do Criminoso\nNome:");
			String Name = in.nextLine();
			System.out.println("Idade:");
			int age = Integer.parseInt(in.nextLine());
			Data nasc;
			
			while(true) {
				System.out.println("Data de Nascimento\nDia:");
				int dia = Integer.parseInt(in.nextLine());
				System.out.println("Mes:");
				int mes = Integer.parseInt(in.nextLine());
				System.out.println("Ano:");
				int ano = Integer.parseInt(in.nextLine());
				
				Data birthday = new Data(dia,mes,ano);
				if(birthday.isValid()) {
					nasc = birthday;
					break;
				}
			}
			
			System.out.println("Peso:");
			int weight = Integer.parseInt(in.nextLine());
			System.out.println("Altura:");
			int height = Integer.parseInt(in.nextLine());
			System.out.println("Está vivo?(Sim/Não)");
			String answer1 = in.nextLine();
			boolean alive = false;
			if(answer1.compareToIgnoreCase("sim")== 0 ) {
				alive = true;
			}
			System.out.println("Está solto?(Sim/Não)");
			String answer2 = in.nextLine();
			boolean free = false;
			if(answer2.compareToIgnoreCase("sim")== 0 ) {
				free = true;
			}
			
			Criminal c = new Criminal(Name, age, nasc, weight, height, alive, free);
			
			while(true) {
				System.out.print("Qual o tipo de crime?\n"
						       + "1:Homícidio\n"
						       + "2:Assalto\n"
						       + "3:Violação\n"
						       + "4:Burla\n"
						       + "5:Sequestro\n"
						       + "6:Atos ilícitos envolvendo drogas\n"
						       + "Opção-->");
				int op = Integer.parseInt(in.nextLine());
				String type;
				switch(op) {
					case 1: type = "Homicidio";
						break;
					case 2: type = "Assalto";
						break;
					case 3: type = "Violacao";
						break;
					case 4: type = "Burla";
					    break;
					case 5: type = "Sequestro";
				    	break;
					case 6: type = "Atos ilicitos envolvendo drogas";
				    	break;
					default:type = "Delito";
						break;
					
				}
				
				Data dc;
				
				while(true) {
					System.out.println("Data do Crime\nDia:");
					int dia = Integer.parseInt(in.nextLine());
					System.out.println("Mes:");
					int mes = Integer.parseInt(in.nextLine());
					System.out.println("Ano:");
					int ano = Integer.parseInt(in.nextLine());
					
					Data ocur = new Data(dia,mes,ano);
					if(ocur.isValid()) {
						dc = ocur;
						break;
					}
				}
				Crime e = new Crime(type, dc);
				
				if(c.addCrime(e)) {	
					System.out.println("Adicionar mais crimes?(Sim/Não)");
					String answer3 = in.nextLine();
					boolean more = false;
					if(answer3.compareToIgnoreCase("sim")== 0) {
						more = true;
					}
					
					if(!more) {
						break;
					}
				}
			}
			
			if(bank.addCriminal(c)) {
				System.out.println("Adicionar mais?(Sim/Não)");
				String answer4 = in.nextLine();
				boolean more = false;
				if(answer4.compareToIgnoreCase("sim")== 0) {
					more = true;
				}
				
				if(!more) {
					break;
				}
			}
		}
	}
	
	public void imprimirLista() {
		bank.printList();
	}

	

}
