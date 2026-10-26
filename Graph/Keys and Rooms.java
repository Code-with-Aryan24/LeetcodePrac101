import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        
        // Start at room 0
        queue.add(0);
        visited[0] = true;
        
        while (!queue.isEmpty()) 
        {
            int currRoom = queue.poll();
        
            for (int key : rooms.get(currRoom)) 
            {
                if (!visited[key]) 
                {
                    visited[key] = true;
                    queue.add(key);
                }
            }
        }
        
        for (boolean v : visited) 
        {
            if (!v) 
            {
                return false;
            }
        }
        
        return true;
    }
}