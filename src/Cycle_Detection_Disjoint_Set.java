import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.Vector;


public class Cycle_Detection_Disjoint_Set {

	Map<Character, Node>map=new Hashtable<Character,Node>();

	class Node 
	{
		char data;
		int rank;
		Node parent;
		Node(char data)
		{
			this.data=data;
		}
	}

	public void makeSet(char data)
	{
		Node node=new Node(data);
		node.rank=0;
		node.parent=node;
		map.put(data, node);
	}
	
	char findSet(char data)
	{
		return findSet(map.get(data)).data;
	}
	
	Node findSet(Node node)
	{
		if(node.parent==node)
		{
			return node.parent;
		}
		node.parent=findSet(node.parent);
		return node.parent;
	}
	
	public void setUnion(char data1,char data2)
	{
		Node node1=map.get(data1);
		Node node2=map.get(data2);
		
		Node parent1=findSet(node1);
		Node parent2=findSet(node2);
		
		if(parent1.data==parent2.data)
			return;
		if(parent1.rank>=parent2.rank)
		{
			if(parent1.rank==parent2.rank)
			{
				parent1.rank++;
			}
			parent2.parent=parent1;
		}
		else
			parent1.parent=parent2;
	}

	public static void main(String[] args) {
		Cycle_Detection_Disjoint_Set c=new Cycle_Detection_Disjoint_Set();
		c.start();
	}

	void start()
	{
		Vector<char[]> edges=new Vector<char[]>();
		char c[]=new char[2];
		c[0]='a';
		c[1]='b';
		edges.add(c);
		makeSet('a');
		c=new char[2];
		c[0]='b';
		c[1]='c';
		edges.add(c);
		makeSet('b');
		c=new char[2];
		c[0]='c';
		c[1]='d';
		edges.add(c);
		makeSet('e');
		c=new char[2];
		c[0]='d';
		c[1]='e';
		edges.add(c);
		makeSet('d');
		c=new char[2];
		c[0]='e';
		c[1]='b';
		edges.add(c);
		makeSet('c');
		
		System.out.println(isCycle(edges));
	}

	boolean isCycle(Vector<char[]> edges)
	{
		boolean cycle=false;
		for(int i=0;i<edges.size();i++)
		{
			   char nodes[]=edges.get(i);
               if(findSet(nodes[0])==findSet(nodes[1]))
               {
            	   cycle=true;
            	   break;
               }
               setUnion(nodes[0],nodes[1]);
			
		}

		return cycle;
	}

}
