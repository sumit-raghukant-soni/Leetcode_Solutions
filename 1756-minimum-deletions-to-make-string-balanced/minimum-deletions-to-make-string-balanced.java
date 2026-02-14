class Solution {
    public int minimumDeletions(String s) {
        int sz = s.length(), a = 0, b = 0, ans = Integer.MAX_VALUE;

        for(int i=0; i<sz; i++){
            if(s.charAt(i) == 'a') a++; 
            // else a++; 
        }

        for(int i=0; i<sz; i++){
            if(s.charAt(i) == 'a') a--; 
            // else b++;
            // System.out.println(i + " " + a + ":" + b);
            ans = Math.min(ans, a + b);
            if(s.charAt(i) == 'b') b++; 
        }

        return ans;
    }
}