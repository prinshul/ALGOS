import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

public class BellManFord {


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
	public static void main(String[] args) {
		new BellManFord().start();
	}
	public void start()
	{
		Hashtable<Character, Integer> distances=new Hashtable<Character, Integer>();
		Hashtable<Character, List<Edge>> adj=new Hashtable<Character, List<Edge>>();
		Edge edgeAB=new Edge('B', -1);
		Edge edgeAC=new Edge('C', 4);
		Edge edgeBD=new Edge('D', 2);
		Edge edgeBC=new Edge('C', 3);
		Edge edgeBE=new Edge('E', 2);

		Edge edgeDC=new Edge('C', 5);
		Edge edgeDB=new Edge('B', 1);
		Edge edgeED=new Edge('D', -3);

		List<Edge> EdgesA=new ArrayList<Edge>();
		EdgesA.add(edgeAB);
		EdgesA.add(edgeAC);
		adj.put('A', EdgesA);

		List<Edge> EdgesB=new ArrayList<Edge>();
		EdgesB.add(edgeBD);
		EdgesB.add(edgeBC);
		EdgesB.add(edgeBE);
		adj.put('B', EdgesB);

		List<Edge> EdgesC=new ArrayList<Edge>();
		adj.put('C', EdgesC);

		List<Edge> EdgesD=new ArrayList<Edge>();
		EdgesD.add(edgeDC);
		EdgesD.add(edgeDB);
		adj.put('D', EdgesD);

		List<Edge> EdgesE=new ArrayList<Edge>();
		EdgesE.add(edgeED);
		adj.put('E', EdgesE);

		distances.put('A', 0);
		distances.put('B', 999);
		distances.put('C', 999);
		distances.put('D', 999);
		distances.put('E', 999);

		shortestPairsPath(distances,adj);

	}

	void shortestPairsPath(Hashtable<Character, Integer> distances,
			Hashtable<Character, List<Edge>> adj)
	{
		for(int i=1;i<distances.size();i++)
		{
			
			Enumeration<Character> keys=adj.keys(); 
			while(keys.hasMoreElements())
			{
				char name=keys.nextElement();
				List<Edge> edges=adj.get(name);
				for(Edge edge: edges)
				{
					if(distances.get(edge.name)> distances.get(name) +edge.w)
					{
						updateDist(distances,
								distances.get(name)+edge.w,edge.name);	
					}
				}
			}

		}
		
		Enumeration<Character> keys=adj.keys(); 
		while(keys.hasMoreElements())
		{
			char name=keys.nextElement();
			List<Edge> edges=adj.get(name);
			for(Edge edge: edges)
			{
				if(distances.get(edge.name)> distances.get(name) +edge.w)
				{
					System.out.println("NEGATIVE CYCLE EXISTS");	
					return;
				}
			}
		}


		Enumeration<Character> cnodes=distances.keys();
		while(cnodes.hasMoreElements())
		{
			char name=cnodes.nextElement();
			int w=distances.get(name);
			System.out.println("A-->"+name+" TotDist:"+w);
		}

	}

	void updateDist(Hashtable<Character, Integer> distances,
			int newdist,char name)
	{
		distances.remove(name);
		distances.put(name, newdist);
	}


}
