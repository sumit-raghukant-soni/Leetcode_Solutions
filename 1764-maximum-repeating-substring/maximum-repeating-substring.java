class Solution {
    public int maxRepeating(String sequence, String word) {
        int sz1 = sequence.length(), sz2 = word.length();
        int ans = 0, tmp;

        for(int i=0; i<sz1; i++){
            int j = i;
            tmp = 0;
            while(i+sz2 <= sz1 && word.equals(sequence.substring(i, i+sz2))){
                tmp++;
                i += sz2;
            }
            ans = Math.max(ans, tmp);
            i = j;
        }

        return ans;
    }
}