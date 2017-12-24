import java.util.HashMap;

/**
 * Created by kangkang on 2017/12/23
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 思路：第一步复制链表，并将原节点和新创建节点通过map对应；第二步，复制random链接，利用map对应在O（1）时间内可
 * 以查到原random指针在clone后对应的节点
 * 注意：1.pHead是不带头结点的
 *      2.做循环时，一定要在完成操作后，补上后续操作，不然就会调整好久
 */

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class problem_26 {
    public RandomListNode Clone(RandomListNode pHead)
    {
        HashMap<RandomListNode, RandomListNode> hashMap = new HashMap<>();
        RandomListNode cHead = new RandomListNode(0);
        RandomListNode p = pHead;
        RandomListNode c = cHead;
        // 复制链表操作,和单链表复制操作相同
        while (p != null) {
            RandomListNode node = new RandomListNode(p.label);
            node.next = c.next;
            c.next = node;
            c = node;
            // 原节点和新创建节点对应
            hashMap.put(p, node);
            // 移位【不要忘记】
            p = p.next;
        }
        p = pHead;
        c = cHead.next; // cHead是带头结点的链表
        while (p != null) {
            c.random = hashMap.get(p.random);
            // 移位【两者都要】
            p = p.next;
            c = c.next;
        }
        // cHead是带头结点的链表，所以要.next来返回其第一个节点
        return cHead.next;
    }
    public static void main(String[] args) {
        RandomListNode phead = new RandomListNode(0);
        RandomListNode A = new RandomListNode(0);
        RandomListNode B = new RandomListNode(0);
        RandomListNode C = new RandomListNode(0);
        RandomListNode D = new RandomListNode(0);
        RandomListNode E = new RandomListNode(0);
        phead.next = A;
        A.next = B;
        B.next = C;
        C.next = D;
        D.next = E;
        A.random = C;
        B.random = E;
        D.random = B;
        // Clone(phead);
    }
}
