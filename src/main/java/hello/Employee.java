package hello;
public class Employee{
	private int id;
	private String name;
	public Employee(){

	}
	public Employee(String cName){
		this.name = cName;
	}
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
}