class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int sz = values.length, ans = 0, k = 0;
        int arr[][] = new int[sz][2];
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<sz; i++){
            arr[i][0] = values[i];
            arr[i][1] = labels[i];
        }

        Arrays.sort(arr, (a, b) -> b[0] - a[0]);

        for(int i=0; i<sz; i++){
            if(numWanted == k) break;
            if(mp.containsKey(arr[i][1]) && mp.get(arr[i][1]) == useLimit) continue;
            mp.put(arr[i][1], mp.getOrDefault(arr[i][1], 0) + 1);
            ans += arr[i][0];
            k++;
        }

        return ans;
    }
}