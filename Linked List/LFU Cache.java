import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
    // Helper class to store value and how many times it was used
    private static class CacheNode {
        int val;
        int freq;
        
        CacheNode(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }

    private final int capacity;
    private int minFreq;
    private final Map<Integer, CacheNode> cache; // key -> CacheNode(value, frequency)
    private final Map<Integer, LinkedHashSet<Integer>> freqMap; // freq -> set of keys

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }
    
    private void updateFrequency(int key, CacheNode node) {
        int oldFreq = node.freq;
        node.freq++;
        
        
        freqMap.get(oldFreq).remove(key);
        
        
        if (freqMap.get(oldFreq).isEmpty() && oldFreq == minFreq) {
            minFreq++;
        }
        
        
        freqMap.computeIfAbsent(node.freq, k -> new LinkedHashSet<>()).add(key);
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        CacheNode node = cache.get(key);
        updateFrequency(key, node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (cache.containsKey(key)) {
            
            CacheNode node = cache.get(key);
            node.val = value; 
            updateFrequency(key, node);
        } else {
            
            if (cache.size() >= capacity) {
                
                int evictKey = freqMap.get(minFreq).iterator().next();
                freqMap.get(minFreq).remove(evictKey);
                cache.remove(evictKey);
            }
            
            
            CacheNode newNode = new CacheNode(value, 1);
            cache.put(key, newNode);
            freqMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
            minFreq = 1; // The lowest frequency is 1
        }
    }
}
