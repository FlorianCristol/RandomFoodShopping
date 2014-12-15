package hello;

public class Ingredient {
	private int id;
	private String nom;
	private int quantite;
	private Aile aile;
	public Ingredient(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Ingredient(String nom, int quantite){
		this.nom = nom;
		this.quantite = quantite;
	}
	public Aile getAile() {
		return aile;
	}
	public void setAile(Aile aile) {
		this.aile = aile;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
}
