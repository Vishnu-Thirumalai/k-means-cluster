import data.*;
import java.util.Scanner;

public class k_means {
	
	public static void main(String []args)
	{
		Scanner scn = new Scanner(System.in);
		System.out.print("How many points are there?");
				
		Point [] points = new Point[scn.nextInt()];
		
		System.out.println("Enter each point as x y, followed by 'Enter'.");
		for(int i =0; i<points.length; i++)
		{
			points[i] = new Point(scn.nextInt(), scn.nextInt());
			scn.nextLine();
		}

		System.out.println("Enter the number of clusters:");
		int k= scn.nextInt();
		System.out.println("\n");
		
		scn.close();
		
		solve(points, k);
	}
	
	private static void solve(Point[] points, int k)
	{
		
		Cluster [] clusters = new Cluster[k];
		
		for(int i=0; i < k; i ++)
		{
			clusters[i] = new Cluster(points[i]);
		}
		
		boolean go = true;
		double smallest=0;
		Cluster close = null;
		Point cen=null;
		
		while(go)
		{
			for(Cluster c: clusters)
			{
				c.empty();
			}
						
			for(Point p: points)
			{

				smallest = clusters[0].distance(p);
				close = clusters[0];
				for(Cluster c: clusters)
				{
					if(smallest > c.distance(p)).
					{
						smallest = c.distance(p);
						close = c;
					}
				}
				close.addPoint(p);
			}
			
			go = false;
			for(Cluster c: clusters)
			{
				cen = c.findCentroid();
				if(!c.getCentroid().equals(cen))
				{
					go = true;
					c.setCentroid(cen);
				}
			}
			
		}
		
		for(Cluster c: clusters)
		{
			System.out.println(c);
		}

	}
}
