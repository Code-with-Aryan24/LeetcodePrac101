import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int numIslands(char[][] grid) 
    {
        if (grid == null || grid.length == 0) 
        {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;

        for (int r = 0; r < rows; r++) 
        {
            for (int c = 0; c < cols; c++) 
            {
                if (grid[r][c] == '1') 
                {
                    islandCount++;
                    grid[r][c] = '0'; //mark

                    
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{r, c});

                    while (!queue.isEmpty()) 
                    {
                        int[] curr = queue.poll();
                        int currR = curr[0];
                        int currC = curr[1];

                        // Direction vectors for Down, Up, Right, Left
                        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

                        for (int[] dir : directions) 
                        {
                            int newR = currR + dir[0];
                            int newC = currC + dir[1];

                            
                            if (newR >= 0 && newR < rows && newC >= 0 && newC < cols && grid[newR][newC] == '1') 
                            {
                                grid[newR][newC] = '0'; // Mark visited
                                queue.offer(new int[]{newR, newC});
                            }
                        }
                    }
                }
            }
        }

        return islandCount;
    }
}