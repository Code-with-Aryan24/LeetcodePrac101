import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int findCircleNum(int[][] isConnected) 
    {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinceCount = 0;

        for (int i = 0; i < n; i++)
        {
            if (!visited[i]) 
            {
                provinceCount++;
                
                //BFS
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                visited[i] = true;

                while (!queue.isEmpty()) 
                {
                    int currCity = queue.poll();

                    //check neighbour
                    for (int neighbor = 0; neighbor < n; neighbor++) 
                    {
                        if (isConnected[currCity][neighbor] == 1 && !visited[neighbor]) 
                        {
                            visited[neighbor] = true;
                            queue.offer(neighbor);
                        }
                    }
                }
            }
        }

        return provinceCount;
    }
}