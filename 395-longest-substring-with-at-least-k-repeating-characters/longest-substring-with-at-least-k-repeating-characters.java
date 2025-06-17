class Solution {
    public int longestSubstring(String s, int k) {
        int sz = s.length(), ans = 0;
        
        ans = solve(s, k, 0, sz-1);

        return ans;
    }

    private int solve(String s, int kVal, int i, int j){
        // System.out.println(i + ":" + j);
        if(i > j) return 0;
        int ans = 0, flg = 0;
        char pivot = 's';
        int freq[] = new int[26];

        for(int k=i; k<=j; k++){
            freq[s.charAt(k) - 'a']++;
        }
        for(int k=0; k<26; k++){
            if(freq[k] != 0 && freq[k] < kVal){
                flg = 1;
                pivot = (char) (k + 'a');
                break;
            }
        }
        
        if(flg == 0) return j - i + 1;
        else{
            int start = i;
            for(int k=i; k<=j; k++){
                if(s.charAt(k) == pivot){
                    // System.out.println("From " + i + ":" + j + " " + pivot + " at " + k);
                    ans = Math.max(ans, solve(s, kVal, start, k-1));
                    // ans = Math.max(ans, solve(s, kVal, k+1, j));
                    start = k+1;
                }
            }
            ans = Math.max(ans, solve(s, kVal, start, j));
        }

        return ans;
    }
}