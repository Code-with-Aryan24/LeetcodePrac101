import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        //maximum possible distance
        int maxDist = Math.max(rCenter, rows - 1 - rCenter) + Math.max(cCenter, cols - 1 - cCenter);
        
        //group cells 
        List<int[]>[] buckets = new ArrayList[maxDist + 1];
        for (int i = 0; i <= maxDist; i++) 
            {
            buckets[i] = new ArrayList<>();
        }

        for (int r = 0; r < rows; r++) 
            {
            for (int c = 0; c < cols; c++) {
                int dist = Math.abs(r - rCenter) + Math.abs(c - cCenter);
                buckets[dist].add(new int[]{r, c});
            }
        }

        //buckets to output array
        int[][] result = new int[rows * cols][2];
        int index = 0;
        for (int d = 0; d <= maxDist; d++) 
            {
            for (int[] cell : buckets[d]) 
                {
                result[index++] = cell;
            }
        }

        return result;
    }
}