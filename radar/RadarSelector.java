package shll.radar;
import shll.*;

public class RadarSelector implements Consts
{
	/**選択可能なレーダーの戦略
	*FullTurnRadar(戦闘開始時に敵を見つける)
	*ChaseScanRadar(↑が一回終了した後、戦闘中相手をずっと索敵し続ける)
	*/
	 
	public static Radar select(Exec myRobot,Enemy enemy)
	{	
		if(!myRobot.enemyInSightFlag)
			return new FullTurnRadar();		//敵が索敵範囲内にいない場合
		else
			return new ChaseScanRadar(myRobot, enemy);
	}
	


}