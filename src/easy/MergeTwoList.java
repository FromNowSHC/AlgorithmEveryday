package easy;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author shc
 * @date 2019-04-04
 **/
public class MergeTwoList {

    /**
     * 用递归的方法轻松实现
     * （可惜没想出来）
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode result;
        if (l1.val < l2.val) {
            result = l1;
            result.next = mergeTwoLists(l1.next, l2);
        } else {
            result = l2;
            result.next = mergeTwoLists(l1, l2.next);
        }
        return result;
    }

    /**
     * 通过循环的方式去实现
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(-1);
        ListNode rsp = head;
        while (l1 != null && l2 != null) {
            // 比较节点值得大小
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            // 这一步是关键，使head指向rsp中已经排序好的最后一个节点
            // 最后一个节点已经指向了l1或l2了
            head = head.next;
            System.out.println(l1.toString());
            System.out.println(l2.toString());
            System.out.println(head.toString());
            System.out.println(rsp.toString());
            System.out.println("+++++++++");
        }

        if (l1 == null) {
            head.next = l2;
        } else {
            head.next = l1;
        }

        return rsp.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        ListNode l2 = new ListNode(0);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(5);
        ListNode listNode = mergeTwoLists2(l1, l2);

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        if (next != null) {
            return val + "===" + next.toString();
        }
        return val + "";
    }
}
