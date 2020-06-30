package mpeiProj;

import java.util.ArrayList;

public class TestBloomFilter {

	public static void main(String[] args) {
		/*
		 * Neste programa iremos testar o Bloom Filter, verificando se certos elementos fazem parte de um consjunto.
		 */
		
		bloomF test = new bloomF(5,1000);
		
		ArrayList<String> grupo1 = new ArrayList<String>();// Grupo 1 = {Alemanha, Brasil, Portugal, França, Espanha, Inglaterra}
		grupo1.add("Alemanha");
		grupo1.add("Brasil");
		grupo1.add("Portugal");
		grupo1.add("França");
		grupo1.add("Espanha");
		grupo1.add("Inglaterra");
		
		ArrayList<String> grupo2 = new ArrayList<String>();// Grupo 2 = {Alemanha, Suécia, Portugal, França, Holanda, Inglaterra,Argentian, Sucéia, Protugal, Franca, Holada, Italia}
		grupo2.add("Alemanha");
		grupo2.add("Suécia");
		grupo2.add("Portugal");
		grupo2.add("França");
		grupo2.add("Holanda");
		grupo2.add("Inglaterra");
		grupo2.add("Alamanha");
		grupo2.add("Brazil");
		grupo2.add("Protugal");
		grupo2.add("Franca");
		grupo2.add("Spanha");
		grupo2.add("Englaterra");
		
		for(String c : grupo1) {
			test.insert(c);
		}
		
		for(String k : grupo2) {
			if(test.exists(k)) {
				System.out.print(String.format("%s faz parte do grupo1\n", k));
			}
			else {
				System.out.print(String.format("%s não faz parte do grupo1\n", k));
			}
		}
		
	}

}
