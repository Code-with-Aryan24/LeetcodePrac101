class KthLargest {
    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) 
    {
        this.k = k;
        this.pq = new PriorityQueue<>(); // Min-heap

        for (int num : nums) 
        {
            add(num);
        }
    }
    
    public int add(int val) 
    {
        pq.add(val);

        
        if (pq.size() > k) 
        {
            pq.poll();
        }

        // The root of the min-heap = largest
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */