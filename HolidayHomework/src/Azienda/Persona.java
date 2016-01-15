package Azienda;

public class Persona {	
	private String _nome;
	private String _cognome;
	
	public Persona(String nome, String cognome){
		this._nome = nome;
		this._cognome = cognome;
	}
	
	public String getNome(){
		return this._nome;
	}
	
	public void setNome(String nome){
		this._nome = nome;
	}
	
	public String getCognome(){
		return this._cognome;
	}
	
	public void setCognome(String cognome){
		this._cognome = cognome;
	}
	
	public String getNomeCognome(){
		return _nome + " " + _cognome;
	}
}