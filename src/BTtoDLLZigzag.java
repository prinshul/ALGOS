
public class BTtoDLLZigzag {

	public class Node
	{
		Node left;
		Node right;
		int data;

		Node(int num)
		{
			this.data=num;
			this.left=null;
			this.right=null;
		}
	}
	Node head=null;

	public static void main(String args[])
	{
		new BTtoDLLZigzag().run();

	}

	public void run()
	{
		int arr[]={9,12,6,7,1,13,8,18,10,-6};
		Node root = new Node(20);
		for(int i=0;i<10;i++)
		{
			Node node= new Node(arr[i]);
			addnode(root,node);
		}

		levelorderTraversal(root);
		printDLL();
	}

	void addnode(Node root,Node node)
	{
		if(root==null)
		{
			return;
		}
		if(root.data>node.data)
		{
			if(root.left==null)
			{
				root.left=node;
			}
			else
				addnode(root.left,node);
		}
		else
		{
			if(root.right==null)
			{
				root.right=node;
			}
			else
				addnode(root.right,node);
		}
	}

	void levelorderTraversal(Node root)
	{
		int height=findHeight(root);
		boolean rev=true;
		for(int i=height;i>0;i--)
		{
			convertBTDLL(root,i,rev);
			rev=!rev;
		}
	}

	int findHeight(Node root)
	{
		if(root==null)
		{
			return 0;
		}
		int LH=findHeight(root.left);
		int RH=findHeight(root.right);

		if(LH>RH)
			return LH+1;
		else
			return RH+1;
	}
	
	void convertBTDLL(Node root,int lev,boolean rev)
	{
		if(root==null)
			return;
		if(lev==1)
		{
			if(head==null)
			{
			  head=root;
			  head.left=null;
			  head.right=null;
			}
			else if(head.right==null)
			{
				root.right=head;
				head.left=root;
				head=root;				
			}
			else
			{
				Node ptr= head.right;
				root.right=ptr;
				root.left=head;
				ptr.left=root;
				head.right=root;
				head=root;
			}
		}
		else if(lev>1)
		{
			if(rev)
			{
			convertBTDLL(root.left,lev-1,rev);
			convertBTDLL(root.right,lev-1,rev);
			}
			else
			{
					convertBTDLL(root.right,lev-1,rev);
					convertBTDLL(root.left,lev-1,rev);
			}
		}
	}
	
	void printDLL()
	{
		Node ptr=head;
		while(ptr!=null)
		{
			System.out.println(ptr.data);
			ptr=ptr.right;
		} 
	}
}
