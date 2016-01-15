package Cambia_monete;

public class Money {
	private int _value;
	private String _type;
	
	public Money(int value, String type) {
		this._value = value;
		this._type = type;
	}
	
	//get & set
	public int getValue() {
		return _value;
	}
	
	public void setValue(int value) {
		this._value = value;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		this._type = type;
	}
}
