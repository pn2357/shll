package shll.caterpillar;
import shll.*;

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