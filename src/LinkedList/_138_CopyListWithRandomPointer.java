package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class _138_CopyListWithRandomPointer {

	/*
	 * Method 1. HashMap
	 */
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return null;
        }
        
        // Loop 1: copy the values of all nodes
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode node = head;
        while(node != null) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }
        
        // Loop 2: copy next and random pointers
        node = head;
        while(node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }	
    
    /*
     * Method 2. 
     */
    public RandomListNode copyRandomList1(RandomListNode head) {
        // To insert new node and copy values
        RandomListNode prev = head;
        RandomListNode next = null;
        while(prev != null) {
            next = prev.next;
            RandomListNode copy = new RandomListNode(prev.label);
            
            copy.next = next;
            prev.next = copy;
            prev = next;
        }
        
        // To copy random pointers
        prev = head;
        while(prev != null) {
            if(prev.random != null) {
                prev.next.random = prev.random.next;
            }
            prev = prev.next.next;
        }
        
        // To seperate
        prev = head;
        RandomListNode cpDummyHead = new RandomListNode(0);
        RandomListNode cp = null;
        RandomListNode cpPrev = cpDummyHead;
        while(prev != null) {
            next = prev.next.next;  // The original copy
            
            cp = prev.next;     // The copy of prev
            cpPrev.next = cp;
            cpPrev = cp;
            
            prev.next = next;
            prev = next;
        }
        return cpDummyHead.next;
    }
}
