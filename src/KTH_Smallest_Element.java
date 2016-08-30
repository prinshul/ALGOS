
public class KTH_Smallest_Element {

	public static void main(String[] args) {
		KTH_Smallest_Element k1=new KTH_Smallest_Element();
		int A[]={3,5,1,23,11,8,12,9,7};
		int k=1;  //k can be 1 to 9
		int element=k1.kthSmallest(A,0,A.length-1,k);
		System.out.println(element);
	}
	
	int kthSmallest(int A[],int p,int q,int i)
	{
		if(p==q)
			return A[p];
		int r=partition(A, p, q);
		int k =r-p+1;
		if(i==k)
			return A[r];
		else if(i<k)
		{
			return kthSmallest(A, p, r-1, i);
		}
		else
			return kthSmallest(A, r+1, q, i-k);
	}
	
	int partition(int A[],int p,int r)
	{
		int i=p-1;
		int x=A[r];
		int temp;
		for(int j=p;j<=r-1;j++)
		{
			if(A[j]<=x)
			{
				i++;
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
