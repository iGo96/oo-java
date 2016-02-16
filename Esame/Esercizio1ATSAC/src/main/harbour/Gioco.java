package main.harbour;

/**
 * ************* *
 * DA COMPLETARE *
 * ************* *
 */
public class Gioco {
	private Porto _porto; 
	public Gioco(Porto p){
		this._porto = p;
	}
	
	public void attacco(Invasore[] i){
		/**
		  * L'attacco somma la potenza di fuoco degli invasori e 
		  * distrugge il porto secondo questa equazione:
		  * metri_quadri_distrutti_del_porto = potenza_di_fuoco_invasori * 2.5
		 */
		int potenza_di_fuoco_invasori = 0; //potenza totale dell'attacco
		double metri_quadri_distrutti_del_porto = potenza_di_fuoco_invasori * 2.5;
		_porto.addMetriQuadriDistrutti(metri_quadri_distrutti_del_porto);
	}
	
	public boolean portoDistrutto(){
		return _porto.isDistrutto();
	}
}
