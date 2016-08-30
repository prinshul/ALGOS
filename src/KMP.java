
public class KMP {

	public static void main(String[] args) {
	  new KMP().kmp_Compute();	
	}

	void kmp_Compute()
	{
		String T="SZzRitrRitRitRisRittRijdRitrRitRitRi";
		int n=T.length();
		String P="mnopmnpomnmn";
		int m= P.length();
		
		int q=0;
		int arr[]=precompute(P);
		for(int i=0;i<n;i++)
		{
			while(q>0 && P.toCharArray()[q]!=T.toCharArray()[i])
				q=arr[q-1];
			if(P.toCharArray()[q]==T.toCharArray()[i])
				q=q+1;
			if(q==m)
			{
				System.out.println("Match found at:"+(i+1-m));
				q=arr[q-1];
			}
			
		}
	}
	
	int[] precompute(String P)
	{
		int arr[]=new int[P.length()];
		int m=P.length();
		
		int q;
		int k=0;
		arr[0]=0;
		
		for(q=1;q<m;q++)
		{
			while(k>0 && P.toCharArray()[k]!=P.toCharArray()[q])
				k=arr[k-1];
			if(P.toCharArray()[k]==P.toCharArray()[q])
				k=k+1;
			arr[q]=k;		
		}
		return arr;
	}
}
