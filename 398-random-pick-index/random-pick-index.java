class Solution {
    HashMap<Integer, List<Integer>> mp = new HashMap<>();
    HashMap<Integer, Integer> mp2 = new HashMap<>();
    public Solution(int[] nums) {
        int sz = nums.length;

        for(int i=0; i<sz; i++){
            mp2.put(nums[i], 0);
            if(!mp.containsKey(nums[i])){
                mp.put(nums[i], new ArrayList<>());
            }
            mp.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        mp2.put(target, mp2.get(target)+1);
        if(mp2.get(target) == mp.get(target).size()) mp2.put(target, 0);
        
        return mp.get(target).get(mp2.get(target));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */