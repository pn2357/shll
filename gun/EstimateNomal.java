package shll.gun;
import shll.*;
import shll.Util;

public class EstimateNomal implements Gun
{
	double degree=0.0;
	double power =0.0;
	
	public void calc(Exec myRobot,Enemy enemy)
	{
		degree=Util.normalizeDegree(enemy.getBearing()+myRobot.getHeading()-myRobot.getGunHeading());
		power=2.0;
	}
	public Double getDegree()
	{
		return new Double(degree);
	}

	public Double getPower() {
		return new Double(power);
	}
}