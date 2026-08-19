class Solution {
    public boolean isPalindrome(int x) {

        int og =x;
        int reverse = 0;
        
        while(x!=0 && x>0)
        {
            int last = x%10;
            reverse = (reverse*10) + last;
            x = x/10; 
        }
        return og==reverse;
    }
}