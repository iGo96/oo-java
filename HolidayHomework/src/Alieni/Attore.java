package Alieni;

public class Attore {
	protected String _nome;
	protected double _lvlSalute;
	
	public Attore(){
		_nome = "";
		_lvlSalute = 100;
	}
	
	public Attore(String nome){
		_nome = nome;
		_lvlSalute = 100;
	}
	
	public void decreaseLvlSalute(){
		if(_lvlSalute > 0)
			_lvlSalute--;
	}
	
	public void decreaseLvlSalute(double danno){
		if(_lvlSalute >= danno)
			_lvlSalute -= danno;
	}
	
	public boolean isAlive(){
		return _lvlSalute == 0;
	}
	
	//get & set
	public String getNome(){
		return _nome;
	}
		
	public void setNome(String newNome){
		_nome = newNome;
	}
	
	public double getLvlSalute(){
		return _lvlSalute;
	}
	
	public void setLvlSalute(double newLvlSalute){
		_lvlSalute = newLvlSalute;
	}
}
