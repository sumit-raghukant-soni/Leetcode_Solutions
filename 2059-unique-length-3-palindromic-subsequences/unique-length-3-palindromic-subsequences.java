class Solution {
    Set<String> st;
    Set<Character> st2;
    public int countPalindromicSubsequence(String s) {
        // st = new HashSet<>();
        st2 = new HashSet<>();

        // solve(s, "", "", 0);

        int alpha[] = new int[26], ans = 0;
        for(int i=0; i<s.length(); i++){
            if(!st2.contains(s.charAt(i))){
                int j = s.lastIndexOf(s.charAt(i));
                if(i != j){
                    st2.add(s.charAt(i));
                    Arrays.fill(alpha, 0);
                    for(int k=i+1; k<j; k++){
                        alpha[s.charAt(k) - 'a']++;
                    }
                    for(int k=0; k<26; k++){
                        if(alpha[k] != 0) ans++;
                    }
                }
            }
        }
        return ans;

        // return st.size();
    }

    public void solve(String s, String str, String rev, int i){
        if(str.length() == 3){
            // System.out.println(str + " " + rev);
            if(str.equals(rev)) st.add(str);
            return;
        }
        if(i == s.length()) return;

        solve(s, str+s.charAt(i), s.charAt(i) + rev, i+1);
        solve(s, str, rev, i+1);
    }
}