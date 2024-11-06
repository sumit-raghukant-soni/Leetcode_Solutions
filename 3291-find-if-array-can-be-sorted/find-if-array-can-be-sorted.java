class Solution {
    public boolean canSortArray(int[] nums) {
        int sz = nums.length;
        int sortedNums[] = new int[sz], i=0;
        for(int j=0; j<sz; j++) sortedNums[j] = nums[j];
        Arrays.sort(sortedNums);

        while(i < sz){
            int j=i, iBits = Integer.bitCount(nums[i]);
            while(j < sz && Integer.bitCount(nums[j]) == iBits){
                j++;
            }
            // System.out.println(i + " " + j);
            if(i != j) Arrays.sort(nums, i, j);
            i = j;
        }

        return Arrays.equals(nums, sortedNums);
    }
}