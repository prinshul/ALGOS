import java.util.ArrayList;


public class MaxSumSubarray {

	public static void main(String[] args) {
		calc();
		non_contiguous();
		contiguous();
	}
	
	static void calc()
	{
		int arr[]={-3,8,-58,-1,-2,-9,-4};
		int curr_max,glob_mx;
		int start=0,end=0;
		int temp=0;
		curr_max=glob_mx=arr[0];
		for(int i=1;i<arr.length;i++)
		{
			curr_max=curr_max+arr[i];
			if(curr_max<arr[i])
			{
				curr_max=arr[i];
				temp=i;
			}
			if(curr_max>glob_mx)
				{
				 glob_mx=curr_max;
				 start=temp;
				 end=i;
				}
		}
		System.out.println(glob_mx);
		System.out.println("start "+start+" end "+end);
	}
	
	static void non_contiguous()
	{
		int arr[]={-3,-1,-8,-58,1,-2,-3,-9,-3,1};
		int curr_sum=arr[0];
		int i;
		//int gm=arr[0];
		for(i=1;i<arr.length;i++)
		{
			curr_sum=Math.max(Math.max(curr_sum, curr_sum+arr[i]),arr[i]);
		}
		System.out.println(curr_sum);
		//System.out.println("start "+start+" end "+end);
	}
	static void contiguous()
	{
		int arr[]={-3,-11,-8,-58,-1,-2,-3,-9,-3,1};
		int curr_sum=arr[0];
		int i;
		int gm=arr[0];
		for(i=1;i<arr.length;i++)
		{
			curr_sum=Math.max(curr_sum+arr[i],arr[i]);
			if(curr_sum>gm)
				gm=curr_sum;
		}
		System.out.println(gm);
		//System.out.println("start "+start+" end "+end);
	}

}
