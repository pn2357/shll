package shll;

public class GunSelector implements Consts
{
	//同じインスタンスを繰り返し使用している
	FullTurnGun fullTurnGun =new FullTurnGun();
	EstimateNomal estimateNomal =new EstimateNomal();
	Exec myRobot =null;
	Enemy enemy = null;
	
	/**
	 * メソッド
	 */
	public Gun select(Exec myRobot,Enemy enemy)
	{
		this.myRobot=myRobot;
		this.enemy=enemy;
		
		if(!myRobot.enemyInSightFlag)
			return fullTurnGun;
		else
			return estimateNomal;
	}
	
		/**選択可能な攻撃戦略
	 * FullTurnGun : 初回スキャン時に最大索敵範囲を得るための回転
	 * EstimateNomal
	 * EstimateLinear : 線形予測
	 * EstimateCircular : 円形予測
	 */
	public class FullTurnGun implements Gun
	{
		public double getDegree()
		{
			return FULL_TURN;
		}
		
		public double getPower()
		{
			return 0;
		}
	}
	
	public class EstimateNomal implements Gun
	{

		public double getDegree()
		{
			return Util.normalizeDegree(enemy.getBearing()+myRobot.getHeading()-myRobot.getGunHeading());
		}

		public double getPower() {
			return 2.0;
		}
	}
	
	public class EstimateCircular implements Gun
	{

		public double getDegree() {
			// TODO 自動生成されたメソッド・スタブ
			return 0;
		}

		public double getPower() {
			// TODO 自動生成されたメソッド・スタブ
			return 0;
		}
		
	}
	
	public class EstimateLinear implements Gun
	{

		public double getDegree() {
			// TODO 自動生成されたメソッド・スタブ
			return 0;
		}

		public double getPower() {
			// TODO 自動生成されたメソッド・スタブ
			return 0;
		}

	}
		
}
