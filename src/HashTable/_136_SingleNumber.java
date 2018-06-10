package HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _136_SingleNumber {
	/*
	 * Method 1. XOR
	 */
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int num: nums) {
            result ^= num;
        }
        return result;
    }
    
    /*
     * Method 2. HashMap
     */
    public int singleNumber1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            if(map.containsKey(num)) {
                map.put(num, 2);
            } else {
                map.put(num, 1);
            }
        }
        for(int key: map.keySet()) {
            if(map.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }
    
    /*
     * Method 3. HashSet
     * Because every element appears twice or one
     */
    public int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            if(set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return set.iterator().next();
    }
}
