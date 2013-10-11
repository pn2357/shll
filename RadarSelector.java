package shll;

public class RadarSelector implements Consts
{
	Exec myRobot =null;
	Enemy enemy = null;
	FullTurnRadar fullTurnRadar =new FullTurnRadar();
	ChaseScanRadar chaseScanRadar =new ChaseScanRadar();
	 
	public Radar select(Exec myRobot,Enemy enemy)
	{
		this.myRobot=myRobot;
		this.enemy=enemy;
		
		if(!myRobot.enemyInSightFlag)
			return fullTurnRadar;		//�G�����G�͈͓��ɂ��Ȃ��ꍇ
		else
			return chaseScanRadar;
	}
	
	/**�I���\�ȃ��[�_�[�̐헪
	*FullTurnRadar(�퓬�J�n���ɓG��������)
	*ChaseScanRadar(�������I��������A�퓬������������ƍ��G��������)
	*/	
	public class FullTurnRadar implements Radar
	{
		public double getDegree()
		{
			return Consts.FULL_TURN;
		}
	}
	
	public class ChaseScanRadar implements Radar
	{
		double turnRadar;
		double past=RADAR_MAX_SPEED/2;
		public double getDegree()
		{
			turnRadar=Util.normalizeDegree(enemy.getBearing()+myRobot.getHeading()-myRobot.getRadarHeading());
			turnRadar+=(turnRadar>0)?past:-past;
			return Util.normalizeDegree(turnRadar);
		}
		
	}

}