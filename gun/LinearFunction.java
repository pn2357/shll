package shll.gun;
import shll.*;

/**
 * ���`�ړ��֐�
 */
public class LinearFunction implements EstimationFunction {
    double enemyVelocity; // �G���{�b�g�̑��x v
    double enemyHeading;  // �G���{�b�g�̐i�s���� ��1
    double enemyInitialX; // �G���{�b�g�̏����ʒu��x���W
    double enemyInitialY; // �G���{�b�g�̏����ʒu��y���W
    
    /**
     * �R���X�g���N�^
     * @param v �G���{�b�g�̑��x v
     * @param h �G���{�b�g�̐i�s���� ��2
     * @param b �����{�b�g����G���{�b�g�ւ̕��� ��1
     * @param d �����{�b�g����G���{�b�g�܂ł̋��� d
     */
    public LinearFunction(double v, double h, double b, double d) {
        enemyVelocity = v;
        enemyHeading = h;
        enemyInitialX = d * Util.sin(b);
        enemyInitialY = d * Util.cos(b);
    }
    
    /**
     * ����t�ɂ�����x���W��Ԃ����\�b�h
     * @return ���߂�x���W
     * @param t ���� t
     */
    public double getEstimatedX(double t) {
        double ve = enemyVelocity;
        double he = enemyHeading;
        double xe = enemyInitialX;
        return xe + ve * t * Util.sin(he);
    }
    
    /**
     * ����t�ɂ�����y���W��Ԃ����\�b�h
     * @return ���߂�y���W
     * @param t ���� t
     */
    public double getEstimatedY(double t) {
        double ve = enemyVelocity;
        double he = enemyHeading;
        double ye = enemyInitialY;
        return ye + ve * t * Util.cos(he);
    }
}
