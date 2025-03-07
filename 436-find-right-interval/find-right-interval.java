class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int sz = intervals.length;
        int ans[] = new int[sz];
        int arr[][] = new int[sz][3];

        Arrays.fill(ans, -1);

        for(int i=0; i<sz; i++){
            arr[i][0] = intervals[i][0];
            arr[i][1] = intervals[i][1];
            arr[i][2] = i;
        }

        Arrays.sort(arr, (a, b) -> {
           if(a[1] != b[0]) return a[1] - b[0];
           return a[0] - b[0];
        });

        for(int i=0; i<sz; i++){
            // System.out.print(arr[i][0] + ":" + arr[i][1] + " " + arr[i][2] + "   ");
            int j = i;
            while(j < sz && arr[i][1] > arr[j][0]){
                j++;
            }
            if(j < sz){
                ans[arr[i][2]] = arr[j][2];
            }
        }
        // System.out.println();
        // int curr = -1;
        // for(int i=sz-1; i>=0; i--){
        //     if(ans[arr[i][2]] == -1){
        //         ans[arr[i][2]] = curr;
        //     }
        //     else curr = ans[arr[i][2]];
        // }

        return ans;
    }
}