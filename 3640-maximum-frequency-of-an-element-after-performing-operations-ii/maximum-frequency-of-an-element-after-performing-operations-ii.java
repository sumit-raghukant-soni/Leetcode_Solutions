class Solution {
    Map<Integer, Integer> mp = new HashMap<>();
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int sz = nums.length;
        Set<Integer> st = new HashSet<>();
        int arr[] = null, j = 0, pre[] = null, suf[] = null, ans = 0;

        for (int i = 0; i < sz; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
            st.add(nums[i]);
        }

        sz = st.size();
        arr = new int[sz];
        pre = new int[sz];
        suf = new int[sz];
        for (int i : st) {
            arr[j++] = i;
        }
        Arrays.sort(arr);

        int a = calc(arr, sz, k, k, numOperations), b = calc(arr, sz, k*2, 0, numOperations-1), c = calc(arr, sz, 0, k*2, numOperations-1);

        // System.out.println(a + " " + b + " " + c);

        return a > b && a > c ? a : (b > c ? b : c);
    }

    private int calc(int arr[], int sz, int k1, int k2, int numOperations){
        int last = 0, cnt = 0, ans = 0;
        int pre[] = new int[sz], suf[] = new int[sz];

        for(int i=0; i<sz; i++){
            while(arr[i] - arr[last] > k1){
                cnt -= mp.get(arr[last]);
                last++;
            }
            pre[i] = cnt;
            cnt += mp.get(arr[i]);
        }

        last = sz-1; cnt = 0;
        for(int i=sz-1; i>=0; i--){
            while(arr[last] - arr[i] > k2){
                cnt -= mp.get(arr[last]);
                last--;
            }
            suf[i] = cnt;
            cnt += mp.get(arr[i]);
        }

        for(int i=0; i<sz; i++){
            int sum = pre[i] + suf[i];
            sum = sum > numOperations ? numOperations : sum;
            // if(k2 == 0) System.out.println(pre[i] + ":" + suf[i] + " " + mp.get(arr[i]) + " " + arr[i]);
            ans = ans > (sum + mp.get(arr[i])) ? ans : (sum + mp.get(arr[i]));
        }

        return ans;
    }
}