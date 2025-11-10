class Solution {
    public int minOperations(int[] nums) {
        int sz = nums.length, ans = 0;
        Stack<Integer> st = new Stack<>();

        for(int i : nums){
            while(!st.isEmpty() && st.peek() > i){
                st.pop();
                ans++;
            }
            if(i != 0 && (st.isEmpty() || st.peek() != i) ) st.push(i);
            // System.out.println(st + " " + ans);
        }

        if(!st.isEmpty()) ans += st.size();
        return ans;
    }
}