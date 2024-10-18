class Solution {
    public void solve(int[] nums, int sz, HashMap<Integer, Integer> mp, int tmp, int ind){
        if(ind == sz){
            if(mp.containsKey(tmp)){
                mp.put(tmp, mp.get(tmp)+1);
            }
            else{
                mp.put(tmp, 1);
            }
            return;
        }
        
        solve(nums, sz, mp, tmp, ind+1);
        tmp = tmp | nums[ind];
        // System.out.print(i + " = " + tmp + " ");
        solve(nums, sz, mp, tmp, ind+1);

    }
    public int countMaxOrSubsets(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        Integer maxi = 0, cnt = 0, sz = nums.length;
        
        solve(nums, sz, mp, 0, 0);

        for(Map.Entry<Integer, Integer> e : mp.entrySet()){
            // System.out.println(e.getKey() + " " + e.getValue());
            if(e.getKey() > maxi){
                maxi = e.getKey();
                cnt = e.getValue();
            }
        }

        return cnt;
    }
}