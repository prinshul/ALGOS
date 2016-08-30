//Manacher's Algo  O(n) complexity
public class Long_Palindrome_Substring {
	String s="ccaacc";
	public static void main(String[] args) {
		Long_Palindrome_Substring s=new Long_Palindrome_Substring();
		s.findLPalinSub();
	}
	void findLPalinSub()
	{
		int C=0,R=0,mirr=0;
		int P[];
		String t="$";
		for(int i=0;i<s.length();i++)
		{
			t=t+"#"+s.toCharArray()[i];
		}
		t=t+"#"+"@";
		P=new int[t.length()];
		for(int i=0;i<t.length();i++)
		{
			P[i]=0;
		}
		for(int i=1;i<t.length()-1;i++)
		{
			mirr=2*C-i;
			if(i<R)
			{
				P[i]=Math.min(R-i, P[mirr]);
			}

			while(t.toCharArray()[i+(1+P[i])]==t.toCharArray()[i-(1+P[i])])
				++P[i];
			
			if(i+P[i]>R)
			{
				C=i;
				R=i+P[i];
			}
		}
		print(t,P);
	}
	
	void print(String t,int P[])
	{
		int maxIndex=0,maxlen=0;
		for(int i=0;i<P.length;i++)
		{
			if(maxlen<P[i])
			{
				maxlen=P[i];
				maxIndex=i;
			}
		}
		
		for(int i=maxIndex-maxlen+1;i<=maxlen+maxIndex;i++)
			if(t.toCharArray()[i]!='#')
			System.out.print(t.toCharArray()[i]);
	}

}
