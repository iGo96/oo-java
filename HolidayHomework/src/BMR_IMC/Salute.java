package BMR_IMC;
public class Salute {
	
	public static void main(String[] args){
		Persona p = new Persona("Igor","Vukajlovic", 183, 91, 19, "molto attivo", 'm');
		System.out.println(BMR(p));
		System.out.println(IMC(p.getWeight(), p.getHeight()));
		
	}
	
	public static double BMR(Persona p){
		char gender = p.getGender();
		double MB;
		if (gender == 'm'){
			MB = 655 + (13.8 * p.getWeight()) + (1.8 * p.getHeight()) * (4.7 * p.getAge());
		}
		else {
			MB = 655 + (9.6 * p.getWeight()) + (1.8 * p.getHeight()) * (4.7 * p.getAge());
		}
		
		switch(p.getLifeStyleType()){ //sedentario; moderatamente attivo, attivo, molto attivo
			case "sedentario":
				MB += (20 * MB ) / 100;
				break;
			case "moderatamente attivo":
				MB += (30 * MB ) / 100;
				break;
			case "attivo":
				MB += (40 * MB ) / 100;
				break;
			case "molto attivo":
				MB += (50 * MB ) / 100;
				break;
			default:
				//non fa niente
		}
		return MB;
	}

	public static String IMC(int weight, int height){
		height/=100;
		double IMC = weight / Math.pow(height, 2);
		String classeRischio = "";
		
		if (IMC < 18.5)
			classeRischio = "sottopeso";
		else if ((IMC >= 18.5) || (IMC < 25))
			classeRischio = "normale";
		else if ((IMC >= 25) || (IMC < 30))
			classeRischio = "sovrappeso";
		else 
			classeRischio = "obeso";
		return classeRischio;
	}
}