/**
 * Coded by  kangkang on 2017/12/15
 * Description:  操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class problem_18 {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
