package LinkedList;

public class _234_Palindrome_LinkedList {

	/*
	 * Method 1.
	 */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null) {
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;
        
        while(slow != null) {
            if(fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        while(node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}
