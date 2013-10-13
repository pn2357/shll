package shll.gun;
import shll.*;

public class DecideBulletPower
{
	private double bulletPower=0.0;
	
	public DecideBulletPower(Exec myRobot,Enemy enemy)
	{
		if(myRobot.getEnergy()<8.0)
			bulletPower=0.1;
		else
			bulletPower=600/enemy.getDistance();
	}
	
	public double getBulletPower()
	{
		return bulletPower;
	}	
}
