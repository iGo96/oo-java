package Cambia_monete;

public class Money {
	private int value;
	private String type;
	
	public Money(int value, String type) {
		this.setValue(value);
		this.setType(type);
	}
	
	//get & set
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
