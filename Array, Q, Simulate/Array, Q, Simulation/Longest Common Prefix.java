class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) 
        {
            return "";
        }
        
        //Find the shortest word
        String shortest = strs[0];
        for (String word : strs) 
        {
            if (word.length() < shortest.length())
             {
                shortest = word;
            }
        }
        
        //Check characters one by one
        for (int i = 0; i < shortest.length(); i++) 
        {
            char c = shortest.charAt(i);
            
            
            for (String word : strs) 
            {
                if (word.charAt(i) != c) 
                {
                    //Return the prefix up to this point if mismatch
                    return shortest.substring(0, i);
                }
            }
        }
        
        
        return shortest;
    }
}