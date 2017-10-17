import java.util.Stack;
/**
 * Created by kangkang on 2017/10/17
 */
// stack1直接入队，出队时先将stack1里的元素压入stack2，再弹出栈顶元素；
// 之后再将stack2剩下的元素弹出并压入stack1.
public class problem_5_realize_queue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }
    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int value = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return value;
    }
}
