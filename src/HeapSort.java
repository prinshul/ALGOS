
public class HeapSort {


	static int heapsize;
	public static void main(String[] args) {
		
		int a[]={5,1,25,6,8,3,7,0,-9};
		build_heap(a);
		heap_insert(a, 33);
		//increase_key(a, 8, 10);
		//extract_max(a);
		//heapsort(a);
//			for(int i=0;i<a.length;i++)
//				System.out.println(a[i]);
	}

	static void increase_key(int a[],int i,int key)
	{
		if(key<a[i])
			System.out.println("cannot inc");
		a[i]=key;
		while(i>0 && a[i/2]<key)
		{
			int temp=a[i];
			a[i]=a[i/2];
			a[i/2]=temp;
			i=i/2;
		}

	}
	
	static void heap_insert(int a[],int key)
	{
		int b[]=new int[10];
		for(int i=0;i<a.length;i++)
			b[i]=a[i];
		heapsize++;
		b[heapsize-1]=-9999;
		
		increase_key(b, heapsize-1, key);
		for(int i=0;i<b.length;i++)
			System.out.println(b[i]);
	}

	static void extract_max(int a[])
	{
		if(heapsize<0)
			System.out.println("error");
		int max;
		max=a[0];
		a[0]=a[heapsize-1];
		heapsize--;

		heapify(a, 0);
		System.out.println(max);
	}

	static void heapsort(int a[])
	{
		build_heap(a);
		for(int i=a.length-1;i>=0;i--)
		{
			int temp=a[0];
			a[0]=a[i];
			a[i]=temp;
			heapsize--;
			heapify(a, 0);
		}
	}

	static void build_heap(int a[])
	{
		heapsize=a.length;
		for(int i=(a.length/2);i>=0;i--)
		{
			heapify(a, i);
		}
	}
	static void heapify(int a[],int i)
	{
		int largest;
		int l=2*i;
		int r=(2*i)+1;

		if(l<heapsize && a[l] > a[i])
		{
			largest=l;
		}
		else
			largest =i;
		if(r<heapsize && a[r] > a[largest])
		{
			largest=r;
		}
		if(largest!=i)
		{
			int temp=a[i];
			a[i]=a[largest];
			a[largest]=temp;
			heapify(a, largest);
		}
	}
}
