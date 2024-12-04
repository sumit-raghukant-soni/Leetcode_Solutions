class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int sz1 = str1.length(), sz2 = str2.length(), j = 0;
        if(sz2 > sz1) return false;
        
        
        for(int i=0; i<sz1; i++){
            // System.out.println(i + " " + j);
            if(j < sz2 && (str1.charAt(i) == str2.charAt(j) || ((int) (str1.charAt(i)+1-97)%26 + 97) == (int) str2.charAt(j))){
                j++;
            }
        }

        if(j == sz2) return true;
        return false;
    }
}