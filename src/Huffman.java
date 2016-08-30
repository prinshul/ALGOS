import java.util.Comparator;
import java.util.Hashtable;
import java.util.PriorityQueue;


public class Huffman {

	class Node
	{
		Node left;
		Node right;
		char c;
		int freq;
		int lb;
		int rb;
		Node par;

		Node(char c,int freq)
		{
			this.c=c;
			this.freq=freq;
			this.left=null;
			this.right=null;
			par=null;
		}
	}

	public static void main(String[] args) {
		new Huffman().huffman();
	}

	void huffman()
	{
		Comparator<Node> c=new Comparator<Huffman.Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				if(o1.freq>o2.freq)
					return 1;
				else if(o1.freq<o2.freq)
					return -1;
				else
					return 0;
			}
		};
		PriorityQueue<Node> pq=new PriorityQueue<Huffman.Node>(c);
		Node node1=new Node('a',30);
		Node node2=new Node('m', 120);
		Node node3=new Node('x',70);
		Node node4=new Node('y', 90);

		pq.add(node2);
		pq.add(node3);
		pq.add(node4);
		pq.add(node1);

		Node root=null;
		while(pq.size()>1)
		{
			Node z=new Node(' ',0);
			Node left=pq.remove();
			Node right=pq.remove();
			z.freq=left.freq+right.freq;
			z.lb=0;
			z.rb=1;
			z.left=left;
			z.right=right;
			left.par=z;
			right.par=z;
			pq.add(z);
		}

		root=pq.remove();
		printHuffman(root);
	}

	void printHuffman(Node root)
	{
		if(root.left==null && root.right==null)
		{
			System.out.println(root.c+" Huffman code->"+findCode(root));

			return;
		}
		printHuffman(root.left);

		printHuffman(root.right);

	}

	String findCode(Node node)
	{
		String code="";

		while(node.par!=null)
		{
			Node par=node.par;

			if(par.left==node)
				code=code+par.lb+"";
			else
				code=code+par.rb+"";
			node=par;
		}
	
		char arr[]=code.toCharArray();
		code="";
        for(int i=arr.length-1;i>=0;i--)
        	code=code+arr[i];
        return code;
	}
}
