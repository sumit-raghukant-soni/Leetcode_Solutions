class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int sz = arr.length, ans = 0;

        for(int i=0; i<sz; i++){
            for(int j=i+1; j<sz; j++){
                for(int k=j+1; k<sz; k++){
                    if(Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) ans++;
                }
            }
        }

        return ans;
    }
}