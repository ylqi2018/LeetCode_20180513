package LinkedList;

public class _2_AddTwoNumbers {
	/*
	 * Method 1.
	 */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = dummyHead;
        int carry = 0;
        while(p != null || q != null) {
            int x = (p == null ? 0 : p.val);
            int y = (q == null ? 0 : q.val);
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(p != null) {
                p = p.next;
            }
            if(q != null) {
                q = q.next;
            }
        }
        if(carry > 0) {
            curr.next = new ListNode(1);
        }
        return dummyHead.next;
    }
}
