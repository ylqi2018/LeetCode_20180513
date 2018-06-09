package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _350_IntersectionOfTwoArraysII {

	/*
	 * Method 1
	 */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<nums1.length; i++) {
            int temp = nums1[i];
            if(map.containsKey(temp)) {
                map.put(temp, map.get(temp)+1);
            } else {
                map.put(temp, 1);
            }
        }
        for(int i=0; i<nums2.length; i++) {
            int temp = nums2[i];
            if(map.containsKey(temp) && map.get(temp) > 0) {
                res.add(temp);
                map.put(temp, map.get(temp)-1);
            }
        }
        int[] result = new int[res.size()];
        for(int i=0; i<res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
    
    /*
     * Method 2
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2 = 0;
        List<Integer> list = new ArrayList<>();
        while((p1 < nums1.length) && (p2 < nums2.length)) {
            if(nums1[p1] < nums2[p2]) {
                p1++;
            } else if(nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                list.add(nums1[p1]);
                p1++;
                p2++;
            }
        }
        int[] res = new int[list.size()];
        for(int i=0; i<res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
