import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); //min heap
        for (int i : nums) 
        {
            minHeap.add(i);
            
            if (minHeap.size() > k) 
            {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}