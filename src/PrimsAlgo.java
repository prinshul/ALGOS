import java.util.ArrayList;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;


public class PrimsAlgo {

	class GNode
	{
		int key;
		char name;

		public GNode(int key,char name)
		{
			this.key=key;
			this.name=name;
		}
	}
	class Edge
	{
		int weight;
		GNode node;
		public Edge(int weight,GNode node)
		{
			this.weight=weight;
			this.node=node;
		}
	}

	public static void main(String[] args) {

		PrimsAlgo prims=new PrimsAlgo();
		Hashtable<GNode,List<Edge>> vertices=prims.createGraph();	
		prims.printGraph(vertices);
		prims.MST(vertices);
	}

	public Hashtable<GNode,List<Edge>> createGraph()
	{
		Hashtable<GNode,List<Edge>> vertices=new Hashtable<GNode,List<Edge>>(); 
		GNode nodeA=new GNode(Integer.MAX_VALUE, 'A');
		GNode nodeB=new GNode(Integer.MAX_VALUE, 'B');
		GNode nodeH=new GNode(Integer.MAX_VALUE, 'H');
		GNode nodeI=new GNode(Integer.MAX_VALUE, 'I');
		GNode nodeC=new GNode(Integer.MAX_VALUE, 'C');
		GNode nodeG=new GNode(Integer.MAX_VALUE, 'G');

		Edge edgAB=new Edge(4, nodeB);
		Edge edgAH=new Edge(8, nodeH);
		Edge edgBA=new Edge(4, nodeA);
		Edge edgBH=new Edge(11, nodeH);
		Edge edgBC=new Edge(5, nodeC);
		Edge edgHA=new Edge(8, nodeA);
		Edge edgHB=new Edge(11, nodeB);
		Edge edgHI=new Edge(7, nodeI);
		Edge edgHG=new Edge(1, nodeG);
		Edge edgGI=new Edge(6, nodeI);
		Edge edgGH=new Edge(1, nodeH);
		Edge edgGC=new Edge(4, nodeC);
		Edge edgCI=new Edge(2, nodeI);
		Edge edgCG=new Edge(4, nodeG);
		Edge edgCB=new Edge(8, nodeB);
		Edge edgIH=new Edge(7, nodeH);
		Edge edgIG=new Edge(6, nodeG);
		Edge edgIC=new Edge(2, nodeC);

		List<Edge> EdgesA=new LinkedList<Edge>();
		EdgesA.add(edgAB);
		EdgesA.add(edgAH);
		vertices.put(nodeA, EdgesA);
		List<Edge> EdgesB=new LinkedList<Edge>();
		EdgesB.add(edgBA);
		EdgesB.add(edgBH);
		EdgesB.add(edgBC);
		vertices.put(nodeB, EdgesB);
		List<Edge> EdgesH=new LinkedList<Edge>();
		EdgesH.add(edgHA);
		EdgesH.add(edgHB);
		EdgesH.add(edgHI);
		EdgesH.add(edgHG);
		vertices.put(nodeH, EdgesH);
		List<Edge> EdgesC=new LinkedList<Edge>();
		EdgesC.add(edgCI);
		EdgesC.add(edgCB);
		EdgesC.add(edgCG);
		vertices.put(nodeC, EdgesC);
		List<Edge> EdgesG=new LinkedList<Edge>();
		EdgesG.add(edgGI);
		EdgesG.add(edgGH);
		EdgesG.add(edgGC);
		vertices.put(nodeG, EdgesG);
		List<Edge> EdgesI=new LinkedList<Edge>();
		EdgesI.add(edgIH);
		EdgesI.add(edgIG);
		EdgesI.add(edgIC);
		vertices.put(nodeI, EdgesI);

		return vertices;

	}

	void printGraph(Hashtable<GNode,List<Edge>> vertices)
	{
		Enumeration<GNode> nodes=vertices.keys();
		while(nodes.hasMoreElements())
		{
			GNode node=nodes.nextElement();
			List<Edge> edges=vertices.get(node);
			String edgs="";
			for(Edge edge: edges)
			{
				int w=edge.weight;
				GNode cnode=edge.node;
				edgs=edgs+cnode.name+"{"+w+"}"+"  ";
			}
			System.out.println(node.name+"-->"+edgs);
		}
	}
	void MST(Hashtable<GNode,List<Edge>> vertices)
	{
		Enumeration<GNode> nodes=null;
		nodes=vertices.keys();
		GNode root=null;
		while(nodes.hasMoreElements())
		{
		  root=nodes.nextElement();
		  if(root.name=='A')
			  break;
		}
		changeKeyOfVertex(root, vertices, 0,null);	
		Comparator<GNode> myComparator=new Comparator<GNode>() {

			@Override
			public int compare(GNode o1, GNode o2) {
				if(o1.key>o2.key)
					return 1;
				if(o1.key<o2.key)
					return -1;
				else
					return 0;
			}
		};
		PriorityQueue<GNode> queue=new PriorityQueue<GNode>(myComparator);

		Hashtable<Character, Character> parents=new Hashtable<Character, Character>();
		nodes=vertices.keys();
		while(nodes.hasMoreElements())
		{
			GNode node=nodes.nextElement();
			queue.add(node);			
		}
		while(!queue.isEmpty())
		{
			GNode node=queue.remove();
			System.out.println("Removed-->"+node.name);
            List<Edge> edges=vertices.get(node);
            for(Edge edge: edges)
            {
            	GNode cnode=edge.node;
            	if(queue.contains(cnode) && edge.weight<cnode.key)
            	{
            		changeKeyOfVertex(cnode,vertices,edge.weight,queue); 
            		parents.put(cnode.name,node.name);
            	}
            }
		}
		
		Enumeration<Character> finnodes=parents.keys();
		while(finnodes.hasMoreElements())
		{
			Character key=finnodes.nextElement();
			Character val=parents.get(key);
			System.out.println(key+"---->"+val);
		}	
	}

	/*void updateQueuevalue(PriorityQueue<GNode> queue,GNode cnode,int newkey)
	{
		queue.remove(cnode);
		cnode.key=newkey;
		queue.add(cnode);
	}*/
	void changeKeyOfVertex(GNode cnode,Hashtable<GNode,List<Edge>> vertices,int newkey,
			PriorityQueue<GNode> queue)
	{
		GNode node=null;
		boolean flag=false;
		Enumeration<GNode> nodes=vertices.keys();
		while(nodes.hasMoreElements())
		{
			node=nodes.nextElement();
			if(node.equals(cnode))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			Enumeration<GNode> nodestc = vertices.keys();
			List<Edge> tempedge= vertices.get(node);
			vertices.remove(node);
			GNode tempNode=new GNode(newkey, cnode.name);
			while(nodestc.hasMoreElements())
			{
			List<Edge> tempedges=new LinkedList<Edge>();	
			GNode tNode=nodestc.nextElement();
			List<Edge>edges=vertices.get(tNode);
			for(Edge edge: edges)
			{
				if(edge.node.name==cnode.name)
				{
					edge.node=tempNode;
				}
				tempedges.add(edge);
				vertices.put(tNode, tempedges);
			}
			}
			
			vertices.put(tempNode, tempedge);
			if(queue!=null)
			{
			queue.remove(node);
			queue.add(tempNode);
			}
		}
	}



}
