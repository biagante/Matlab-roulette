package mpeiProj;

import java.util.ArrayList;
import java.util.List;

public class Criminal extends Person{
	private static int idStart = 0;
	private int id;
	private ArrayList<Crime> record;
	private boolean encarcerated;
	private bloomF bloom;

	public Criminal(String Name, int age, Data birthday, int weight, int height, boolean alive, boolean free) {
		super(Name, age, birthday, weight, height, alive);
		this.encarcerated = (!free);
		this.record = new ArrayList<Crime>();
		this.bloom  =new bloomF(7,480);
		this.id = idStart+1;
		idStart++;
	}
	
	public boolean addCrime(Crime e) {
		if(!crimeExists(e)) {
			record.add(e);
			bloom.insert(e.toString4Hash());
			return true;
		}
		else {
			return false;
		}
	}

	private boolean crimeExists(Crime e) {
		return this.bloom.exists(e.toString4Hash());
	}

	/*private boolean removeCrime(int c) {
		int index = c-1;
		
		if(index < record.size() && crimeExists(record.get(index))) {
			this.bloom.remove(record.get(index).toString4Hash());
			this.record.remove(index);
			return true;
		}
		else{
			return false;
		}
	}*/
	
	public String toString() {
		String s = "";
		
		for(int i = 0; i < this.record.size();i++) {
			s = s + String.format("%s\n", this.record.get(i).toString());
		}
		
		return String.format("::Ficha Criminal::\n"
				           + "%s\n"
				           + "Número de Identificação:%d\n"
				           + "Encarcerado:%b\n"
				           + "Crimes:\n"
				           + "%s\n", super.toString(),this.id,this.encarcerated,s);
	}
	
	@Override
	public String toString4Hash() {
		String s = "";
		for(int i = 0 ; i< this.record.size(); i++) {
			s += record.get(i).toString4Hash();
		}
		return String.format("%s %s %s", super.toString4Hash(), s, this.encarcerated);
	}
	
	public List<String> getCrimes() {
		
		ArrayList<String> tmp = new ArrayList<String>();
		for(int i = 0; i<record.size();i++) {
			tmp.add(record.get(i).type());
		}
		return tmp;
	}
	
	public List<String> getAtrtibutes() {
		ArrayList<String> tmp = new ArrayList<String>();
		tmp.add(String.format("%d", this.age()));
		tmp.add(String.format("%d", this.weight()));
		tmp.add(String.format("%d", this.height()));
		tmp.add(String.format("%b", this.dead()));
		tmp.add(String.format("%b", this.encarcerated));
		
		return tmp;
	}
	
	public int id() {
		return this.id;
	}

	public boolean encarcerated() {
		return this.encarcerated;
	}

	public ArrayList<Crime> record() {
		return this.record;
	}
}
