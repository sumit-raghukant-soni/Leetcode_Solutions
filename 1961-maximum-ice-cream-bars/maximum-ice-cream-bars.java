class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int sz = costs.length, ans = 0;
        int arr[] = new int[100001];

        for(int i=0; i<sz; i++){
            arr[costs[i]]++;
        }

        for(int i=0; i<100001; i++){
            if(coins >= arr[i] * i){
                coins -= arr[i] * i;
                ans += arr[i];
            }
            else {
                ans += coins/i;
                coins = 0;
                break;
            }
        }

        return ans;
    }
}