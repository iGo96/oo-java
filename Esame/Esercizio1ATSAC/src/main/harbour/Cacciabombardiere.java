package main.harbour;

/**
 * ************* *
 * DA COMPLETARE *
 * ************* *
 */
public class Cacciabombardiere extends Invasore implements PotenzaFuoco {
	
	public Cacciabombardiere(){
		
	}
	
	@Override
	public int potenzaFuoco(){
		/**
		 * La potenza di fuoco è 40 volte la somma del numero di armamenti alpha e beta
		 * => (10 + 20) * 40
		 */
		int retVal = (super._nArmamentiAlpha + this._nArmamentiBeta) * 40;
		return retVal;
	}
	
	@Override
	public void setId(String newID){
		super.setId(newID);
	}	
}

