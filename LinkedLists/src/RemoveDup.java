import java.util.HashSet;
import java.util.Set;

public class RemoveDup {

    // Write code to remove duplicates from an unsorted linked list
    // Follow up: how would you solve this problem if a temporary buffer is not allowed?

    // Time O(N) Space O(N)
    public void deleteDups(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode prev = null;
        while (head != null) {
            if (set.contains(head.val)) {
                prev.next = head.next;
            } else {
                set.add(head.val);
                prev = head;
            }
            head = head.next;
        }
    }

    // Time O(N^2) Space O(1)
    public void deleteDupsII(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            ListNode runner = cur;
            while (runner.next != null) {
                if (runner.next.val == cur.val) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            cur = cur.next;
        }
    }
}
