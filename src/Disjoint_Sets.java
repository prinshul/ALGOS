import java.util.Hashtable;
import java.util.Map;


public class Disjoint_Sets {

	Map<Integer, Node>map=new Hashtable<Integer,Node>();
	class Node
	{
		int rank;
		int data;
		Node parent;
		Node(int data)
		{
			this.data=data;
		}
	}

	public static void main(String[] args) {
       Disjoint_Sets ds=new Disjoint_Sets();
       ds.makeSet(4);
       ds.makeSet(5);
       ds.makeSet(1);
       ds.makeSet(2);
       ds.makeSet(8);
       ds.makeSet(6);
       ds.makeSet(7);
       
       ds.setUnion(4, 5);
       ds.setUnion(1, 2);
       ds.setUnion(8, 6);
       
       ds.setUnion(8, 2);
       ds.setUnion(8, 7);
       ds.setUnion(4, 7);
       
       System.out.println(ds.findset(8));
       System.out.println(ds.findset(7));
	}
	void makeSet(int data)
	{
		Node node=new Node(data);
		node.rank=0;
		node.parent=node;
		map.put(data, node);
	}

	int findset(int data)
	{
		return findSetNode(map.get(data)).data;
	}

	Node findSetNode(Node node)
	{
		if(node.parent==node)
			return node.parent;
		node.parent=findSetNode(node.parent);
		return node.parent;	
	}
	void setUnion(int data1,int data2)
	{
		Node node1=map.get(data1);
		Node parent1=findSetNode(node1);

		Node node2=map.get(data2);
		Node parent2=findSetNode(node2);
		
		if(parent1.data==parent2.data)
			return;

		if(parent1.rank >=parent2.rank)
		{
			if(parent2.rank ==parent1.rank)
				parent1.rank++;
			parent2.parent=parent1;	
		}
		else
			parent1.parent=parent2;	
	}

}
