
public class MultidimentionalArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = {{88,45,102},{34,24,1},{85,42,99}};
		int small=a[0][0];
		int columnNumber = 0;
		int maxColumnNumberValue;
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {		
					if(a[i][j]<small) {
						small=a[i][j];
					}
				System.out.print(a[i][j]+",");
			}
			System.out.println("");
		}
		System.out.println("-----------\n"+"small: "+small);
		
		System.out.println("----------------");
		int max=a[0][0];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {		
					if(a[i][j]>max) {
						max=a[i][j];
					}
				//System.out.print(a[i][j]+",");
			}
			//System.out.println("");
		}
		System.out.println("max: "+max);
		
		
		
	/*	
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {		
					if(a[i][j]<small) {
						small=a[i][j];
						columnNumber=j;
					}
				System.out.print(a[i][j]+",");
			}
			System.out.println("");
		}
		System.out.println("-----------\n"+"small: "+small);
		System.out.println("-----------\n"+"ColumnNumber: "+columnNumber);
		maxColumnNumberValue=a[0][columnNumber];
		int k = 0;
		while(k<3) {
			if(maxColumnNumberValue<a[k][columnNumber]) {
				maxColumnNumberValue=a[k][columnNumber];
			}
			k++;
		}
		System.out.println(maxColumnNumberValue);*/
	}

}
