
public class Insertion {

	public static void main(String args[])
	{
		int A[]={7,9,0,4,2,11,1};
		insertionSort(A,A.length);
	}
	
	static void insertionSort(int A[],int n)
	{
		      for (int j=1;j<n;j++)
				{
			       int key=A[j];
			       int i=j-1;
			       while (i>=0 && A[i]>key)
			       {
			    	   A[i+1] = A[i];
			    	   i--;
			       }
			       A[i+1] =key;
				}
		      for(int i=0;i<n;i++)
		  		System.out.println(A[i]);
	}
}
