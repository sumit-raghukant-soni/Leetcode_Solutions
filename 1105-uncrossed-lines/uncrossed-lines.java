class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int sz1 = nums1.length, sz2 = nums2.length, ans = 0;
        int arr[][] = new int[sz1][sz2];

        for(int i=0; i<sz1; i++){
            for(int j=0; j<sz2; j++){
                if(nums1[i] == nums2[j]){
                    arr[i][j] = 1 + (i-1 >= 0 && j-1 >= 0 ? arr[i-1][j-1] : 0);
                }
                else {
                    arr[i][j] = Math.max(i-1 >= 0 ? arr[i-1][j] : 0, j-1 >= 0 ? arr[i][j-1] : 0);
                }
                ans = ans > arr[i][j] ? ans : arr[i][j];
            }
        }

        return ans;
    }
}