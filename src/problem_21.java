import java.util.Stack;
/**
 * Created by kangkang on 2017/10/17
 */
// 包含min函数的栈，
// 一个存储数据stack_data，一个保存当前栈中的最小值，但是如果只用一个整型变量min保存，当该最小值弹出后，min中应该
// 存储次小值，但是无法实现，所以需要每次存入数据后stack_data栈当前的最小值对应存入stack_min中。

public class problem_21 {
    public static Stack<Integer> stack_data = new Stack<>();
    public static Stack<Integer> stack_min = new Stack<>();
    public void push(int node) {
        stack_data.push(node);
        if (!stack_min.isEmpty()) {
            int top = stack_min.peek();
            if (top > node)
                stack_min.push(node);
            else
                stack_min.push(top);
        }
        else
            stack_min.push(node);
    }

    public int pop() {
        stack_min.pop();
        return stack_data.pop();
    }

    public int top() {
        return stack_data.peek();
    }

    public int min() {
        return stack_min.peek();
    }
}
