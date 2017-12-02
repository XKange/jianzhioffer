/**
 * Created by kangkang on 2017/11/30
 *
 */
public class problem_15 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode L = new ListNode(0);   // 创建头结点
        L.next = null;
        while (list1 != null || list2 != null) {  // 循环条件：两者中有不为空时
            if (list1 != null && list2 != null) { // 两者至少其一不为空
                if (list1.val <= list2.val) {
                    insert(L, list1);
                    list1 = list1.next;
                } else {
                    insert(L, list2);
                    list2 = list2.next;
                }

            } else if (list2 == null) {
                insert(L, list1);
                list1 = list1.next;
            } else {
                insert(L, list2);
                list2 = list2.next;
            }
        }
        return L.next;
    }

    private void insert(ListNode L, ListNode list) { // 将list指向节点插入L尾部
        ListNode p = L;
        while (p.next != null) {
            p = p.next;
        }
        ListNode elem = new ListNode(list.val);
        p.next = elem;
        elem.next = null;
    }
}
