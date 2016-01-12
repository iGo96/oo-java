package Cambia_monete;

/*import java.io.InputStreamReader;
import java.io.BufferedReader ;
import java.io.IOException;*/

public class Test {

	public static void main(String[] args) {
		int[] money = MoneyChange.money;
		
		int val = 1254890;
		
		System.out.println("Per cambiare " + val + "€ ti servono: ");
		
		int[] retArr = MoneyChange.change(val);		
		
		for (int i = 0; i < retArr.length; i++){
			String valueType = "";
			
	    	if (retArr[i] > 0){
	    		if(money[i] >= 5){
	    			if (retArr[i] > 1)
	    				valueType = " banconote";
	    			else
	    				valueType = " banconota";
	    		}
	    		else{
	    			if (retArr[i] > 1)
	    				valueType = " monete";
	    			else
	    				valueType = " moneta";
	    		}
		    	System.out.println(retArr[i] + valueType + " da " + money[i] + "€");
	    	}
	    	
	    } 
	    //---------------------------------------------------------------
		
		/*
		 * da aggiungere => inserimento da utente della valuta da cambiare
		 * InputStreamReader reader = new InputStreamReader(System.in);
			BufferedReader inputVal = new BufferedReader(reader);
			String inputString = new String();
		
	    	try {
				inputString = inputVal.readLine();
	    	}
	    	catch (IOException e) {
				e.printStackTrace();
			}
		
	    	int val = Integer.parseInt(inputString);
		 * 
		 */
	}

}
