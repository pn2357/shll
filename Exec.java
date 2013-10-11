package shll;

import java.awt.Color;

import robocode.*;

public class Exec extends AdvancedRobot implements Consts
{
	Movement movement = null;
	Radar radar = null;
	Gun gun =null;
	MovementSelector movementSelector = new MovementSelector();
	RadarSelector radarSelector = new RadarSelector();
	GunSelector gunSelector = new GunSelector();
	Enemy enemy =new Enemy();
	
	public boolean enemyInSightFlag=false;
	
	public void run()
	{
		initialize();
		while(true)
		{
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
		movement=movementSelector.select(this);
		setTurnRight(movement.getDegree());
		setAhead(movement.getDistance());
	}
	public void doGun()
	{
		gun=gunSelector.select(this);
		setTurnGunRight(gun.getDegree());
		if(gun.getPower()!=0)
			setFire(gun.getPower());
		out.println(gun.getPower());
	}
	public void doRadar()
	{
		radar=radarSelector.select(this,enemy);
		setTurnRadarRight(radar.getDegree());
	}
	
	public void onScannedRobot(ScannedRobotEvent e)
	{
		enemyInSightFlag=true;
		enemy.setAll(e);
	}
}
