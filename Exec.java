package shll;

import java.awt.Color;

import shll.radar.*;
import shll.gun.*;
import shll.caterpillar.*;
import robocode.*;

public class Exec extends AdvancedRobot implements Consts
{
	int count=0;
	Movement movement = null;
	Gun gun =null;
	Radar radar = null;
	Enemy enemy =new Enemy();
	public int direction =1;
	public boolean enemyInSightFlag=false;
	public boolean shotDetectedFlag=false;
	GetCycle getCycle =new GetCycle();
	
	public void run()
	{
		initialize();
		while(true)
		{
			doMove();		//�ړ��s���̌���
			doRadar();		//���[�_�[�̍s���̌���
			doGun();		//�C���̍s���̌���
			if(getCycle.getCycle(getTime(),3))
				out.print(count++);
			execute();
		}
	}
	
	public void initialize()
	{
		setAdjustGunForRobotTurn(true);
		setAdjustRadarForGunTurn(true);
		setAdjustRadarForRobotTurn(true);
		setColors(Color.black, Color.black, Color.black);
		setScanColor(Color.black);
	}
	
	/**
	 * do�n�Ń��b�p�[�N���X���g�p����̂͒�~�ƌp�����g�������������߁B
	 * null���Ԃ��ꂽ����if���ɂ��O�̓�����p�����čs���B0�̎���0���Z�b�g�o����������~�ł���
	 */
	public void doMove()
	{
		movement=MovementSelector.select(this,enemy);
		if(movement.getDegree()!=null)
			setTurnRight(movement.getDegree().doubleValue());
		if(movement.getDistance()!=null)
			setAhead(movement.getDistance().doubleValue());
	}
	
	public void doGun()
	{
		gun=GunSelector.select(this,enemy);
		if(gun.getDegree()!=null)
			setTurnGunRight(gun.getDegree().doubleValue());
		if(gun.getPower()!=null)
			setFire(gun.getPower().doubleValue());
	}
	
	public void doRadar()
	{
		radar=RadarSelector.select(this,enemy);
		if(radar.getDegree()!=null)
			setTurnRadarRight(radar.getDegree().doubleValue());
	}
	
	/*public void onCustomEvent(CustomEvent e)
	{
		//if(e.getCondition() instanceof RadarTurnCompleteCondition)
		//this.removeCustomEvent(e.getCondition());	//��x�g����������Ă΂Ȃ��Ƃ�������
	}*/
	
	public void onScannedRobot(ScannedRobotEvent e)
	{	
		decisionShot(e);
		enemyInSightFlag=true;
		enemy.setAll(e);
	}
	public void decisionShot(ScannedRobotEvent e)
	{
		/*������energy���X�V���鏈���͂��̊֐��̑O�Ɏ����Ă��Ȃ��悤�ɂ���*/
		if(enemy.getEnergy()==0) enemy.setEnergy(e.getEnergy());	
		double energyLoss=enemy.getEnergy()-e.getEnergy();
		//enemy.setEnergy(e.getEnergy());
		if(0.1<=energyLoss && energyLoss<=3.0)
			shotDetectedFlag=true;
		else
			shotDetectedFlag=false;
	}
	
	public void onHitByBullet(HitByBulletEvent e)
	{
		double power=e.getPower();
		double energy=4.0*power + enemy.getEnergy();
		if(power > 1.0) energy += 2.0*(power-1.0);
		enemy.setEnergy(energy);
	}
	
	public void onWin(WinEvent event)
	{
		setColors(Color.white, Color.white,Color.white);
		setScanColor(Color.white);
		while(true)
		{
			setTurnRight(360);
			setTurnGunRight(360);
			setTurnRadarRight(360);
			setAhead(0);
			execute();
		}
	}
	
	public void onHitWall(HitWallEvent event)
	{
		direction=-direction;
	}
}
