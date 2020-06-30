package mpeiProj;

public class hashF {
	static final int p = 792581; //Primo de valor considerável para diminuir o número de retornos igual a 0 no processo de Hashing
	
	//Método do retorno sem considerar o tamanho do Bloom Filter (Simple Hash)
	public static int[] hashMe(String x, int[] m, int[] b) {
		
		int[] hashed = new int[m.length];
		
		for(int i = 0; i < hashed.length; i++) {
			hashed[i] = Math.abs(((m[i] * (x.hashCode()) + b[i]) % p));
		}
		
		return hashed;
	}
	

	//Método do retorno tendo em consideração o tamanho do Bloom Filter
	public static int[] hashMe(String x, int[] m, int[] b, int size) {
		int[] hashed = new int[m.length];
		
		for(int i = 0; i < hashed.length; i++) {
			hashed[i] = Math.abs((((m[i] * (x.hashCode()) + b[i]) % p) % size));
		}
		
		return hashed;
	}
	
	/*Esta Hash Function implementa o método hashCode e combina-o com uma função linear do tipo y(x) = m * x + b,
	 * subsequentemente y(x)%p, de forma a diminuir o valor da hash;
	 */
	

}
