import java.util.Iterator;
import java.util.Stack;


public class Edit_Distance {

	String X="abnc";
	String Y="ax";
	int cost[][]=new int[X.length()+1][Y.length()+1];
	public static void main(String[] args) {
		Edit_Distance e=new Edit_Distance();
		e.init();
		e.edist();
	}

	void init()
	{
		for(int i=0;i<=X.length();i++)
			cost[i][0]=i;

		for(int j=0;j<=Y.length();j++)
			cost[0][j]=j;
	}

	void edist()
	{
		for(int i=1;i<=X.length();i++)
		{
			for(int j=1;j<=Y.length();j++)
			{
				if(X.toCharArray()[i-1]==Y.toCharArray()[j-1])
				{
					cost[i][j]=cost[i-1][j-1];
				}
				else
				{
					cost[i][j]=Math.min(cost[i-1][j],Math.min(cost[i][j-1], cost[i-1][j-1]))+1;
				}
			}

		}
		System.out.println(cost[X.length()][Y.length()]);
		printSol();
	}

	void printSol()
	{
		int i=X.length();
		int j=Y.length();
		Stack<String>s=new Stack<String>();
		while(i!=0 && j!=0)
		{
			if(X.toCharArray()[i-1]!=Y.toCharArray()[j-1])
			{
				int val=Math.min(cost[i-1][j],Math.min(cost[i][j-1], cost[i-1][j-1]));
				if(cost[i-1][j]==val)
				{
					s.push(X.toCharArray()[i-1]+" deleted");
					i--;

				}
				else if(cost[i][j-1]==val)
				{
					s.push(X.toCharArray()[i-1]+" inserted");
					j--;
				}
				else
				{
					s.push(X.toCharArray()[i-1]+" converted to "+Y.toCharArray()[j-1]);
					i--;
					j--;
				}
			}
			else
			{
				i--;
				j--;
			}
		}
		while(i!=0)
		{
			s.push(X.toCharArray()[i-1]+" deleted");
			i--;
		}
		while(j!=0)
		{
			s.push(Y.toCharArray()[j-1]+" inserted");
			j--;
		}
		
		Iterator<String>loop=s.iterator();
		while(loop.hasNext())
		{
			System.out.println(s.pop());
		}
	}
}
