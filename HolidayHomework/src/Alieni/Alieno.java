package Alieni;

public class Alieno extends Attore {
	private double _danno;	
	
	public Alieno(){
		super();
		_danno = 1;
	}
	
	public Alieno(String nome, double danno){
		super(nome);
		_danno = danno;		
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
	
	public double getLvlSalute(){
		return super.getLvlSalute();
	}
	
	public void setLvlSalute(double newLvlSalute){
		super.setLvlSalute(newLvlSalute);
	}
	
	public double getDanno(){
		return _danno;
	}
	
	public void setDanno(double newDanno){
		_danno = newDanno;
	}
}
