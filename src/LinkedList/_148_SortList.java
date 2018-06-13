package LinkedList;

public class _148_SortList {

	/*
	 * Method 2.
	 */
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        // Step 1: split the list into two sud-lists
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        
        ListNode l1 = sortList(slow);
        ListNode l2 = sortList(head);
        
        return merge(l1, l2);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1 != null) {
            curr.next = l1;
        }
        if(l2 != null) {
            curr.next = l2;
        }
        return dummyHead.next;
    }
    
    /*
     * Metho 2. Quick sort
     */
    public ListNode sortList1(final ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        // Split into three lists
        ListNode fakesmall = new ListNode(0);
        ListNode small = fakesmall;
        ListNode fakelarge = new ListNode(0);
        ListNode large = fakelarge;
        ListNode fakeequal = new ListNode(0);
        ListNode equal = fakeequal;
        
        ListNode cur = head;    // pivot is head
        while(cur != null) {
            if(cur.val < head.val) {
                small.next = cur;
                small = small.next;
            } else if(cur.val == head.val) {
                equal.next = cur;
                equal = equal.next;
            } else {
                large.next = cur;
                large = large.next;
            }
            cur = cur.next;
        }
        // Put an end
        small.next = null;
        equal.next = null;
        large.next = null;
        
        ListNode l1 = sortList(fakesmall.next);
        ListNode l2 = sortList(fakelarge.next);
        
        return merge(merge(l1, l2), fakeequal.next);
    }
    
}
