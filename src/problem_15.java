/**
 * Coded by  kangkang on 2017/12/15
 * Description:  输入一个链表，反转链表后，输出链表的所有元素
 */
public class problem_15 {
    public ListNode ReverseList(ListNode head) {
        // 创建头结点
        ListNode listNode = new ListNode(0);
        // 定义指向头结点的指针p
        ListNode p;
        p = listNode;
        // 遍历链表当当前指向不为空，按头插法插入到listNode中
        while (head != null) {
            ListNode node = new ListNode(head.val);
            node.next = p.next;
            p.next = node;
            head = head.next;
        }
        return listNode.next;
    }
}
