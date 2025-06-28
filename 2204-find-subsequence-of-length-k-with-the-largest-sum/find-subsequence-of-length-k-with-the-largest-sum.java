class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int sz = nums.length, j = 0;
        int ans[] = new int[k]; 
        List<Integer> tmp = new ArrayList<>();

        for(int i=0; i<sz; i++){
            tmp.add(nums[i]);
        }
        Collections.sort(tmp);
        for(int i=0; i<(sz-k); i++){
            tmp.remove(Integer.valueOf(tmp.get(0)));
        }

        for(int i=0; i<sz; i++){
            if(tmp.contains(nums[i])){
                ans[j++] = nums[i];
                tmp.remove(tmp.indexOf(nums[i]));
            }
        }

        return ans;
    }
}