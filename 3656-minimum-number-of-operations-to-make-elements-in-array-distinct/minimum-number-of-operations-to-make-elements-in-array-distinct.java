class Solution {
    public int minimumOperations(int[] nums) {
        int sz = nums.length, i = sz-1;
        int freq[] = new int[100];

        for(; i>=0; i--){
            freq[nums[i] - 1]++;
            if(freq[nums[i] - 1] > 1) break;
        }
        i++;

        return (i/3) + ((i%3) != 0 ? 1 : 0);
    }
}