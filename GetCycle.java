package shll;

public class GetCycle
{
	long target=0;	//getTimeの戻り値の型がlongの為
	boolean flag=true;
	
	public boolean getCycle(long nowTime,int cycle)
	{
		if(flag)
		{
			target=nowTime+cycle-1;		//0を含むとので1カウント分多くなるため
			flag=false;
		}
		
		if(nowTime==target)
		{
			flag=true;
			return true;
		}
		else
		{
			return false;
		}
	}
}