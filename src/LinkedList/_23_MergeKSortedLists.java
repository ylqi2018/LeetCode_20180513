package LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _23_MergeKSortedLists {
	
	/*
	 * Partition and merge
	 */
    public ListNode mergeKLists(ListNode[] lists) {
        return partition(lists, 0, lists.length-1);
    }
    
    private ListNode partition(ListNode[] lists, int start, int end) {
        if(start == end) {
            return lists[start];
        }
        if(start < end) {
            int mid = (start + end) / 2;
            ListNode l1 = partition(lists, start, mid);
            ListNode l2 = partition(lists, mid+1, end);
            return merge(l1, l2);
        } else {
            return null;
        }
    }
    
    // Merge two sorted lists
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
        curr.next = (l1 == null ? l2 : l1);
        return dummyHead.next;
    }
    
    // merge method based on recursion
	private ListNode merge1(ListNode l1, ListNode l2) {
	    if(l1 == null) {
	        return l2;
	    }
	    if(l2 == null) {
	        return l1;
	    }
	    if(l1.val < l2.val) {
	        l1.next = merge(l1.next, l2);
	        return l1;
	    } else {
	        l2.next = merge(l1, l2.next);
	        return l2;
	    }
	}
	
	/*
	 * Method 2. Using Arrays sort
	 */
    public ListNode mergeKLists1(ListNode[] lists) {
        List<Integer> numbers = new ArrayList<>();
        for(ListNode head: lists) {
            ListNode node = head;
            while(node != null) {
                numbers.add(node.val);
                node = node.next;
            }
        }
        int[] nums = new int[numbers.size()];
        for(int i=0; i<nums.length; i++) {
            nums[i] = numbers.get(i);
        }
        Arrays.sort(nums);
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        for(int number: nums) {
            curr.next = new ListNode(number);
            curr = curr.next;
        }
        return dummyHead.next;
    }
    
    /*
     * Method 3
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists==null||lists.length==0) return null;
        
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else 
                    return 1;
            }
        });
        
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        
        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);
            
        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;
            
            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
    
    /*
     * Method 4
     */
    public ListNode mergeKLists3(ListNode[] lists) {
        if(lists.length==0)
            return null;
        return merge(0,lists.length-1,lists);
    }
    public ListNode merge(int i,int j,ListNode[] lists) {
        if(j<i)return null;
        if(i==j)return lists[i];
        int mid=i+(j-i)/2;
        ListNode l=merge(i,mid,lists);
        ListNode r= merge(mid+1,j,lists);
        ListNode dummy =new ListNode(0);
        ListNode runner= dummy;

        while(l!=null && r!=null) {
            if(l.val>r.val) {
                runner.next=r;
                r=r.next;
                runner=runner.next;
            }
            else {
                runner.next=l;
                l=l.next;
                runner=runner.next;
            }
        }
        if(l==null && r==null)
            return dummy.next;
        if(l==null)
            runner.next=r;
        else
            runner.next=l;
        return dummy.next;
    }
}
