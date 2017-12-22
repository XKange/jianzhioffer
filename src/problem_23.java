import java.util.Arrays;

/**
 * Coded by  kangkang on 2017/12/19
 * Description:  输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 *
 * 注意：根节点占据数组最后一位，所以遍历和切片都是以 len-1 为边界，而不是len
 *
 */
public class problem_23 {

    public static boolean VerifySquenceOfBST(int [] sequence) {

        // 如果为空，则返回false
        if (sequence == null || sequence.length <= 0)
            return false;
        // 只有一个元素, 返回true
        if (sequence.length == 1)
            return true;
        // 取根节点
        int len = sequence.length;
        int root = sequence[len - 1];

        // 小于i的属于左子树
        int i = 0;
        for (; i < len - 1; ++i) {
            if (root < sequence[i])
                break;
        }

        // 右子树中如果有大于根节点的，返回false
        int j = i;
        for (; j < len - 1; ++j) {
            if (root > sequence[j])
                return false;
        }

        boolean left = true, right = true;
        // 判断左子树是不是二叉搜索树
        if (i > 0)
            left = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i));
        // 判断右子树是不是二叉搜索树
        if (i < len - 1)
            right = VerifySquenceOfBST(Arrays.copyOfRange(sequence, i, len - 1));
        return left && right;
    }
}
