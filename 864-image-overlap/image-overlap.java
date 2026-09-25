class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int sz = img1.length, ans = 0;
        List<Integer[]> lst1 = new ArrayList<>();
        List<Integer[]> lst2 = new ArrayList<>();
        int arr[][] = new int[(sz*2) + 1][(sz*2) + 1];

        for(int i=0; i<sz; i++) {
            for(int j=0; j<sz; j++) {
                if(img1[i][j] == 1) {
                    lst1.add(new Integer[]{i, j});
                }
            }
        }

        for(int i=0; i<sz; i++) {
            for(int j=0; j<sz; j++) {
                if(img2[i][j] == 1) {
                    lst2.add(new Integer[]{i, j});
                }
            }
        }

        for(Integer[] e1 : lst1) {
            for(Integer[] e2 : lst2) {
                int diffX = (e1[0] - e2[0]) + sz;
                int diffY = (e1[1] - e2[1]) + sz;
                arr[diffX][diffY]++;
                ans = ans > arr[diffX][diffY] ? ans : arr[diffX][diffY];
            }
        }
        
        return ans;
    }
}