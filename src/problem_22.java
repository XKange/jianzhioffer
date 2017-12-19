import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Coded by  kangkang on 2017/12/19
 * Description:  从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class problem_22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList();
        // java只有Query接口，不像Stack可以直接使用的类，可以用LinkedList来实现队列
        Queue<TreeNode> queue = new LinkedList();
        // 相当于put方法
        queue.offer(root);
        while (queue.peek() != null) {
            // 相当于get方法
            TreeNode temp = queue.poll();
            result.add(temp.val);
            if (temp.left != null)
                queue.offer(temp.left);
            if (temp.right != null)
                queue.offer(temp.right);
        }
        return result;
    }
}
