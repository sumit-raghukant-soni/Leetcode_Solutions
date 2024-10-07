class Solution {
    public int minLength(String s) {
        int sz = s.length();
        Stack<Character> st = new Stack<>();

        for(int i=0; i<sz; i++){
            if(!st.isEmpty() && (st.peek() == 'A' && s.charAt(i) == 'B')){
                st.pop();
            }
            else if(!st.isEmpty() && (st.peek() == 'C' && s.charAt(i) == 'D')){
                st.pop();
            }
            else st.push(s.charAt(i));
        }

        return st.size();
    }
}