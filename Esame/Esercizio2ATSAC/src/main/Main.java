package main;

import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		int reps = 1000;
		Stack<TemperatureSensorListener> calls = new Stack<TemperatureSensorListener>(); //contiene tutte le chiamate
		
		TemperatureSensor t = new TemperatureSensor();
		
		TemperatureSensorListener listener = null;
		t.setListener(listener);
		
		for (int i = 0; i < reps; i++){
			t.next();
			calls.add(listener);
		}
	}
	
//	public double getMax(Stack<TemperatureSensorListener> s){
//		/**
//		 * Trova il valore massimo registrato
//		 */
//		double retVal;
//		
//		for(TemperatureSensorListener t : s){
//			if(t.getTemp > retVal) // (?)
//				retVal = t;
//		}
//		return retVal;
//	}
	
//	public double mediaTemperature(Stack<TemperatureSensorListener> temperature){
//		int tot = 0;
//		int len = 0;
//		for (TemperatureSensorListener temperatura : temperature){
//			tot += temperatura;
//			len++;
//		}
//		double media = tot/len;
//		return media;
//	}
}
