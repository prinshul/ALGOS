
public class Maze_With_Recursion {
	char maze[][];
	boolean visited[][];
	boolean solution[][];
	public static void main(String[] args) {
		new Maze_With_Recursion().solve_maze();
	}

	void solve_maze()
	{
		maze=new char[4][5];
		visited=new boolean[4][5];
		solution=new boolean[4][5];
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<5;j++)
			{
				maze[i][j]='O';
				visited[i][j]=false;
				solution[i][j]=false;
			}
		}
		maze[0][3]='B';
		maze[1][3]='B';
		maze[3][1]='B';
		maze[3][4]='B';
		

		boolean found=find_Path(1,0);
		if(!found)
		{
			System.out.println("No path");
		    return;
		}
		System.out.println("PAth found");
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<5;j++)
			{
				if(solution[i][j])
					System.out.println("("+i+","+j+")");
			}
		}
		
	}
	
	boolean find_Path(int r,int c)
	{
		if(r<0 || r>3 || c<0 || c>4)
			return false;
		if(maze[r][c]=='B' || visited[r][c])
			return false;
		if(r==2 && c==4)
			return true;
		 visited[r][c]=true;
		if(find_Path(r, c-1))
		{
			solution[r][c-1]=true;
			return true;
		}
		if(find_Path(r+1, c))
		{
			solution[r+1][c]=true;
			return true;
		}
		if(find_Path(r, c+1))
		{
			solution[r][c+1]=true;
			return true;
		}
		if(find_Path(r-1, c))
		{
			solution[r-1][c]=true;
			return true;
		}
		return false;
	}
}
