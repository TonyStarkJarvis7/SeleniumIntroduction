
public class CoreJavaBrushUp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=5; //int is a primitive data type
		String website="text"; //String is a non-primitive data type
		char c = 'c';
		double dec = 5.36;  //double or float data type for decimals
		boolean mycard  = true; // boolean dataype is used for true or false
		
		System.out.println(num +" is the value stored in NUM"); //We give + Symbol as it differentiates
		//between integer and string. They can be concatenated only through 
		//+ operator=stands for concatenation 
		
		/*System.out.println(website);
		System.out.println(c);
		System.out.println(dec);
		System.out.println(mycard);*/
		
		//Arrays-> Can store multiple values in a single Variable
		//Declaring an array can be done in any of the following ways. Here both arrays can store 5 int
		//values
		int a1[] = new int[5];  
		int[] a2 = new int[5];
		
		//To store fixed values in the arrays
		a1[0]=1; a1[1]=2; a1[2]=3; a1[3]=4; a1[4]=5;
		//or this can be done in the below way also
		/*int[] ar-> or -> */int ar[] = {1,2,3,4}; //initializing the array
		
		System.out.println(a1[2]); //This prints out the value stored in an array "a1" in the index 2.
		
		//For Loop
		System.out.print("Printing the values of the array 'a1'= ");
		for(int i=0; i<a1.length; i++) { //<array>.length method can be used to know or use the length of Array 
			if(i<a1.length-1) { //Using the if loop to avoid an extra ',' and extra space in the end of the output
				System.out.print(a1[i]+", ");
			}else {
				System.out.println(a1[i]);
			}
		}
		
		//Similarly For loop can be used for Strings As well
		String name[]= {"Alpha","Beta", "Delta"};
		System.out.print("The values stored in a string variable 'name' = ");
		for(int i=0; i<name.length; i++) {
			if(i<name.length-1) {
				System.out.print(name[i]+", ");
			}else {
				System.out.println(name[i]);
			}	
		}
		
		//ENCHANCED FOR LOOP
		for(String n: name) {//this enhanced for loop iterates one by one on the array "name" and 
			System.out.println(n);
		}
		
		//Break Keyword is used to break a loop once our requirement is achieved.
		//Lets test break by using it on the number array and check if there is a number in the array 
		//which is a multiple of 2 and we want to stop the array as soon as it finds the first instance
		// which is a multiple of 2
		System.out.println("We are checking multiple of 2 while the main agenda is to user Break");
		for(int i=0; i<a1.length;i++) {
			if(a1[i]%2==0) {
				System.out.println(a1[i]);
				break; //The loop stopped as soon as it found its first multiple.
			}else {
				System.out.println(a1[i]+" is not a multiple of 2");
			}
		}
		
		
	}

}
