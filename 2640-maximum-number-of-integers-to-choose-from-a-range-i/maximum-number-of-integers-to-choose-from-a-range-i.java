class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int j=0, sz = banned.length, cnt = 0;
        Set<Integer> st = new HashSet<>();
        
        Arrays.sort(banned);
        
        for(int i=1; i<=n; i++){
            if(i > maxSum) break;
            if(j < sz){
                if(banned[j] != i && (maxSum-i) >= 0 && !st.contains(i)){
                    maxSum -= i;
                    cnt++;
                    st.add(i);
                }
                while(j < sz && banned[j] == i) j++;
            }
            else{
                cnt++;
                maxSum -= i;
            }
        }

        return cnt;
    }
}