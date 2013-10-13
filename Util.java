package shll;

public class Util implements Consts {
	private Util(){}

    // �����̐�����Ԃ�
    public static double sign(double x)
    {
        return (x > 0.0 ? 1 : (x < 0.0 ? -1 : 0));
    }

    // sin�֐���360�x�P�ʂŎg�p�ł���悤�ɂ��邽�߂̃��\�b�h
    public static double sin(double v)
    {
        return Math.sin(Math.toRadians(v));
    }
    
    // cos�֐���360�x�P�ʂŎg�p�ł���悤�ɂ��邽�߂̃��\�b�h
    public static double cos(double v)
    {
        return Math.cos(Math.toRadians(v));
    }
    
    // atan�֐���360�x�P��/���{�R�[�h���W�n�Ŏg�p�ł���悤�ɂ��邽�߂̃��\�b�h
    public static double atan(double y, double x)
    {
        return QUATER_TURN - Math.toDegrees(Math.atan2(y, x));
    }
    

    //  ���{�R�[�h���W�n�ł̊p�x���A���w���W�n�ɕϊ�
	public static double toMathDegree(double roboDegree)
	{
		return -roboDegree + QUATER_TURN;
	}
    
    //  ���w���W�n�ł̊p�x���A���{�R�[�h���W�n�ɕϊ�
	public static double toRoboDegree(double mathDegree)
	{
		return -mathDegree + QUATER_TURN;
	}

	// �p�x��-180�x����180�x�ɐ��K��
	public static double normalizeDegree(double degree)
	{
		degree = degree % FULL_TURN;

		if (degree < -HARF_TURN) {
			degree += FULL_TURN;
		}
		if (degree > HARF_TURN) {
			degree -= FULL_TURN;
		}

		return degree;
	}

	// �p�x��-90�x����90�x & �����ɕϊ�
	public static class ShortTurn
	{
		private double _degree = 0;
		private int _dir = 1;

		public ShortTurn(double degree) {
			degree = normalizeDegree(degree);
			if (Math.abs(degree) <= QUATER_TURN) {
				_degree = degree;
				_dir = 1;
			} else {
				if (degree > QUATER_TURN) {
					_degree = degree - HARF_TURN;
				} else {
					_degree = degree + HARF_TURN;
				}
				_dir = -1;
			}
		}

		// �p�x��Ԃ� [-90,90]
		public double getDegree() {
			return _degree;
		}

		// ������Ԃ� +1,-1
		public int getDirection() {
			return _dir;
		}
	}
}