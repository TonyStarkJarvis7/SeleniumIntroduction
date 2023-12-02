
public class MultiDimentionalQuestion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("------To find the largest number in the coloumn which has the smallest number------------");
		int a[][]= {{5,6,2},{4,5,1},{7,8,9}};
		int minValue=a[0][0];
		int minColumn=0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(minValue>a[i][j]) {
					minValue=a[i][j];
					minColumn=j;
				}
			}
		}
		System.out.println("Minimum Value: "+minValue+" and the Column is :"+minColumn);
		
		int k=0;
		int max=a[0][minColumn];
		while (k<3) {
			if(max<a[k][minColumn]) {
				max=a[k][minColumn];
		
			}
			k++;
		}
		System.out.println("Max value in that column is :"+max);
	}

}
