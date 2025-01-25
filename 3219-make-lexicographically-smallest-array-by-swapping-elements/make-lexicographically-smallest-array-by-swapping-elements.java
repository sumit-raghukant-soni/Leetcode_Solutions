class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int sz = nums.length, k = -1, len = -1;
        int ans[] = new int[sz];
        List<List<Integer>> mpg_val = new ArrayList<>();
        List<List<Integer>> mpg_idx = new ArrayList<>();
        int tmp[][] = new int[sz][2];

        for(int i=0; i<sz; i++){
            tmp[i][0] = nums[i];
            tmp[i][1] = i;
        }

        Arrays.sort(tmp, (a, b) -> a[0] - b[0]);

        for(int i=0; i<sz; i++){
            if(k == -1 || mpg_val.get(k).size() == 0 || (tmp[i][0] - mpg_val.get(k).get(len)) > limit){
                mpg_val.add(new ArrayList<>());
                mpg_idx.add(new ArrayList<>());
                k++; len = -1;
            }
            mpg_val.get(k).add(tmp[i][0]);
            mpg_idx.get(k).add(tmp[i][1]);
            len++;
        }

        for(int i=0; i<mpg_val.size(); i++){
            Collections.sort(mpg_idx.get(i));
            System.out.println(mpg_val.get(i));
            for(int j=0; j<mpg_val.get(i).size(); j++){
                ans[mpg_idx.get(i).get(j)] = mpg_val.get(i).get(j);
            }
        }

        return ans;
    }
}