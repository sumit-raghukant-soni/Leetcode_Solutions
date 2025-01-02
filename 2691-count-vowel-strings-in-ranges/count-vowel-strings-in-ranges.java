class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int sz = words.length, sz2 = queries.length;
        int ans[] = new int[sz2], prefixSum[] = new int[sz];

        for(int i=0; i<sz; i++){
            if(isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length()-1))){
                prefixSum[i] = 1;
            }
            if(i-1 >= 0) prefixSum[i] += prefixSum[i-1];
        }

        for(int i=0; i<sz2; i++){
            int left = queries[i][0], right = queries[i][1];
            if(left > 0) left = prefixSum[left-1];
            else left = 0;
            right = prefixSum[right];
            ans[i] = right - left;
        }

        return ans;
    }

    public boolean isVowel(char ch){
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }
}