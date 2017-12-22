import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Coded by  kangkang on 2017/12/19
 * Description:  输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class problem_24 {
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> array = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        // 根节点入栈
        stack.push(root);
        find(result, stack, array, target);
        return result;
    }
    public static void find(ArrayList<ArrayList<Integer>> result, Stack<TreeNode> stack, ArrayList<Integer> array, int target) {

        // 取栈顶元素节点并加入计算列表
        TreeNode root = stack.peek();
        array.add(root.val);
        // 如果是叶子节点且计算列表值为target，则添加到结果列表
        // 【java中传引用的，且后面操作会改变array的值，所以要新建一个对象】
        if (root.left == null && root.right == null && countArray(array) == target) {
            result.add(new ArrayList<>(array));
        }
        // 如果左子树不为空，入栈，然后处理左子树
        if (root.left != null) {
            stack.push(root.left);
            find(result, stack, array, target);
        }
        if (root.right != null) {
            stack.push(root.right);
            find(result, stack, array, target);
        }
        // 在返回父结点之前，在路径上的删除当前结点
        array.remove(array.size() - 1);
        stack.pop();
    }
    public static int countArray(ArrayList<Integer> array) {
        int sum = 0;
        for (int i = 0; i < array.size(); ++i) {
            sum += array.get(i);
        }
        return sum;
    }

    public static void print(ArrayList<ArrayList<Integer>> arrayListArrayList) {
        for (int i = 0; i < arrayListArrayList.size(); ++i) {
            printA(arrayListArrayList.get(i));
        }
    }

    public static void printA(ArrayList<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); ++i) {
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode A = new TreeNode(5);
        TreeNode B = new TreeNode(12);
        TreeNode C = new TreeNode(4);
        TreeNode D = new TreeNode(7);
        root.left = A;
        root.right = B;
        A.left = C;
        A.right = D;
        ArrayList<ArrayList<Integer>> a = FindPath(root,22);
        print(a);
    }
}
