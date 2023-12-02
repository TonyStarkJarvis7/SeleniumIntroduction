
public class CoreJavaBrushUp3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Strings
		//In Java, String is an object which represents a sequence of characters or *array of characters but not directly an array
		//In Java, if 2 String variables carry the same value, at that time multiple objects are not
		//created, infact the other variable having the same value as the first variable will point to
		//the first variable
		String s="Alpha"; //THis is STRING LITERAL METHOD of String Creation
		String s1="Alpha";
		String s2="Echo"; // Here new memory will be allocated as the value the obj holds is different.
		//Here, as variables 's' and 's1' carry the same value. Java doesn't create a separate object 
		//memory alocation if 's1' but will point back to the first object 's' as the values are same.
		
		//Other way of creating a string is that by using "new" Operator
		String f=new String("Beta");
		String f1=new String("Beta"); 
		//In this method, Java does separate memory allocation to both objects(f,f1) though both 
		//variables contain same values. This happens because we are explicitly saying it to java by 
		//giving the 'new' operator, asking java to give separate memory space.
		
		//Splitting of string based on the delimiter we will be passing
		String splt="Alpha Beta Charlie Echo";
		String splittedString[]=splt.split(" ");//obj.split() method will split based on the demlimiter
		//value we pass. Here we passed the value as space(" ") stating the obj.split() method to split
		//the string at every space. 
		//Now the splitted strings needs to be taken into an array (here:splittedString[]) to extract 
		//the values
		
		//We can access the extracted values in the following ways
		System.out.println(splittedString[0]);
		System.out.println(splittedString[1]);
		System.out.println(splittedString[2]);
		System.out.println(splittedString[3]);
		System.out.println("-------------------");
		
		//We can access the extracted values using for loop also
		for(String i: splittedString) {//We are extracting the values of array(splittedString[]) using Enhanced For Loop
			System.out.println(i);
		}
		
		//Splitting based on word
		System.out.println("--------------------\nSplitting based on word: ");
		String wordSplittedString[]=splt.split("Charlie"); //This split would consider the entire string
		//left to Charlie into index[0] and the entire right part of charlie into index[1].
		System.out.println(wordSplittedString[0]); //THis would print "Alpha Beta"
		System.out.println(wordSplittedString[1]); //This would print " Echo". To trim the space before
		//" Echo" we need to use the use the method trim which will remove the spaces before and after the
		//word we use it on
		
		//Trim-> REmoves spaces before and after the string
		System.out.println("----------------\nTo use the Trim() method and remove the space before and after the word 'echo' :");
		System.out.println(wordSplittedString[1].trim());
		
		//To print each character of the string by iterating through it
		System.out.println("----------------\nTo print characters of the complete String");
		for(int i=0; i<splt.length(); i++) {
			System.out.println(splt.charAt(i)+" - Index Value: "+i);
		}
		//The method obj.charAt() splits the string into individual characters 
		
		//TO print the string in reverse
		System.out.println("To print the String in reverse order: ");
		for(int i=splt.length()-1; i>=0; i--) { //Focus on the conditions of the For loop
			System.out.println(splt.charAt(i)+" - Index Value: "+i);
		}
	}

}
