import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;


public class Test {

	public static void main(String[] args) {
		
		/*Random r=new Random();
		
		String array="";
		for(int j=1;j<=5000;j++)
		{
		
		String word="";
		int wordsize=1+r.nextInt(6);
		for(int i=1;i<=wordsize;i++)
		{
			int num=r.nextInt(26)+97;
			char c=(char) num;
			word=word+c;
		}
		array=array+"\""+word+"\""+",";
		}
		System.out.println(array);*/
		/*int a[]={2,5,1,4,0};
		ArrayList<Integer>sym =new ArrayList<Integer>();
		new Test().find(a,0,0,6,sym);*/
		
		new Test().XOR();
		
	}
	
	void print(ArrayList<Integer> sym)
	{
		for(int i=0;i<sym.size();i++)
			System.out.print(sym.get(i)+" " );
	}
	void find(int a[],int i,int res,int target,ArrayList<Integer> sym)
	{
		//int temp=res;
		if(i==a.length)
			{
			 if(res==target)
			 {
				 print(sym);
			     System.out.println();
			 }
			}
		else
		{
			res=res+a[i];
			sym.add(a[i]);
			find(a,i+1,res,target,sym);
			res=res-a[i];
			sym.remove((Integer)(a[i]));
			find(a,i+1,res,target,sym);
		}
		
	}
    void permute(String str)
    {
    	HashSet<String> permute=find(str);
    	System.out.println(permute);
    }
    
    HashSet<String> find(String str)
    {
    	HashSet<String> anagrams=new HashSet<String>();
    	if(str.equals(""))
    		{
    		  anagrams.add("");
    		  return anagrams;
    		}
    	
    	char c=str.charAt(0);
    	HashSet<String> list=find(str.substring(1));
    	for(String st: list)
    	{
    		for(int i=0;i<=st.length();i++)
    		anagrams.add(insert(st,c,i));
    	}
    	return anagrams;
    }
    
    String insert(String st,char c,int index)
    {
    	return st.substring(0,index)+c+st.substring(index);
    }
    
    void XOR()
    {
    	int a[]={1,2,3,4,4,5};
    	int x=2;
    	int y=1;
    	int b=0;
    	for(int i=0;i<a.length;i++)
    	{
    		b=b^a[i]^i;
    	}
    	System.out.println(b);
    }
}

