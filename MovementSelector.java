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
	 * �I���\�Ȉړ��헪
	 * FullTurnMovement : ����X�L�������ɍő���G�͈͂𓾂邽�߂̉�]
	 * SimpleAvoidMovement : �ʏ펞�̉����@
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
