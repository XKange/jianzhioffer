/**
 * Coded by  kangkang on 2017/12/15
 * Description:  输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class problem_17 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;

        // 这个递归逻辑最关键
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val)
                result = dosTree1HaveTree2(root1, root2);
            if (!result)
                result = HasSubtree(root1.left, root2);
            if (!result)
                result = HasSubtree(root1.right, root2);
        }
        return result;
    }
    public boolean dosTree1HaveTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (root1.val != root2.val)
            return false;
        return dosTree1HaveTree2(root1.left, root2.left) && dosTree1HaveTree2(root1.right, root2.right);
    }
}
