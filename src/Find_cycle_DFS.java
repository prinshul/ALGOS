import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;


public class Find_cycle_DFS {

	int v;
	LinkedList<Character> adj[];
	static ArrayList<Character> nodes=new ArrayList<Character>();
	Hashtable<Character, Character>parent=new Hashtable<Character, Character>();

	Find_cycle_DFS(int v)
	{
		this.v=v;
		adj=new LinkedList[v];
		for(int i=0;i<v;i++)
			adj[i]=new LinkedList<Character>();
	}
	public static void main(String[] args) {
		Find_cycle_DFS fc=new Find_cycle_DFS(6);
		nodes.add('A');
		nodes.add('C');
		nodes.add('B');
		nodes.add('E');
		nodes.add('D');
		nodes.add('F');
		nodes.sort(null);

		fc.addEdge('A', 'B');
		fc.addEdge('B', 'C');
		fc.addEdge('B', 'E');
		fc.addEdge('C', 'D');
		fc.addEdge('A', 'E');

		System.out.println(fc.findCycle());

	}

	boolean findCycle()
	{
		boolean cycle=false;
		for(int i=0;i<v;i++)
		{
			if(parent.get(nodes.get(i))==null)
			{
				parent.put(nodes.get(i), '#');
				cycle= isCycle(nodes.get(i));
				if(cycle)
					break;
			}

		}
		return cycle;
	}

	int getIndex(char node)
	{
		return nodes.indexOf(node);
	}

	void addEdge(char u,char v)
	{
		adj[getIndex(u)].add(v);
	}

	boolean isCycle(char node)
	{
		boolean cycle=false;
		LinkedList<Character> nodes=adj[getIndex(node)];
		for(char c: nodes)
		{
			if(parent.get(c)==null)
			{
				parent.put(c, node);
				cycle=isCycle(c);
			}
			else
				cycle= true;

		}
		return cycle;
	}

}
