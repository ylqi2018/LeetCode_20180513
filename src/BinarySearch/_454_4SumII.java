package BinarySearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _454_4SumII {
	/*
	 * Method 1
	 */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int nAB = A.length * B.length;
        int[] sumAB = new int[nAB];
        int i = 0;
        for(int a: A) {
            for(int b: B) {
                sumAB[i++] = a + b;
            }
        }
        Arrays.sort(sumAB);
        
        int nCD = C.length * D.length;
        int[] negSumCD = new int[nCD];
        int j = 0;
        for(int c: C) {
            for(int d: D) {
                negSumCD[j++] = - (c + d);
            }
        }
        Arrays.sort(negSumCD);
        
        int res = 0;
        i = 0;
        j = 0;
        while(i < nAB && j < nCD) {
            if(sumAB[i] < negSumCD[j]) {
                i++;
            } else if(sumAB[i] > negSumCD[j]) {
                j++;
            } else {
                int countAB = 1;
                int countCD = 1;
                while(++i < nAB && sumAB[i-1] == sumAB[i]) {
                    countAB++;
                }
                while(++j < nCD && negSumCD[j-1] == negSumCD[j]) {
                    countCD++;
                }
                res += countAB * countCD;
            }
        }
        return res;
    }
    
    /*
     * Method 2
     */
    public int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<C.length; i++) {
            for(int j=0; j<D.length; j++) {
                int sum = C[i] + D[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        
        int res = 0;
        for(int i=0; i<A.length; i++) {
            for(int j=0; j<B.length; j++) {
                res += map.getOrDefault(-1*(A[i] + B[j]), 0);
            }
        }
        return res;
    }
}
