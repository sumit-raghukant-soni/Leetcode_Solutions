class Solution {
    public String removeDuplicateLetters(String s) {
        int sz = s.length(), freq[] = new int[26], seen[] = new int[26];
        String ans = "";
        Stack<Character> st = new Stack<>();

        for(int i=0; i<sz; i++){
            freq[s.charAt(i) - 'a']++;
        }

        for(int i=0; i<sz; i++){
            int iVal = s.charAt(i) - 'a';
            if(seen[iVal] != 1){
                while(!st.isEmpty() && st.peek() > s.charAt(i) && freq[st.peek() - 'a'] > 0){
                    seen[st.pop() - 'a']--;
                }   
                st.push(s.charAt(i));
                seen[iVal]++;
            }
            freq[iVal]--; 
        }

        while(!st.isEmpty()){
            ans = st.pop() + ans;
        }

        return ans;
    }
}