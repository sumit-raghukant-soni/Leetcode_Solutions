class Solution {
    public int[] sumZero(int n) {
        int arr[] = new int[n];
        int i=0, k = (n&1) == 1 ? 0 : 1;

        for(; i<=(n-1)/2; i++){
            arr[i] = k++;
        }

        k--;
        for(; i<n; i++){
            arr[i] = k--*-1;
        }

        return arr;
    }
}