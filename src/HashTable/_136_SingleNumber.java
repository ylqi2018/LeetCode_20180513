package HashTable;

import java.util.HashMap;
import java.util.Map;

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
}
