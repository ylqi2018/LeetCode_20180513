package Array;

public class _11_ContainerWithMostWater {
	
	/*
	 * Method 1
	 */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        int area = 0;
        while(left < right) {
            int l = height[left];
            int r = height[right];
            if(l > r) {
                area = r * (right - left);
                while(height[--right]<r);
            } else {
                area = l * (right - left);
                while(height[++left]<l);
            }
            if(area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }
    
    /*
     * Improved by myself.
     */
    public int maxArea1(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while(left < right) {
            int l = height[left];
            int r = height[right];
            if(l > r) {
                maxArea = Math.max(maxArea, r*(right-left));
                while(height[--right]<r);
            } else {
                maxArea = Math.max(maxArea, l*(right-left));
                while(height[++left]<l);
            }
        }
        return maxArea;
    }

}
