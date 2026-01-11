class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length, ans = 0;
        int arr[] = new int[n];
        
        for(int i=m-1; i>=0; i--){
            for(int j=0; j<n; j++){
                // if(matrix[i][j] == 1) 
                // System.out.println(matrix[i][j] == 1);
                arr[j] = (matrix[i][j] == '1' ? arr[j]+1 : 0);
            }
            ans = Math.max(ans, solve(arr, n));
        }

        return ans;
    }

    private int solve(int arr[], int n){
        int w, area, ans = -1;
        int pre[] = new int[n], suf[] = new int[n];

        pre[0] = -1;
        for(int i=1; i<n; i++){
            // pre[i] = arr[i-1] < arr[i] ? i-1 : pre[i-1];
            int j = i-1;
            while(j >= 0 && arr[j] >= arr[i]) j--;
            pre[i] = j;
        }

        suf[n-1] = n;
        for(int i=n-2; i>=0; i--){
            // suf[i] = arr[i+1] < arr[i] ? i+1 : suf[i+1];
            int j = i+1;
            while(j < n && arr[j] >= arr[i]) j++;
            suf[i] = j;
        }

        // System.out.println("arr ");
        // for(int i=0; i<n; i++){
        //     System.out.print(arr[i] + ",");
        // }
        // System.out.println();
        // System.out.println("pre ");
        // for(int i=0; i<n; i++){
        //     System.out.print(pre[i] + ",");
        // }
        // System.out.println();
        // System.out.println("suf ");
        // for(int i=0; i<n; i++){
        //     System.out.print(suf[i] + ",");
        // }
        // System.out.println();

        for(int i=0; i<n; i++){
            w = suf[i] - pre[i] - 1;
            // if(w == 0) w = 1;
            area = w * arr[i];
            // System.out.println("For " + i);
            // System.out.println("w " + w + " arr " + arr[i]);
            ans = ans < area ? area : ans;
        }

        // System.out.println(ans);

        return ans;
    }
}