class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int j=0, sz = banned.length, cnt = 0;
        Set<Integer> st = new HashSet<>();
        
        for(int i=0; i<sz; i++){
            st.add(banned[i]);
        }
        
        for(int i=1; i<=n; i++){
            if(i > maxSum) break;
            if(!st.contains(i)){
                maxSum -= i;
                cnt++;
            }
        }

        return cnt;
    }
}