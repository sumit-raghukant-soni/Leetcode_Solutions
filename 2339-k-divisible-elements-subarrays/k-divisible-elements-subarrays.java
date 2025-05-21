class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int sz = nums.length;
        boolean flg[] = new boolean[sz];
        Set<String> st = new HashSet<>();

        for(int i=0; i<sz; i++){
            if(nums[i]%p == 0) flg[i] = true;
        }

        for(int i=0; i<sz; i++){
            int cnt = 0;
            StringBuilder tmp = new StringBuilder("");
            for(int j=i; j<sz; j++){
                if(flg[j]) cnt++;
                if(cnt > k) break;
                tmp.append((char)(nums[j] + '0'));
                st.add(tmp.toString());
            }
        }

        return st.size();
    }
}