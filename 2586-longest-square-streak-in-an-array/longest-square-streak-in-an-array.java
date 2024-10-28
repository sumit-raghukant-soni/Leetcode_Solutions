class Solution {
    public int longestSquareStreak(int[] nums) {
        int arr[] = nums, sz = nums.length, ans = -1;
        HashMap<Integer, Integer> mp = new HashMap<>();
        Arrays.sort(arr);

        for(int i=0; i<sz; i++){
            // System.out.print(arr[i] + " ");
            mp.put(arr[i], 0);
            int sqrt = (int) Math.sqrt(arr[i]);

            if(sqrt*sqrt == arr[i] && mp.containsKey(sqrt)){
                // System.out.print("found ");
                mp.put(arr[i], 1 + mp.get(sqrt));
            }
        }

        for(Map.Entry<Integer, Integer> pair : mp.entrySet()){
            ans = Math.max(ans, pair.getValue());
        }

        return ans == 0 ? -1 : ans+1;
    }
}