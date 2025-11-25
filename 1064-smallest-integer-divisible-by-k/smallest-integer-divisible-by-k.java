class Solution {
    public int smallestRepunitDivByK(int k) {
        int val = 1, cnt = 1;
        Set<Integer> st = new HashSet<>();

        while(!st.contains(val)){
            st.add(val);
            while(val < k){
                cnt++;
                val = (val*10) + 1;
            }
            val = val%k;
            // System.out.println(val);
            if(val == 0) return cnt;
        }

        return -1;
    }
}