import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;


public class Maze_Using_BFS {

	class Maze
	{
		int r;
		int c;
		public Maze(int r,int c) {
			this.r=r;
			this.c=c;
		}
	}
	char maze[][];
	boolean visited[][];
	Hashtable<Maze, Maze> parent=new Hashtable<Maze_Using_BFS.Maze, Maze_Using_BFS.Maze>();
	public static void main(String[] args) {
		new Maze_Using_BFS().solve_maze();

		//source (1,0) ---> dest (2,4)
	}

	void solve_maze()
	{
		maze=new char[4][5];
		visited=new boolean[4][5];
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<5;j++)
			{
				maze[i][j]='O';
				visited[i][j]=false;
			}
		}
		maze[0][3]='B';
		maze[1][3]='B';
		maze[3][1]='B';
		maze[3][4]='B';

		visited[1][0]=true;

		boolean found=find_Path();
		if(!found)
		{
			System.out.println("No path");
		    return;
		}
		System.out.println("PAth found");

		Enumeration<Maze>keys=parent.keys();
		Maze end=null;
		while(keys.hasMoreElements())
		{
			Maze m=keys.nextElement();
			if(m.r==2 && m.c==4)
				end=m;
			System.out.println("Child:"+m.r+","+m.c);
			System.out.println("Parent:"+parent.get(m).r+","+parent.get(m).c);
			
		}
		ArrayList<Maze>solution =new ArrayList<Maze_Using_BFS.Maze>();
		solution.add(end)	;
		do
		{
		   Maze par=parent.get(end);
		   solution.add(par);
		   end=par;
		   
		}while(!(end.r==1 && end.c==0));
	
		for(int i=solution.size()-1;i>=0;i--)
		{
			System.out.println("("+solution.get(i).r+","+solution.get(i).c+")");
		}
	}

	boolean find_Path()                               //BFS
	{
		Queue<Maze> q=new LinkedList<Maze_Using_BFS.Maze>();
		Maze m=new Maze(1, 0);  //start
		q.add(m);
		while(!q.isEmpty())
		{
			Maze cell=q.remove();
			ArrayList<Maze>cells=getValidCells(cell);
			for(Maze c: cells)
			{
				if(c.r==2 && c.c==4)
				{
					parent.put(c, cell);
					return true;
				}


				if(!visited[c.r][c.c])
				{
					visited[c.r][c.c]=true;
					q.add(c);
					parent.put(c,cell);
				}
			}
		}
		return false;
	}

	ArrayList<Maze> getValidCells(Maze cell)
	{
		ArrayList<Maze>cells =new ArrayList<Maze_Using_BFS.Maze>();
		Maze c1=new Maze(cell.r-1,cell.c);
		Maze c2=new Maze(cell.r,cell.c+1);
		Maze c3=new Maze(cell.r+1,cell.c);
		Maze c4=new Maze(cell.r,cell.c-1);
		if(c1.r>=0 && c1.c>=0 && c1.r<=3 && c1.c<=4 && maze[c1.r][c1.c]!='B')
			cells.add(c1);
		if(c2.r>=0 && c2.c>=0 && c2.r<=3 && c2.c<=4 && maze[c2.r][c2.c]!='B')
			cells.add(c2);
		if(c3.r>=0 && c3.c>=0 && c3.r<=3 && c3.c<=4 && maze[c3.r][c3.c]!='B')
			cells.add(c3);
		if(c4.r>=0 && c4.c>=0 && c4.r<=3 && c4.c<=4 && maze[c4.r][c4.c]!='B')
			cells.add(c4);
		return cells;
	}
}
