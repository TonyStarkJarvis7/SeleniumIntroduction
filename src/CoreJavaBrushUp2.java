import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJavaBrushUp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ArrayList is used to dynamically increase the size of an array based on our need.
		//Initializing the size of an array statically is not helpful in real world scenarios.
		//Syntax: ArrayList al = new ArrayList(); ->Where 'al' is the obj of ArrayList
		//ArrayList is a class in Java
		//We create object's of a class to access the methods of that class. We can then call
		//the methods of that class by-> "object.method()"
		
		ArrayList al=new ArrayList(); //here we created an object 'al' to access the methods of the class
		//ArrayList
		
		//To make an ArrayList store only a specific type of data, we specify the data type after it as below:
		ArrayList<String> als=new ArrayList(); //here we created an object 'als' to access the methods of
		//the class ArrayList
		als.add("Alpha"); //Using the syntax 'obj.method' we access the methods like add using the object
							//This method helps to add values into the ArrayList
							//We can continue to add data into the ArrayList and as we keep adding data, the
							//size of the ArrayList will keep increasing dynamically
		als.add("Beta");
		als.add("Delta");
		
		System.out.println(als.get(2));//obj.get() method of ArrayList helps in extracting data in ArrayList
		
		for(int i=0;i<als.size(); i++) { //in ArrayList we use obj.size() and NOT obj.length().
			System.out.print(als.get(i)+","); //To Extract values of ArrayList we use obj.get()".
		}
		System.out.println("****");
		
		//Using Enhanced FOR Loop to print ArrayList
		System.out.println("Using enhanced For loop to print ArrayList:");
		for(String s:als) {
			System.out.println(s);
		}
		
		//How to use "Contains" in ArrayList
		System.out.println("We are checking the contains menthod of ArrayList Class: "+ als.contains("Alpha")); 
		//This method(obj.contains("")) is available only in ArrayList
		// and this cannot be used in static and normal Arrays unless the are converted into Lists as below.
		//ArrayList has some flexible methods where we can add, remove, clear, or add all elements at a time
		// by writing 'addall', etc.
		//All these are available from a package called 'util'.
		
		//How to execute the same functionality as above on normal/traditional array
		String name[]= {"Alpha","Beta", "Delta"};
		//We can pass this array as a list as below
		List<String> na = Arrays.asList(name); //We converted the above static array into list return type
		//and are sending that array value to a varaible 'na'.
		System.out.print("We are cheking the contains method after converting a static array into list: ");
		System.out.print(na.contains("Beta"));  //We are now able to use the obj.contains here also in the same as we used in
		//ArrayList above
		
	}

}
