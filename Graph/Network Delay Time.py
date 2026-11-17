import heapq

class Solution:
    def networkDelayTime(self, times: list[list[int]], n: int, k: int) -> int:
        #adjacency list
        adj = [[] for _ in range(n + 1)]
        for u, v, w in times:
            adj[u].append((v, w))
            
        #Min-heap priority queue storing (current_distance, node)
        pq = [(0, k)]
        dist = {}
    
        while pq:
            d, u = heapq.heappop(pq)
            if u in dist:
                continue
            dist[u] = d
            
            for ngh, w in adj[u]:
                if ngh not in dist:
                    heapq.heappush(pq, (d + w, ngh))
                    
        if len(dist) < n:
            return -1
            
        # Return the maximum time required
        return max(dist.values())