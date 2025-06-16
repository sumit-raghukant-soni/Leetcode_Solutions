class Solution {
    public boolean canTransform(String start, String result) {
        int sz = start.length(), r = 0, l = 0;
        if(result.length() != sz) return false;

        for(int i=0; i<sz; i++){
            if(l < 0 || r > 0) return false;
            if(result.charAt(i) == 'L'){
                l++;
                if(r != 0) return false;
            }
            else if(result.charAt(i) == 'R'){
                r++;
                if(l != 0) return false;
            }
            if(start.charAt(i) == 'L'){
                l--;
                if(r != 0) return false;
            }
            else if(start.charAt(i) == 'R'){
                r--;
                if(l != 0) return false;
            }
        }

        return r == 0 && l == 0;
    }
}