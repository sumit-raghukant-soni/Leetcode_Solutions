class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int sz1 = nums1.length, sz2 = nums2.length, ans = 0;

        for(int i=0; i<sz1; i++){
            int k=i;
            for(int j=0; j<sz2; j++){
                // System.out.println(i + " " + k + ":" + ans);
                if(k < sz1 && nums1[k] == nums2[j]){
                    ans = Math.max(ans, k-i+1);
                    k++;
                }
                else{
                    if(k != i) j--;
                    k = i; 
                }
            }
        }

        for(int i=0; i<sz2; i++){
            int k=i;
            for(int j=0; j<sz1; j++){
                // System.out.println(i + " " + k + ":" + ans);
                if(k < sz2 && nums2[k] == nums1[j]){
                    ans = Math.max(ans, k-i+1);
                    k++;
                }
                else{
                    if(k != i) j--;
                    k = i; 
                }
            }
        }

        return ans;
    }
}