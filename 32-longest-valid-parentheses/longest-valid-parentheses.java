class Solution {
    public int longestValidParentheses(String s) {
        int sz = s.length(), j = 0;
        int c1 = 0, c2 = 0, ans = 0;
        char ch;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < sz; i++) {
            ch = s.charAt(i);
            if (ch == '(')
                st.push(-1);
            else {
                if (!st.isEmpty() && st.peek() == -1) {
                    st.pop();
                    st.push(2);
                    ans = Math.max(ans, 2);
                } else if (!st.isEmpty() && st.peek() > 0) {
                    // System.out.println("Before " + st);
                    int val = 0;
                    while (!st.isEmpty() && st.peek() > 0) {
                        val += st.pop();
                    }
                    // System.out.println("After sum " + st);
                    if (!st.isEmpty() && st.peek() == -1) {
                        st.pop();
                        val += 2;
                        st.push(val);
                        ans = Math.max(ans, val);
                    }
                    // System.out.println("finally " + st);
                } else {
                    st.push(-2);
                }

                int val = 0;
                while (!st.isEmpty() && st.peek() > 0) {
                    val += st.pop();
                }

                if(val > 0) {
                    st.push(val);
                    ans = Math.max(ans, val);
                }
            }
            // System.out.println(st);
        }

        return ans;
    }
}