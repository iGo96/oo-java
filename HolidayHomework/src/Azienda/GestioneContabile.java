package Azienda;

import java.util.Stack;

public abstract class GestioneContabile {
	public static double getStipendiDaErogare(Stack<Dipendente> dipendenti){
		//estraggo tutti gli stipendi dei dipendenti, li sommo e li restituisco
		double tot = 0;
		for(Dipendente element:dipendenti){
			tot+=element.getStipendio();
		}
		return tot;
	}
	
	public static double getStipendiDaErogare(Azienda a){
		return getStipendiDaErogare(a.getDipendenti());
	}
	
	public static Stack<Dipendente> getDipendentiStipendioMax(Stack<Dipendente> dipendenti){
		/**
		 * Richiama metodo orderByPrice ma mostra solo i primi 3 risultati (più alti)  
		 */
		Stack<Dipendente> orderedStack = orderByPrice(dipendenti);
		Stack<Dipendente> retStack = new Stack<Dipendente>();
		for(int i=0; i < 3; i++){
			retStack.add(orderedStack.pop());
		}
		return retStack;
	}
	
	public static Stack<Dipendente> getDipendentiStipendioMax(Azienda a){
		return getDipendentiStipendioMax(a.getDipendenti());
	}
	
	private static Stack<Dipendente> orderByPrice(Stack<Dipendente> dipendenti){
		//il metodo fa il merge degli stipendi in ordine decrescente 
		//riordina da stipendio più alto a più bassob
		return sort(dipendenti);
	}
	
	public static Stack<Dipendente> sort(Stack<Dipendente> s) {
		if (s.isEmpty())
			return s;
		Dipendente pivot = s.pop();
		
		// partition
		Stack<Dipendente> left  = new Stack<Dipendente>();
		Stack<Dipendente> right = new Stack<Dipendente>();
		while(!s.isEmpty()) {
			Dipendente y = s.pop();
			if (y.getStipendio() < pivot.getStipendio())
				left.push(y); 
			else 
				right.push(y);
		}
		sort(left);
		sort(right);
		// merge
		Stack<Dipendente> tmp = new Stack<Dipendente>();
		while(!right.isEmpty()) {
			tmp.push(right.pop());
		}
		tmp.push(pivot);
		while(!left.isEmpty()) {
		  tmp.push(left.pop());
		}
		while(!tmp.isEmpty()) {
		  s.push(tmp.pop());
		}
		return s;
	}
}