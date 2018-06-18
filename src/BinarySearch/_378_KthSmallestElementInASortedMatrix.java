package BinarySearch;

import java.util.PriorityQueue;

public class _378_KthSmallestElementInASortedMatrix {

	/*
	 * Method 1. heap
	 */
    public int kthSmallest(int[][] matrix, int k) {
        int num_rows = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for(int j=0; j<matrix[0].length; j++) {
            pq.offer(new Tuple(0, j, matrix[0][j]));
        }
        for(int i=0; i<k-1; i++) {
            Tuple t = pq.poll();
            if(t.x == num_rows-1)
                continue;
            pq.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
        }
        return pq.poll().val;
    }
    
    /*
     * Method 2.
     */
    public int kthSmallest1(int[][] matrix, int k) {
        int lo = matrix[0][0];
        int hi = matrix[matrix.length-1][matrix[0].length-1] + 1;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            int j = matrix.length - 1;
            for(int i=0; i<matrix.length; i++) {
                while(j >= 0 && matrix[i][j] > mid) {
                    j--;
                }
                count += (j + 1);
            }
            if(count < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return hi;
    }
}

class Tuple implements Comparable<Tuple> {
    int x;
    int y;
    int val;
    
    public Tuple(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
    
    @Override
    public int compareTo(Tuple that) {
        return this.val - that.val;
    }
}