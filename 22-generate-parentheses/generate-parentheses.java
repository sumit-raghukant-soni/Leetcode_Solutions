class Solution {
    private List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();

        solve("", n, n);

        return ans;
    }

    private void solve(String str, int o, int c) {
        if(o == c && o == 0) {
            ans.add(str);
            return;
        }

        if(o > 0) {
            solve(str+"(", o-1, c);
        }
        if(c > 0 && c > o) {
            solve(str+")", o, c-1);
        }
    }
}