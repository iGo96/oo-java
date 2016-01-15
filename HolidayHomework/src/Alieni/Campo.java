package Alieni;

import java.util.Random;
import java.util.Stack;


//ALIENO NON é UN ARRAY MA UNO STACK! -> non si sa la quantità all'inizio.
//PLAYER é UNO STACK. REGOLA DEL GIOCO = se un giocatore sopravvive 3 mov senza essere attaccato si sdoppia.
public class Campo extends CampoGenerico{
	private Stack<Giocatore> _players; //I giocatori vengono creati dinamicamente durante il gioco (se sopravvive più di 3 passi)
	private Alieno[] _aliens; //Meglio Array (dim fissa) o Stack (dim variabile)
					//TENERE CONTO CHE ALIENO CHE MUORE PUO' ESSERE QUALSIASI.
					//NON PER FORZA L'ULTIMO. MA UNO IN UNA POSIZIONE QUALSIASI DELLA LISTA.
	
	public Campo(int nAliens, int rows, int cols){
		//NB: gli alieni non possono essere più di (rows*cols)-_players
		//1 campo per il giocatore, il resto può essere occupato da alieni
		//si sconsiglia di occupare più del 30% del campo per permettere una maggiore fluidità di movimento
		super(rows, cols);
		
		//setPlayers(new Stack<Giocatore>()); //c'è solo 1 giocatore all'inizio (preda)
		
		for (int i = 0; i < randomize(rows, cols); i++){
			for (int j = 0; j < randomize(rows, cols); j++){
				try {
					this.setPlayer(i, j, new Alieno());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		for (int i = 0; i < nAliens; i++) //molteplici alieni (predatori)
			_aliens[i] = new Alieno("Alieno " + (i + 1), 1);
		
		
	}
	
	public void setPlayer(int row, int col, Object player) throws Exception{
		/**
		 * Metodo che posiziona un giocatore in una data posizione del campo.
		 * Accetta come parametro una riga e una colonna (posizione) e un giocatore.
		 * Nel caso in cui la posizione sia già occupata da un altro giocatore lancia un'eccezzione
		 * NB: Il gioco dovrà intercettare l'eccezione e randomizzare una nuova posizione se questa è già occupata
		 */
		if (!super._playground[row][col].isEmpty()) {
			throw new PositionOccupiedException("Posizione già occupata da un " + super._playground[row][col].getPlayer().getClass()); //Può ritornare solo "Alieno" o "Giocatore". 
																																		//NON TESTATO. FORSE TORNA Object(?)
		}
		else {
			super._playground[row][col].setPlayer(player);
		}
	}
	
	public Object getPlayer(int row, int col){
		return super._playground[row][col].getPlayer();
	}
	
	private int randomize(int start, int end){ //f(x) scaricata da internet. 
		Random random = new Random();
		if (start > end)
			throw new IllegalArgumentException("Start cannot exceed End."); //lancia un'eccezione -> numero iniziale >> numero finale (PER FORZA)
		
		/*if (start > end) { //ALTERNATIVA -> sostituisce i numeri in modo da avere il più grande come START ed il più piccolo come END
			int h = start;
			start = end;
			end = h;
		}*/ 
		
		//get the range, casting to long to avoid overflow problems
		long range = (long)end - (long)start + 1;
		// compute a fraction of the range, 0 <= frac < range
		long fraction = (long)(range * random.nextDouble());
		int retVal =  (int)(fraction + start);
		return retVal;
	}
	
	public void reset(int rows, int cols){
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				super._playground[i][j].reset(); //setta tutte le celle a -1 (= vuota)
	}

	//get & set
	public Stack<Giocatore> getPlayers() {
		return _players;
	}

	public void setPlayers(Stack<Giocatore> _players) {
		this._players = _players;
	}
}