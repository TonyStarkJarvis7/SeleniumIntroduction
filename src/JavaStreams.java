import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class JavaStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//To Use Java Streams
		ArrayList<String> ar=new ArrayList();
		ar.add("Azkansha");ar.add("Akshay"); ar.add("Sha");
		ar.add("Sing");ar.add("Arjun"); int count=0;
		/*for(int i=0;i<ar.size();i++) {//the Usual way of executing 
			String actual=ar.get(i);
			if(actual.startsWith("A")) {
			count++;
			}
		}
		System.out.println(count);*/
		
		//Solving the above problem with Streams
		long c=ar.stream().filter(i->i.startsWith("A")).count(); System.out.println(c);
		//First the ArrayList is converted into stream ('<ArrayListName>.stream()') then intermediate operations
		//are made i.e .filter(<iterator>[lamda->]<iterator>.<method>(<Argument>) FOLLOWED by .terminal operation
		//in this case i.e .count().
		//In Streams, Long is used instead of int to store the value of count
		//There is no life for intermediate operations without terminal operations
		//Terminal operation will ONLY EXECUTE if Intermediate Operation returns TRUE 
		
		//For Practice
		//Stream.of("Akansha","Akshay","Akshay","Akshay","Akshay").filter((i->i.startsWith("A")));
		long d=Stream.of("Azkansha","Akshay","Shashank","Singham","Arjun").filter(i->{
			i.startsWith("A");//Intermediate operation
			return true;      //The Boolean result which the intermediate operation is returning
		}).count(); 
		//Terminal operation(.count()) will purely be depended on the boolean result which the intermediate 
	   //operation provides. Here if 'false' is returned then the count() will give out 0. 
				
		ar.stream().filter(i->i.length()>4).forEach(i->System.out.println("Names of length>4: "+i));
		//This stream creates a sub-stream of those words with length>4 and then 
		//for-each of those elements in substring we are printing them out
		
		//To Print only the first value of the arrayList with the above condition for which we use limit() which is a terminal operation(Basically takes only first few depending on the limit value)
		ar.stream().filter(i->i.length()>4).limit(1).forEach(i->System.out.println("Printing only one element using Limit: "+i));
		
		//TO PRINT THE RESULTS IN UPPERCASE 
		//TO do this we Need "map". 
		//map is used to do any Modifications of a sub-stream made, etc or for just modifications also 
		ar.stream().filter(i->i.endsWith("a")).map(i->i.toUpperCase()).forEach(i->System.out.println("Using Map: "+i));
		
		//TO PRINT NAMES OF ARRAYLIST STARTING WITH A, UPPERCASE AND SORTED MANNER
		ar.stream().filter(i->i.startsWith("A")).sorted().map(i->i.toUpperCase()).forEach(i->System.out.println("Sorted and uppercase: "+i));
		
		
		//To merge two lists and sort them
		//We have one arrayList above and we'll create a new one below
		System.out.println("Merged and sorted Stream: ");
		List<String> newList=Arrays.asList("Alpha","Beta","Omega","Delta");
		Stream<String> mergedStream=Stream.concat(ar.stream(), newList.stream());//where ar and newList are two lists which are converted to Streams and merged using Stream.concat(list1.stream,list2.stream)	
		//mergedStream.sorted().forEach(i->System.out.print(i+","));//sorting the mergedStream and printing the values
		//Commented mergedstream above for other operations as once it is executed, we can't use it for other operations again it seems as for boolean
		
		boolean flag=mergedStream.anyMatch(i->i.equalsIgnoreCase("Omega"));
		System.out.println(flag);
		Assert.assertTrue(flag);
		
		//To take a list(ar)-> Convert into a stream-> perform manipulations-> and converting and collecting into a list(ls) again
		List<String> ls=ar.stream().map(i->i.toUpperCase()).collect(Collectors.toList());		
		System.out.println(ls.get(0));
		
		
		System.out.println("Trying a question below from the video:--------------");
		List<Integer> intValues=Arrays.asList(3,2,2,7,5,1,9,7);
		//to sort and print 3rd index value
		//get distinct/unique values
		intValues.stream().distinct().forEach(i->System.out.println("Distinct values: "+i));
		List<Integer> sortedvalues=intValues.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(sortedvalues.get(2));
	}

}
