class Solution {
    public int scoreOfParentheses(String s) {
        int sz = s.length(), cnt = 0;
        int ans = 0;
        Stack<Integer> st = new Stack<>();

        for(char ch : s.toCharArray()) {
            if(ch == '(') st.push(0);
            else {
                if(st.peek() == 0) {
                    st.pop();
                    st.push(1);
                }
                else {
                    int val = 0;
                    while(!st.isEmpty() && st.peek() != 0) {
                        val += st.pop() * 2;
                    }
                    st.pop();
                    st.push(val);
                }
            }
            // System.out.println(st);
        }

        while(!st.isEmpty()) {
            ans += st.pop();
        }

        return ans;
    }
}