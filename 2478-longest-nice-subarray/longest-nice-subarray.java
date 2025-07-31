class Solution {

    public int longestNiceSubarray(int[] nums) {
        int maxLength = 1; 

        for (int start = 0; start < nums.length - maxLength; start++) {
            int currentLength = 1; 
            int usedBits = nums[start]; 

            for (int end = start + 1; end < nums.length; end++) {
                if ((usedBits & nums[end]) == 0) {
                    usedBits |= nums[end];
                    currentLength++;
                }
                else break;
            }
            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}