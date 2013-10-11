package shll;

public class MovementSelector implements Consts
{
	FullTurnMovement fullTurnMovement= new FullTurnMovement();
	SimpleAvoidMovement simpleAvoidMovement =new SimpleAvoidMovement();
	StopMovement stopMovement =new StopMovement();
	Exec myRobot =null;
	Enemy enemy = null;
	
	public Movement select(Exec myRobot,Enemy enemy)
	{
		this.myRobot=myRobot;
		this.enemy=enemy;
		
		if(!myRobot.enemyInSightFlag)
			return fullTurnMovement;
		else if(myRobot.shotDetectedFlag)
			return simpleAvoidMovement;
		else 
			return stopMovement;
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
	public class StopMovement implements Movement
	{

		public double getDegree() {
			// TODO �����������ꂽ���\�b�h�E�X�^�u
			return 0;
		}

		public double getDistance() {
			// TODO �����������ꂽ���\�b�h�E�X�^�u
			return 0;
		}
		
	}
}
