class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int sz = arr.length, MOD = 1000000007;
        long ans = 0;
        Map<Integer, Long> mp = new HashMap<>();
        Arrays.sort(arr);

        for(int i=0; i<sz; i++){
            long tmp = 1;
            for(int j=i-1; j>=0; j--){
                // System.out.println(arr[i] + " " + arr[j]);
                if(arr[i]%arr[j] == 0 && mp.containsKey(arr[i] / arr[j])){
                    tmp += mp.get(arr[j]) * mp.get(arr[i] / arr[j]);
                }
            }
            mp.put(arr[i], tmp);
            ans += tmp;
        }
        
        // System.out.println(mp);

        return (int) (ans % MOD);
    }
}