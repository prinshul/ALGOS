import java.util.ArrayList;


public class SubSets {

	public static void main(String[] args) {
		char a[]={'a','b','c'};
		SubSets s=new SubSets();
		s.findSub(a);
	}

	void findSub(char []a)
	{
		int range=(int) Math.pow(2, a.length);
		for(int i=0;i<range;i++)
		{ 
			int num=i;
			int bits[]=new int[a.length];
			for(int j=a.length-1;j>=0;j--)
			{
				bits[j]=num%2;
				num=num/2;
			}
			String set="{";
			String binary="";
			for(int j=0;j<a.length;j++)
			{
				if(bits[j]==1)
				set=set+a[j]+",";
				
				binary=binary+bits[j];
			}
			if(set.endsWith(","))
			{
				set=set.substring(0, set.length()-1);
			}
			set=set+"}";
			System.out.println(set);
			System.out.println(binary);
		}
	}
}
