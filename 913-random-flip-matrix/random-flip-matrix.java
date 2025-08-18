class Solution {
    int e, m, n;
    Set<Integer> st = new HashSet<>();
    public Solution(int m, int n) {
        this.m = m;
        this.n = n;
        e = (m * n) - 1;
    }
    
    public int[] flip() {
        int ans[] = new int[2], rand;
        do{
            rand = (int) (Math.random() * (e + 1));
        }
        while(st.contains(rand));

        st.add(rand);
        ans[0] = rand/n;
        ans[1] = rand%n;
        return ans;
    }
    
    public void reset() {
        st.clear();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */