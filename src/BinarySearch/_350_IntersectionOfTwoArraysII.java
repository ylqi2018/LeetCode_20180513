package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _350_IntersectionOfTwoArraysII {

	/*
	 * Method 1. Sorting
	 */
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2 = 0;
        while((p1 < nums1.length) && (p2 < nums2.length)) {
            if(nums1[p1] == nums2[p2]) {
                temp.add(nums1[p1]);
                p1++;
                p2++;
            } else if(nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }
        int[] res = new int[temp.size()];
        for(int i=0; i<temp.size(); i++) {
            res[i] = temp.get(i);
        }
        return res;
    }
    
    /*
     * Method 2. HashMap
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        // Interate nums1
        for(int i=0; i<nums1.length; i++) {
            if(map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }
        for(int i=0; i<nums2.length; i++) {
            if(map.containsKey(nums2[i])) {
                if(map.get(nums2[i]) > 0) {
                    list.add(nums2[i]);
                    map.put(nums2[i], map.get(nums2[i]) - 1);
                }
            }
        }
        int[] res = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
