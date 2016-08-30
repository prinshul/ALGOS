
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Nodes {

	int data;
	Nodes left;
	Nodes right;

	Nodes(int data)
	{
		this.data= data;
		this.left=null;
		this.right=null;
	}
	Nodes()
	{
		
	}

	public static void main(String[] args) {
		Nodes n=new Nodes(20);
		int arr[]={9,12,6,7,1,13,8,18,10,-6};
		for(int i=0;i<10;i++)
		{
			n.addnode(arr[i]);
		}

		/*n.preorderTraversal();
		System.out.println();
		n.inorderTraversal();
		System.out.println();
		n.postorderTraversal();
		System.out.println();
		n.levelOrder();
		System.out.println();*/
		Nodes head=n.BTtoDLLStack();
		n.printDLL(head);
		//n.convertTreetoDLL();
		//n.printDLL();


	}

	void addnode(int n)
	{
		if(n < this.data)
		{
			if(this.left!=null)
			{
				this.left.addnode(n);
			}
			else
			{
				this.left=new Nodes(n);
			}
		}
		else
		{
			if(this.right!=null)
			{
				this.right.addnode(n);
			}
			else
			{
				this.right=new Nodes(n);
			}
		}
	}

	void preorderTraversal()
	{
		System.out.println(this.data);
		if(this.left!=null)
			this.left.preorderTraversal();
		if(this.right!=null)
			this.right.preorderTraversal();
	}

	void inorderTraversal()
	{
		if(this.left!=null)
			this.left.inorderTraversal();
		System.out.println(this.data);
		if(this.right!=null)
			this.right.inorderTraversal();
	}
	void postorderTraversal()
	{
		if(this.left!=null)
			this.left.postorderTraversal();
		if(this.right!=null)
			this.right.postorderTraversal();
		System.out.println(this.data);
	}

	void levelOrder()
	{
		Queue<Nodes> queue= new LinkedList<Nodes>();
		queue.add(this);
		while(!queue.isEmpty())
		{
			Nodes n=queue.remove();
			System.out.println(n.data);

			if(n.left!=null)
				queue.add(n.left);
			if(n.right!=null)
				queue.add(n.right);

		}
	}

	Nodes BTtoDLLStack()
	{
		Stack<Nodes> stack1= new Stack<Nodes>();
		Stack<Nodes> stack2= new Stack<Nodes>();
		stack1.push(this);
		
		Nodes head=null;
		Nodes lastnode=null;
		
		while(!stack1.isEmpty() || !stack2.isEmpty())
		{
			while(!stack1.isEmpty())
			{
				Nodes n=stack1.pop();
				if(n.left!=null)
					stack2.push(n.left);
				if(n.right!=null)
					stack2.push(n.right);
				
				n.right=null;
				if(head==null)
				{
					head=lastnode=n;
					n.left=null;
				}
				else
				{
					n.left=lastnode;
					lastnode.right=n;
					lastnode=n;
				}
				
				/*ArrayList<Nodes> vals=addatEnd(n,lastnode,head);
				lastnode=vals.get(0);
				head=vals.get(1);*/
			}
			while(!stack2.isEmpty())
			{
				Nodes n=stack2.pop();
				if(n.right!=null)
					stack1.push(n.right);	
				if(n.left!=null)
					stack1.push(n.left);
				n.right=null;
				if(head==null)
				{
					head=lastnode=n;
					n.left=null;
				}
				else
				{
					n.left=lastnode;
					lastnode.right=n;
					lastnode=n;
				}
				/*ArrayList<Nodes> vals=addatEnd(n,lastnode,head);
				lastnode=vals.get(0);
				head=vals.get(1);*/
			}
			

		}
		return head;
	}
	ArrayList<Nodes>  addatEnd(Nodes n,Nodes lastnode,Nodes head)
	{
		ArrayList<Nodes> vals=new ArrayList<Nodes>();
		n.right=null;
		if(head==null)
		{
			head=lastnode=n;
			n.left=null;
		}
		else
		{
			n.left=lastnode;
			lastnode.right=n;
			lastnode=n;
		}
		vals.add(0, head);
		vals.add(1, lastnode);
		return vals;
	}
/*	void convertTreetoDLL()
	{

		int height=findHeight();
		boolean rev=true;
		for(int i=height;i>0;i--)
		{
			helper(i,rev);
			rev=!rev;
		}
	}*/

	/*void helper(int level, boolean rev)
	{
		if(level==1)
		{
			if(head==null)
			{
				head=this;
				head.left=null;
				head.right=null;
			}
			else
			{
				Nodes ptr= head.right;
				this.right=ptr;
				this.left=head;
				ptr.left=this;
				head.right=this;
				head=this;
			}
		}
		else if(level>1)
		{
			if(rev)
			{
				if(this.right!=null)
				this.right.helper(level-1, rev);
				if(this.left!=null)
				this.left.helper(level-1, rev);
			}
			else
			{
				if(this.left!=null)
				this.left.helper(level-1, rev);
				if(this.right!=null)
				this.right.helper(level-1, rev);
			}

		}
	}
*/
	int findHeight()
	{
		int h;
		h=1;
		int lh=0;
		int rh=0;
		if(this.left!=null)
			lh=this.left.findHeight();
		if(this.right!=null)
			rh=this.right.findHeight();
		if(lh>rh)
			h=h+lh;
		else
			h=h+rh;
		return h;
	}
	
	void printDLL(Nodes head)
	{
		Nodes ptr=head;
		while(ptr!=null)
		{
			System.out.println(ptr.data);
			ptr=ptr.right;
		}
	}
}
