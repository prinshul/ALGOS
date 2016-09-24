
public class Coin_Change_DP {

	public static void main(String[] args) {
		Coin_Change_DP l=new Coin_Change_DP();
		l.init();
	}

	void init()
	{
		int coins[]={7,2,3,6};
		int sum = 13;
		findCoins(coins, sum);
	}
	void findCoins(int coins[],int sum)
	{
		int arr[]=new int[sum+1]; 
		arr[0]=0;
		for(int i=1;i<=sum;i++)
			arr[i]=Integer.MAX_VALUE-2;
		int coin_index[]=new int[sum+1];
		for(int i=0;i<=sum;i++)
			coin_index[i]=-1;
		for(int i=0;i<coins.length;i++)
		{
			for(int j=1;j<arr.length;j++)
			{
				if(j>=coins[i])
				{
					if(arr[j] > 1+arr[j-coins[i]])
					{
						arr[j]=1+arr[j-coins[i]];
						coin_index[j]=i;
					}	
				}
			}
		}
		int rem_sum=sum;
		while(rem_sum>0)
		{
			int f_coin=coins[coin_index[rem_sum]];
			System.out.println(f_coin);
			rem_sum=rem_sum-f_coin;
		}
	}
}
