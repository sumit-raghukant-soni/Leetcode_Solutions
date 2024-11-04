class Solution {
    public String compressedString(String word) {
        int sz = word.length(), i = 0, cnt;
        String ans = "";

        while(i < sz){
            char ch = word.charAt(i++);
            cnt = 1;
            while(i < sz && word.charAt(i) == ch && cnt < 9){
                i++; cnt++;
            }
            ans += (char)(cnt + '0');
            ans += ch;
        }

        return ans;
    }
}