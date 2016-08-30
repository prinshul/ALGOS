import java.util.ArrayList;
import java.util.Hashtable;

public class RadixSort {

	public static void main(String[] args) {
		int a[]={2,34,567,5,68,89,432,10};
		for(int j=0;j<3;j++)
		{
			Hashtable<Integer, ArrayList<Integer>> lists=new Hashtable<Integer, ArrayList<Integer>>();
			for(int i=0;i<a.length;i++)
			{
				int val=(int)Math.pow(10, j);
				int num=a[i]/val;
				if(lists.get(num%10)==null)
				{
					ArrayList<Integer> list=new ArrayList<Integer>();
					list.add(a[i]);
					lists.put(num%10, list);
				}
				else
					lists.get(num%10).add(a[i]);
			}
			int k=0;
			for(int i=0;i<=9;i++)
			{
				if(lists.get(i)!=null)
				{
					for(int x: lists.get(i))
					{
						a[k]=x;
						k++;
					}
				}
			}
			
		}
		for(int k=0;k<a.length;k++)
			System.out.println(a[k]);
	}

}
