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
	public class StopMovement implements Movement
	{

		public double getDegree() {
			// TODO 自動生成されたメソッド・スタブ
			return 0;
		}

		public double getDistance() {
			// TODO 自動生成されたメソッド・スタブ
			return 0;
		}
		
	}
}
