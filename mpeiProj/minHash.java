package mpeiProj;

import java.util.List;

public class minHash {
	private int nHash;
	private int[] mV;
	private int[] bV;
	
	public minHash(int nHash) {
		this.nHash = nHash;
		this.mV = new int[nHash];
		this.bV = new int[nHash];
		for(int i = 0; i < nHash; i++) {
			this.mV[i] = (int)Math.floor(Math.random()*3840674) + 1; //Números gerados aleatoriamente
			this.bV[i] = (int)Math.ceil(Math.random()*7051122); //Números gerados aleatoriamente
		}
	}
	
	public int[] minhash(List<String> set) {
		int[] assinatura = new int[nHash];
		int[][]tmpMatrix = new int[nHash][set.size()];
		for (int i = 0; i < set.size(); i++) {
			int[] hashR = hashF.hashMe(set.get(i),mV,bV);
			for(int c = 0; c < hashR.length; c++) {
				tmpMatrix[c][i] = hashR[c];
			}
		}
		
		for(int h = 0; h < nHash; h++) {
			assinatura[h] = Integer.MAX_VALUE;
			for(int s = 0; s < set.size(); s++) {
				if(assinatura[h]>tmpMatrix[h][s]) {
					assinatura[h] = tmpMatrix[h][s];
				}
			}
		}
		
		return assinatura;
	}
	
	public boolean jaccard(int[] ass1, int[] ass2, double treshold) {
		int nEquals = 0;
		
		for(int i = 0; i < nHash; i++) {
			if(ass1[i] == ass2[i]) {
				nEquals++;
			}
		}
		//int ratio  = (length1+length2)-nEquals;
		
		return treshold > (1 - (nEquals/(double)ass1.length));
		
		//double distJaccard = 1 - (nEquals/(double)length1);

		//if(distJaccard < treshold) {
			//union++;
			//}
		
		//if(union > 0) return true;
		
		//return false;
		
		}
	
	
		
		//return (treshold <= (union/(ass1.length+ass2.length-union)) && (union/(ass1.length+ass2.length-union)) != 1);
}
