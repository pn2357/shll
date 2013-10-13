package shll.gun;

import shll.Enemy;
import shll.Exec;
import shll.Util;

public class EstimateLinear implements Gun
{
	private double bulletPower=2.0;
	private double degree=0.0;
	private GunBearingEstimator gunBearingEstimator;
	
	/**
	 * コンストラクタ
	 */
	
	EstimateLinear(Exec myRobot,Enemy enemy)
	{
		double v=enemy.getVelocity();
		double h=Util.normalizeDegree(enemy.getHeading());
		double b=Util.normalizeDegree(myRobot.getHeading()+enemy.getBearing());
		double d=enemy.getDistance();
		bulletPower=new DecideBulletPower(myRobot,enemy).getBulletPower();
		gunBearingEstimator=new GunBearingEstimator(new LinearFunction(v,h,b,d),bulletPower);
		degree=Util.normalizeDegree(gunBearingEstimator.getEstimatedGunBearing()-myRobot.getGunHeading());
	}
	
	public Double getDegree()
	{
		return new Double(degree);
	}

	public Double  getPower()
	{
		return new Double(bulletPower);
	}




}