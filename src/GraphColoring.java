import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;


public class GraphColoring {
	
	LinkedList<Node> adj[];
	ArrayList<Node> nodes=null; 
	public GraphColoring(int n) {
		adj=new LinkedList[n];
		for(int i=0;i<n;i++)
		{
			adj[i]=new LinkedList<GraphColoring.Node>();
		}
	}
	
	static char COLORS[];
	static int TOTAL_NODES=6;
	
	class Node
	{
		int key;
		char color;

		Node(int c)
		{
			key=c;
		}
	}
	public static void main(String[] args) {
		GraphColoring g=new GraphColoring(TOTAL_NODES);
		g.init();
		char c[]=new char[TOTAL_NODES];
		g.color(0,c);
		//g.print();
	}

	void init()
	{
		COLORS=new char[4];
		
		COLORS[0]='G';
		COLORS[1]='B';
		COLORS[2]='Y';
		COLORS[3]='R';
		
		nodes=new ArrayList<Node>();
		
		Node n0=new Node(0);
		nodes.add(n0);
		Node n1=new Node(1);
		nodes.add(n1);
		Node n2=new Node(2);
		nodes.add(n2);
		Node n3=new Node(3);
		nodes.add(n3);
		Node n4=new Node(4);
		nodes.add(n4);
		Node n5=new Node(5);
		nodes.add(n5);
		
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
	}

	void color(int i,char c[])
	{
		if(i==TOTAL_NODES)
			{
			  print(c);
			  System.out.println();
			  return;
			}
		else
		{
	    	Node n=nodes.get(i);
			for(int color=0;color<COLORS.length;color++)
			{			
				if(canColor(n,color))
				{
					n.color=COLORS[color];
					c[i]=COLORS[color];
					color(i+1,c);
				}
			}
			n.color=' ';
			c[i]=' ';         //wrong assignment reassign previous node backtrack 
			
		}
	}
	
	void print(char c[])
	{
		for(int i=0;i<c.length;i++)
		{
		System.out.println(i+" "+c[i]);
		}
	}
	
	boolean canColor(Node n,int color)
	{
		boolean canColor =true;
		for(Node node: adj[n.key])
		{
			if(node.color==COLORS[color])
			{
				canColor=false;
				break;
			}
		}
		return canColor;
	}
}
