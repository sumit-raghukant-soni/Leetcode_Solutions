class Solution {
    public int minFlipsMonoIncr(String s) {
        int sz = s.length(), o = 0, z = 0;
        int ans = Integer.MAX_VALUE;

        for(int i=0; i<sz; i++){
            if(s.charAt(i) == '0') z++;
        }
    
        for(int i=0; i<sz; i++){
            // System.out.println(o + " " + z);
            ans = ans < (o+z) ? ans : (o+z);
            if(s.charAt(i) == '0') z--;
            else o++;
        }
        ans = ans < (o+z) ? ans : (o+z);

        return ans;
    }
}