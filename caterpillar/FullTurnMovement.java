package shll.caterpillar;
import shll.*;

public class FullTurnMovement implements Movement,Consts
{
	public Double getDegree()
	{
		return new Double(FULL_TURN);
	}

	public Double getDistance()
	{
		return new Double(0);
	}
}