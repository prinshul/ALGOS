
public class Least_Common_Ancestor {

	class Node
	{
		int data;
		Node left;
		Node right;
		
		Node(int data)
		{
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}

	public static void main(String[] args) {
		Least_Common_Ancestor l=new Least_Common_Ancestor();
		l.init();
	}
	
	void init()
	{
		Node root=new Node(4);
		Node node1=new Node(2);
		Node node2=new Node(3);
		root.left=node1;
		root.right=node2;
		Node node3=new Node(1);
		Node node4=new Node(5);
		node1.left=node3;
		node1.right=node4;
		Node node5=new Node(6);
		node4.left=node5;
		System.out.println(LCA(root,node3, node2).data);
	}

	Node LCA(Node root, Node n1, Node n2)
	{
		if(root==null)
			return null;
		if(root==n1 || root==n2)
			return root;
		Node left=LCA(root.left,n1,n2);
		Node right=LCA(root.right,n1,n2);
		if(left!=null && right!=null)
			return root;
		if(left==null && right==null)
			return null;
		return left!=null ? left:right;
	}
}
