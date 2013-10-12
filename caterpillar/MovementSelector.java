package shll.caterpillar;
import shll.*;

public class MovementSelector implements Consts
{
	/**
	 * 選択可能な移動戦略
	 * FullTurnMovement : 初回スキャン時に最大索敵範囲を得るための回転
	 * SimpleAvoidMovement : 通常時の回避方法
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
