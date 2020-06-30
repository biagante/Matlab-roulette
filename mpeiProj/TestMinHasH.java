package mpeiProj;

import java.util.ArrayList;

public class TestMinHasH {

	public static void main(String[] args) {
		/* Neste programa de java iremos testar o M�dulo MinHash
		 * Para tal iremos comparara 3 grupos de singles e verificar varias dist�ncias de Jaccard deles.
		 */
		minHash test = new minHash(40); //MinHash 
		
		ArrayList<String> grupo1 = new ArrayList<String>();// Grupo 1 = {Alemanha, Brasil, Portugal, Fran�a, Espanha, Inglaterra}
		grupo1.add("Alemanha");
		grupo1.add("Brasil");
		grupo1.add("Portugal");
		grupo1.add("Fran�a");
		grupo1.add("Espanha");
		grupo1.add("Inglaterra");
		
		ArrayList<String> grupo2 = new ArrayList<String>();// Grupo 2 = {Alemanha, Su�cia, Portugal, Fran�a, Holanda, Inglaterra}
		grupo2.add("Alemanha");
		grupo2.add("Su�cia");
		grupo2.add("Portugal");
		grupo2.add("Fran�a");
		grupo2.add("Holanda");
		grupo2.add("Inglaterra");
		
		ArrayList<String> grupo3 = new ArrayList<String>();// Grupo 3 = {Argentina, Su�cia, Portugal, Fran�a, Holanda, It�lia}
		grupo3.add("Argentina");
		grupo3.add("Su�cia");
		grupo3.add("Portugal");
		grupo3.add("Fran�a");
		grupo3.add("Holanda");
		grupo3.add("It�lia");
		
		StringBuilder s1 = new StringBuilder();
		int[] tmp1 = test.minhash(grupo1);
		for(int i = 0; i < tmp1.length;i++) {
			s1.append(tmp1[i]+" ");
		}
		System.out.println(String.format("%s", s1.toString()));
		
		StringBuilder s2 = new StringBuilder();
		int[] tmp2 = test.minhash(grupo2);
		for(int i = 0; i < tmp2.length;i++) {
			s2.append(tmp2[i]+" ");
		}
		System.out.println(String.format("%s", s2.toString()));
		
		StringBuilder s = new StringBuilder();
		int[] tmp = test.minhash(grupo3);
		for(int i = 0; i < tmp.length;i++) {
			s.append(tmp[i]+" ");
		}
		System.out.println(String.format("%s", s.toString()));
        
		System.out.println(String.format("Dist�ncia de Jaccard entre o grupo 1 e 2 � menor que 0,6? %b :: deve ser verdadeiro", test.jaccard(test.minhash(grupo1), test.minhash(grupo2), 0.6)));
		System.out.println(String.format("Dist�ncia de Jaccard entre o grupo 1 e 2 � menor que 0,2? %b :: deve ser falso", test.jaccard(test.minhash(grupo1), test.minhash(grupo2), 0.2)));
		System.out.println(String.format("Dist�ncia de Jaccard entre o grupo 2 e 3 � menor que 0,6? %b :: deve ser verdadeiro", test.jaccard(test.minhash(grupo2), test.minhash(grupo3), 0.6)));
		System.out.println(String.format("Dist�ncia de Jaccard entre o grupo 2 e 3 � menor que 0,2? %b :: deve ser falso", test.jaccard(test.minhash(grupo2), test.minhash(grupo3), 0.2)));
		System.out.println(String.format("Dist�ncia de Jaccard entre o grupo 1 e 3 � menor que 0,9? %b :: deve ser verdadeiro", test.jaccard(test.minhash(grupo1), test.minhash(grupo3), 0.9)));
		System.out.println(String.format("Dist�ncia de Jaccard entre o grupo 1 e 3 � menor 0,1? %b :: deve ser falso", test.jaccard(test.minhash(grupo1), test.minhash(grupo3), 0.1)));
		
	}

}
