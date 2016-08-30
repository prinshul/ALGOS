
public class Sudoku {

	public static void main(String[] args) {
		Sudoku s=new Sudoku();
		
		int n=9;
		int a[][] = new int[][]{{3, 0, 6, 5, 0, 8, 4, 0, 0},
                 {5, 2, 0, 0, 0, 0, 0, 0, 0},
                 {0, 8, 7, 0, 0, 0, 0, 3, 1},
                 {0, 0, 3, 0, 1, 0, 0, 8, 0},
                 {9, 0, 0, 8, 6, 3, 0, 0, 5},
                 {0, 5, 0, 0, 9, 0, 6, 0, 0},
                 {1, 3, 0, 0, 0, 0, 2, 5, 0},
                 {0, 0, 0, 0, 0, 0, 0, 7, 4},
                 {0, 0, 5, 2, 0, 6, 3, 0, 0}};
//		int a[][]=new int[n][n];
//		for(int i=0;i<n;i++)
//		{
//			for(int j=0;j<n;j++)
//			{
//				a[i][j]=0;
//			}
//		}
//		a[0][0]=5;
//		a[0][1]=3;
//		a[0][4]=7;
//		a[1][0]=6;
//		a[1][3]=1;
//		a[1][4]=9;
//		a[1][5]=5;
//
//		a[2][1]=9;
//		a[2][2]=8;
//		a[2][7]=6;
//
//		a[3][0]=8;
//		a[3][4]=6;
//		a[3][8]=3;
//
//		a[4][0]=4;
//		a[4][3]=8;
//		a[4][5]=3;
//		a[4][8]=1;
//
//		a[5][0]=7;
//		a[5][4]=2;
//		a[5][8]=6;
//
//		a[6][1]=6;
//		a[6][6]=2;
//		a[6][7]=8;
//
//		a[7][3]=4;
//		a[7][4]=1;
//		a[7][5]=9;
//		a[7][8]=5;
//
//		a[8][4]=8;
//		a[8][7]=7;
//		a[8][8]=9;


		s.sudoku(a,n);
			//s.print(a, n);
		//else
		//	System.out.println("No sol");
	}


	void sudoku(int a[][],int n)
	{
		int row=0;
		int col=0;
		boolean unassignedFound=false;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(a[i][j]==0)
				{
					row=i;
					col=j;
					unassignedFound=true;
					break;
				}
			}
			if(unassignedFound)
				break;
		}
		if(!unassignedFound)
		{
			row=n;
			col=n;
		}
		if(row==n && col==n)
		{
			//return true;
			print(a, n);
			System.out.println();
			return;
		}
			
		for(int i=1;i<=n;i++)
		{
			if(find(a,row,col,i,n))
			{
				a[row][col]=i;

				sudoku(a,n);
					//return true;
				a[row][col]=0;
			}

		}
		//a[row][col]=0;
		//return false;
	}

	void print (int a[][],int n)
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(a[i][j]+" ");
				if(j==n-1)
					System.out.println();
			}
		}
	}

	boolean find(int a[][],int i,int j,int k,int n)
	{
		for(int p=0;p<n;p++)
		{
			if(a[i][p]==k)
			{
				return false;
			}
		}

		for(int p=0;p<n;p++)
		{
			if(a[p][j]==k)
			{
				return false;
			}
		}

		int val=(int)Math.sqrt((double)n);

		int row1=0; int row2=val-1;
		int col1=0; int col2=val-1;
		while(true)
		{
			if(row1<=i && row2>=i)
				break;
			row1=row1+val;
			row2=row2+val;
		}
		while(true)
		{
			if(col1<=j && col2>=j)
				break;
			col1=col1+val;
			col2=col2+val;
		}

		for(int p=row1;p<=row2;p++)
		{
			for(int l=col1;l<=col2;l++)
			{
				if(a[p][l]==k)
				{
					return false;
				}
			}
		}


		return true;
	}


}
