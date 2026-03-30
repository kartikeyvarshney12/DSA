class Solution {
    public boolean canBeEqual(String s1, String s2) {
        int l = 0;
        for(int r = 0; r < s1.length(); r++) {
            while(r < s1.length()) {
                if((r - l) != 2) {
                    r++;
                }
                else {
                    swap(s1,l,r);
                    l++;
                    break;
                }
            }
        }
        int[] even = new int[26];
        int[] odd = new int[26];

        for(int i = 0; i < s1.length(); i++) {
            if(i % 2 == 0) {
                even[s1.charAt(i) - 'a']++;
                even[s2.charAt(i) - 'a']--;
            } else {
                odd[s1.charAt(i) - 'a']++;
                odd[s2.charAt(i) - 'a']--;
            }
        }

        for(int i = 0; i < 26; i++) {
            if(even[i] != 0 || odd[i] != 0) {
                return false;
            }
        }

        return true;
    }
    public String swap(String str, int i, int j) {
        char[] arr = str.toCharArray();

        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
        return new String(arr);
    }
}