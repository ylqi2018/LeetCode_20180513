package Array;

public class _62_UniquePaths {
    public int uniquePaths(int m, int n) {
        long result = 1;
        for(int i=0; i<Math.min(m-1, n-1); i++) {
            result = result * (m+n-2-i) / (i+1);
        }
        return (int)result;
    }
}
