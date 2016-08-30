import java.lang.Character.Subset;


public class SubsetSum {

	public static void main(String[] args) {
		int a[]={7,8,11,3,4,78};
		int sum=33;
		SubsetSum s=new SubsetSum();
		System.out.println(s.findSum(a,sum));
	}

	boolean findSum(int a[],int sum)
	{
		boolean T[][]=new boolean[7][sum+1];
		for(int i=0;i<=a.length;i++)
			T[i][0]=true;
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<=sum;j++)
			{
				if(a[i]>j)
				{
					T[i+1][j]=T[i][j];
				}
				else
				{
					if(T[i][j])
						T[i+1][j]=T[i][j];
					else
					{
						T[i+1][j]=T[i][j-a[i]];
					}
				}
			}
		}
		int row=6;
		int col=sum;
		while(row>0 && col>0)
		{
			if(T[row][col]==T[row-1][col])
			{
				row--;
			}
			else
			{
				System.out.println(a[row-1]);
				col=col-a[row-1];
				row--;
				
			}
		}
		
		return T[6][sum];
	}
}
