/**
 * Created by kangkang on 2017/11/28
 * 一只青蛙可以跳1级也可以跳2级台阶，请问N级台阶需要跳几步
 */
public class problem_8 {
    public static int JumpFloor(int target) {
        if (target == 1)
            return 1;
        if (target <= 0)
            return 0;
        if (target == 2)
            return 2;
        int a = 1;
        int b = 2;
        int result = 0;
        for (int i = 3; i <= target; ++i) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }
}
