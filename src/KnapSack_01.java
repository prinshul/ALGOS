
public class KnapSack_01 {

	public static void main(String[] args) {
		new KnapSack_01().startAlgo();
	}

	void startAlgo()
	{
		int w[]={0,10,5,16,22,1,40,21};
		int v[]={0,7,14,11,5,3,9,6};
		int bag = 50;
		int m[][]=new int[8][51];

		for (int i=0;i<=50;i++)
			m[0][i]=0;
		for(int i=1;i<=7;i++)
		{
			for (int j=0;j<=50;j++)
			{
				if(w[i]>j)
				{
					m[i][j]=m[i-1][j];
				}
				else
				{
					m[i][j]=Math.max(m[i-1][j],m[i-1][j-w[i]]+v[i]);
				}
			}
		}
		System.out.println(m[7][50]);
        int row=7;
        int col=50;
        while(row>0 && col>0)
        {
        	if(m[row][col]==m[row-1][col])
        	{
        		row--;
        	}
        	else
        	{
        		System.out.println("item:"+row+" ("+row+","+col+")");
        		col=col-w[row];
        		row--;
        	}
        }
	}
}
