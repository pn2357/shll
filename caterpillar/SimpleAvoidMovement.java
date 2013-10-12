package shll.caterpillar;
import shll.*;

public class SimpleAvoidMovement implements Movement
{
	double degree=0.0;
	double distance=50.0;
	SimpleAvoidMovement(Exec myRobot,Enemy enemy)
	{
		degree=Util.normalizeDegree(enemy.getBearing()+90);
		distance=myRobot.direction*distance;
	}
	
	public double getDegree()
	{
		return degree;
	}
	
	public double getDistance()
	{
		return distance;
	}
}