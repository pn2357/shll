package shll.gun;
import shll.*;

public class GunSelector implements Consts
{	
	/**�I���\�ȍU���헪
	 * FullTurnGun : ����X�L�������ɍő���G�͈͂𓾂邽�߂̉�]
	 * EstimateNomal
	 * EstimateLinear : ���`�\��
	 * EstimateCircular : �~�`�\��
	 */
	
	/**
	 * ���\�b�h
	 */
	public static Gun select(Exec myRobot,Enemy enemy)
	{
		if(!myRobot.enemyInSightFlag)
			return new FullTurnGun();
		else
			return new EstimateLinear(myRobot,enemy);
	}
	

		
}
