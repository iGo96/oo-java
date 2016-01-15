package Cambia_monete;

public abstract class MoneyChange {
	public static Money[] money = new Money[] {
		new Money(500, "banconota"), new Money(200, "banconota"), new Money(100, "banconota"), new Money(50, "banconota"), 
		new Money(20, "banconota"), new Money(10, "banconota"), new Money(5, "banconota"), new Money(2, "moneta"), new Money(1, "moneta")}; //valuta utilizzabile
	
	public static int[] change(int value) {
		int[] repetitions = new int[money.length]; //array che contiene la quantità di banconote da utilizzare
		int[] retArr = new int[money.length];
		
		for (int i = 0; i < money.length; i++) {
			int rep = value / money[i].getValue(); 
			value -= money[i].getValue() * rep;
			repetitions[i] = rep;
		}
		
		for (int i = 0; i < repetitions.length; i++) {
			if(repetitions[i] > 0)
				retArr[i] = repetitions[i];
		}
		
		return retArr;
	}
}