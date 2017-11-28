/**
 * Created by kangkang on 2017/10/17
 * 运行时间：458ms
 * 占用内存：33996k
 * Descreption：
 */
public class problem_6 {
    public static int findMinNumber(int[] array) {
        int i = 0;
        int j = array.length - 1;
        int min = i;
        boolean flag = true;
        while (flag) {
            if (array[i] > array[j]) { //前者大于后者，说明最小值在后半段
                min = j;
                for (int k = j; k >= i+1; k--) {
                    if (array[k - 1] > array[k]) {
                        min = k;
                        flag = false;
                        break;
                    }
                }
            }
            else if (array[i] == array[j]) { //两者相等往中间继续比较
                i++;
                j--;
            }
            else { // 前者小于后者说明该序列为递增，故i指向的即是最小值
                min = i;
                break;
            }
        }
        return array[min];
    }

    public static void main(String[] args) {
        int[] a = new int[] {3, 4, 5, 1, 2};
        System.out.println(findMinNumber(a));
    }
}
