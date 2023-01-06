package model;

public class Salle {
	private int id;
	private int num;
	private Infirmier survellant;
	private int nombreLits;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Infirmier getSurvellant() {
		return survellant;
	}
	public void setSurvellant(Infirmier survellant) {
		this.survellant = survellant;
	}
	public int getNombreLits() {
		return nombreLits;
	}
	public void setNombreLits(int nombreLits) {
		this.nombreLits = nombreLits;
	}
	
	
}
