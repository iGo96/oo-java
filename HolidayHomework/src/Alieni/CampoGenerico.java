package Alieni;

public class CampoGenerico {
	protected int _rows;
	protected int _cols;
	protected Cella[][] _playground; //campo di gioco. dimensione predefinita

	public CampoGenerico(int rows, int cols){
		/**
		 * Imposta le dimensioni(rowsxcols) del campo da gioco ed il loro stato(vuoto) secondo i 
		 * valori di default 
		 */ 
		this._rows = rows;
		this._cols = cols;

		for (int i = 0; i < _rows; i++)
			for (int j = 0; j < _cols; j++)
				this._playground[i][j] = new Cella(); //svuota le celle 
	}

	public CampoGenerico(){
		/**
		 * Imposta le dimensioni(20x20) del campo da gioco ed il loro stato(vuoto) secondo i 
		 * valori di default 
		 */
		this(20,20);
	}

	

	public boolean isEmpty(int row, int col){
		return this._playground[row][col].isEmpty();
	}

	public void reset(){
		/**
	 	 * Tramite l'utilizzo del metodo Cella.reset() svuota le celle.
	 	 */	
		for (int i = 0; i < _rows; i++)
			for (int j = 0; j < _cols; j++)
				this._playground[i][j].reset(); //svuota le celle 
	}

	//get & set
	public Cella[][] getPlayground(){
		return this._playground;
	}
	
	public int getCols() {
		return this._cols;
	}
	
	public int getRows() {
		return this._rows;
	}
}