import java.util.LinkedList;
import java.util.Queue;
//process level wise
class Solution {
    public int orangesRotting(int[][] grid)
     {
        if (grid == null || grid.length == 0)
         {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

       
        for (int r = 0; r < rows; r++) 
        {
            for (int c = 0; c < cols; c++) 
            {
                if (grid[r][c] == 2)
                 {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) 
                {
                    freshOranges++;
                }
            }
        }

        
        if (freshOranges == 0) 
        {
            return 0;
        }

        int minutes = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        
        while (!queue.isEmpty()) 
        {
            int size = queue.size();
            boolean rottedThisMinute = false;

            for (int i = 0; i < size; i++) 
            {
                int[] curr = queue.poll();
                int currR = curr[0];
                int currC = curr[1];

                
                for (int[] dir : directions) 
                {
                    int newR = currR + dir[0];
                    int newC = currC + dir[1];

                   
                    if (newR >= 0 && newR < rows && newC >= 0 && newC < cols && grid[newR][newC] == 1) 
                    {
                        grid[newR][newC] = 2; 
                        freshOranges--;       
                        queue.offer(new int[]{newR, newC});
                        rottedThisMinute = true;
                    }
                }
            }

            
            if (rottedThisMinute) 
            {
                minutes++;
            }
        }

        
        return freshOranges == 0 ? minutes : -1;
    }
}