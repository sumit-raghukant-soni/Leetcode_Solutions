class Solution {
    public int climbStairs(int n, int[] costs) {
        int arr[] = new int[n];

        for(int i=0; i<n; i++) {
            int a, b, c;
            if(i-3 >= 0) {
                a = arr[i-3] + 9;
                b = arr[i-2] + 4;
                c = arr[i-1] + 1;
            }
            else if(i-2 >= 0) {
                a = 9;
                b = arr[i-2] + 4;
                c = arr[i-1] + 1;
            }
            else {
                a = 9;
                b = 4;
                c = i > 0 ? arr[i-1] + 1 : 1;
            }
            arr[i] = costs[i] + Math.min(a, Math.min(b, c));
            // System.out.println(i + " " + a + ":" + b + ":" + c);
        }

        return arr[n-1];
    }
}