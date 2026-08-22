class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        //Loop backwards from the last
        for (int i = n - 1; i >= 0; i--)
        {
           
            if (digits[i] < 9)
            {
                digits[i]++;
                return digits;
            }
            
            
            digits[i] = 0;
        }
        
        
        //new array that is 1 size larger
        int[] result = new int[n + 1];
        result[0] = 1; 
        
        return result;
    }
}
