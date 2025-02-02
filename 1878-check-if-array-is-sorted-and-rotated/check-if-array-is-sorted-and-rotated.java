class Solution {
    public boolean check(int[] nums) {
        int sz = nums.length, cnt;

        for(int i=0; i<sz; i++){
            cnt = 0;
            for(int j=i; j<(i+sz-1); j++){
                // System.out.print(nums[j%sz] + ":" + nums[(j+1)%sz] + ", ");
                if(nums[j%sz] > nums[(j+1)%sz]) break;
                cnt++;
            }
            if(cnt == sz-1) return true;
        }

        return false;
    }
}