package LinkedList;

public class _206_ReverseLinkedList {
	/*
	 * Method 1. One iteration
	 */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    
    /*
     * Method 2. Recursion
     */
    public ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
