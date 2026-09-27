class Solution {
    public boolean hasMatch(String s, String p) 
    {
        int starIndex = p.indexOf('*');
        String prefix = p.substring(0, starIndex);
        String suffix = p.substring(starIndex + 1);

        //earliest occurrence of prefix
        int prefixIndex = s.indexOf(prefix);
        if (prefixIndex == -1) 
        {
            return false;
        }

        
        int suffixIndex = s.indexOf(suffix, prefixIndex + prefix.length());
        
        return suffixIndex != -1;
    }
}