package shll.gun;
import shll.*;

public class FullTurnGun implements Gun,Consts
{	
	public Double getDegree()
	{
		return new Double(FULL_TURN);
	}
	
	public Double getPower()
	{
		return new Double(0);
	}
}