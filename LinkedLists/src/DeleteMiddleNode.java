public class DeleteMiddleNode {

    // Implement an algorithm to delete a node in the middle of a singly linked list, given only access to
    // that node

    public boolean deleteMiddleNode(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode prev = head;
        ListNode s = head;
        ListNode f = head;
        while (f.next != null && f.next.next != null) {
            prev = s;
            s = s.next;
            f = f.next.next;
        }
        prev.next = s.next;
        s.next = null;
        return true;
    }
}
