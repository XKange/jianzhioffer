import java.util.HashMap;
import java.util.Map;
/**
 * Created by kangkang on 2018/1/19
 */
public class problem_29 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0)
            return 0;
        int result = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            if (times == 0)
            {
                result = array[i];
                times = 1;
            }
            else if (result == array[i])
                ++times;
            else
                --times;
        }

        if (checkMoreThanHalf(array, result))
            return result;

        return 0;
    }

    public static boolean checkMoreThanHalf(int[] array, int number) {
        int times = 0;
        for(int i : array){
            if (i == number)
                ++times;
        }
        return times > (array.length >> 1);
    }
}
