import java.util.ArrayList;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Hashtable;


public class DFS {
	
	class Nodes 
	{
		char node;
		int startTime;
		int finishTime;
		public Nodes(char node,
		int startTime,
		int finishTime) {
			this.node=node;
			this.startTime=startTime;
			this.finishTime=finishTime;
		}
	}

	//Hashtable<Character,Boolean> visited=new Hashtable<Character,Boolean>();
	Hashtable<Character,Character> parent=new Hashtable<Character,Character>();
	Hashtable<Character,int[]> times=new Hashtable<Character,int[]>();
	int time=0;
	
	public static void main(String[] args) {
		DFS dfs=new DFS();
		dfs.start();
	}
	
	void start()
	{
		Hashtable<Character,Character[]> adj=new Hashtable<Character, Character[]>();
		
		Character list1[]={'b','d'};
		adj.put('a',list1);
		Character list2[]={'b'};
		adj.put('d',list2);
		Character list3[]={'d'};
		adj.put('e',list3);
		Character list4[]={'e'};
		adj.put('b',list4);
		Character list5[]={'e','f'};
		adj.put('c',list5);
		Character list6[]={'f'};
		adj.put('f',list6);
		
		ArrayList<Character> nodes=new ArrayList<Character>();
		nodes.add('a');
		nodes.add('c');
		nodes.add('d');
		nodes.add('b');
		nodes.add('f');
		nodes.add('e');
		
		for(char node: nodes)
		{
			if(parent.get(node)==null)
			{
				parent.put(node, '#');
				time++;
				DFS_Visit(adj, node);
			}
		}
		
		Enumeration<Character> keys=parent.keys();
		while(keys.hasMoreElements())
		{
			char node=keys.nextElement();
			System.out.println(node+"-->"+parent.get(node));
		}
		
	    keys=times.keys();
	    ArrayList<Nodes> cnodes=new ArrayList<Nodes>();
	    Comparator<Nodes> c=new Comparator<Nodes>() {
			
			@Override
			public int compare(Nodes o1, Nodes o2) {
				if(o1.startTime>o2.startTime)
				return 1;
				if(o1.startTime<o2.startTime)
					return -1;
				else
					return 0;
			}
		};
		while(keys.hasMoreElements())
		{
			char node=keys.nextElement();
			int p[]=times.get(node);
			System.out.println(node+"=> "+"start:"+p[0]+" finish:"+p[1]);
			Nodes tnode=new Nodes(node,p[0],p[1]);
			cnodes.add(tnode);
			cnodes.sort(c);
		}
		for(Nodes node1: cnodes)
		{
			System.out.print(node1.node+",");
		}
		
		//Topological Sorting
		
		
	}

    
	void DFS_Visit(Hashtable<Character,Character[]> adj,char s)
	{
	    int p[]=new int[2];
		p[0]=time; //discover time or start time
		p[1]=0;    // end time not yet known so initialize to 0
		times.put(s, p);
		
		for(char u : adj.get(s))
		{
			if(parent.get(u)==null)
			{
				time++;
				//System.out.println(u);
				//visited.put(u, true);
				parent.put(u, s);
				DFS_Visit(adj, u);
			}
		}
		time++;
		int temp[]=times.get(s) ;   // end time known so initialize to correct value
		temp[1]=time;	
	}
	
}
