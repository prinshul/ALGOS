import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;


public class BFS {

	public static void main(String[] args) {
		BFS bfs=new BFS();
		bfs.start();
	}

	void start()
	{

		Hashtable<Character,Character[]> adj=new Hashtable<Character, Character[]>();
		Hashtable<Character,String[]> parent=new Hashtable<Character,String[]>();
		Hashtable<Character,Boolean> visited=new Hashtable<Character,Boolean>();
		Character list1[]={'a','x'};
		adj.put('s',list1);
		Character list2[]={'s','z'};
		adj.put('a',list2);
		Character list3[]={'a'};
		adj.put('z',list3);
		Character list4[]={'s','d','c'};
		adj.put('x',list4);
		Character list5[]={'x','c','f'};
		adj.put('d',list5);
		Character list6[]={'x','d','f','v'};
		adj.put('c',list6);
		Character list7[]={'d','c','v'};
		adj.put('f',list7);
		Character list8[]={'c','f'};
		adj.put('v',list8);

		visited.put('s', true);
		visited.put('a', false);
		visited.put('c', false);
		visited.put('d', false);
		visited.put('v', false);
		visited.put('f', false);
		visited.put('z', false);
		visited.put('x', false);
		
		System.out.println('s');
        String s[]=new String[2];
        s[0]="0";
        s[1]="NIL";
        parent.put('s', s);
		Queue<Character> q=new LinkedList<Character>();
		q.add('s');
		while(!q.isEmpty())
		{
			char v=q.remove();
			for(char u : adj.get(v))
			{
				if(!visited.get(u))
				{
					String p[]=parent.get(v);
					System.out.println(u);
					q.add(u);
					visited.put(u, true);
					String t[]=new String[2];
					t[1]=v+"";
					t[0]=(Integer.parseInt(p[0])+1)+"";
					parent.put(u, t);
				}
			}
		}
		
		Enumeration<Character> keys=parent.keys();
		while(keys.hasMoreElements())
		{
			char c=keys.nextElement();
			String p[]=parent.get(c);
			System.out.println(c+"--->"+p[1]+" dist:"+p[0]);
		}

	}
}
