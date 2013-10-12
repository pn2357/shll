package shll.caterpillar;

import shll.Enemy;
import shll.Exec;
import shll.Util;

public class StopMovement implements Movement
{
	double degree=0.0;
	StopMovement(Exec myRbot,Enemy enemy)
	{
		degree=Util.normalizeDegree(enemy.getBearing() + 90);
	}
	public double getDegree()
	{
		return degree;
	}

	public double getDistance() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}
}