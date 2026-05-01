class Solution {
    public int maxRotateFunction(int[] nums) {
        int sz = nums.length;
        int sum = 0, maxSum = Integer.MIN_VALUE, extra = nums[0];
        int tmpSum = 0;

        for(int i=0; i<sz; i++) {
            sum += i * nums[i];
            tmpSum += nums[i];
        }

        // System.out.println(sum);
        // System.out.println(tmpSum);
        int k=1;
        for(int i=sz-1; i>=0; i--){
            sum -= nums[i] * (i+k++);
            sum += tmpSum;
            // System.out.println(sum);
            maxSum = sum > maxSum ? sum : maxSum;
        }

        return maxSum;
    }
}