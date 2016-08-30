import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;


public class Find_Cycle_Directed_Graph {

	LinkedList<Character>adj[];
	int v;
	ArrayList<Character> nodes=new ArrayList<Character>();
	HashSet<Character>grey=new HashSet<Character>();
	HashSet<Character>black=new HashSet<Character>();
	Find_Cycle_Directed_Graph(int v)
	{
		this.v=v;
		adj=new LinkedList[v];
		for(int i=0;i<v;i++)
			adj[i]=new LinkedList<Character>();
	}
	public static void main(String[] args) {
		Find_Cycle_Directed_Graph fc=new Find_Cycle_Directed_Graph(5);
		fc.start();
	}
	void start()
	{
		nodes.add('a');
		nodes.add('b');
		nodes.add('c');
		nodes.add('d');
		nodes.add('e');
		nodes.sort(null);

		addEdgde('a', 'b');
		addEdgde('b', 'e');
		addEdgde('e', 'd');
		addEdgde('d', 'c');
		addEdgde('a', 'c');
		addEdgde('b', 'd');
		addEdgde('a', 'e');

		boolean isCycle=false;
		for(char node: nodes)
		{
			if(!black.contains(node))
			{
				grey.add(node);
				isCycle=isCycle(node);
				if(isCycle)
					break;
			}
		}
		System.out.println(isCycle);
	}

	boolean isCycle(char node)
	{
		boolean cycle=false;
		LinkedList<Character>n=adj[nodes.indexOf(node)];
		for(char c: n)
		{
			if(grey.contains(c))
			{
				return true;
			}
			if(!black.contains(c))
			{
				grey.add(c);
				cycle=isCycle(c);
			}
		}
		black.add(node);
		grey.remove(node);
		return cycle;
	}

	void addEdgde(char u,char v)
	{
		adj[nodes.indexOf(u)].add(v);
	}
}
