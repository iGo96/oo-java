package Azienda;

public class Dipendente extends Persona {
	//Di logica dovrebbe ereditare da stack in modo da evitare in Azienda di fare Stack<Dipendenti>. 
	//Dipendenti di suo è stack con metodi aggiuntivi (overload) e add modificato (override) 
	
	private int _anzianita; //anni di servizio 
	private Contratto _contratto;
	private double _stipendio; //stipendio annuo in euro
		
	public Dipendente(String nome, String cognome, int anzianita, Contratto contratto){
		super(nome, cognome);
		this._anzianita = anzianita;
		this._contratto = contratto; 
		this._stipendio = _contratto.getStipendioBaseEur() + ((0.5 * _contratto.getStipendioBaseEur()) / 100) * _anzianita; 
	}
	
	public int getAnzianita(){
		return this._anzianita;
	}
	
	public void setAnzianita(int anzianita){
		this._anzianita = anzianita;
	}
	
	public Contratto getContratto(){
		return this._contratto;
	}
	
	public void setContratto(Contratto contratto){
		this._contratto = contratto;
	}
	
	public void setContratto(String nome, double stipendioBase){
		this._contratto = new Contratto(nome, stipendioBase);
	}
	
	public double getStipendio(){
		return this._stipendio;
	}
	
	public void setStipendio(double stipendio){
		/**
		 * teoricamente non da utilizzare -> stipendio varia in base agli anni di servizio presso 
		 * l'azienda: impostato all'inizio e ogni anno gli viene aggiunto 0.5%. 
		 * Piuttosto utilizzare updateStipendio
		*/
		
		this._stipendio = stipendio;
	} 
	
	public void updateStipendio(){
		/** 
		 * In base agli anni di servizio aggiorna lo stipendio.
		 * Probabile utilizzo in una funzione di routine annuale (automatica).
		*/
		this._stipendio += ((0.5 * this._contratto.getStipendioBaseEur()) / 100) * this._anzianita;
	}
}
