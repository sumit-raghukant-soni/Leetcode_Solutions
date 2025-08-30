class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int sz = nums.length, ans = 1, j = 0;
        TreeSet<PPair> st = new TreeSet<>();

        for(int i=0; i<sz; i++){
            st.add(new PPair(nums[i], i));
            while(st.last().val - st.first().val > limit){
                st.remove(new PPair(nums[j], j));
                j++;
            }
            ans = ans > (i-j+1) ? ans : (i-j+1);
        }

        return ans;
    }
}

class PPair implements Comparable<PPair> {
    int val, ind;
    PPair(int v, int i){
        this.val = v;
        this.ind = i;
    }
    @Override
    public int compareTo(PPair other) {
        if (this.val != other.val) {
            return Integer.compare(this.val, other.val);
        }
        return Integer.compare(this.ind, other.ind);
    }
}