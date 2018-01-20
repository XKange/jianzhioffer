/**
 * Coded by  kangkang on 2018/1/18
 * Description:  二叉树转化为双向链表
 */
public class problem_XX {
    public static TreeNode pLastNode = null;
    public static TreeNode Convert(TreeNode root) {

        ConvertNode(root, pLastNode);

        while (pLastNode.left != null && pLastNode.left != null)
            pLastNode = pLastNode.left;
        return pLastNode;
    }
    public static void ConvertNode(TreeNode root, TreeNode pLastNode) {
        if (root == null)
            return;
//        TreeNode pCurrent = root;
        if (root.left != null)
            ConvertNode(root.left, pLastNode);
        // 根结点操作，左孩子指向前一序列最后一个结点, 若前一结点不为空，则前一结点的右孩子指向当前结点
        root.left = pLastNode;
        if (pLastNode != null)
            pLastNode.right = root;
        pLastNode = root;

        if (root.right != null)
            ConvertNode(root.right, pLastNode);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode A = new TreeNode(6);
        TreeNode B = new TreeNode(14);
        TreeNode C = new TreeNode(4);
        TreeNode D = new TreeNode(8);
        TreeNode E = new TreeNode(12);
        TreeNode F = new TreeNode(16);
        root.left = A;
        root.right = B;
        A.left = C;
        A.right = D;
        B.left = E;
        B.right = F;
//        TreeNode result = Convert(root);
//        System.out.println(result);
    }
}
