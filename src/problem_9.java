/**
 * Created by kangkang on 2017/11/28
 * 青蛙可以跳1-N级
 */
public class problem_9 {
    public int JumpFloor2(int target) {
        if (target <= 0)
            return 0;
        if (target == 1)
            return 1;
        if (target == 2)
            return 2;
        int preResult = 2;
        int result = 0;
        for (int i = 3; i <= target; ++i) {
            result = preResult * 2;
            preResult = result;
        }
        return result;
    }
}
