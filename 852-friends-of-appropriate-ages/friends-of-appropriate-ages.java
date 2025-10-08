class Solution {
    public int numFriendRequests(int[] ages) {
        int sz = ages.length, ans = 0;
        int lastInd[] = new int[121];

        Arrays.sort(ages);

        for(int i=0; i<sz; i++){
            lastInd[ages[i]] = i;
        }

        for(int i=0; i<sz; i++){
            int tmp = solve(ages, sz, (int) ((ages[i] * 0.5) + 7));
            if(tmp < lastInd[ages[i]]) ans += lastInd[ages[i]] - tmp;
        }

        return ans;
    }

    private int solve(int arr[], int sz, int val){
        int s = 0, e = sz-1;

        while(s <= e){
            int mid = s + (e-s)/2;
            if(arr[mid] > val){
                e = mid - 1;
            }
            else{
                s = mid + 1;
            }
        }

        // System.out.println(val + " " + s);

        return s;
    }
}