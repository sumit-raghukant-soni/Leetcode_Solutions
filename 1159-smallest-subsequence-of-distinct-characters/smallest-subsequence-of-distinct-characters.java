class Solution {
    public String smallestSubsequence(String s) {
        int freq[] = new int[26], seen[] = new int[26], sz = s.length();   
        String ans = "";
        Stack<Character> st = new Stack<>();

        for(int i=0; i<sz; i++){
            freq[s.charAt(i) - 'a']++;
        }

        for(int i=0; i<sz; i++){
            // System.out.println(st);
            int iVal = s.charAt(i) - 'a';
            if(seen[iVal] != 1){
                while(!st.isEmpty() && st.peek() > s.charAt(i) && freq[st.peek() - 'a'] > 0){
                    // System.out.println("removed " + st.peek() + " with " + freq[st.peek() - 'a']);
                    seen[st.pop() - 'a']--;
                }
                seen[iVal]++;
                st.push(s.charAt(i));
            }
            freq[iVal]--;
        }

        while(!st.isEmpty()){
            ans = st.pop() + ans;
        }


        return ans;
    }
}