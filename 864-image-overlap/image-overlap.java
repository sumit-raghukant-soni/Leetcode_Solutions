class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int sz = img1.length;
        int ans = 0;
        int r1[] = new int[sz], c1[] = new int[sz];
        int r2[] = new int[sz], c2[] = new int[sz];

        for(int i=0; i<sz; i++) {
            for(int j=0; j<sz; j++) {
                if(img1[i][j] == 1) {
                    r1[i]++; c1[j]++;
                }
            }
        }

        for(int i=0; i<sz; i++) {
            for(int j=0; j<sz; j++) {
                if(img2[i][j] == 1) {
                    r2[i]++; c2[j]++;
                }
            }
        }

        for(int k=0; k<sz; k++) {
            for(int m=0; m<sz; m++) {
                int tmp1 = 0, tmp2 = 0, tmp3 = 0, tmp4 = 0, newi, newj;
                for(int i=0; i<sz; i++) {
                    for(int j=0; j<sz; j++) {
                        newi = i + k; newj = j + m;
                        if(newi < sz && newj < sz && img1[i][j] + img2[newi][newj] == 2) {
                            tmp1++;
                        }
                        newi = i - k; newj = j - m;
                        if(newi >= 0 && newj >= 0 && img1[i][j] + img2[newi][newj] == 2) {
                            tmp2++;
                        }
                        newi = i + k; newj = j - m;
                        if(newi < sz && newj >= 0 && img1[i][j] + img2[newi][newj] == 2) {
                            tmp3++;
                        }
                        newi = i - k; newj = j + m;
                        if(newi >= 0 && newj < sz && img1[i][j] + img2[newi][newj] == 2) {
                            tmp4++;
                        }
                    }
                }
                ans = ans > tmp1 ? ans : tmp1;
                ans = ans > tmp2 ? ans : tmp2;
                ans = ans > tmp3 ? ans : tmp3;
                ans = ans > tmp4 ? ans : tmp4;
            }
        }

        return ans;
    }
}