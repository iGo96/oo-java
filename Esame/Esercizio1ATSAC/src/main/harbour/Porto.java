package main.harbour;

/**
 * ************* *
 * DA COMPLETARE *
 * ************* *
 */
public class Porto {
	private double _dimensioneSqMeters;
	private double _dimensioneSqMetersDistrutta;
	
	public Porto(){
		this._dimensioneSqMeters = 0;
		this._dimensioneSqMetersDistrutta = 0;
	}

	public void addMetriQuadriDistrutti(double mq){
		if(this._dimensioneSqMeters - mq >= 0)
			this._dimensioneSqMetersDistrutta += mq;
		else
			this._dimensioneSqMetersDistrutta = this._dimensioneSqMeters; 
	}
	
	public boolean isDistrutto(){
		return (this._dimensioneSqMeters - this._dimensioneSqMetersDistrutta <= 0); //mi tutelo per eventuali bug che 
																					//possano settare la dimensione negativa
	}
	
	//Get & Set	
	public void setDimensioneSqMeters(int newDimensioneSqMeters){
		if (newDimensioneSqMeters >= 0) //viene usato per settare anche quando viene distrutto tutto
			this._dimensioneSqMeters = newDimensioneSqMeters;
	}
	
	public int getDimensioneSqMeters(){
		return (int)(this._dimensioneSqMeters - this._dimensioneSqMetersDistrutta);
	}
	
	public double getDimensioneSqMetersNonDistrutta(){
		return this._dimensioneSqMeters - this._dimensioneSqMetersDistrutta;
	}
}
