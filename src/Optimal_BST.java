
public class Optimal_BST {

	public static void main(String[] args) {
		Optimal_BST o=new Optimal_BST();
		o.init();
	}

	void init()
	{
		int keys[]={2,4,5,7};
		int freq[]={1,2,5,2};
		dCost(keys, freq);
	}

	void dCost(int keys[],int freq[])
	{
		int n=keys.length;
		int cost[][]=new int[n][n];
		for(int i=0;i<n;i++)
			cost[i][i]=i;

		for(int L=2;L<=n;L++)
		{
			for(int i=0;i<n-L+1;i++)
			{
				int j=i+L-1;
				int c=0;
				cost[i][j]=Integer.MAX_VALUE;
				for(int r=i;r<=j;r++)
				{
					c  =    (r>i? cost[i][r-1]:0)+
							(r<j? cost[r+1][j]:0)+
							sum(i,j,freq);
					if(c<cost[i][j])
						cost[i][j]=c;
				}
				
			}
		}
		System.out.println(cost[0][n-1]);
	}
	int sum(int i,int j,int freq[])
	{
		int sum=0;
		for(int k=i;k<=j;k++)
			sum=sum+freq[k];
		return sum;
	}
}
