package mpeiProj;

public class Crime{
	private String type;
	private Data dC;
	
	public Crime(String type, Data dc){
		this.type = type;
		this.dC = dc;
	}

	public boolean equals(Crime crime) {//Usar minhash
		if(this.type.compareToIgnoreCase(crime.type)==0 && this.dC.equals(crime.dC)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		return String.format("%s |Data: %s", this.type, this.dC.toString());
	}
	
	public String toString4Hash() {
		return String.format("%s %s", this.type, this.dC.toString());
	}
	
	public String type() {
		return this.type;
	}

	public Data dC() {
		return this.dC;
	}
}