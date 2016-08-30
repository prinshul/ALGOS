
public class Quicksort {

	public static void main(String[] args) {
		new Quicksort().sort();
	}

	void sort()
	{
		int A[]={3,5,1,23,7,8,12,9,11};
		QuickSort(A,0,8);
		for(int i=0;i<A.length;i++)
			System.out.println(A[i]);
	}

	void QuickSort(int A[], int p,int r)
	{
		if(p<r)
		{
			int q= partition(A, p,r);
			QuickSort(A,p,q-1);
			QuickSort(A,q+1,r);
		}
	}

	int partition(int A[], int p,int r)
	{
		int i=p-1;
		int x=A[r];
		int temp;
		for(int j=p;j<=r-1;j++)
		{
			if(A[j]<=x)
			{
				i=i+1;
				temp=A[i];
				A[i]=A[j];
				A[j]=temp;
			}
		}
		temp=A[i+1];
		A[i+1]=A[r];
		A[r]=temp;
		return i+1;
	}
}
