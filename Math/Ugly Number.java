class Solution {
    public boolean isUgly(int n) {
        //base case
        if (n <= 0) 
        {
            return false;
        }

        //Divide all factors
        int[] primeFactors = {2, 3, 5};
        for (int factor : primeFactors) 
        {
            while (n % factor == 0) 
            {
                n /= factor;
            }
        }

        
        return n == 1;
    }
}