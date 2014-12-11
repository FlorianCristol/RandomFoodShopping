package hello;

public class Greeter {
	String message;
	String message2;
	public void setMessage(String message){
		this.message = message;
	}
	public void setMessage2(String message){
		this.message2 = message;
	}
	public void getMessage(){
		System.out.println("Your message: "+ this.message);
	}
	public void getMessage2(){
		System.out.println("Your second message:"+ this.message2);
	}
	public String getM(){
		return this.message;
	}
}