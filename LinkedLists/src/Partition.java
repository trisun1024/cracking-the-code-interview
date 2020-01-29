public class Partition {

    // Write code to partition a linked list around a value x, such that all nodes less than x come before
    // all nodes greater than or equal to x.

    public ListNode partition(ListNode head, int target) {
        if (head == null) {
            return null;
        }
        ListNode small = new ListNode(-1);
        ListNode big = new ListNode(-1);
        ListNode newHead = small;
        ListNode tmp = big;
        while (head != null) {
            if (head.val < target) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        big.next = null;
        small.next = tmp.next;
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(8);
        ListNode n4 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        Partition sol = new Partition();
        ListNode head = sol.partition(n1, 5);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
