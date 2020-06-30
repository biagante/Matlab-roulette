package mpeiProj;

public class bloomF {
	private int[] filtro; // Filtro de Bloom
	private int nHash; // Número de Hash Functions
	private int filled;// Numero de slots do filtro que não têm valor zero
	private int capacity;//Tamanho do filtro desejado
	private int[] mV;// Valores para a entrada da Hash Fucntion
	private int[] bV;// Valores para a entrada da Hash Fucntion
	
	public bloomF(int nHash, int capacity){
		this.capacity = capacity;
		this.filtro = new int[capacity];
		this.nHash = nHash;
		this.filled = 0;
		this.mV = new int[nHash];
		this.bV = new int[nHash];
		
		for(int c = 0; c < this.filtro.length; c++) { //Inicia o filtro com zeros
			this.filtro[c] = 0;
		}
		
		for(int i = 0; i < nHash; i++) {
			this.mV[i] = (int)Math.floor(Math.random()*3840674) + 1; //Números gerados aleatoriamente
			this.bV[i] =	(int)Math.ceil(Math.random()*7051122);	//Números gerados aleatoriamente
		}
	}
	
	public void insert(String s) {
		int[] pos = hashF.hashMe(s, this.mV, this.bV, this.capacity);
		
		for(int i = 0; i < pos.length ; i++){
			if(validPos(pos[i])) {
				this.filtro[pos[i]] += 1;
			}
		}
		filledUpDate();
	}
	
	//public void add
	
	public boolean validPos(int n) {
		return(0 <= n && n < capacity);
	}
	
	public boolean exists(String s) {
		boolean exists = true;
		int[] pos = hashF.hashMe(s, this.mV, this.bV, this.capacity);
		
		for(int i = 0; i < pos.length ; i++){
			if(validPos(pos[i]) && (this.filtro[pos[i]]==0)) {
				exists = false;
				break;
			}
		}
		return exists;
	}

	public void remove(String s) {
		if(exists(s)) {
			int[] pos = hashF.hashMe(s, this.mV, this.bV, this.capacity);
			
			for(int i = 0; i < pos.length ; i++){
				if(validPos(pos[i])) {
					this.filtro[pos[i]] -= 1;
				}
			}
		}
		filledUpDate();
		
	}
	
	public int filled() {
		return this.filled;
	}
	
	public int nHash() {
		return this.nHash;	
	}

	public int capacity() {
		return this.capacity;
	}
	
	private void filledUpDate() {
		int k = 0;
		
		for(int n : this.filtro) {
			if(n != 0) {
				k++;
			}
		}
		
		this.filled = k;
	}
	
}