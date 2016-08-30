
public class AVL {
	
	class Node 
	{
		int data;
		Node par,l,r;
		int h;
		
		public Node(int data) {
			this.data=data;
			this.l=null;
			this.r=null;
			this.h=0;
			// TODO Auto-generated constructor stub
		}
	}

	public static void main(String[] args) {	
		 AVL avl=new AVL();
         avl.start();
        
	}
	void start()
	{
		 Node root=new Node (23);
	        int a[]={7,9,12,78,34,5,2,45};
	  
	        for(int i=0;i<a.length;i++)
	        {
	        	insert(root, a[i]);
	        }
	        
	        inorder(root);
	        
	       // n=new Node(40);
	        /*insert(root, n);
	        assignHeight(n);
	        inorder(root);*/
	        
	      
	}
	
	Node rotateright(Node root)
	{
		Node newnode = root.l;
		root.l=newnode.r;
		newnode.r=root;
		
		root.h= max(root.l, root.r)+1;
		newnode.h= max(newnode.l, newnode.r)+1;
		return newnode;
	}
	
	Node rotateleft(Node root)
	{
		Node newnode = root.r;
		root.r=newnode.l;
		newnode.l=root;
		
		root.h= max(root.l, root.r)+1;
		newnode.h= max(newnode.l, newnode.r)+1;
		return newnode;
	}
	
	Node insert(Node root,int data )
	{
		if(root==null)
		{
			return new Node(data);
		}
		if(root.data>data)
		{
			root.l=insert(root.l, data);
		}
		else {
			root.r=insert(root.r, data);
		}
		int bal=bal(root.l,root.r);
		if(bal>1)
		{
			if(isMax(root.l.l,root.l.r))
			{
				return rotateright(root);
			}
			else
			{
				root.l=rotateleft(root.l);
				return rotateright(root);
			}
		}
		if(bal<-1)
		{
			if(isMax(root.r.r,root.r.l))
			{
				return rotateleft(root);
			}
			else
			{
				root.r=rotateright(root.r);
				return rotateleft(root);
			}
		}
		
		root.h=max(root.l,root.r)+1;
		return root;
	}
	
	void inorder(Node root)
	{
		if(root==null)
			return;
		inorder(root.l);
		
		System.out.println(root.data+" level"+root.h);
		inorder(root.r);
	}
	
    int max(Node l,Node r)
    {
    	if(l==null && r==null)
    		return 0;
    	if(l==null && r!=null)
    		return r.h;
    	if(l!=null && r==null)
    		return l.h;
    	else return Math.max(l.h,r.h);
    	
    }
    
    int bal(Node l,Node r)
    {
    	if(l==null && r==null)
    		return 0;
    	if(l==null && r!=null)
    		return -r.h;
    	if(l!=null && r==null)
    		return l.h;
    	else return (l.h-r.h);
    }
    
    boolean isMax(Node l,Node r)
    {
    	if(l==null && r==null)
    		return true;
    	if(l==null && r!=null)
    		{
    		if(-1>=r.h)
    			return true;
    		else
    			return false;
    		}
    	    
    	if(l!=null && r==null)
    	{
    		if(l.h>=-1)
    			return true;
    		else
    			return false;
    		}
    	else 
    		{
    		if(l.h>=r.h)
    			return true;
    		else
    			return false;
    		}
    }
}
