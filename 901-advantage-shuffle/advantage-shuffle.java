class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int sz = nums1.length, j = 0, k = 0;
        int tmp[][] = new int[sz][2];
        int ans[] = new int[sz];
        List<Integer> pending = new ArrayList<>();

        for(int i=0; i<sz; i++){
            tmp[i][0] = nums2[i];
            tmp[i][1] = i;
        }
        Arrays.sort(tmp, (a, b) -> b[0] - a[0]);
        Arrays.sort(nums1);

        // for(int i=0; i<sz; i++){
        //     System.out.print(tmp[i][0] + ":" + tmp[i][1] + ", ");
        // }
        // System.out.println();

        for(int i=sz-1; i>=0; i--){
            while(j < sz && tmp[j][0] >= nums1[i]){
                pending.add(tmp[j][1]);
                j++;
            }
            if(j < sz){
                // System.out.println(nums1[i] + " used for " + tmp[j][1]);
                ans[tmp[j][1]] = nums1[i];
                j++;
            }
            else{
                // System.out.println(nums1[i] + " used for " + pending.get(k));
                ans[pending.get(k++)] = nums1[i];
            }
        }

        return ans;
    }
}