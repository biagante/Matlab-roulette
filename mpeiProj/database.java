package mpeiProj;

import java.util.ArrayList;
import java.util.List;

public class database {
	private ArrayList<Criminal> db;
	private bloomF bloom;
	private minHash sig;
	
	public database(){
		this.db = new ArrayList<Criminal>();
		this.bloom = new bloomF(23,33548);
		this.sig = new minHash(50);
	}
	

	public boolean addCriminal(Criminal e) {
		if(!criminalExists(e)) {
			db.add(e);
			bloom.insert(e.toString4Hash());
			return true;
		}
		else {
			return false;
		}
	}

	public boolean criminalExists(Criminal e) {
		if(db.size()==0) {
			return false;
		}
		else {
			if(this.bloom.exists(e.toString4Hash())) {
				return true;
			}
			else {
				return false;
			}
		}

	}
	public boolean addCrime(int n, Crime c) {
		int index = n-1;
		if(index < db.size() && criminalExists(db.get(index))) {
			db.get(index).addCrime(c);
			return true;
		}
		else {
			return false;
		}
	}

	public boolean removeCriminal(int c) {
		int index = c-1;
		if(index < db.size() && criminalExists(db.get(index))) {
			this.bloom.remove(db.get(index).toString4Hash());
			db.remove(index);
			return true;
		}
		else {
			return false;	
		}
	}
	
	public List<Criminal> findSimilarAtr(Criminal e) {
		ArrayList<Criminal> tmp = new ArrayList<Criminal>();
		int[] ass1 = sig.minhash(e.getAtrtibutes());
		
		for(int i = 0; i < this.db.size();i++) {
			int[] ass2 = sig.minhash(db.get(i).getAtrtibutes());
			if(sig.jaccard(ass1, ass2, 0.8)) {
				tmp.add(db.get(i));
			}
		}
		
		return tmp;
	}
	
	public List<Criminal> findSimilarCr(Criminal e) {
		ArrayList<Criminal> tmp = new ArrayList<Criminal>();
		int[] ass1 = sig.minhash(e.getCrimes());
		
		for(int i = 0; i < this.db.size();i++) {
			int[] ass2 = sig.minhash(db.get(i).getCrimes());
			if(sig.jaccard(ass1, ass2, 0.8)) {
				tmp.add(db.get(i));
			}
		}
		
		return tmp;
	}
	
	public void printList() {
		String s = "";
		for(int i = 0; i < db.size(); i++) {
			s = s + String.format("%d| NOME: %s | ID: %d\n", i, db.get(i).name(), db.get(i).id());
		}
		
	    System.out.print(String.format("\n\n:: Lista de Criminosos ::\n%s",s));
	}
	
	public void printCriminal(int n) {
		int index = n-1;
		if(index < db.size() && criminalExists(db.get(index))) {
			System.out.print(db.get(index).toString());
		}
	}
	
	public ArrayList<Criminal> db(){
		return this.db;
	}
	
	public minHash sig() {
		return this.sig;
	}
	

}
