package shll;

public class GetCycle
{
	long target=0;	//getTime�̖߂�l�̌^��long�̈�
	boolean flag=true;
	
	public boolean getCycle(long nowTime,int cycle)
	{
		if(flag)
		{
			target=nowTime+cycle-1;		//0���܂ނƂ̂�1�J�E���g�������Ȃ邽��
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