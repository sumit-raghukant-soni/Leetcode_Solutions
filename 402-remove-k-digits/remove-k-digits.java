class Solution {
    public String removeKdigits(String num, int k) {
        int sz = num.length();
        String ans = "";
        Deque<Character> st = new LinkedList<>();

        for(int i=0; i<sz; i++){
            while(k > 0 && !st.isEmpty() && st.peekLast() > num.charAt(i)){
                if(st.size() > 1 || st.peekLast() != '0') k--;
                st.removeLast();
            }
            
            st.add(num.charAt(i));

            if(st.size() == 1 && num.charAt(i) == '0') st.removeLast();
        }

        while(!st.isEmpty() && k > 0){
            k--;
            st.removeLast();
        }

        while(!st.isEmpty()){
            ans = st.removeLast() + ans;
        }
        
        return ans.isEmpty() ? "0" : ans;
    }
}