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
			return fullTurnRadar;		//敵が索敵範囲内にいない場合
		else
			return chaseScanRadar;
	}
	
	/**選択可能なレーダーの戦略
	*FullTurnRadar(戦闘開始時に敵を見つける)
	*ChaseScanRadar(↑が一回終了した後、戦闘中相手をずっと索敵し続ける)
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