class Solution {
    public int minimumRecolors(String blocks, int k) {
        int sz = blocks.length(), ans = Integer.MAX_VALUE;
        int recolor = 0;

        for(int i=0; i<sz; i++){
            if(blocks.charAt(i) == 'W') recolor++;
            if(i >= (k-1)){
                ans = Math.min(ans, recolor);
                if(blocks.charAt(i-(k-1)) == 'W') recolor--;
            }
        }

        return ans;
    }
}