class Solution {
    public int removeCoveredIntervals(int[][] itvl) {
        int sz = itvl.length, cnt = 0;

        Arrays.sort(itvl, (a, b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        for(int i=0; i<sz; i++){
            cnt++;
            int j = i;
            // System.out.println(itvl[i][0] + " " + itvl[i][1]);
            i++;
            // if(i < sz) System.out.println("check " + itvl[i][0] + " " + itvl[i][1] + " " + (itvl[j][0] >= itvl[i][0]) + " " + (itvl[i][1] <= itvl[j][1]));
            while(i < sz && itvl[j][0] <= itvl[i][0] && itvl[i][1] <= itvl[j][1]) {
                // System.out.println("check " + itvl[i][0] + " " + itvl[i][1] + " " + (itvl[j][0] >= itvl[i][0] && itvl[i][1] <= itvl[j][1]));
                i++;
            }
            i--;
        }

        return cnt;
    }
}