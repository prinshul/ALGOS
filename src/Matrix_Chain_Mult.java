import java.util.Hashtable;


public class Matrix_Chain_Mult {

	int N=6;
	int p[]=null;
	int cost[][]=null;
	int s[][]=null;
	public static void main(String[] args) {
		Matrix_Chain_Mult m=new Matrix_Chain_Mult();
		m.init();
		m.matrix_Mult();
	}

	void init()
	{
		p=new int[N+1];
		cost=new int[N+1][N+1];
		s=new int[N+1][N+1];
		p[0]=30;
		p[1]=35;
		p[2]=15;
		p[3]=5;
		p[4]=10;
		p[5]=20;
		p[6]=25;
	}

	void matrix_Mult()
	{
		for(int i=1;i<=N;i++)
		{
			cost[i][i]=0;
		}

		for(int L=2;L<=N;L++)
		{
			for(int i=1;i<=N-L+1;i++)
			{
				int j=L+i-1;
				cost[i][j]=Integer.MAX_VALUE;
				int q;
				for(int k=i;k<j;k++)
				{
					q=cost[i][k]+cost[k+1][j]+p[i-1]*p[k]*p[j];
					if(q<cost[i][j])
					{
						cost[i][j]=q;
						s[i][j]=k;
					}
				}
			}
		}

		System.out.println("cost:"+cost[1][N]);
		boolean inAResult[]=new boolean[s.length];
		solution(s, 1, N,inAResult);
	}

	Hashtable<Integer, String>val=new Hashtable<Integer, String>();
	void solution(int s[][],int i,int j,boolean inAResult[])
	{
		if(j>i)
		{
			solution(s, i, s[i][j],inAResult);
			solution(s, s[i][j]+1,j,inAResult);
			String istr = inAResult[i] ? "_result " : " ";
			String jstr = inAResult[j] ? "_result " : " ";
			System.out.println(" A_" + i + istr + "* A_" + j + jstr);
			inAResult[i] = true;
			inAResult[j] = true;
		}
	}
}
