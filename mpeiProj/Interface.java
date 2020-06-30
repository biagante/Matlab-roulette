package mpeiProj;

import java.io.IOException;
import java.util.Scanner;

public class Interface {	
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		Handler engine = new Handler();
		boolean cond = true;
		while(cond) {
			printMenu(0);
			int op = Integer.parseInt(in.nextLine());
			switch(op) {
				case 1:engine.adicionarCriminosos();
					break;
				case 2:engine.imprimirLista();
					break;
				case 4:engine.imprimirLista();
				       int n = Integer.parseInt(in.nextLine());
					   printMenu(1);
					   int c = Integer.parseInt(in.nextLine());
					   switch(c) {
					   		case 1:engine.encontrarCriminosoAtr(n);
					   			break;
					   		case 2:engine.encontrarCriminosoCr(n);
					   			break;
					   		default:break;
					   }
					break;
				case 3:System.out.print("Nome?");
				    String name = in.nextLine();
					engine.searchByName(name);
					break;
				case 5:engine.save();
					cond=false;
					break;
				default:
					break;
			}
		}
		
		
	}

	private static void printMenu(int i) {
		switch(i) {
		case 0:System.out.print(String.format("\n\n|-----------------------------------------------|\n"
                							 +"|              Main do Projeto                  |\n"
                							 +"|-----------------------------------------------|\n"
                							 +"| 1 - Adicionar criminosos                      |\n"
                							 +"| 2 - Imprimir lista de criminosos              |\n"
                							 +"| 3 - Procurar um criminoso por nome            |\n"
                							 +"| 4 - Encontrar criminosos semelhantes          |\n"
                							 +"| 5 - Sair do programa                          |\n"
                							 +"|_______________________________________________|\n"
                							 +" Escolha: "));
			break;
		case 1:System.out.print(String.format("\n\n|-----------------------------------------------|\n"
				 							 +"|           Critérios de Semelhança             |\n"
				 							 +"|-----------------------------------------------|\n"
				 							 +"| 1 - Atributos                                 |\n"
				 							 +"| 2 - Crimes                                    |\n"
				 							 +"|_______________________________________________|\n"
				 							 +" Escolha: "));
			break;
		default:
			break;	
		}
	}
	
}
