class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> mpp = new HashMap<>();
        int l = 0, maxlen = 0;
        int maxFreq = 0;

        for(int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            mpp.put(ch, mpp.getOrDefault(ch,0) + 1);
            maxFreq = Math.max(maxFreq, mpp.get(ch));

            while( (r-l+1) - maxFreq > k) {
                char leftChar = s.charAt(l);
                mpp.put(leftChar, mpp.get(leftChar) - 1);
                l++;
            }
            maxlen = Math.max(maxlen, r-l+1);
        }
        return maxlen;
    }
}