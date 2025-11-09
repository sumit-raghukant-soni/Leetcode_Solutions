class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int sz = nums.length;
        int cnt[] = new int[51], ans[] = new int[sz - k + 1];
        Set<Pair<Integer, Integer>> st = new TreeSet<>((a, b) -> {
            if(a.getValue() != b.getValue()) return b.getValue() - a.getValue();
            return b.getKey() - a.getKey();
        });

        for(int i=0; i<sz; i++){
            st.remove(new Pair(nums[i], cnt[nums[i]]));
            cnt[nums[i]]++;
            st.add(new Pair(nums[i], cnt[nums[i]]));
            if(i >= k-1){
                System.out.println(st);
                int j=x, sum = 0;
                for(Pair<Integer, Integer> p : st){
                    if(j-- == 0) break;
                    sum += p.getKey() * p.getValue();
                }
                ans[i-k+1] = sum;
                st.remove(new Pair(nums[i-k+1], cnt[nums[i-k+1]]));
                cnt[nums[i-k+1]]--;
                st.add(new Pair(nums[i-k+1], cnt[nums[i-k+1]]));
            }
        }

        return ans;
    }
    
}