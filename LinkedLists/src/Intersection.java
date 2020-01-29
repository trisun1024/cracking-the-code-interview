public class Intersection {

    // Given two linked list, determine if he two lists intersect. Return the intersecting node.

    public ListNode findIntersection(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            pa = (pa != null) ? pa.next : headB;
            pb = (pb != null) ? pb.next : headA;
        }
        return pa;
    }

    public static void main(String[] args) {
        Intersection sol = new Intersection();
        ListNode a = ListNode.arrayToLinkedList(new int[]{ 3, 1, 5, 9 });
        ListNode b = ListNode.arrayToLinkedList(new int[]{ 4, 6 });
        ListNode c = ListNode.arrayToLinkedList(new int[]{ 7, 2, 1 });
        ListNode cur = a;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = c;
        cur = b;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = c;
        ListNode n = sol.findIntersection(a, b);
        // ListNode.printLinkedList(a);
        ListNode.printLinkedList(n);
    }
}
