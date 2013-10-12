package shll.gun;
import shll.*;
/**
 * 照準器：大砲の方向を見積もるためのクラス
 */
class GunBearingEstimator {
    EstimationFunction motionFunction; // 移動関数
    double bulletVelocity;             // 弾丸の速度
    
    /**
     * コンストラクタ
     * 本文では各メソッドの引数に移動関数 f を指定していましたが、
     * このクラスを作るにあたってフィールドに保持することにしました。
     * @param f 的合わせの対象となる移動関数
     * @param p 弾丸に使用するエネルギーの量
     */
    public GunBearingEstimator(EstimationFunction f, double p) {
        this.motionFunction = f;
        setBulletPower(p);
    }
    
    /**
     * 弾丸に使用するエネルギーの量を指定するメソッド
     * @param p エネルギー使用量
     */
    public void setBulletPower(double p) {
        this.bulletVelocity = 20 - 3 * p;
    }
    
    /**
     * 的あわせを行うメソッド
     * @return 大砲を向けるべき方向（絶対角）
     */
    double getEstimatedGunBearing() {
        // 衝突時刻を計算
        double t = getEstimatedImpactTime();
        
        // 衝突時刻における敵ロボットの位置を計算
        double dx = motionFunction.getEstimatedX(t);
        double dy = motionFunction.getEstimatedY(t);
        
        // 大砲を向けるべき絶対角を返す
        double b = Util.atan(dy, dx);
        return Util.normalizeDegree(b);
    }
    
    /**
     * セカント法で衝突時刻を計算するメソッド
     * @return 求める衝突時刻
     */
    double getEstimatedImpactTime() {
        // セカント法の初期値
        double t0 = 10;
        double t1 = 20;
        
        // 初期値における関数の値を計算
        double d0 = getEstimatedDistance(t0);
        
        // 繰り返し計算
        for(int i=0; i<20; i++) {
            // 精度を満たしたら終了
            if(Math.abs(t1 - t0) < 0.001) {
                break;
            }
            
            // 関数の値を計算
            double d1 = getEstimatedDistance(t1);
            // 次の近似点を求める
            double t2 = (t0 * d1 - t1 * d0) / (d1 - d0);
            
            // 次の計算に備えて添え字をシフトする
            t0 = t1;
            t1 = t2;
            d0 = d1;
        }
        
        // 求めた結果を返す
        return t1;
    }
    
    /**
     * 弾丸と敵ロボットの距離を計算するメソッド
     * @return 発射からt秒後の弾丸と敵ロボットの間の距離
     * @param t 発射からの時刻
     */
    double getEstimatedDistance(double t) {
        // 弾丸の速度
        double vb = bulletVelocity;
        
        // 時刻tにおける敵ロボットの位置を計算
        double dx = motionFunction.getEstimatedX(t);
        double dy = motionFunction.getEstimatedY(t);
        
        // 距離を計算して返す
        return Math.sqrt(dx * dx + dy * dy) - vb * t;
    }
}
