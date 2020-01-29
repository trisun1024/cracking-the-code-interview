public class SumLists {

    // You have two numbers represented by a linked list, where each node contains a single digit. The
    // digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a
    // function that adds the two numbers and returns the sum as a linked list.

    public ListNode addLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int val = 0;
        while (l1 != null || l2 != null || val != 0) {
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(val % 10);
            val = val / 10;
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        SumLists sol = new SumLists();
        ListNode h1 = new ListNode(3);
        ListNode n2 = new ListNode(5);
        ListNode h2 = new ListNode(8);
        ListNode n4 = new ListNode(2);
        h1.next = n2;
        n2.next = null;
        h2.next = n4;
        n4.next = null;
        ListNode head = sol.addLists(h1, h2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
