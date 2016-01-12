package Cambia_monete;

/*import java.io.InputStreamReader;
import java.io.BufferedReader ;
import java.io.IOException;*/

public class Test {

	public static void main(String[] args) {
		Money[] money = MoneyChange.money;
		
		int val = 782;
		
		System.out.println("Per cambiare " + val + "€ ti servono: ");
		
		int[] retArr = MoneyChange.change(val);
		
		for (int i = 0; i < retArr.length; i++){
			//if (retArr[i] > 0)
				System.out.println(retArr[i] + " " + money[i].getType() + " da " + money[i].getValue() + "€");
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
