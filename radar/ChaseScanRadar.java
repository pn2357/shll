package shll.radar;
import shll.*;

public class ChaseScanRadar implements Radar,Consts
{
	double degree;
	double past=RADAR_MAX_SPEED/2;
	
	ChaseScanRadar(Exec myRobot, Enemy enemy)
	{
		degree=Util.normalizeDegree(enemy.getBearing()+myRobot.getHeading()-myRobot.getRadarHeading());
		degree+=(degree>0)?past:-past;
	}
	
	public Double getDegree()
	{
		return new Double(degree);
	}

	
}