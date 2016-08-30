import java.util.LinkedList;
//undirected graph
public class Hamiltonian_Cycle {

	static int TN=6;
	int StartV;
	LinkedList<Integer> adj[]=null;
	int path[]=null;
	public Hamiltonian_Cycle() {
		adj=new LinkedList[TN];
		path=new int[TN];
		for(int i=0;i<TN;i++)
			adj[i]=new LinkedList<Integer>();
	}

	public static void main(String[] args) {
		Hamiltonian_Cycle c=new Hamiltonian_Cycle();
		c.init();
	}

	void init()
	{  
		int n0=0;
		int n1=1;
		int n2=2;
		int n3=3;
		int n4=4;
		int n5=5;

		adj[0].add(n1);
		adj[0].add(n3);
		adj[0].add(n4);
		adj[0].add(n5);

		adj[1].add(n0);
		adj[1].add(n3);
		adj[1].add(n2);

		adj[2].add(n1);
		adj[2].add(n3);

		adj[3].add(n2);
		adj[3].add(n1);
		adj[3].add(n0);
		adj[3].add(n4);

		adj[4].add(n0);
		adj[4].add(n3);
		adj[4].add(n5);

		adj[5].add(n0);
		adj[5].add(n4);

		path[0]=0;
		for(int i=1;i<TN;i++)
			path[i]=-1;
		if(isHamCycle(1))
		{
			System.out.println("Hamiltonian cycle present!");
			for(int i=0;i<TN;i++)
			{
				System.out.print(path[i]+"->");
			}
			System.out.print(path[0]);
			return;
		}

		System.out.println("Hamiltonian cycle not present!");
	}

	boolean isHamCycle(int pos)
	{
		if(pos==TN)
		{
			if(adj[path[pos-1]].contains(path[0]))
				return true;
			else
				return false;
		}
		for(int v=1;v<TN;v++)
		{
			if(isSafe(pos, v))
			{
				path[pos]=v;
				if(isHamCycle(pos+1))
					return true;

				path[pos]=-1;
			}
		}
		return false;
	}

	boolean isSafe(int pos,int vertex)
	{
		if(!(adj[path[pos-1]].contains(vertex)))
			return false;
		for(int i=0;i<pos;i++)
		{
			if(path[i]==vertex)
				return false;
		}
		return true;
	}
}
