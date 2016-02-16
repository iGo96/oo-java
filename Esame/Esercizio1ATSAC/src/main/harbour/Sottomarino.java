package main.harbour;

/**
 * ************* *
 * DA COMPLETARE *
 * ************* *
 */
public class Sottomarino extends Invasore implements PotenzaFuoco {
	
	public Sottomarino(){
		super();
	}
	
	@Override
	public int potenzaFuoco(){ //NON FUNZIA!
		/**
		 * La potenza di fuoco è il 25% del prodotto tra numero armamenti e stazza.
		 * Il valore è arrotondato all'intero più vicino.
		 */
		int mul = this._nArmamentiAlpha * this._stazza;	//funzia
		int mul2 = 25 * mul; //funzia
		
		float percentage = mul2 / 100; //!!!!non funzia!!!!
		
		return Math.round(percentage); //teoricamente funzia
	}
	
	@Override
	public void setId(String newID){
		super.setId(newID);
	}
	
	//metodo che rende utilizzabile dal test il metodo "setnArmamenti". Fa riferimento a "setnArmamentiAlpha".
	public void setnArmamenti(int newNArmamenti){
		super.setnArmamentiAlpha(newNArmamenti);
	}
}
