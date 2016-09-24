
public class Longest_Increasing_Subsequence {

	int arr[]={6,7,2,6,8,10,3,11,4,15,6,-1};
	int LS[]=new int[arr.length];
	public static void main(String[] args) {
		Longest_Increasing_Subsequence l=new Longest_Increasing_Subsequence();
		l.longIncreasingSeq();
	}

	void longIncreasingSeq()
	{
		for(int i=0;i<arr.length;i++)
		{
			LS[i]=1;
		}	
		for(int i=1;i<arr.length;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[i]>arr[j] && LS[i]<LS[j]+1)
				{
					LS[i]=LS[j]+1;
				}
			}
		}
		int max=0;
		for(int i=0;i<arr.length;i++)
		{
			if(LS[i]>max)
				max=LS[i];
		}
		System.out.println(max);
	}

}
