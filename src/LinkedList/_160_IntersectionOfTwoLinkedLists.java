package LinkedList;

public class _160_IntersectionOfTwoLinkedLists {
	/*
	 * Method 1
	 */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // boundary check
        if(headA == null || headB == null) {
            return null;
        }
        
        ListNode a = headA;
        ListNode b = headB;
        
        // if a and b have different len, then we will stop the loop after second iteration
        while( a != b) {
            a = (a == null ? headB : a.next);
            b = (b == null ? headA : b.next);
        }
        return a;
    }
    
    /*
     * Method 2. Make the comparision begin at the same start point
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int lenA = length(headA);
        int lenB = length(headB);
        
        // move headA and headB to the same start point
        while(lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while(lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        // Find the intersection until end
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    
    private int length(ListNode node) {
        int length = 0;
        while(node != null) {
            length++;
            node = node.next;
        }
        return length;
    }  
}
