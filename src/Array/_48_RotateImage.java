package Array;

public class _48_RotateImage {
	/*
	 * Method 1
	 */
    public void rotate(int[][] matrix) {
        int len = matrix.length-1, level = 0,current = 0;
        if((len & 1) == 1){
            level = (len >> 1) + 1;
        }else {
            level = len >> 1;
        }
        while (current <= level){
            for (int i = current; i <= len-current-1; i++){ //
                int tmp1 = matrix[i][len-current];
                matrix[i][len-current] = matrix[current][i];
                int tmp2 = matrix[len-current][len-i];
                matrix[len-current][len-i] = tmp1;
                tmp1 = matrix[len-i][current];
                matrix[len-i][current] = tmp2;
                matrix[current][i] = tmp1;
            }
            current++;
        }
    }
    
    /*
     * Method 2
     */
    public void rotate2(int[][] matrix) {
        int N = matrix.length, cube_len = (N + 1) / 2;
        for (int i = 0; i < cube_len; i++) {
            for (int j = 0; j < N - cube_len; j++) {
                Point[] points = new Point[4];
                points[0] = new Point (i, j);
                points[1] = new Point (j, N - 1 - i);
                points[2] = new Point (N - 1 - i, N - 1 - j);
                points[3] = new Point (N - 1 - j, i);
                for (int k = 3; k >= 1; k--)
                    swap (matrix, points[k], points[k - 1]);
            }
        }
    }

    void swap (int[][] matrix, Point A, Point B) {
        int tmp = matrix[A.x][A.y];
        matrix[A.x][A.y] = matrix[B.x][B.y];
        matrix[B.x][B.y] = tmp;
    }
    
    static class Point {
        int x, y;
        Point (int x, int y) {this.x = x; this.y = y;}
    }

    /*
     * Method 3
     */
    public void rotate3(int[][] matrix) {
        int n = matrix.length;
        for(int i=0; i<n/2; i++) {
            for(int j=i; j<n-i-1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }
}
