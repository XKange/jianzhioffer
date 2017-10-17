import java.util.*;

/**
 * 利用栈来实现从后向前打印链表
 * 还有一种递归解法，先输出自己后一个数再输出自身。
 */
class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
             this.val = val;
         }
    }

public class problem_3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<ListNode> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode);
            listNode = listNode.next;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!stack.isEmpty()) {
            ListNode elem = stack.pop();
            arrayList.add(elem.val);
        }
        return arrayList;
    }
}
