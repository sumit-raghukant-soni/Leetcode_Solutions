class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int sz = nums.length, ans = 0;
        ArrayList<Integer> lst = new ArrayList<>();

        for(int i=0; i<sz; i++){
            if(nums[i] >= left && nums[i] <= right) lst.add(i);
            else if(nums[i] > right) lst.add(-1*i);
        }

        lst.add(sz);

        int pre = 0, next, curr, sz2 = lst.size();
        for(int i=0; i<sz2; i++){
            curr = lst.get(i);
            if(curr == sz || curr < 0 || (curr == 0 && nums[0] > right)){
                pre = (curr*-1) + 1;
                continue;
            }
            
            next = (i+1 < sz2) ? (lst.get(i+1) >= 0 ? lst.get(i+1)-1 : (lst.get(i+1)*-1)-1) : lst.get(i);

            // System.out.println("at " + lst.get(i) + " pre : " + pre + " next : " + next);
            // System.out.println(" pre : " + (curr-pre+1) + " next : " + (next-curr+1));
            ans += (curr-pre+1) * (next-curr+1);
        }

        return ans;
    }
}