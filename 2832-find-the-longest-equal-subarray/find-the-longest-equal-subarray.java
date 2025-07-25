class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int sz = nums.size(), ans = 0;
        List<Integer>[] arr = new ArrayList[sz+1];

        for(int i=1; i<=sz; i++) arr[i] = new ArrayList<>();

        for(int i=0; i<sz; i++){
            arr[nums.get(i)].add(i);
        }

        for(int i=1; i<=sz; i++){
            if(arr[i].size() == 0) continue;
            int l=0;
            for(int j=0; j<arr[i].size(); j++){
                while( (arr[i].get(j) - arr[i].get(l)) - (j-l) > k){
                    l++;
                }
                ans = ans > (j-l+1) ? ans : (j-l+1);
            }
        }

        return ans;
    }
}