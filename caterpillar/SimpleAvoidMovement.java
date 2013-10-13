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
		ramdomDirection=(Math.random()>0.5)?1:-1;
		distance=ramdomDirection*distance;
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