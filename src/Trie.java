import java.util.HashMap;
import java.util.Hashtable;
import java.util.Stack;


public class Trie {

	class TrieNode
	{
		Hashtable<Character, TrieNode> node;
		boolean status;

	}
	public static void main(String[] args) {
		new Trie().init();
	}

	void init()
	{
		TrieNode root=new TrieNode();
		root.node=null;
		root.status=false;
		insert(root,"abcd");
		insert(root,"abcde");
		insert(root,"abce");
		insert(root,"ghi");
		insert(root,"gh");
		insert(root,"ghip");
		insert(root,"ghxy");
		insert(root,"almn");
		insert(root,"abcf");

		System.out.println(search(root, "abcd"));
		System.out.println(search(root, "abcde"));
		System.out.println(search(root, "abce"));
		System.out.println(search(root, "ghi"));
		System.out.println(search(root, "gh"));
		System.out.println(search(root, "ghip"));
		System.out.println(search(root, "ghxy"));
		System.out.println(search(root, "almn"));
		System.out.println(search(root, "abcf"));

		delete(root, "gh");
		delete(root, "abcde");
		delete(root,"almn");
		delete(root,"abcf");

		System.out.println();

		System.out.println(search(root, "abcd"));
		System.out.println(search(root, "abcde"));
		System.out.println(search(root, "abce"));
		System.out.println(search(root, "abcf"));
		System.out.println(search(root, "ghi"));
		System.out.println(search(root, "gh"));
		System.out.println(search(root, "ghip"));
		System.out.println(search(root, "ghxy"));
		System.out.println(search(root, "almn"));
	}

	void delete(TrieNode root, String s)
	{
		TrieNode node=root;
		boolean found=true;
		Stack<TrieNode> stack=new Stack<Trie.TrieNode>();
		for(int i=0;i<s.length();i++)
		{
			char c=s.toCharArray()[i];
			if(node.node!=null && node.node.containsKey(c))
			{
				stack.push(node);
				node=node.node.get(c);
			}
			else
			{   
				found=false;
				break;
			}
		}
		if(found)
		{
			if(node.node!=null)
				node.status=false;
			else
			{
				while(!stack.isEmpty())
				{
					TrieNode t=stack.pop();
					if(t.node.size()==1)
					{
						if(!t.status)
						{
							t.node=null;
							t.status=false;
							t=null;
						}
						else
							t.node.remove(s.toCharArray()[stack.size()]);	
					}
					else
					{
						if(t.node.get(s.toCharArray()[stack.size()]).node==null)
							t.node.remove(s.toCharArray()[stack.size()]);

						break;
					}
				}
			}
		}
	}

	boolean search(TrieNode root, String s)
	{
		boolean found=true;
		TrieNode node=root;
		for(int i=0;i<s.length();i++)
		{
			char c=s.toCharArray()[i];
			if(node.node!=null && node.node.containsKey(c))
			{
				node=node.node.get(c);
			}
			else
			{
				found=false;
				break;
			}
		}
		if(found)
		{
			if(!node.status)
				found=false;
		}
		return found;
	}
	void insert(TrieNode root, String s)
	{
		TrieNode node=root;
		for(int i=0;i<s.length();i++)
		{
			char c=s.toCharArray()[i];
			if(node.node!=null && node.node.containsKey(c))
			{
				node=node.node.get(c);
			}
			else
			{   
				TrieNode t=new TrieNode();
				t.status=false;
				t.node=null;
				if(node.node==null)
				{
					Hashtable<Character, TrieNode> n=new Hashtable<Character, Trie.TrieNode>();
					n.put(c, t);
					node.node=n;
				}
				else
					node.node.put(c, t);
				node=t;
			}
		}
		node.status=true;
	}
}
