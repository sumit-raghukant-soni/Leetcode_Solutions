class Solution {
    public List<String> ans = new ArrayList<>();
    public List<String> ambiguousCoordinates(String s) {
        int sz = s.length();

        StringBuilder a = new StringBuilder(""), b = new StringBuilder(s.substring(1, sz-1));
        
        for(int i=1; i<sz-2; i++){
            a.append(s.charAt(i));    
            b.deleteCharAt(0);    
            solve(a, b);
            // System.out.println(a + " " + b);
        }

        return ans;
    }

    private void solve(StringBuilder a, StringBuilder b){
        int sz1 = a.length(), sz2 = b.length();
        List<String> perm1 = new ArrayList<>();
        List<String> perm2 = new ArrayList<>();

        if(isValid(a.toString())) perm1.add(a.toString());
        for(int i=1; i<sz1; i++){
            a.insert(i, '.');
            if(isValid(a.toString())) perm1.add(a.toString());
            a.deleteCharAt(i);
        }

        if(isValid(b.toString())) perm2.add(b.toString());
        for(int i=1; i<sz2; i++){
            b.insert(i, '.');
            // System.out.println(b);
            if(isValid(b.toString())) perm2.add(b.toString());
            b.deleteCharAt(i);
        }

        for(int i=0; i<perm1.size(); i++){
            for(int j=0; j<perm2.size(); j++){
                ans.add("(" + perm1.get(i) + ", " + perm2.get(j) + ")");
            }
        }
    }

    private boolean isValid(String s){
        int sz = s.length();
        boolean isDecimal = false;

        if(sz > 1 && s.charAt(0) == '0' && s.charAt(1) != '.') return false;
        for(int i=0; i<sz; i++){
            if(s.charAt(i) =='.') isDecimal = true;
            // if(i+1 < sz && s.charAt(i) == s.charAt(i+1) && s.charAt(i) == '0') return false;
            if(i == sz-1 && s.charAt(i) == '0' && isDecimal) return false;
            if(sz > 1 && i == sz-1 && s.charAt(i) == '0' && s.charAt(i-1) == '.') return false;
        }

        return true;
    }
}