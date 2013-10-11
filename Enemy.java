package shll;

import robocode.ScannedRobotEvent;

public class Enemy
{
    private double heading=0.0;
    private double bearing=0.0;
    private double velocity=0.0;
    private double distance=0.0;
    private double energy=0.0;
    
    /**
     * �K�v�ȑS�p�����[�^�̃Z�b�g
     */
    public void setAll(ScannedRobotEvent e)
    {
    	heading=e.getHeading();
    	bearing=e.getBearing();
    	velocity=e.getVelocity();
    	distance=e.getDistance();
    	energy=e.getEnergy();
    }
    
    /**
     * �����̃��{�b�g����Ƃ��鑊��̃��{�b�g�̑��Ίp�x
     */
    public void setBearing(double bearing) {
        this.bearing = bearing;
    }

    public double getBearing() {
        return bearing;
    }

    /**
     * ����̃��{�b�g�̌����Ă������
     */
    public void setHeading(double heading) {
        this.heading = heading;
    }

    public double getHeading() {
        return heading;
    }

    /**
     * ����̃��{�b�g�̑��x
     */
    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public double getVelocity() {
        return velocity;
    }

    /**
     * ����̃��{�b�g�܂ł̋���
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    /**
     * ����̃��{�b�g�̗̑�
     */
    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public double getEnergy() {
        return energy;
    }
}
