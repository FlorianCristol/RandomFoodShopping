package hello;

import java.util.ArrayList;
import java.util.List;

public class Recette {
	private List<Ingredient> ingredients;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private int id ;
	private String nom;
	public Recette(){
		
	}
	public Recette(String nom){
		this.ingredients = new ArrayList<Ingredient>();
		this.nom = nom;
	}
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void addIngredient(Ingredient in){
		this.ingredients.add(in);
	}
	
}
