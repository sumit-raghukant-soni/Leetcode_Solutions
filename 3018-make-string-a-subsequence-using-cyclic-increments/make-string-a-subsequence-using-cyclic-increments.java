class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int sz1 = str1.length(), sz2 = str2.length(), j = 0;
        if(sz2 > sz1) return false;

        char[] next = new char[26];
        for(int i=0; i<26; i++){
            next[i] = (char) ((i + 1)%26 + 97);
        }
        
        
        for(int i=0; i<sz1; i++){
            if(j < sz2 && (str1.charAt(i) == str2.charAt(j) || next[(int) str1.charAt(i) - 97] == str2.charAt(j))){
                j++;
            }
        }

        if(j == sz2) return true;
        return false;
    }
}