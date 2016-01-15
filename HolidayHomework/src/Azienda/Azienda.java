package Azienda;

import java.util.Stack;

public class Azienda {
	
	private String _ragioneSociale;
	private Stack<Dipendente> _dipendenti = new Stack<Dipendente>();
	
	public Azienda(String ragioneSociale){
		this._ragioneSociale = ragioneSociale;
	}
	
	public String getRagioneSociale(){
		return this._ragioneSociale;
	}
	
	public void setRagioneSociale(String newRagioneSociale){
		this._ragioneSociale = newRagioneSociale;
	}
	
	public Stack<Dipendente> getDipendenti(){
		return this._dipendenti;
	}
	
	public void add(Dipendente d){
		this._dipendenti.add(d);
	}
	
	public void add(String nome, String cognome, int anzianita, Contratto contratto){
		this._dipendenti.add(new Dipendente(nome,cognome,anzianita,contratto));
	}
	
	public void add(String nome, String cognome, int anzianita, String nomeContratto, double stipendioBase){
		this._dipendenti.add(new Dipendente(nome,cognome,anzianita, new Contratto(nomeContratto, stipendioBase)));
	}
}