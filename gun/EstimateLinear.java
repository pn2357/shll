package shll.gun;

import shll.Enemy;
import shll.Exec;
import shll.Util;

public class EstimateLinear implements Gun
{
	double bulletPower=2.0;
	double degree=0.0;
	GunBearingEstimator gunBearingEstimator;
	
	/**
	 * コンストラクタ
	 */
	
	EstimateLinear(Exec myRobot,Enemy enemy)
	{
		double v=enemy.getVelocity();
		double h=Util.normalizeDegree(enemy.getHeading());
		double b=Util.normalizeDegree(myRobot.getHeading()+enemy.getBearing());
		double d=enemy.getDistance();
		
		LinearFunction linearFunction =new LinearFunction(v,h,b,d);
		gunBearingEstimator=new GunBearingEstimator(linearFunction,bulletPower);
		degree=Util.normalizeDegree(gunBearingEstimator.getEstimatedGunBearing()-myRobot.getGunHeading());	//絶対角が返される
	}
	
	public double getDegree()
	{
		return degree;
	}

	public double getPower()
	{
		return bulletPower;
	}




}