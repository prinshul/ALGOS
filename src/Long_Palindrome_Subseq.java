import java.util.ArrayList;


public class Long_Palindrome_Subseq {

	String str="raddar";
	int cost[][]=new int[str.length()][str.length()];
	public static void main(String[] args) {
		Long_Palindrome_Subseq l=new Long_Palindrome_Subseq();
		l.findSeq();
	}
	void findSeq()
	{
		for(int i=0;i<str.length();i++) 
		{
			cost[i][i]=1;
		}

		for(int L=2;L<=str.length();L++)
		{
			for(int i=0;i<str.length()-L+1;i++)
			{
				int j=L+i-1;
				if(str.toCharArray()[i]==str.toCharArray()[j])
				{
					if(i+1==j)
						cost[i][j]=2;
					else
						cost[i][j]=2+cost[i+1][j-1];
				}
				else
					cost[i][j]=Math.max(cost[i][j-1],cost[i+1][j]);
			}
		}
		System.out.println("Length of longest palindromic subsequence:"+cost[0][str.length()-1]);
		print();
	}

	void print()
	{
		ArrayList<Integer>list=new ArrayList<Integer>();
		int i=0;
		int j=str.length()-1;
		while(i<=j)
		{
			if(i==j)
			{
				list.add(i);
				break;
			}
			if(cost[i][j-1]!=cost[i][j] && cost[i+1][j]!=cost[i][j])
			{
				list.add(i);
				list.add(j);
				i++;
				j--;
			}
			else
			{
				if(cost[i][j-1]==cost[i][j])
				{
					j--;
				}
				else
				{
					i++;
				}
			}
		}
		list.sort(null);
		for(int x: list)
			System.out.print(str.toCharArray()[x]);
	}
}
