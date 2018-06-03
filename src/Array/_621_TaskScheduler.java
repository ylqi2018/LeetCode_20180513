package Array;

import java.util.Arrays;

public class _621_TaskScheduler {
	/*
	 * Method 1
	 */
	public int leastInterval(char[] tasks, int n) {
		int[] map = new int[26];
		for(char c: tasks) {
			map[c-'A']++;
		}
		Arrays.sort(map);
		int time = 0;
		while(map[25] > 0) {
			int i = 0;
			while(i <= n) {
				if(map[25] == 0) {
					break;
				}
				if(i < 26 && map[25-i] > 0) {
					map[25-i]--;
				}
				time++;
				i++;
			}
			Arrays.sort(map);
		}
		return time;
	}

	/*
	 * Method 2
	 */
    public int leastInterval1(char[] tasks, int n) {
        int[] map = new int[26];
        for(char c: tasks) {
            map[c-'A']++;
        }
        Arrays.sort(map);
        int max_val = map[25] - 1;
        int idle_slots = max_val * n;
        for(int i=24; i>0 && map[i]>0; i--) {
            idle_slots -= Math.min(map[i], max_val);
        }
        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
    }
    
    /*
     * Method 3
     */
    public int leastInterval2(char[] tasks, int n) {
    	int[] map = new int[26];
    	for(char c: tasks) {
    		map[c-'A']++;
    	}
    	int max = 0;
    	int maxCount = 0;
    	for(int t: map) {
    		if(t > max) {
    			max = t;
    			maxCount = 1;
    		} else if(t == max) {
    			maxCount++;
    		}
    	}
    	return Math.max(tasks.length, maxCount + (n+1)*(max-1));
    }
    
    /*
     * Method 4
     */
    public int leastInterval3(char[] tasks, int n) {
        int[] map = new int[26];
        for(char c: tasks) {
            map[c-'A']++;
        }
        Arrays.sort(map);
        int max_val = map[25];
        int maxCount = 0;
        for(int i=25; i>=0; i--) {
            if(map[i]==max_val) {
                maxCount++;
            } else {
                break;
            }
        }
        return Math.max(tasks.length, (max_val - 1) * (n + 1) + maxCount);
    }
    
}
