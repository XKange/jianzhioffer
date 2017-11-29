import java.util.ArrayList;

/**
 * Created by kangkang on 2017/11/28
 * 为了保证奇数序列和偶数序列有序，设置两个可变数组分别存入奇数和偶数，
 * 最后将偶数序列添加到奇数序列后面，再赋值给array
 */
public class problem_13 {
    public void reOrderArray(int[] array) {
        ArrayList<Integer> oddArrayList = new ArrayList<>(); // 奇数序列
        ArrayList<Integer> evenArrayList = new ArrayList<>();// 偶数序列
        for (int i = 0; i < array.length; ++i) {
            if (array[i] % 2 == 1) {
                oddArrayList.add(array[i]);
            }
            else {
                evenArrayList.add(array[i]);
            }
        }
        oddArrayList.addAll(evenArrayList); // 偶数序列添加到奇数序列后
        for (int i = 0; i < oddArrayList.size(); ++i) { // 赋值
            array[i] = oddArrayList.get(i);
        }
    }
}
