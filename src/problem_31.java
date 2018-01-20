/**
 * Created by kangkang on 2018/1/19
 * 连续子数组的最大和：
 * 注意一个性质：当前数作为和最大子序列的第一个数的条件是 以前一个数结尾组成的子序列值 < 0
 */
public class problem_31 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int max = array[0];
        int start = 0, sum;
        for (int i = 0; i < array.length; ++i) {
            sum = sumOfArray(array, start, i);
            if (sum > max) {
                max = sum;
            } else if (sum < 0) {
                start = i + 1;
            }
        }
        return max;
    }
    public int sumOfArray(int[] array, int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; ++k)
            sum += array[k];
        return sum;
    }
}
