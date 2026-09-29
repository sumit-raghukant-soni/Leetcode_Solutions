class Solution {
    private int MOD = 1000000007;
    public int sumSubarrayMins(int[] arr) {
        int sz = arr.length, mini;   
        long sum = 0;
        int[] preMin = new int[sz], nextMin = new int[sz];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<sz; i++) {
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }            
            preMin[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        
        st.clear();
        for(int i=sz-1; i>=0; i--) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }            
            nextMin[i] = st.isEmpty() ? sz : st.peek();
            st.push(i);
        }

        for(int i=0; i<sz; i++) {
            int leftLen = i - preMin[i];
            int rightLen = nextMin[i] - i;
            sum = (sum + ((long) arr[i] * leftLen % MOD) * rightLen % MOD) % MOD;
            // System.out.print(leftLen + ":" + arr[i] + ":" + rightLen + ", ");
        }

        return (int) sum;
    }
}