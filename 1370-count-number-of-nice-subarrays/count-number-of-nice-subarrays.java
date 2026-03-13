class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int sz = nums.length, sz2, cnt = 0, j = 0;
        int ans = 0;
        List<Integer> lst = new ArrayList<>();

        for(int i=0; i<sz; i++){
            if( (nums[i]&1) == 1 ) lst.add(i);
        }

        sz2 = lst.size();
        for(int i=k-1; i<sz2; i++){
            int left = i-k >= 0 ? lst.get(i-(k-1)) - lst.get(i-k) : lst.get(i-(k-1))+1;
            int right = i+1 <sz2 ? lst.get(i+1) - lst.get(i) : sz-lst.get(i);
            // if(left == 0) left++; if(right == 0) right++;
            ans += left * right;
            // System.out.println(lst.get(i) + " " + left + ":" + right);
            // if(i-k >= 0) System.out.println( lst.get(i-(k-1)) + "-" + lst.get(i-k) );
        }

        return ans;
    }
}