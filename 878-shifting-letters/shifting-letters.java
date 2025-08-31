class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int sz = s.length(), val = 0;
        StringBuilder ans = new StringBuilder("");

        for(int i=sz-1; i>=0; i--){
            val = (int) (1l * val + shifts[i])%26;
            int ch = (s.charAt(i) - 'a' + val) % 26;
            ans.insert(0, (char) (ch + 'a'));
        }

        return ans.toString();
    }
}