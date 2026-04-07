class Solution {
    public int reverse(int x) {
        return helper(x,0);
    }
    public int helper(int x, int reversed) {
        if(x == 0) return reversed;
        int rem = x % 10;
        // Check overflow BEFORE multiplying
        if (reversed > Integer.MAX_VALUE/10 || reversed < Integer.MIN_VALUE/10) {
            return 0;
        }
        reversed = reversed * 10 + rem;
        return helper(x/10, reversed);
    }
}