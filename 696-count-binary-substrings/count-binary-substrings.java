class Solution {
    public int countBinarySubstrings(String s) {
        int sz = s.length(), i = 0, ans = 0;
        int curr = -1, prev = -1;
        char ch;

        while(i < sz){
            curr = 0;
            ch = s.charAt(i);
            while(i < sz && s.charAt(i) == ch){
                curr++; i++;
            }
            if(prev != -1){
                ans += prev < curr ? prev : curr;
            }
            prev = curr;
        }

        return ans;
    }
}