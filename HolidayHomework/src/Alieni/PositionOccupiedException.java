package Alieni;

public class PositionOccupiedException extends Exception {
	/**
	 * Classe che definisce l'eccezione "PositionOccupiedException".
	 * Viene lanciata dalla classe Campo nel momento in cui il metodo setPlayer cerca di inserire un giocatore in una cella già occupata.
	 */
	private static final long serialVersionUID = 1L;

	public PositionOccupiedException(){
		super("Posizione già occupata.");
	}
	
	public PositionOccupiedException(String msg){
		super(msg);
	}
}
