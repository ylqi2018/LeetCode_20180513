package LinkedList;

public class _237_DeleteNodeInALinkedList {

	/*
	 * Method 1
	 */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
