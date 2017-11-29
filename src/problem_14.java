/**
 * Created by kangkang on 2017/11/29
 * 注意边界检查，如果k值大于结点个数，则返回为null
 *两个指针保持k个位置，如果第一个指针指到null, 那么第二个指针即指向了倒数第k个节点。
 */
public class problem_14 {
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode firstPointer = head;   // 第一个指针，用于指向secondPointer后第k个位置
        ListNode secondPointer = head;  // 第二个指针
        while (k != 0) {
            if (firstPointer != null)
                firstPointer = firstPointer.next;
            else {
                return null; // 如果提前到达null,说明结点个数小于k，直接返回null
            }
            k--;
        }
        while (firstPointer != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }

        return secondPointer;
    }
}
