package mpeiProj;

public class Person {
	private String name;
	private int age;
	private Data birthday;
	private int weight;
	private int height;
	private boolean dead;
	
	public Person(String Name,int age, Data birthday, int weight, int height, boolean alive) {
		this.name = Name;
		this.age = age;
		this.birthday = birthday;
		this.weight = weight;
		this.height = height;
		this.dead = (!alive);
	}
	
	public String toString() {
		return String.format("Nome:%s  Idade:%d\n"
				           + "Data de Nascimento:%s\n"
				           + "Peso:%d Kg Altura:%d cm\n"
				           + "Morto:%b\n",this.name,this.age,this.birthday.toString(),this.weight,this.height, this.dead);
	}
	
	public String toString4Hash() {
		return String.format("%s %d %s %d %d %b",this.name,this.age,this.birthday.toString(),this.weight,this.height,this.dead);
	}
	
	public String name() {
		return this.name;
	}
	public int age() {
		return this.age;
	}
	
	public Data birthday() {
		return this.birthday;
	}
	
	public int weight() {
		return this.weight;
	}
	
	public int height() {
		return this.height;
	}
	
	public boolean dead() {
		return this.dead;
	}
	

}
