package shll.caterpillar;
import shll.*;

public class MovementSelector implements Consts
{
	/**
	 * �I���\�Ȉړ��헪
	 * FullTurnMovement : ����X�L�������ɍő���G�͈͂𓾂邽�߂̉�]
	 * SimpleAvoidMovement : �ʏ펞�̉����@
	 */
	
	public static Movement select(Exec myRobot,Enemy enemy)
	{
		if(!myRobot.enemyInSightFlag)
			return new FullTurnMovement();
		else if(myRobot.shotDetectedFlag)
			return new SimpleAvoidMovement(myRobot,enemy);
		else 
			return new StopMovement(myRobot,enemy);
	}
}
