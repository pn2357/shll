package shll.gun;
import shll.*;

public class GunSelector implements Consts
{	
	/**選択可能な攻撃戦略
	 * FullTurnGun : 初回スキャン時に最大索敵範囲を得るための回転
	 * EstimateNomal
	 * EstimateLinear : 線形予測
	 * EstimateCircular : 円形予測
	 */
	
	/**
	 * メソッド
	 */
	public static Gun select(Exec myRobot,Enemy enemy)
	{
		if(!myRobot.enemyInSightFlag)
			return new FullTurnGun();
		else
			return new EstimateLinear(myRobot,enemy);
	}
	

		
}
