class Solution {
    public int trap(int[] height) {
        int sz = height.length, ans = 0;
        int arr[] = new int[sz], prefix[] = new int[sz], sufix[] = new int[sz];

        prefix[0] = height[0];
        for(int i=1; i<sz; i++){
            if(prefix[i-1] < height[i]) prefix[i] = height[i];
            else prefix[i] = Math.max(prefix[i-1], height[i-1]);
        }

        sufix[sz-1] = height[sz-1];
        for(int i=sz-2; i>=0; i--){
            if(sufix[i+1] < height[i]) sufix[i] = height[i];
            else sufix[i] = Math.max(sufix[i+1], height[i+1]);
        }

        for(int i=0; i<sz; i++){
            // System.out.print(prefix[i] + ":" + sufix[i] + ", ");
            if(Math.min(prefix[i], sufix[i]) > height[i]) ans += Math.min(prefix[i], sufix[i]) - height[i];
        }

        return ans;
    }
}