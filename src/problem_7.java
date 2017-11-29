/**
 * Created by kangkang on 2017/11/28
 */
public class problem_7 {
    public static int Fibonacci(int n) {
//        if (n <= 0)
//            return 0;
//        if (n == 1)
//            return 1;
//        return Fibonacci(n -1) + Fibonacci(n - 2);
        // 上面例子效率太低
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        int result = 0; // 用a、b保存每一步的中间值
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; ++i) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }
}
