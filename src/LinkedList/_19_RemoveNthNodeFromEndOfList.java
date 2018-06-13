package LinkedList;

public class _19_RemoveNthNodeFromEndOfList {
	/*
	 * method 1
	 */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode first = dummyHead;
        ListNode second = dummyHead;
        for(int i=0; i<=n; i++) {
            first = first.next;
        }
        while(first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummyHead.next;
    }
    
    /*
     * Method 2. Two pass
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        int len = length(head);
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        ListNode curr = dummyHead;
        int index = 0;
        while(index < len - n) {
            curr = curr.next;
            index++;
        }
        curr.next = curr.next.next;
        return dummyHead.next;
    }
    
    private int length(ListNode node) {
        int len = 0;
        while(node != null) {
            len++;
            node = node.next;
        }
        return len;
    }
    
    /*
     * Method 3. Two pass.
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        int len = 0;
        ListNode curr = head;
        while(curr != null) {
            len++;
            curr = curr.next;
        }
        len = len - n;
        curr = dummy;
        while(len > 0) {
            len--;
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return dummy.next;
    }
}
