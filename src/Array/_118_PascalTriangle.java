package Array;

import java.util.ArrayList;
import java.util.List;

public class _118_PascalTriangle {

	/*
	 * Method 1. dynamic programming
	 */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        // First base case; if user requests zero rows, they get zero rows.
        if (numRows == 0) {
            return triangle;
        }

        // Second base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum-1);
            
            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }
    
    /*
     * Method 2
     */
    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        List<Integer> row = new ArrayList<Integer>();
        
        for(int i=0; i<numRows; i++) {
            row.add(0, 1);	// Always INSERT 1 at the beginning
            for(int j=1; j<row.size()-1; j++) {
                row.set(j, row.get(j) + row.get(j+1));
            }
            triangle.add(new ArrayList<Integer>(row));
        }
        return triangle;
    }
}
