class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int sz = nums.length, ans = 0;
        int freq[] = new int[100001];
        int pre[] = new int[100001];
        int suf[] = new int[100001];

        for(int i=0; i<sz; i++) freq[nums[i]]++;

        int last = 0, cnt = 0;
        for(int i=0; i<100001; i++){
            // if(freq[i] == 0) continue;
            while(last < i-k){
                cnt -= freq[last];
                last++;
            }
            pre[i] = cnt;
            cnt += freq[i];
        }

        last = 100000; cnt = 0;
        for(int i=100000; i>=0; i--){
            // if(freq[i] == 0) continue;
            while(last > i+k){
                cnt -= freq[last];
                last--;
            }
            suf[i] = cnt;
            cnt += freq[i];
        }

        for(int i=0; i<100001; i++){
            int l = pre[i], r = suf[i];
            int sum = (l+r) <= numOperations ? (l+r) : numOperations;
            sum += freq[i];
            // if(freq[i] > 0) System.out.println(l + ":" + r + " " + freq[i] + " = " + i);
            ans = ans > sum ? ans : sum;
        }

        return ans;
    }
}