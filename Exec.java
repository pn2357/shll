package shll;

import java.awt.Color;

import robocode.*;

public class Exec extends AdvancedRobot implements Consts
{
	int count=0;
	Movement movement = null;
	Gun gun =null;
	Radar radar = null;
	MovementSelector movementSelector = new MovementSelector();
	GunSelector gunSelector = new GunSelector();
	RadarSelector radarSelector = new RadarSelector();
	Enemy enemy =new Enemy();
	public boolean enemyInSightFlag=false;
	public boolean shotDetectedFlag=false;
	
	public void run()
	{
		initialize();
		while(true)
		{
			if(shotDetectedFlag) out.println("ban");
			doMove();		//移動行動の決定
			doRadar();		//レーダーの行動の決定
			doGun();		//砲撃の行動の決定
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
	
	public void doMove()
	{
		movement=movementSelector.select(this,enemy);
		setTurnRight(movement.getDegree());
		if(movement.getDistance()!=0)
			setAhead(movement.getDistance());
	}
	
	public void doGun()
	{
		gun=gunSelector.select(this,enemy);
		setTurnGunRight(gun.getDegree());
		if(gun.getPower()!=0)
			setFire(gun.getPower());
	}
	
	public void doRadar()
	{
		radar=radarSelector.select(this,enemy);
		setTurnRadarRight(radar.getDegree());
	}
	
	/*public void onCustomEvent(CustomEvent e)
	{
		//if(e.getCondition() instanceof RadarTurnCompleteCondition)
		//this.removeCustomEvent(e.getCondition());	//一度使ったらもう呼ばないということ
	}*/
	
	public void onScannedRobot(ScannedRobotEvent e)
	{	
		decisionShot(e);
		enemyInSightFlag=true;
		enemy.setAll(e);
		

	}
	public void decisionShot(ScannedRobotEvent e)
	{
		/*性質上energyを更新する処理はこの関数の前に持ってこないようにする*/
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
}
