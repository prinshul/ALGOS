
public class TwoLineIntersect {

	class Point
	{
		int x;
		int y;
		Point(int x,int y)
		{
			this.x=x;
			this.y=y;
		}

	}
	public static void main(String[] args) {
		TwoLineIntersect t=new TwoLineIntersect();
		t.createSegments();	
	}

	void createSegments()
	{
		Point p1=new Point(5, 8);
		Point p2=new Point(2, 3);
		Point p3=new Point(2, 4);
		Point p4=new Point(4, 4);

		System.out.println(isIntersect(p1, p2, p3, p4));
	}

	boolean isIntersect(Point p1,Point p2,Point p3,Point p4)
	{
		int d1= determinant(p3,p1,p4);
		int d2= determinant(p3,p2,p4);
		int d3= determinant(p1,p4,p2);
		int d4= determinant(p1,p3,p2);

		if(((d1>0) && (d2<0) || (d1<0) && (d2>0))
				&& ((d3>0) && (d4<0) || (d3<0) && (d4>0)))
			return true;
		else if (d1==0 && (onSegment(p3, p4, p1)))
			return true;
		else if (d2==0 && (onSegment(p3, p4, p2)))
			return true;
		else if (d3==0 && (onSegment(p1, p2, p4)))
			return true;
		else if (d4==0 && (onSegment(p1, p2, p3)))
			return true;

		return false;

	}

	int determinant(Point p3,Point p1,Point p4)
	{
		int X1= p1.x -p3.x;
		int Y1= p1.y -p3.y;
		int X2= p4.x -p3.x;
		int Y2= p4.y -p3.y;

		int det=(X1*Y2)-(X2*Y1);
		return det;
	}
	boolean onSegment(Point p1,Point p2,Point p3)
	{
		int Xmin=Math.min(p1.x, p2.x);
		int Xmax=Math.max(p1.x, p2.x);

		int Ymin=Math.min(p1.y, p2.y);
		int Ymax=Math.max(p1.y, p2.y);

		if((Xmin <= p3.x  && p3.x<=Xmax) &&
				((Ymin <= p3.y  && p3.y<=Ymax)))
			return true;
		else
			return false;
	}
}
