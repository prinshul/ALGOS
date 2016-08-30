
public class RabinKarp {

	public static void main(String[] args) {
		new RabinKarp().start();
	}

	void start()
	{
		String T="SZzzyyshdjdRitr";
		int n=T.length();
		String P="Ritr";
		double  m= P.length();
		double d=52;
		int q=101;
		double h= Math.floorMod((int)(Math.pow(d, m-1)),q);

		double p=0;
		double t0=0;

		double t;
		for(int i=0;i<m;i++)
		{
			p=Math.floorMod((int)(d*p+P.toCharArray()[i]),q);
			t0=Math.floorMod((int)(t0*d+T.toCharArray()[i]),q);
		}
		t=t0;
		double temp;
		for(int s=0;s<=n-m;s++)
		{
			if(p==t)
			{
				int len=0;
				for(int i=0;i<m;i++)
				{
					if(P.toCharArray()[i]==T.toCharArray()[s+i])
						len++;
				}
				if(len==m)
				{
					System.out.println("Found at:"+s);
					return;
				}
			}
			if(s<n-m)
			{
				temp=t;
				t= Math.floorMod((int)(d*(temp-h*T.toCharArray()[s])+T.toCharArray()[(int) (s+m)]),q);
			}
		}
	}

}
