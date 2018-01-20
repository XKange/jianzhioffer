import java.util.ArrayList;
import java.util.List;

/**
 * Created by kangkang on 2018/1/19
 */
public class problem_30 {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || k > input.length || k <= 0)
            return result;
        int start = 0, end = input.length -1;
        int index = Partition(input, start, end);
        while (index != k -1) {
            if (k < index) {
                end = index -1;
                index = Partition(input, start, end);
            } else {
                start = index + 1;
                index = Partition(input, start, end);
            }
        }
        for (int i = 0; i < k; i++)
            result.add(input[i]);
        return result;
    }

    public static int Partition(int[] input, int i, int j) {
        int pLot = input[i];
        int index = i;
        i = i + 1;
        while (i != j) {
            while (i < j && input[j] > pLot)
                j--;
            while (i < j && input[i] < pLot)
                i++;
            swap(input, i, j);
        }
        swap(input, index, i);
        return i;
    }

    public static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void main(String[] args) {
        int[] input = {5,4,8,6,1,3,2,9,7};
        int k = 4;
        List list = GetLeastNumbers_Solution(input, k);
        System.out.println(list);
    }
}
