import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n]; 

        for (int i=0; i<n; i++) 
        {
            if (colors[i] == 0) 
            {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                colors[i] = 1; 

                while (!queue.isEmpty()) 
                {
                    int curr = queue.poll();

                    for (int neighbor : graph[curr]) 
                    {
                        if (colors[neighbor] == 0) 
                        {
                            colors[neighbor] = -colors[curr];
                            queue.add(neighbor);
                        } else if (colors[neighbor] == colors[curr]) 
                        {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}