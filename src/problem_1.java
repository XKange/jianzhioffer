
/**对二维数组a.length是行的长度, a[i].length是第i列的长度
 *本题的思路是采用逐步缩小范围的方法，通过找到合适的规律来简化求解步骤，（比较的点选择左下或者右上），
 * 比较对角线上的点太过复杂。
 *
 */
public class problem_1 {
    public boolean Find(int target, int[][] array) {
        boolean bool = false;
        int row = 0;
        // 这个地方行和列的计算写反了
        int col = array[0].length - 1;
        int rows = array.length -1;
        // row<= rows少写了=
        while (row <= rows && col >= 0) {
            if (target < array[row][col])
                col--;
            else if (target > array[row][col])
                row++;
            else
                bool = true;
        }
        return bool;
    }
    public static void print(int i) {
        System.out.println(i);
    }
    public static void main(String[] args) {

    }
}
