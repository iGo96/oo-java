package Azienda;

public class Contratto {
	private String _nome;
	private double _stipendioBase; //annuo in centesimi
	
	public Contratto(String nome, double stipendioBase){
		this._nome = nome;
		this._stipendioBase = stipendioBase;
	}
	
	public String getNome(){
		return this._nome;
	}
	
	public void setNome(String nome){
		this._nome = nome;
	}
	
	public double getStipendioBaseCent(){
		return this._stipendioBase;
	}
	
	public double getStipendioBaseEur(){
		return this._stipendioBase / 100;
	}
	
	public void setStipendioBase(double stipendioBase){
		this._stipendioBase = stipendioBase;
	}
}
