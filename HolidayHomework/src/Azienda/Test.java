package Azienda;

import java.util.Stack;

public class Test {
	
	public static void main(String[] args) {
		Azienda a = new Azienda("NaBerTech");
		Azienda b = new Azienda("Electrolux");
		Contratto tempoIndet = new Contratto("A tempo indeterminato", 12000);
		
		a.add("Igor","Vukajlovic", 1, "A tempo indeterminato", 12000);
		a.add("Smilja", "Cavric", 2, tempoIndet);
		a.add("Petra", "Kretic", 20, tempoIndet);
		a.add("Drazan", "Cavric", 5, "5 anni", 10000);
		
		b.add("Alen", "Vukajlovic", 0, "3 anni", 10000);
		b.add("Miladin", "Vukajlovic", 5, tempoIndet);
		b.add("Goran", "Cavric", 6, tempoIndet);
		b.add("Drazen", "Vukajlovic", 3, tempoIndet);
		
		System.out.println(a.getRagioneSociale());
		for(Dipendente element:a.getDipendenti()){
			System.out.println(element.getNome() + " " + element.getCognome());
			System.out.println("stipendio base " + element.getContratto().getStipendioBaseEur() + "€ ");
			System.out.println("guadagno " + element.getStipendio() + "€");
			System.out.println();
		}
		
		System.out.println(b.getRagioneSociale());
		for(Dipendente element:b.getDipendenti()){
			System.out.println(element.getNome() + " " + element.getCognome());
			System.out.println("stipendio base " + element.getContratto().getStipendioBaseEur() + "€ ");
			System.out.println("guadagno " + element.getStipendio() + "€");
			System.out.println();
		}
		
		System.out.println("\nTEST classe GestioneContabile");
		
		System.out.println("getStipendiDaErogare");
		System.out.println("\t Azienda " + a.getRagioneSociale() + " passando dipendenti: " + GestioneContabile.getStipendiDaErogare(a.getDipendenti()));
		System.out.println("\t Azienda " + a.getRagioneSociale() + " passando azienda: " + GestioneContabile.getStipendiDaErogare(a));
		System.out.println();
		System.out.println("\t Azienda " + b.getRagioneSociale() + " passando dipendenti: " + GestioneContabile.getStipendiDaErogare(b.getDipendenti()));
		System.out.println("\t Azienda " + b.getRagioneSociale() + " passando azienda: " + GestioneContabile.getStipendiDaErogare(b));
		
		System.out.println("\ngetDipendentiStipendioMax");
		System.out.println("\tAzienda " + a.getRagioneSociale() + " passando dipendenti:");
		
		Stack<Dipendente> stackA = GestioneContabile.getDipendentiStipendioMax(a.getDipendenti());
		for (Dipendente element:stackA) {
			System.out.println("\t\t" + element.getNomeCognome());
		}
		
		System.out.println();
		System.out.println("\tAzienda " + b.getRagioneSociale() + " passando dipendenti:");
		
		Stack<Dipendente> stackB = GestioneContabile.getDipendentiStipendioMax(b.getDipendenti());
		for (Dipendente element:stackB) {
			System.out.println("\t\t" + element.getNomeCognome());
		}
	}
}