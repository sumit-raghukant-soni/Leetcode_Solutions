class Solution {
    public boolean isTrionic(int[] nums) {
        int sz = nums.length;
        int j = 1, i = 1;

        while(i<sz && nums[i] > nums[i-1]){
            i++;
        }
        if(i == j) return false;
        
        // System.out.println("First");
        j = i;
        while(i<sz && nums[i] < nums[i-1]){
            i++;
        }
        if(i == j) return false;

        // System.out.println("Second");
        j = i;
        while(i<sz && nums[i] > nums[i-1]){
            i++;
        }

        return i != j && i == sz;
    }
}