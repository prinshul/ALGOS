
public class Fibonacci {

	public static void main(String[] args) {
		Fibonacci f=new Fibonacci();
		System.out.println(f.fibo(8));
	}
	
	int fibo(int n)
	{
		if(n<=2)
			return 1;
		int sum= fibo(n-1)+fibo(n-2);
		return sum;
	}

}
