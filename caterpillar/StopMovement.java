package shll.caterpillar;

import shll.Enemy;
import shll.Exec;
import shll.Util;
import shll.Util.ShortTurn;

public class StopMovement implements Movement
{
	double degree=0.0;
	double distance=0.0;
	StopMovement(Exec myRbot,Enemy enemy)
	{
		Util.ShortTurn shortTutn =  new ShortTurn(enemy.getBearing() + 90);
		degree=shortTutn.getDegree();
	}
	public Double getDegree()
	{
		return new Double(degree);
	}

	public Double getDistance()
	{
		return null;
	}
}