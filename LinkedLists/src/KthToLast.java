public class KthToLast {

    // Implement an algorithm to find kth to last element of a singly linked list.

    // recursive
    public int printKthToLast(ListNode head, int k) {
        if (head == null) {
            return 0;
        }
        int index = printKthToLast(head.next, k) + 1;
        if (index == k) {
            System.out.println(k + "th to last node is " + head.val);
        }
        return index;
    }

    // iterative
    // Time O(N) Space O(1)
    public ListNode kthToLast(ListNode head, int k) {
        ListNode p1 = head;
        ListNode p2 = head;
        for(int i = 0; i < k; i++) {
            if(p1==null) {
                return null;
            }
            p1 = p1.next;
        }
        while(p1!=null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
