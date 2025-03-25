class Solution {
    public boolean checkValidCuts(int n, int[][] rects) {
        int sz = rects.length, k = 0;
        Arrays.sort(rects, (a, b) -> a[1] - b[1]);

        // for(int i=0; i<sz; i++){
        //     System.out.print("[" + rects[i][0] + "," + rects[i][1] + "," + rects[i][2] + "," + rects[i][3] + "], ");
        // }

        for(int i=0; i<sz; i++){
            // System.out.println(i);
            if(k == 2) break;
            int j = i, end = rects[i][3];
            while(j < sz && rects[j][1] < end){
                end = Math.max(rects[j][3], end);
                j++;
            }
            if(j != i && j < sz){
                k++;
            }
            i = j - 1;
        }
        if(k == 2) return true;

        Arrays.sort(rects, (a, b) -> a[0] - b[0]);
        k = 0;
        for(int i=0; i<sz; i++){
            if(k == 2) break;
            int j = i, end = rects[i][2];
            while(j < sz && rects[j][0] < end){
                end = Math.max(rects[j][2], end);
                j++;
            }
            if(j != i && j < sz){
                k++;
            }
            i = j - 1;
        }

        return k == 2;
    }
}