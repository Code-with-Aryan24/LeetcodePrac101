class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        //adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) 
        {
            graph.add(new ArrayList<>());
        }

        //edges
        for (int[] edge : edges) 
        {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        //visited note
        boolean[] visited = new boolean[n];

        
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(source);
        visited[source] = true;

        //BFS
        while (!queue.isEmpty()) 
        {

            int current = queue.poll();

            // Destination found
            if (current == destination) 
            {
                return true;
            }

            // Visit all neighbours
            for (int neighbour : graph.get(current)) 
            {

                if (!visited[neighbour]) 
                {
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }

        
        return false;
    }
}