
public class CoreJavaBrushUp4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Methods - Needs to be written outside of main function so that we can call them when ever needed
		//To use methods we need objects. We call methods into a class by creating an object of that class.
		//Here lets create an object of this class to use it to call methods made outside of this class
		
		CoreJavaBrushUp4 meth= new CoreJavaBrushUp4(); // Here we have created an obj-> meth of this
													//class to use it to call other methods
		meth.getData();                    //we called the method we created with the object we created.
		
		System.out.println(meth.getstringdata()); //or the value can be taken into a variable and that
		//variable can be printed Ex: String name = meth.getstringdata(); Then Sysout the variable.
		
		//To call a method from another class file we need to create an object of that class to access
		//the methods it has as below
		Methods m=new Methods(); //Obj 'm' is created of the class 'Methods' to access its methods
		m.m1(); //obj 'm' is accessing a method 'm1' from the class 'Methods'
		gd();   //This is a static method and static methods doesn't need an object to be called in its class.
		m.gs(); //Static methods in an other class will still be needing its class obj, to be called and used.
		
		
	}//Main class ending Parenthesis
	
	//Methods
	//Method-1
	public void getData() {//here this method is public and it can be accessed by any of the other 
						   //CJBU-CoreJavaBrushUp classes
						   //And "Void" is the return type of the method which means that this method
						   //returns nothing. But if the method returns an Integer, we'll then be writing
						   // public integer getData(){ return null;(needed)} <- Syntax
		System.out.println("Method - 1 : This method is executing a void return type method named getData");
	}
	
	//Method-2
	public String getstringdata() {
		System.out.println("Method - 2 : GetStringdata method is being executed");
		return "Executed Method is a method with String return type";
	}
	
	//STATIC Methods
	//These methods can be accessed by its own class without any object.
	public static String gd() {
		System.out.println("This is a static method in the same class");
		return "These static methods doesn't need objects to be called";
	}
}
