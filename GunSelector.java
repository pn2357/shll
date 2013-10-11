package shll;

public class GunSelector implements Consts
{
	//�����C���X�^���X���J��Ԃ��g�p���Ă���
	FullTurnGun fullTurnGun =new FullTurnGun();
	EstimateNomal estimateNomal =new EstimateNomal();	
	
	/**
	 * ���\�b�h
	 */
	public Gun select(Exec myRobot)
	{
		if(!myRobot.enemyInSightFlag)
			return fullTurnGun;
		else
			return estimateNomal;
	}
	
		/**�I���\�ȍU���헪
	 * FullTurnGun : ����X�L�������ɍő���G�͈͂𓾂邽�߂̉�]
	 * EstimateNomal
	 * EstimateLinear : ���`�\��
	 * EstimateCircular : �~�`�\��
	 */
	public class FullTurnGun implements Gun
	{
		public double getDegree()
		{
			return FULL_TURN;
		}
		
		public double getPower()
		{
			return 0;
		}
	}
	
	public class EstimateNomal implements Gun
	{

		public double getDegree() {
			return 0;
		}

		public double getPower() {
			return 0;
		}
	}
	
	public class EstimateCircular implements Gun
	{

		public double getDegree() {
			// TODO �����������ꂽ���\�b�h�E�X�^�u
			return 0;
		}

		public double getPower() {
			// TODO �����������ꂽ���\�b�h�E�X�^�u
			return 0;
		}
		
	}
	
	public class EstimateLinear implements Gun
	{

		public double getDegree() {
			// TODO �����������ꂽ���\�b�h�E�X�^�u
			return 0;
		}

		public double getPower() {
			// TODO �����������ꂽ���\�b�h�E�X�^�u
			return 0;
		}

	}
		
}
