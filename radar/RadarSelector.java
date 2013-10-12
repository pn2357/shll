package shll.radar;
import shll.*;

public class RadarSelector implements Consts
{
	/**�I���\�ȃ��[�_�[�̐헪
	*FullTurnRadar(�퓬�J�n���ɓG��������)
	*ChaseScanRadar(�������I��������A�퓬������������ƍ��G��������)
	*/
	 
	public static Radar select(Exec myRobot,Enemy enemy)
	{	
		if(!myRobot.enemyInSightFlag)
			return new FullTurnRadar();		//�G�����G�͈͓��ɂ��Ȃ��ꍇ
		else
			return new ChaseScanRadar(myRobot, enemy);
	}
	


}