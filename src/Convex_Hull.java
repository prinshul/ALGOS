import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;


public class Convex_Hull {
	ArrayList<Point> p;
	class Point 
	{
		double  x;
		double y;
		double angle;
		public Point(double x,double y) {
			this.x=x;
			this.y=y;
			this.angle=0;
		}
	}

	public double getAngle(Point p1,Point p2)
	{
		if(p1.equals(p2))
			return 0;
		if(p1.x==p2.x)
			return 90;
		double slope=(p2.y-p1.y)/(p2.x-p1.x);
		double angle=(Math.atan(slope))*180/Math.PI;
		if(angle<0)
			angle=angle+180;
		return angle;
	}

	public static void main(String[] args) {
		Convex_Hull c=new Convex_Hull();
		c.findConvexHull();
	}

	int ccw(Point a,Point b,Point c)
	{
		double val= ((b.x-a.x)*(c.y-a.y))-((b.y-a.y)*(c.x-a.x));
		if(val>0)
			return 1;
		else
			if(val<0)
				return -1;
			else
				return 0;
	}

	void findConvexHull()
	{
		p=new ArrayList<Convex_Hull.Point>();
		Point a=new Point(2, 3);
		p.add(a);
		a=new Point(4, 1);
		p.add(a);
		a=new Point(7, 6);
		p.add(a);
		a=new Point(3, 3);
		p.add(a);
		a=new Point(12, 13);
		p.add(a);
		a=new Point(6, -9);
		p.add(a);
		a=new Point(9, 3);
		p.add(a);
		a=new Point(10, -3);
		p.add(a);
		a=new Point(-7, -11);
		p.add(a);
		a=new Point(-2, 0);
		p.add(a);
		a=new Point(-10, 2);
		p.add(a);

		Comparator<Point> c=new Comparator<Convex_Hull.Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if(o1.y>o2.y)
					return 1;
				else if(o1.y<o2.y)
					return -1;
				else
					return 0;
			}
		};

		p.sort(c);
		for(int i=0;i<p.size();i++)
		{
			p.get(i).angle=getAngle(p.get(0),p.get(i));
		}
		Point p0=p.get(0);
		p.remove(0);
		Comparator<Point> comp=new Comparator<Convex_Hull.Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if(o1.angle>o2.angle)
					return 1;
				else if(o1.angle<o2.angle)
					return -1;
				else
					return 0;
			}
		};
		p.sort(comp);
		ArrayList<Point> fp=new ArrayList<Convex_Hull.Point>();
		fp.add(p0);
		for(int i=0;i<p.size();i++)
			fp.add(p.get(i));
		Stack<Point> stack=new Stack<Convex_Hull.Point>();
		stack.push(fp.get(0));
		stack.push(fp.get(1));
		for(int i=2;i<fp.size();i++)
		{
			Point top=stack.pop();
			while(ccw(stack.peek(), top, fp.get(i))<=0)
				top=stack.pop();
			stack.push(top);
			stack.push(fp.get(i));
		}
		
		Iterator<Point> points=stack.iterator();
		while(points.hasNext())
		{
			Point p=points.next();
			System.out.println("("+p.x+","+p.y+")");
		}
	}


}
