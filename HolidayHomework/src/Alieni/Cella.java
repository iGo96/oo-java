package Alieni;

public class Cella{
	//ERRORE -> non sa cosa verrà inserito (giocatore o alieno) => messo Object perchè generico.. per capire il tipo param.getClass(); 
	private Object _player; 
	
	public Cella(){
		this._player = null;
	}
	
	public void setPlayer(Object player){
		if ((player != null)&&(_player == null))
			this._player = player;
	}
	
	public void reset(){
		this._player = null;
	}
	
	public Object getPlayer(){
		return this._player;
	}
	
	public boolean isEmpty(){
		return this._player == null;
	}
}
