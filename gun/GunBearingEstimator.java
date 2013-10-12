package shll.gun;
import shll.*;
/**
 * �Ə���F��C�̕��������ς��邽�߂̃N���X
 */
class GunBearingEstimator {
    EstimationFunction motionFunction; // �ړ��֐�
    double bulletVelocity;             // �e�ۂ̑��x
    
    /**
     * �R���X�g���N�^
     * �{���ł͊e���\�b�h�̈����Ɉړ��֐� f ���w�肵�Ă��܂������A
     * ���̃N���X�����ɂ������ăt�B�[���h�ɕێ����邱�Ƃɂ��܂����B
     * @param f �I���킹�̑ΏۂƂȂ�ړ��֐�
     * @param p �e�ۂɎg�p����G�l���M�[�̗�
     */
    public GunBearingEstimator(EstimationFunction f, double p) {
        this.motionFunction = f;
        setBulletPower(p);
    }
    
    /**
     * �e�ۂɎg�p����G�l���M�[�̗ʂ��w�肷�郁�\�b�h
     * @param p �G�l���M�[�g�p��
     */
    public void setBulletPower(double p) {
        this.bulletVelocity = 20 - 3 * p;
    }
    
    /**
     * �I���킹���s�����\�b�h
     * @return ��C��������ׂ������i��Ίp�j
     */
    double getEstimatedGunBearing() {
        // �Փˎ������v�Z
        double t = getEstimatedImpactTime();
        
        // �Փˎ����ɂ�����G���{�b�g�̈ʒu���v�Z
        double dx = motionFunction.getEstimatedX(t);
        double dy = motionFunction.getEstimatedY(t);
        
        // ��C��������ׂ���Ίp��Ԃ�
        double b = Util.atan(dy, dx);
        return Util.normalizeDegree(b);
    }
    
    /**
     * �Z�J���g�@�ŏՓˎ������v�Z���郁�\�b�h
     * @return ���߂�Փˎ���
     */
    double getEstimatedImpactTime() {
        // �Z�J���g�@�̏����l
        double t0 = 10;
        double t1 = 20;
        
        // �����l�ɂ�����֐��̒l���v�Z
        double d0 = getEstimatedDistance(t0);
        
        // �J��Ԃ��v�Z
        for(int i=0; i<20; i++) {
            // ���x�𖞂�������I��
            if(Math.abs(t1 - t0) < 0.001) {
                break;
            }
            
            // �֐��̒l���v�Z
            double d1 = getEstimatedDistance(t1);
            // ���̋ߎ��_�����߂�
            double t2 = (t0 * d1 - t1 * d0) / (d1 - d0);
            
            // ���̌v�Z�ɔ����ēY�������V�t�g����
            t0 = t1;
            t1 = t2;
            d0 = d1;
        }
        
        // ���߂����ʂ�Ԃ�
        return t1;
    }
    
    /**
     * �e�ۂƓG���{�b�g�̋������v�Z���郁�\�b�h
     * @return ���˂���t�b��̒e�ۂƓG���{�b�g�̊Ԃ̋���
     * @param t ���˂���̎���
     */
    double getEstimatedDistance(double t) {
        // �e�ۂ̑��x
        double vb = bulletVelocity;
        
        // ����t�ɂ�����G���{�b�g�̈ʒu���v�Z
        double dx = motionFunction.getEstimatedX(t);
        double dy = motionFunction.getEstimatedY(t);
        
        // �������v�Z���ĕԂ�
        return Math.sqrt(dx * dx + dy * dy) - vb * t;
    }
}
