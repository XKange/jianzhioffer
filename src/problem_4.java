/**
 * Created by kangkang on 2017/10/17
 */
// 重建二叉树
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int x) { val = x; }
}

public class problem_4 {
    public static TreeNode rebuild_binary_tree (int[] pre, int[] in) {
        if (pre.length == 0)
            return null;
        // 取先序数组第一个值为根节点
        TreeNode root = new TreeNode(pre[0]);
        // 找到根节点在中序数组中的位置
        int p = find_place(in, pre[0]);
        // 根据位置p划分左右子树的先序和中序数组（注意划分区间上下界）
        int[] pre_left = slice_pre(pre, 1, p);
        int[] pre_right = slice_pre(pre, p+1, pre.length-1);
        int[] in_left = slice_pre(in, 0, p - 1);
        int[] in_right = slice_pre(in, p + 1, in.length-1);
        // 根节点的左、右子树指向
        root.left = rebuild_binary_tree(pre_left, in_left);
        root.right = rebuild_binary_tree(pre_right, in_right);
        return root;
    }
    // 返回target在数组中的位置
    public static int find_place(int[] a, int target) {
        int place = -1;
        for (int i = 0; i < a.length; ++i) {
            if (a[i] == target) {
                place = i;
                break;
            }
        }
        return place;
    }
    // 对数组进行切片[start:finish]（包含边界）
    public static int[] slice_pre(int[] pre, int start, int finish) {
        //System.out.println(pre.length);
        //if (pre == null) return null;
        if (start > pre.length || finish > pre.length) { return null; }
        int[] temp = new int[finish - start + 1];
        for (int i = 0, j = start; j <= finish; ++i, ++j) {
            temp[i] = pre[j];
        }
        return temp;
    }
    // 先序打印二叉树，验证程序的正确性
    public static void print(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.val);
        print(root.left);
        print(root.right);
    }
    public static void main(String[] args) {
        int[] a = {1,2,4,7,3,5,6,8};
        int[] b = {4,7,2,1,5,3,8,6};
        TreeNode root = rebuild_binary_tree(a, b);
        print(root);
    }
}
