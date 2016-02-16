package main.harbour;

/**
 * ************* *
 * DA COMPLETARE *
 * ************* *
 */

public class Invasore {
	private String _Id;
	private String _modello;
	protected int _nArmamentiAlpha;
	protected int _nArmamentiBeta;
	protected int _stazza;
	
	public Invasore(){
		this._Id = "";
		this._modello = "";
		this._nArmamentiAlpha = 0;
		this._nArmamentiBeta = 0;
		this._stazza = 0;
	}
	
	//Get & Set
	public void setId(String newID){
		this._Id = newID;
	}
	
	public String getId(){
		return this._Id;
	}
	
	public void setModello(String newModello){
		this._modello = newModello;
	}
	
	public String getModello(){
		return this._modello;
	}
	
	public int getnArmamentiAlpha(){
		return this._nArmamentiAlpha;
	}
	
	public void setnArmamentiAlpha(int newNArmamentiAlpha){
		this._nArmamentiAlpha = newNArmamentiAlpha;
	}
	
	public int getnArmamentiBeta(){
		return this._nArmamentiBeta;
	}
	
	public void setnArmamentiBeta(int newNArmamentiBeta){
		this._nArmamentiBeta = newNArmamentiBeta;
	}
	
	public int getStazza(){
		return this._stazza;
	}
	
	public void setStazza(int newStazza){
		this._stazza = newStazza;
	}
}
