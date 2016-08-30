import java.util.ArrayList;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;


public class Dijktras {

	public class Edge
	{
		char name;
		int w;

		public Edge(char name,int w)
		{
			this.name=name;
			this.w=w;
		}
	}
	public class Vertex
	{
		char name;
		int dist;
		public Vertex(char name,int dist) {
			this.name=name;
			this.dist=dist;
		}

	}
	public static void main(String[] args) {
		new Dijktras().start();
	}
	public void start()
	{
		Hashtable<Character, Integer> distances=new Hashtable<Character, Integer>();
		Hashtable<Character, List<Edge>> adj=new Hashtable<Character, List<Edge>>();
		Edge edgeAB=new Edge('B', 10);
		Edge edgeAC=new Edge('C', 3);
		Edge edgeBD=new Edge('D', 2);
		Edge edgeBC=new Edge('C', 1);

		Edge edgeCB=new Edge('B', 4);
		Edge edgeCD=new Edge('D', 8);
		Edge edgeCE=new Edge('E', 2);
		Edge edgeDE=new Edge('E', 7);
		Edge edgeED=new Edge('D', 9);

		List<Edge> EdgesA=new ArrayList<Edge>();
		EdgesA.add(edgeAB);
		EdgesA.add(edgeAC);
		adj.put('A', EdgesA);

		List<Edge> EdgesB=new ArrayList<Edge>();
		EdgesB.add(edgeBD);
		EdgesB.add(edgeBC);
		adj.put('B', EdgesB);

		List<Edge> EdgesC=new ArrayList<Edge>();
		EdgesC.add(edgeCB);
		EdgesC.add(edgeCD);
		EdgesC.add(edgeCE);
		adj.put('C', EdgesC);

		List<Edge> EdgesD=new ArrayList<Edge>();
		EdgesD.add(edgeDE);
		adj.put('D', EdgesD);

		List<Edge> EdgesE=new ArrayList<Edge>();
		EdgesE.add(edgeED);
		adj.put('E', EdgesE);

		distances.put('A', 0);
		distances.put('B', Integer.MAX_VALUE);
		distances.put('C', Integer.MAX_VALUE);
		distances.put('D', Integer.MAX_VALUE);
		distances.put('E', Integer.MAX_VALUE);

		shortestPairsPath(distances,adj);

	}

	void shortestPairsPath(Hashtable<Character, Integer> distances,
			Hashtable<Character, List<Edge>> adj)
	{
		Comparator<Vertex> mycomp=new Comparator<Dijktras.Vertex>() {

			@Override
			public int compare(Vertex o1, Vertex o2) {
				if(o1.dist>o2.dist)
					return 1;
				if(o1.dist<o2.dist)
					return -1;
				return 0;
			}
		};

		PriorityQueue<Vertex> pqueue=new PriorityQueue<Vertex>(mycomp);
		Enumeration<Character> keys=distances.keys(); 
		while(keys.hasMoreElements())
		{
			char name=keys.nextElement();
			int dist=distances.get(name);
			Vertex v=new Vertex(name, dist);
			pqueue.add(v);
		}

		while(!pqueue.isEmpty())
		{
			Vertex v=pqueue.remove();
			List<Edge> edges=adj.get(v.name);
			for(Edge edge: edges)
			{
				if(distances.get(edge.name) > (v.dist+edge.w))
				{
					
					updateDist(distances,
							pqueue, v.dist+edge.w,edge.name);
				}
			}

		}
		
		Enumeration<Character> cnodes=distances.keys();
		while(cnodes.hasMoreElements())
		{
			char name=cnodes.nextElement();
			int w=distances.get(name);
			System.out.println("A-->"+name+" Tot Dist:"+w);
		}

	}

	void updateDist(Hashtable<Character, Integer> distances,
			PriorityQueue<Vertex> pqueue,int newdist,char name)
	{
       distances.remove(name);
       distances.put(name, newdist);
       Iterator<Vertex>vertices=pqueue.iterator();
       while(vertices.hasNext())
       {
    	   Vertex vertex=vertices.next();
    	   if(vertex.name==name)
    	   {
    		   pqueue.remove(vertex);
    		   break;
    	   }
       }
       Vertex ver=new Vertex(name, newdist);
       pqueue.add(ver);
	}
}
