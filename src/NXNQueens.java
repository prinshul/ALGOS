
public class NXNQueens {

	int placed[];
	public static void main(String[] args) {

		NXNQueens nq= new NXNQueens();
		nq.init(4);
		nq.NQueens(1, 4);
	}

	void init(int n)
	{
		placed=new int[n+1];
	}
	void NQueens(int k,int n)
	{
       for(int i=1;i<=n;i++)
       {
    	   if(place(k,i))
    	   {
    		   placed[k]=i;
    		   if(k==n)
    			   {
    			     printPos(n);
    			     System.out.println();
    			     return;
    			   }
    		   else
    			   NQueens(k+1, n);
    	   }
       }
       placed[k]=-1;
	}

	boolean place(int k,int i)
	{
		for(int j=1;j<=k-1;j++)
		{
			if(placed[j]==i ||                              //same col
					Math.abs(k-j)==Math.abs(placed[j]-i))   //same diagnol
				return false;
		}
		return true;
	}
	
	void printPos(int n)
	{
		for(int i=1;i<=n;i++)
		{
			System.out.println(i+","+placed[i]);
		}
	}
}
