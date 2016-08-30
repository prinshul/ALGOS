import java.util.ArrayList;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;

//its recursive only
public class Non_Recursive_DFS {
	
	class Node 
	{
		int s;
		int f;
		char data;
		Node(char data,int s,int f)
		{
			this.data=data;
			this.f=f;
			this.s=s;
		}
	}

	int v;
	LinkedList<Character> adj[];
	static ArrayList<Character>nodes=new ArrayList<Character>();
	Hashtable<Character, Character> parent=new Hashtable<Character, Character>();
	Hashtable<Character, int[]> times=new Hashtable<Character, int[]>();  //for topological sort
	int time=0;
	public Non_Recursive_DFS(int v) {
		this.v=v;
		adj=new LinkedList[v];
		for(int i=0;i<v;i++)
			adj[i]=new LinkedList<Character>();
	}

	public static void main(String[] args) 
	{
		Non_Recursive_DFS dfs=new Non_Recursive_DFS(6);
		
		nodes.add('b');
		nodes.add('d');
		nodes.add('c');
		nodes.add('e');
		nodes.add('a');
		nodes.add('f');
		nodes.sort(null);
		
		dfs.addEdge('a', 'b');
		dfs.addEdge('a', 'd');
		dfs.addEdge('d', 'b');
		dfs.addEdge('e', 'd');
		dfs.addEdge('c', 'e');
		dfs.addEdge('c', 'f');
		dfs.addEdge('f', 'f');
		dfs.addEdge('b', 'e');
		
		dfs.DFS();
	}

	public void addEdge(char u,char v)
	{
		adj[getIndex(u)].add(v);
	}

	int getIndex(char u)
	{
		int index=-1;
		if(nodes.contains(u))
		{
			index=nodes.indexOf(u);
		}
		return index;
	}
	void DFS()
	{
       for(int i=0;i<v;i++) 
       {
    	   if(parent.get(nodes.get(i))==null)
    	   {
    		   parent.put(nodes.get(i) ,'#');
    		   time++;
    		   DFS_Visit(nodes.get(i));
    	   }
       }    
       
       Enumeration<Character> keys=parent.keys();
       while(keys.hasMoreElements())
       {
    	   char c=keys.nextElement();
    	   System.out.println(c+"--->"+parent.get(c));
       }
       
       ArrayList<Node> nodes=new ArrayList<Non_Recursive_DFS.Node>();
       keys=times.keys();
       while(keys.hasMoreElements())
       {
    	   char c=keys.nextElement();
    	   int s_f_t[]=times.get(c);
    	   System.out.println(c+" start:"+s_f_t[0]+" finish:"+s_f_t[1]);
    	   Node n=new Node(c, s_f_t[0], s_f_t[1]);
    	   nodes.add(n);
       }
       
       Comparator<Node> comp=new Comparator<Non_Recursive_DFS.Node>() {
		
		@Override
		public int compare(Node o1, Node o2) {
			if(o1.f>o2.f)
			return -1;
			if(o1.f<o2.f)
				return 1;
			else
			return 0;
		}
	};
	//Topological sort on decreasing finish times
       nodes.sort(comp);
       
       for(int i=0;i<nodes.size();i++)
       {
    	   System.out.print(nodes.get(i).data+" ");
       }
	}
	
	void DFS_Visit(char c)
	{
		int s_f_time[]=new int[2];
		s_f_time[0]=time;
		s_f_time[1]=0;
		times.put(c, s_f_time);
		
		LinkedList<Character> list=adj[getIndex(c)];
		for(char node: list)
		{
			if(parent.get(node)==null)
			{
				time++;
				parent.put(node, c);
				DFS_Visit(node);
			}
		}
		
		time++;
		int t[]=times.get(c);
		t[1]=time;
	}

   

}
