package shll;

public class MovementSelector implements Consts
{
	FullTurnMovement fullTurnMovement= new FullTurnMovement();
	SimpleAvoidMovement simpleAvoidMovement =new SimpleAvoidMovement();
	
	public Movement select(Exec myRobot)
	{
		if(!myRobot.enemyInSightFlag)
			return fullTurnMovement;
		else
			return simpleAvoidMovement;
	}
	
	/**
	 * 選択可能な移動戦略
	 * FullTurnMovement : 初回スキャン時に最大索敵範囲を得るための回転
	 * SimpleAvoidMovement : 通常時の回避方法
	 */
	public class FullTurnMovement implements Movement,Consts
	{
		public double getDegree()
		{
			return FULL_TURN;
		}

		public double getDistance()
		{
			return 0;
		}
	}
	
	public class SimpleAvoidMovement implements Movement
	{
		
		public double getDegree()
		{
			return 0;
		}

		public double getDistance()
		{
			
			return 0;
		}

	}


}
