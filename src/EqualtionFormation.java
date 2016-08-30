
public class EqualtionFormation {

	boolean found;
	public static void main(String[] args) {
		EqualtionFormation e=new EqualtionFormation();
		e.init();
		int a[]={2,5,4,5,1,8,7,3};
		//int a[]={2,5,6,1};
		char sym[]=new char[a.length];
		e.formEquation(a, 0, 3, 0,sym);
		
		
		if(!e.getstatus())
			System.out.println("Eq cannot be formed");
	}
	
	void init()
	{
		found=false;
	}
	
	boolean getstatus()
	{
		return found;
	}

	void formEquation(int a[],int i,int target,int res,char []sym)
	{
		int temp=res;
		if(i==a.length)
		{
			if(res==target)
			{
				found=true;
				print(sym,a,target);
				return;
			}
		}

		else
		{
			res=res+a[i];
			sym[i]='+';
			formEquation(a, i+1, target, res,sym);

			temp=temp-a[i];
			res=temp;
			sym[i]='-';
			formEquation(a, i+1, target, res,sym);
		}
	}
	
	void print(char [] sym,int a[],int target)
	{
		String s =a[0]+"";
		for(int i=1;i<a.length;i++)
		{
			s=s+sym[i]+a[i];
		}
		System.out.println(s+"="+target);
	}

}
