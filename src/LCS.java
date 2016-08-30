
public class LCS {
  
	public static void main(String args[])
	{
		String X = "XMJYAUZ";
		String Y = "MZJAWXU";
		findLCS(X,Y);
	}
	
	
	static void findLCS(String  X, String Y)
	{
		int m =X.length();
		int n=Y.length();
		Integer LCSArr[][]= new Integer[m+1][n+1];
		for (int i=0;i<=m;i++)
		{
			LCSArr[i][0]=0;
		}
		for (int i=0;i<=n;i++)
		{
			LCSArr[0][i]=0;
		}
		for (int i=1;i<=m;i++)
		{
			for (int j=1;j<=n;j++)
			{
				if(X.charAt(i-1)==Y.charAt(j-1))
				{
					LCSArr[i][j]= LCSArr[i-1][j-1]+1;
				}
				else
				{
					if(LCSArr[i-1][j] > LCSArr[i][j-1])
					{
						LCSArr[i][j]=LCSArr[i-1][j];
					}
					else
					{
						LCSArr[i][j]=LCSArr[i][j-1];
					}
				}
			}
		}
		int LCSValue = LCSArr[m][n];
		Character LCSVal[] = new Character[LCSValue+1];
		LCSVal[LCSValue]='\0';
		int i=m;
		int j=n;
		while(i>0 && j>0)
		{
			if(X.charAt(i-1)==Y.charAt(j-1))
			{
				LCSVal[LCSValue-1]=X.charAt(i-1);
				LCSValue--;
				i--;
				j--;
				
			}
			else
			{
				if(LCSArr[i-1][j] > LCSArr[i][j-1])
				{
					i--;
				}
				else
				{
					j--;
				}
			}
		}
		
		System.out.println(LCSArr[m][n]);
		for (i=0;i<LCSVal.length-1;i++)
		System.out.print(LCSVal[i]);
	}
	
}
