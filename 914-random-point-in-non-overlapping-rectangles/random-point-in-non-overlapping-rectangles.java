class Solution {
    private int[][] Myrects;
    private int index, r, c, sz;
    public Solution(int[][] rects) {
        sz = rects.length;
        Myrects = new int[sz][4];
        for(int i=0; i<sz; i++){
            Myrects[i][0] = rects[i][0];
            Myrects[i][1] = rects[i][3];
            Myrects[i][2] = rects[i][2];
            Myrects[i][3] = rects[i][1];
        }

        // for(int i=0; i<sz; i++){
        //     System.out.print(Myrects[i][0] + ":" + Myrects[i][1] + "<>" + Myrects[i][2] + ":" + Myrects[i][3] + ", ");
        // }

        index = 0;
        r = Myrects[0][1];
        c = Myrects[0][0];
    }
    
    public int[] pick() {
        int m = Myrects[index][3], n = Myrects[index][2];
        if(r == m-1){
            index = (index+1)%sz;
            r = Myrects[index][1];
            c = Myrects[index][0];
        }

        int[] ans = {c, r};

        if(c == n){
            r--;
            c = Myrects[index][0];
        }
        else c++;

        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */