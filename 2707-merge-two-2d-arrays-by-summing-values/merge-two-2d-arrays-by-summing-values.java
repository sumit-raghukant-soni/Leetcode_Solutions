class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int sz1 = nums1.length, sz2 = nums2.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<sz1; i++){
            mp.put(nums1[i][0], mp.getOrDefault(nums1[i][0], 0) + nums1[i][1]);
        }
        for(int i=0; i<sz2; i++){
            mp.put(nums2[i][0], mp.getOrDefault(nums2[i][0], 0) + nums2[i][1]);
        }

        int ans[][] = new int[mp.size()][2];
        int i=0;
        for(Map.Entry<Integer, Integer> e : mp.entrySet()){
            ans[i][0] = e.getKey();
            ans[i++][1] = e.getValue();
        }

        Arrays.sort(ans, (a, b) -> a[0] - b[0]);

        return ans;
    }
}