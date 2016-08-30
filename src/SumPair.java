import java.util.HashMap;


public class SumPair {

	public static void main(String args[])
	{
		int sum=7;
		int arr[]={1,3,4,6};
		HashMap<Integer, Integer> store=new HashMap<Integer, Integer>();
		for(int i=0;i<arr.length;i++)
		{
			store.put(arr[i], arr[i]);
		}
		for(int i=0;i<arr.length;i++)
		{
			if(store.get(sum-arr[i])!=null)
			{
				System.out.println(arr[i]+","+store.get(sum-arr[i]));
			}
		}
	}
	
	
}
