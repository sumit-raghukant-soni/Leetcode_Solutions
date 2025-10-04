class Solution {
    public int maxArea(int[] height) {
        int sz = height.length, ans = 0, s = 0, e = sz-1;
        
        while(s < e){
            int tmp = (e-s) * (height[s] < height[e] ? height[s] : height[e]);
            // System.out.println(s + " " + e + " " + tmp);
            ans = ans > tmp ? ans : tmp;
            if(height[s] <= height[e]) s++;
            else e--;
        }

        return ans;
    }
}