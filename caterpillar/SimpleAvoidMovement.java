package shll.caterpillar;
import shll.*;
import shll.Util.ShortTurn;

public class SimpleAvoidMovement implements Movement
{
	double degree=0.0;
	double distance=80;
	int ramdomDirection=1;
	
	SimpleAvoidMovement(Exec myRobot,Enemy enemy)
	{
		Util.ShortTurn shortTurn = new ShortTurn(enemy.getBearing()+90);
		degree=shortTurn.getDegree();
		distance=myRobot.direction*shortTurn.getDirection()*distance;
	}
	
	public Double getDegree()
	{
		return new Double(degree);
	}
	
	public Double getDistance()
	{
		return new Double(distance);
	}
}