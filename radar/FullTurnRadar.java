package shll.radar;
import shll.*;

public class FullTurnRadar implements Radar,Consts
{
	public Double getDegree()
	{
		return new Double(FULL_TURN);
	}
}