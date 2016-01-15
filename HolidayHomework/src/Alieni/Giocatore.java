package Alieni;

//ereditare da una classe "attore" generica e poi sia alieno che giocatore ereditano(?)
public class Giocatore extends Attore {
	public Giocatore(){
		super();
	}
	
	public Giocatore(String nome){
		super(nome);
	}
	
	public boolean isAlive(){
		return super.isAlive();
	}
	
	//get & set
	public String getNome(){
		return super.getNome();
	}
	
	public void setNome(String newNome){
		super.setNome(newNome);
	}
	
	public void setLvlSalute(double newLvlSalute){
		super.setLvlSalute(newLvlSalute);
	}
	
	public double getLvlSalute(){
		return super.getLvlSalute();
	}
}