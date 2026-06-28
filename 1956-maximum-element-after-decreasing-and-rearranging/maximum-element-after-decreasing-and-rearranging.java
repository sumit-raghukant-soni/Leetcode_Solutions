class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int sz = arr.length, curr = 1;

        Arrays.sort(arr);
        for(int i=0; i<sz; i++){
            curr = Math.min(curr, arr[i]);
            curr++;
        }

        return curr-1;
    }
}