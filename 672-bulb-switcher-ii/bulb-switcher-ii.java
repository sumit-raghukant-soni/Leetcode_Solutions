class Solution {
    public int flipLights(int n, int presses) {
        if(presses == 0) return 1;
        int ans[][] = {{2, 3, 4}, {2, 4, 7}, {2, 4, 8}};
        
        n = n > 3 ? 2 : n-1;
        presses = presses > 3 ? 2 : presses-1;

        return ans[presses][n];
    }
} 

// when p >= 3 
// 2, 4, 8...

// when p == 2
// 2, 4 , 7...

// when p == 1
// 2, 3, 4