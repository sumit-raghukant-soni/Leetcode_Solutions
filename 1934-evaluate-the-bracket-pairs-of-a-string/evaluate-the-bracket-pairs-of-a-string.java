class Solution {
    private Map<String, String> mp = new HashMap<>();
    public String evaluate(String s, List<List<String>> kw) {
        for(List<String> elm : kw) {
            mp.put(elm.get(0), elm.get(1));
        }

        return solve(s, 0, s.length());
    }
    private String solve(String s, int i, int sz) {
        boolean kFlg = false;
        char ch;
        String res = "", key = "";

        for(; i<sz; i++) {
            ch = s.charAt(i);
            if(ch == '(') {
                kFlg = true;
            }
            else if(ch == ')') {
                kFlg = false;
                res += mp.getOrDefault(key, "?");
                key = "";
            }
            else {
                if(kFlg) key += ch;
                else res += ch;
            }
        }

        return res;
    }
}