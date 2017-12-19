import java.util.Stack;

/**
 * Coded by  kangkang on 2017/12/19
 * Description:  输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的
 * 一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class problem_21 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int i = 0, j = 0, len = pushA.length;
        Stack<Integer> s1 = new Stack();
        while (i <= len) {
            if (s1.empty() || s1.peek() != popA[j]) {
                if (i == len)       //  如果相等, 还进入此分支, 说明pushA已循环完, 可结束循环
                    break;
                s1.push(pushA[i]);
                i++;               // pushA最后一个元素入栈后,此时i与len相等, 所以while判断条件要加上=
            }
            else {
                s1.pop();
                j++;
            }
        }
        if (s1.empty())
            return true;
        return false;
    }
}
