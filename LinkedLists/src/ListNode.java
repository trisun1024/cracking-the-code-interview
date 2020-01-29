public class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        next = null;
    }

    public static ListNode arrayToLinkedList(int[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int i : arr) {
            ListNode node = new ListNode(i);
            cur.next = node;
            cur = cur.next;
        }
        cur.next = null;
        return dummy.next;
    }

    public static void printLinkedList(ListNode head) {
        while (head.next != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.print(head.val);
    }
}
