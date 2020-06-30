package mpeiProj;

public class hashF {
	static final int p = 792581; //Primo de valor consider�vel para diminuir o n�mero de retornos igual a 0 no processo de Hashing
	
	//M�todo do retorno sem considerar o tamanho do Bloom Filter (Simple Hash)
	public static int[] hashMe(String x, int[] m, int[] b) {
		
		int[] hashed = new int[m.length];
		
		for(int i = 0; i < hashed.length; i++) {
			hashed[i] = Math.abs(((m[i] * (x.hashCode()) + b[i]) % p));
		}
		
		return hashed;
	}
	

	//M�todo do retorno tendo em considera��o o tamanho do Bloom Filter
	public static int[] hashMe(String x, int[] m, int[] b, int size) {
		int[] hashed = new int[m.length];
		
		for(int i = 0; i < hashed.length; i++) {
			hashed[i] = Math.abs((((m[i] * (x.hashCode()) + b[i]) % p) % size));
		}
		
		return hashed;
	}
	
	/*Esta Hash Function implementa o m�todo hashCode e combina-o com uma fun��o linear do tipo y(x) = m * x + b,
	 * subsequentemente y(x)%p, de forma a diminuir o valor da hash;
	 */
	

}
