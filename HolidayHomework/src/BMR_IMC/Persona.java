package BMR_IMC;

public class Persona {
	//altezza: cm
    //peso: kg
    //eta: anni
    //tipo attività fisica: sedentario; moderatamente attivo, attivo, molto attivo
    //sesso: m f
    
    //classe: persona, salute	
	
	private String _name;
	private String _surname;
	private int _height;
	private int _weight;
	private int _age;
	private String _lifestyleTipe; //sedentario; moderatamente attivo, attivo, molto attivo
	private char _gender;
	
	public Persona(String name, String surname, int height, int weight, int age, String lifestyleTipe, char gender) {
		this._name = name;
		this._surname = surname;
		this._height = height;
		this._weight = weight;
		this._age = age;
		this._lifestyleTipe = lifestyleTipe;
		this._gender = gender;
	}

	//----Personal info -----------------------------
	public String getName(){
		return this._name;
	}
	
	public void setName(String newName){
		this._name = newName;
	}
	
	public String getSurname(){
		return this._surname;
	}
	
	public void setSurname(String newSurname){
		this._surname = newSurname;
	}
	//------------------------------------------------
	public int getHeight(){
		return this._height;
	}
	
	public void setHeight(int newHeight){
		this._height = newHeight;
	}
	
	public int getWeight(){
		return this._weight;
	}
	
	public void setWeight(int newWeight){
		this._weight = newWeight;
	}
	
	public int getAge(){
		return this._age;
	}
	
	public void setAge(int newAge){
		this._age = newAge;
	}
	
	public String getLifeStyleType(){
		return this._lifestyleTipe;
	}
	
	public void setLifeStyleType(String newLifestyleTipe){
		this._lifestyleTipe = newLifestyleTipe;
	}
	
	public char getGender(){
		return this._gender;
	}
	
	public void setGender(char newGender){
		this._gender = newGender;
	}
}
