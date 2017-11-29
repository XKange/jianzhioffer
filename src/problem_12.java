/**
 * Created by kangkang on 2017/11/28
 * 常规循环exponent次效率太低，直接改进做
 * 注意负数的情况
 */
public class problem_12 {
    public double Power(double base, int exponent) {
//        if (exponent == 1)
//            return base;
        if (exponent >= 0) return PowerForPositive(base, exponent);
        else return 1 / PowerForPositive(base, -exponent);
    }
    public double PowerForPositive(double base, int exponent) { // 正数求exponent次方
        if (exponent == 0)
            return 1;
        if (exponent % 2 == 0)
            return Power(base, exponent / 2) * Power(base, exponent / 2);
        else
            return base * Power(base, exponent -1);
    }
}
