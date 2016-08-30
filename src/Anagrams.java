import java.util.HashSet;

public class Anagrams {
	

   static HashSet<String> permutations=new HashSet<String>(); 
   
	public static void main(String args[])
	{
		permute("aba");
		for(String word: permutations)
		{
			System.out.println(word);
		}
	}
	
	static void permute(String str)
	{
		permutations=permuteIT(str);
	}
	
	static HashSet<String> permuteIT(String str)
	{
		HashSet<String> temp=new HashSet<String>(); 
		if(str==null)
		{
			return null;
		}
		else if(str.equals(""))
		{
			temp.add("");
			return temp;
		}
		
		char c=str.charAt(0);

		HashSet<String> words=permuteIT(str.substring(1));
		for(String word: words)
		{
			for(int i=0;i<=word.length();i++)
			{
				temp.add(insert(word,i,c));
			}
		}
		
		return temp;
	}
	
	static String insert(String word,int i,char c)
	{
		return word.substring(0,i)+c+ word.substring(i);
	}
}
