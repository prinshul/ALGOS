public class RedBlack {

	class Node 
	{
		int data;
		Node left;
		Node right;
		Node parent;
		int color;

		public Node(int data,int color ) {
			this.data=data;
			this.left=null;
			this.right=null;
			this.parent=null;
			this.color=color;
		}
	}
	class Color
	{
		final static int RED=0;
		final static int BLACK=1;
	}
	public static void main(String[] args) {
		RedBlack rb =new RedBlack();
		rb.start();
	}
	void start()
	{
		int a[]={7,9,12,78,34,5,2,45};
		Node root=insert(null, null, 23);
//		for(int i=0;i<a.length;i++)
//		{
//			insert(root,  a[i]);
//		}
	}

	Node createBlackNode(int data)
	{
		return new Node(data,Color.BLACK);
	}

	Node createRedNode(Node parent,int data)
	{	
		Node root=null;
		if(parent.data>data)
			root=parent.left=new Node(data, Color.RED);
		else
			root=parent.right=new Node(data, Color.RED);
		return root;
	}

	Node insert(Node parent, Node root, int data)
	{
		if(root==null)
		{
			if(parent!=null)
				return createRedNode(parent,data);
			else
				return createBlackNode(data);	
		}
		boolean isLeft;
		if(root.data>data)
		{
			Node left= insert(root, root.left, data);
			if(left==root.parent)	
			{
				return left;
			}

			root.left=left;
			isLeft=true;
		}
		else
		{
			Node right= insert(root, root.right, data);
			if(right==root.parent)	
			{
				return right;
			}

			root.right=right;
			isLeft=false;
		}

		if(isLeft)
		{
			if(root.color==Color.RED && root.parent.color==Color.RED)
			{
				Node sibling=findSibling(root);
				if(sibling==null || sibling.color==Color.BLACK)
				{
					if(isleftChild(root))
					{
						rightRotate(root, true);
					}
					else
					{
						rightRotate(root.left, false);
						root=root.parent;
						leftRotate(root,true);
					}
				}
				else
				{
					root.color=Color.BLACK;
					sibling.color=Color.BLACK;
					if(root.parent.parent!=null)
					{
						root.parent.color=Color.RED;
					}
				}
			}
		}
		else
		{

			if(root.color==Color.RED && root.parent.color==Color.RED)
			{
				Node sibling=findSibling(root);
				if(sibling==null || sibling.color==Color.BLACK)
				{
					if(!isleftChild(root))
					{
						leftRotate(root, true);
					}
					else
					{
						leftRotate(root.right, false);
						root=root.parent;
						rightRotate(root,true);
					}
				}
				else
				{
					root.color=Color.BLACK;
					sibling.color=Color.BLACK;
					if(root.parent.parent!=null)
					{
						root.parent.color=Color.RED;
					}
				}
			}

		}
		return root;
	}

	Node findSibling(Node root)
	{
		if(root.parent.parent.left==root.parent)
			return root.parent.parent.right;
		return root.parent.parent.left;	
	}

	boolean isleftChild(Node root)
	{
		if(root.parent==root.parent.left)
			return true;
		else
			return false;
	}

	void rightRotate(Node root, boolean color)
	{
		Node parent = root.parent;
		root.parent=parent.parent;
		if(parent.parent!=null)
		{
			if(parent.parent.left==parent)
				parent.parent.left=root;
			else
				parent.parent.right=root;
		}
		Node right=root.right;
		parent.parent=root;
		parent.left=right;
		root.right=parent;
		if(right!=null)
		{
			right.parent=parent;
		}

		if(color)
		{
			root.parent.color=Color.RED;
			root.color=Color.BLACK;
		}
	}

	void leftRotate(Node root, boolean color)
	{
		Node parent = root.parent;
		root.parent=parent.parent;
		if(parent.parent!=null)
		{
			if(parent.parent.right==parent)
				parent.parent.right=root;
			else
				parent.parent.left=root;
		}
		Node left=root.left;
		parent.parent=root;
		parent.right=left;
		root.left=parent;
		if(left!=null)
		{
			left.parent=parent;
		}

		if(color)
		{
			root.parent.color=Color.RED;
			root.color=Color.BLACK;
		}
	}

}


