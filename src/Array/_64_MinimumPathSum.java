package Array;

public class _64_MinimumPathSum {
    public int minPathSum(int[][] grid) {
        return next(grid, 0, 0);
    }
    
    public int next(int[][] grid, int x, int y) {
        if(x == grid.length-1 && y == grid[0].length-1) {
            return grid[x][y];
        }
        if(grid[x][y] < 0) {
            return -grid[x][y];
        }
        int down = x < grid.length-1 ? next(grid, x+1, y) : Integer.MAX_VALUE;
        int right = y < grid[0].length-1 ? next(grid, x, y+1) : Integer.MAX_VALUE;
        
        int result = Math.min(down, right) + grid[x][y];
        grid[x][y] = -result;
        return result;
    }
}
