class Solution {
    public int minimumCost(int[] nums) {
        int sz = nums.length;
        int a = nums[0], b = Integer.MAX_VALUE, c = Integer.MAX_VALUE;

        for(int i=1; i<sz; i++){
            if(b == Integer.MAX_VALUE) b = nums[i];
            else if(c == Integer.MAX_VALUE) c = nums[i];
            else{
                if(b+c > c+nums[i] || b+c > b+nums[i]){
                    if(b > c) b = c;
                    c = nums[i];
                }
            }
        }

        // System.out.println(a + ":" + b + ":" + c);

        return a + b + c;
    }
}